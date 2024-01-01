package Client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import jxl.*;
import jxl.read.biff.BiffException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class Worker {
    private Client c;

    // 格式：flag(有返回值为0) + number(int为1) + length(column) + column + sql
    // 表: id(int2), usr(string3), pass(string4), schn(int4), phone(string5), sex(int3), birth(string5), money(int5)

    // 构造，初始化
    Worker() {
        this.c = new Client("192.168.66.128",6606);
    }

    // 查询用户是否存在 不存在返回true，存在返回false
    private boolean check_usr(String usr) {
        return send_msg("012idSELECT id FROM fmbank WHERE usr='"+usr+"';").equals("Null");
    }

    // 判断是否登录成功
    public boolean check_login(String usr, String pass) {
        if(check_usr(usr) == true) return false;
        return send_msg("004passSELECT pass FROM fmbank WHERE usr='"+usr+"';").equals(pass);
    }

    // 发送数据
    private String send_msg(String data) {
        return c.work(data);
    }

    // 余额查询,返回余额
    public int check_money(String usr) {
        return Integer.parseInt(send_msg("015moneySELECT money FROM fmbank WHERE usr='"+usr+"';"));
    }

    // 取款，返回是否成功
    public boolean withdraw_money(String usr, int money) {
        int count = check_money(usr);
        if(count < money) return false;
        count -= money;
        send_msg("1UPDATE fmbank SET money="+count+" WHERE usr='"+usr+"';");
        return true;
    }

    // 存款，返回是否存款成功
    public boolean store_money(String usr, int money) {
        int count = check_money(usr);
        count += money;
        send_msg("1UPDATE fmbank SET money="+count+" WHERE usr='"+usr+"';");
        return true;
    }

    // 转账，返回是否转账成功
    public boolean transfer(String fromusr, String tousr, int money) {
        if(check_usr(tousr) == true) return false;
        boolean res = withdraw_money(fromusr,money);
        if(res == false) return res;
        return store_money(tousr,money);
    }

    // 注册，返回是否注册成功
    public boolean signin(String usr_name, String birth, String phone, String pass, int sex, int schn, int money) {
        if(check_usr(usr_name) == false) return false;
        send_msg("1INSERT INTO fmbank (usr,pass,schn,phone,sex,birth,money) VALUES ('"+usr_name+"','"+pass+"',"+schn+",'"+phone+"',"+sex+",'"+birth+"',"+money+");");
        return true;
    }

    // 批量注册, 返回是否成功
    public int bulk_signin(String file_name) {
        int cnt = 0;
        try {
            Workbook book = Workbook.getWorkbook(new File(file_name));
            Sheet sheet = book.getSheet(0);
            int cols = sheet.getColumns();
            int rows = sheet.getRows();
            for(int i = 0; i < rows; i++) {
                String usr,birth,phone,pass,sex,schn;
                usr = birth = phone = pass = sex = schn = null;
                for(int j = 0; j < cols; j++) {
                    switch(j) {
                        case 0: usr = sheet.getCell(j, i).getContents(); break;
                        case 1: birth = sheet.getCell(j, i).getContents(); break;
                        case 2: phone = sheet.getCell(j, i).getContents(); break;
                        case 3: pass = sheet.getCell(j, i).getContents(); break;
                        case 4: sex = sheet.getCell(j, i).getContents(); break;
                        case 5: schn = sheet.getCell(j, i).getContents(); break;
                    }
                }
                int sex_, schn_;
                try {
                    sex_ = Integer.parseInt(sex);
                } catch (NumberFormatException e) {sex_ = -1;}
                try {
                    schn_ = Integer.parseInt(schn);
                } catch (NumberFormatException e) {schn_ = -1;}
                signin(usr,birth,phone,pass,sex_,schn_,2000);
                cnt++;
            }
        } catch (IOException e) {
            return -1;
        } catch (BiffException e) {
            return -1;
        }
        return cnt;
    }

    // 注销用户，返回是否注销成功
    public boolean logout(String usr) {
        send_msg("1DELETE FROM fmbank WHERE usr='"+usr+"';");
        return true;
    }

    // 修改信息, 返回是否修改成功
    public boolean update_info(String usr, String pass, String birth, String phone) {
        send_msg("1UPDATE fmbank SET pass='"+pass+"',birth='"+birth+"',phone='"+phone+"' WHERE usr='"+usr+"';");
        return true;
    }

    // 年终报告
    public boolean createpdf(String file_name) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            int account = Integer.parseInt(send_msg("014numsSELECT COUNT(*) AS nums FROM fmbank;"));
            int count = Integer.parseInt(send_msg("014numsSELECT SUM(money) AS nums FROM fmbank;"));
            document.open();
            document.add(new Paragraph("Fei Ma Bank annual report"));
            document.add(new Paragraph("The total number of the account is: "+account));
            document.add(new Paragraph("The number of the new account is: "+account));
            document.add(new Paragraph("The total cash in the bank are: "+count));
            document.close();
            return true;
        } catch (DocumentException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
