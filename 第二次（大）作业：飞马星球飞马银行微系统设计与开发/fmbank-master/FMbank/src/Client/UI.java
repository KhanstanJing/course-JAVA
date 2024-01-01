package Client;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener{   

	// 用户参数
	private Worker w;
	private String usr;
	private String pas;
	private int count;

	// 参数
	private String Title;
	private int size1;
	private int size2;
	private final int xloc = 400;
	private final int yloc = 300;

	private JFrame current;
	private JFrame frame1;
	private JFrame frame2;
	private JFrame frame3;
	private JFrame frame4;
	private JFrame frame5;
	private JFrame frame6;
	private JFrame frame7;
	private JFrame frame8;
	private JFrame frame9;
	private JFrame frame10;
    
	// 回退
	private JButton bak1;
	private JButton bak2;
	private JButton bak3;
	private JButton bak4;
	private JButton bak5;
	private JButton bak6;
	// frame1
	private JButton btn1;
	private JButton btn2;
	// frame2
	private JButton btn3;
	private JButton btn4;
	// frame3
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn10;
	// 查询余额
	private JButton btn15;
	//取款
	private JButton btn11;
	// 存款
	private JButton btn12;
	// 转账
	private JButton btn13;
	// 修改信息
	private JButton btn14;
	// 提交注册
	private JButton btn16;
	// 管理员操作
	private JButton btn17;
	private JButton btn18;

	// 卡片布局
	private CardLayout c1;
	private JPanel cards1;

	// 表单
	private JTextArea jta1;
	private JTextArea jta2;
	private JTextArea jta3;
	private JTextArea jta4;
	private JTextArea jta5;
	private JTextArea jta6;
	private JTextArea jta7;
	private JTextArea jta8;
	// 用户名
	private JTextArea jta9;
	// 生日
	private JTextArea jta10;
	// 手机号
	private JTextArea jta11;

	// 密码框
	private JPasswordField jpd1;
	private JPasswordField jpd2;
	private JPasswordField jpd3;
	// ...
	
	// 初始化
	UI(String title, int size1, int size2) {
		this.w = new Worker();
		this.Title = title;
		this.size1 = size1;
		this.size2 = size2;
		Frame1();
	}

	// 初始界面
    private void Frame1() {
		frame1 = new JFrame("飞马银行");
		frame1.setBounds(xloc,yloc,size1,size2);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(null);
		frame1.setBackground(Color.gray);

		JLabel label = new JLabel("欢迎来到飞马银行");
		
		btn1 = new JButton("登录");
		btn2 = new JButton("注册");
	
		label.setBounds(100,2,200,30);
		btn1.setBounds(100,50,100,30);
		btn2.setBounds(100,100,100,30);

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		frame1.add(label);
		frame1.add(btn1);
		frame1.add(btn2);
		
		current = frame1;
		current.setVisible(true);
	}

    // 登录界面
	private void Frame2() {
		frame2 = new JFrame("飞马银行");
		frame2.setBounds(xloc,yloc,size1,size2);
		frame2.setResizable(false);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setBackground(Color.gray);

		JPanel p = new JPanel();
		cards1 = new JPanel(new CardLayout(50,10));
		c1 = (CardLayout)(cards1.getLayout());
		
		JLabel label = new JLabel("输入用户名和密码");
		jta1 = new JTextArea(1,10);
		jpd1 = new JPasswordField(10);
		btn3 = new JButton("  登录  ");
		btn4 = new JButton("忘记密码");

		p.add(label);
		p.add(jta1);
		p.add(jpd1);
		p.add(btn3);
		p.add(btn4);

		cards1.add(p,"ok");
		frame2.add(cards1);

		btn3.addActionListener(this);
		btn4.addActionListener(this);

	}

	// 用户界面
	private void Frame3() {
		frame3 = new JFrame(Title+usr);
		frame3.setBounds(xloc,yloc,size1,size2);
		frame3.setResizable(false);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setBackground(Color.gray);

		btn5 = new JButton("查询余额");
		btn6 = new JButton("取款");
		btn7 = new JButton("存款");
		btn8 = new JButton("转账");
		btn9 = new JButton("修改信息");
		btn10 = new JButton("销户");

		frame3.add(btn5);
		frame3.add(btn6);
		frame3.add(btn7);
		frame3.add(btn8);
		frame3.add(btn9);
		frame3.add(btn10);

		frame3.setLayout(new GridLayout(3,2,5,5));

		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);

	}

	// 查询余额界面
	private void Frame4() {
		frame4 = new JFrame(Title+usr);
		//frame4.setSize(size1,size2);
		frame4.setBounds(xloc,yloc,size1,size2);
		frame4.setResizable(false);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setBackground(Color.gray);

		frame4.setLayout(null);

		JLabel label = new JLabel("当前余额为："+count+"");
		btn15 = new JButton("刷新");
		bak1 = new JButton("返回");

		label.setBounds(100,20,150,20);
		btn15.setBounds(20,100,100,20);
		bak1.setBounds(150,100,100,20);

		frame4.add(label);
		frame4.add(btn15);
		frame4.add(bak1);

		btn15.addActionListener(this);
		bak1.addActionListener(this);
	}

	// 取款界面
	private void Frame5() {
		frame5 = new JFrame(Title+usr);
		frame5.setBounds(xloc,yloc,size1,size2);
		frame5.setResizable(false);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setBackground(Color.gray);
		frame5.setLayout(null);
		
		JLabel label = new JLabel("输入取款数目");
		jta2 = new JTextArea(1,10);
		btn11 = new JButton("取款");
		bak2 = new JButton("返回");

		label.setBounds(100,10,100,50);
		jta2.setBounds(100,60,100,20);
		btn11.setBounds(20,110,100,30);
		bak2.setBounds(150,110,100,30);

		frame5.add(label);
		frame5.add(jta2);
		frame5.add(btn11);
		frame5.add(bak2);


		btn11.addActionListener(this);
		bak2.addActionListener(this);
	}

	// 存款界面
	private void Frame6() {
		frame6 = new JFrame(Title+usr);
		frame6.setBounds(xloc,yloc,size1,size2);
		frame6.setResizable(false);
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.setBackground(Color.gray);

		frame6.setLayout(null);

		JLabel label = new JLabel("输入存款数目");
		jta3 = new JTextArea(1,10);
		btn12 = new JButton("存款");
		bak3 = new JButton("返回");

		btn12.addActionListener(this);
		bak3.addActionListener(this);

		label.setBounds(100,10,100,50);
		jta3.setBounds(100,60,100,20);
		btn12.setBounds(20,110,100,30);
		bak3.setBounds(150,110,100,30);

		frame6.add(label);
		frame6.add(jta3);
		frame6.add(btn12);
		frame6.add(bak3);
	}

	// 转账界面
	private void Frame7() {
		frame7 = new JFrame(Title+usr);
		frame7.setBounds(xloc,yloc,size1,size2);
		frame7.setResizable(false);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.setBackground(Color.gray);

		frame7.setLayout(null);

		JLabel label1 = new JLabel("输入转入用户名和金额");
		JLabel label2 = new JLabel("用户名：");
		JLabel label3 = new JLabel("金额");
		jta4 = new JTextArea(1,10);
		jta5 = new JTextArea(1,10);
		btn13 = new JButton("转账");
		bak4 = new JButton("返回");

		btn13.addActionListener(this);
		bak4.addActionListener(this);

		label1.setBounds(80,5,150,20);
		label2.setBounds(100,25,100,20);
		jta4.setBounds(100,45,100,20);
		label3.setBounds(100,65,100,20);
		jta5.setBounds(100,85,100,20);
		btn13.setBounds(20,120,100,30);
		bak4.setBounds(150,120,100,30);

		frame7.add(label1);
		frame7.add(label2);
		frame7.add(jta4);
		frame7.add(label3);
		frame7.add(jta5);
		frame7.add(btn13);
		frame7.add(bak4);
	}

	// 修改信息界面
	private void Frame8() {
		frame8 = new JFrame(Title+usr);
		frame8.setBounds(xloc,yloc,size1,size2);
		frame8.setResizable(false);
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.setBackground(Color.gray);

		frame8.setLayout(null);

		JLabel label1 = new JLabel("新密码：");
		JLabel label2 = new JLabel("修改生日");
		JLabel label3 = new JLabel("修改手机号");
		jpd2 = new JPasswordField();
		jta7 = new JTextArea(1,10);
		jta8 = new JTextArea(1,10);
		btn14 = new JButton("修改");
		bak5 = new JButton("返回");

		btn14.addActionListener(this);
		bak5.addActionListener(this);

		label1.setBounds(100,5,100,20);
		jpd2.setBounds(100,25,100,20);
		label2.setBounds(100,45,100,20);
		jta7.setBounds(100,65,100,20);
		label3.setBounds(100,85,100,20);
		jta8.setBounds(100,105,100,20);
		btn14.setBounds(20,140,100,20);
		bak5.setBounds(150,140,100,20);

		frame8.add(label1);
		frame8.add(label2);
		frame8.add(label3);
		frame8.add(jpd2);
		frame8.add(jta7);
		frame8.add(jta8);
		frame8.add(btn14);
		frame8.add(bak5);
	}

	// 注册界面
	private void Frame9() {
		frame9 = new JFrame(Title);
		frame9.setBounds(xloc,yloc,size1,size2+50);
		frame9.setResizable(false);
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame9.setBackground(Color.gray);

		frame9.setLayout(null);

		JLabel label1 = new JLabel("输入用户名(不区分大小写)");
		JLabel label2 = new JLabel("输入生日");
		JLabel label3 = new JLabel("输入手机号");
		JLabel label4 = new JLabel("输入密码");
		jta9 = new JTextArea(1,10);
		jta10 = new JTextArea(1,10);
		jta11 = new JTextArea(1,10);
		jpd3 = new JPasswordField();
		btn16 = new JButton("注册");
		bak6 = new JButton("返回");

		label1.setBounds(80,5,200,20);
		jta9.setBounds(100,25,100,20);
		label2.setBounds(100,45,100,20);
		jta10.setBounds(100,65,100,20);
		label3.setBounds(100,85,100,20);
		jta11.setBounds(100,105,100,20);
		label4.setBounds(100,125,100,20);
		jpd3.setBounds(100,145,100,20);
		btn16.setBounds(20,170,100,20);
		bak6.setBounds(150,170,100,20);

		btn16.addActionListener(this);
		bak6.addActionListener(this);

		frame9.add(label1);
		frame9.add(label2);
		frame9.add(label3);
		frame9.add(label4);
		frame9.add(jta9);
		frame9.add(jta10);
		frame9.add(jta11);
		frame9.add(jpd3);
		frame9.add(btn16);
		frame9.add(bak6);
	}

	// 管理员界面
	private void Frame10() {
		frame10 = new JFrame(Title+"管理员"+usr);
		frame10.setBounds(xloc,yloc,size1,size2);
		frame10.setResizable(false);
		frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame10.setLayout(null);
		frame10.setBackground(Color.gray);

		JLabel label = new JLabel("管理员操作界面");
		
		btn17 = new JButton("批量开户");
		btn18 = new JButton("年终报告");
	
		label.setBounds(100,2,200,30);
		btn17.setBounds(100,50,100,30);
		btn18.setBounds(100,100,100,30);

		btn17.addActionListener(this);
		btn18.addActionListener(this);

		frame10.add(label);
		frame10.add(btn17);
		frame10.add(btn18);
		
	}

    // ...



	// 事件监听
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bak6) bak0();
		else if(e.getSource() == bak1 || e.getSource() == bak2 || e.getSource() == bak3 || e.getSource() == bak4 || e.getSource() == bak5) bak();
		else if(e.getSource() == btn1) btn_1();
		else if(e.getSource() == btn2) btn_2();
		else if(e.getSource() == btn3) btn_3();
		else if(e.getSource() == btn4) btn_4();
		else if(e.getSource() == btn5) btn_5();
		else if(e.getSource() == btn6) btn_6();
		else if(e.getSource() == btn7) btn_7();
		else if(e.getSource() == btn8) btn_8();
		else if(e.getSource() == btn9) btn_9();
		else if(e.getSource() == btn10) btn_10();
		else if(e.getSource() == btn11) btn_11();
		else if(e.getSource() == btn12) btn_12();
		else if(e.getSource() == btn13) btn_13();
		else if(e.getSource() == btn14) btn_14();
		else if(e.getSource() == btn15) btn_15();
		else if(e.getSource() == btn16) btn_16();
		else if(e.getSource() == btn17) btn_17();
		else if(e.getSource() == btn18) btn_18();
	}

	// 返回按钮
	private void bak() {
		current.setVisible(false);
		frame3.setVisible(true);
		current = frame3;
	}

	private void bak0() {
		current.setVisible(false);
		frame1.setVisible(true);
		current = frame1;
	}


	// 跳转登录界面
	private void btn_1() {
		Frame2();
		current.setVisible(false);
		frame2.setVisible(true);
		c1.show(cards1,"ok");
		current = frame2;
	}

	// 跳转创建账户页面
	private void btn_2() {
		Frame9();
		current.setVisible(false);
		frame9.setVisible(true);
		current = frame9;
	}

	// 跳转用户页面
	private void btn_3() {
		usr = jta1.getText();
		pas = new String(jpd1.getPassword());
		if(w.check_login(usr,pas) == false) {
			JOptionPane.showMessageDialog(frame2, "密码或用户名错误！","错误",2);
		} else {
			if(usr.equals("root")) {
				Frame10();
				current.setVisible(false);
				frame10.setVisible(true);
				current = frame10;
			} else {
				Frame3();
				current.setVisible(false);
				frame3.setVisible(true);
				current = frame3;
			}
		}
	}

	// 忘记密码
	private void btn_4() {
		JOptionPane.showMessageDialog(frame2, "仔细回忆","忘记密码",1);
	}

	// 跳转查询余额页面
	private void btn_5() {
		Frame4();
		count = w.check_money(usr);
		Frame4();
		current.setVisible(false);
		frame4.setVisible(true);
		current = frame4;
	}

	// 跳转取款页面
	private void btn_6() {
		Frame5();
		current.setVisible(false);
		frame5.setVisible(true);
		current = frame5;
	}

	// 跳转存款页面
	private void btn_7() {
		Frame6();
		current.setVisible(false);
		frame6.setVisible(true);
		current = frame6;
	}

	// 跳转转账页面
	private void btn_8() {
		Frame7();
		current.setVisible(false);
		frame7.setVisible(true);
		current = frame7;
	}

	// 跳转修改信息页面
	private void btn_9() {
		Frame8();
		current.setVisible(false);
		frame8.setVisible(true);
		current = frame8;
	}

	// 销户
	private void btn_10() {
		if(w.logout(usr)) {
			JOptionPane.showMessageDialog(frame3, "注销成功！","销户",2);
			btn_1();
		}
	}

	// 取款提交
	private void btn_11() {
		try {
			int withdraw = Integer.parseInt(jta2.getText());
			// System.out.println(withdraw);
			w.withdraw_money(usr, withdraw);
			JOptionPane.showMessageDialog(frame5, "取款成功！","取款",JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {JOptionPane.showMessageDialog(frame5, "请输入数字！","格式错误",2);}
		
	}

	// 存款提交
	private void btn_12() {
		try {
			int store = Integer.parseInt(jta3.getText());
			// System.out.println(store);
			w.store_money(usr, store);
			JOptionPane.showMessageDialog(frame6, "存款成功！","存款",JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {JOptionPane.showMessageDialog(frame6, "请输入数字！","格式错误",2);}
	}

	// 转账提交
	private void btn_13() {
		try {
			String tousr = jta4.getText();
			int transfer = Integer.parseInt(jta5.getText());
			if(tousr.equals("root")) {
				JOptionPane.showMessageDialog(frame7, "禁止向管理员转账！","错误",2);
			} else {
				if(w.transfer(usr, tousr, transfer) == false) JOptionPane.showMessageDialog(frame7, "转账失败！用户不存在或余额不足！","转账",JOptionPane.PLAIN_MESSAGE);
				else JOptionPane.showMessageDialog(frame7, "转账成功！","转账",JOptionPane.PLAIN_MESSAGE);
			}
		} catch (Exception e) {JOptionPane.showMessageDialog(frame7, "请输入数字！","格式错误",2);}

	}

	// 修改信息提交
	private void btn_14() {
		String pas = new String(jpd2.getPassword());
		String birth = jta7.getText();
		String phone = jta8.getText();
		if(w.update_info(usr, pas, birth, phone)) {
			JOptionPane.showMessageDialog(frame8, "修改成功！","修改",JOptionPane.PLAIN_MESSAGE);
		}
	}

	// 余额刷新
	private void btn_15() {
		btn_5();
	}

	// 注册提交
	private void btn_16() {
		String usr_name = jta9.getText();
		String birth = jta10.getText();
		String phone = jta11.getText();
		String pass = new String(jpd3.getPassword());
		if(w.signin(usr_name, birth, phone, pass, 1, 9941, 2000) == false) {
			JOptionPane.showMessageDialog(frame9, "用户名重复!","注册失败",2);
		} else {
			JOptionPane.showMessageDialog(frame9, "注册成功！","注册",JOptionPane.PLAIN_MESSAGE);
			btn_1();
		}
	}

	// 批量开户
	private void btn_17() {
		JFileChooser fc = new JFileChooser("C:\\");
		int val = fc.showOpenDialog(frame10);
		if(val == fc.APPROVE_OPTION) {
			System.out.println(fc.getSelectedFile().toString());
			int res = w.bulk_signin(fc.getSelectedFile().toString());
			if(res == -1) {
				JOptionPane.showMessageDialog(frame10, "文件格式错误或不支持xlsx格式，请使用xls格式！","文件格式错误",2);
			} else {
				JOptionPane.showMessageDialog(frame10, "成功注册"+res+"个用户！","成功",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	// 年终报告
	private void btn_18() {
		if(w.createpdf(".\\REPORT.pdf")) {
			JOptionPane.showMessageDialog(frame10, "生成报告成功！文件在当前目录中。","生成报告",JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(frame10, "生成报告失败！","生成报告",2);
		}
	}

}

