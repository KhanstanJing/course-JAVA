package fmxq;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
    	//本次作业中用到了动态数组这一方法
        ArrayList<Satellite> pre = new ArrayList<Satellite>();
        pre = Satellite.Satellite();
        do{System.out.println("************************************");
           System.out.println("1-----显示当前活动卫星列表");
           System.out.println("2-----注册新卫星");
           System.out.println("3-----删除旧卫星");
           System.out.println("4-----激活卫星");
           System.out.println("5-----封锁卫星");
           System.out.println("6-----显示失活卫星列表");
           System.out.println("7-----按名称模糊查找卫星");
           System.out.println("8-----修改卫星信息");
           System.out.println("9-----退出");
           System.out.println("************************************");
           System.out.println("请选择操作：");
           boolean decide = false;
           boolean find = true;
           char operator = '0';
           do{Scanner input01 = new Scanner(System.in);//设置输入并判断操作
              operator = input01.next().charAt(0);//设置提取输入信息的操作
              if(operator != '1' && operator != '2' && operator != '3' &&
                 operator != '4' && operator != '5' && operator != '6' && 
                 operator != '7' && operator != '8' && operator != '9'){
                 System.out.println("你的输入有误请重新输入");
                 decide = true;
                 } 
              else{
            	  decide = false;
            	  }
              } 
           while (decide);
           //==========================================================================================================
           //利用switch语句，对于不同的输入情况进行判断
           switch (operator){
           //显示当前活动卫星列表
           case '1':
        	   System.out.println("=========================================");
               new see().look(pre,true,find);
               System.out.println("=========================================");
               continue;
           //注册新卫星
           case '2':
        	   System.out.println("=========================================");
               System.out.println("请输入创建卫星的信息");
               pre = new addpre().addarray(pre);
               System.out.println("已创建卫星可返回查看");
               System.out.println("=========================================");
               continue;
           //删除旧卫星
           case '3':
        	   System.out.println("=========================================");
               find=new find().del(pre,"删除",true,find);
               System.out.println("=========================================");
               continue;
           //激活卫星
           case '4':
        	   System.out.println("=========================================");
               new enable().enable(find,pre,true,"激活");
               System.out.println("=========================================");
               continue;
           //封锁卫星
           case '5':
        	   System.out.println("=========================================");
               new enable().enable(find,pre,false,"封锁");
               System.out.println("=========================================");
               continue;
           //显示失活卫星列表
           case '6':
        	   System.out.println("=========================================");
               new see().look(pre,false,find);
               System.out.println("=========================================");
               continue;
           //模糊查找
           case '7':
        	   System.out.println("=========================================");
               find=new find().del(pre,"查找",false,find);
               System.out.println("=========================================");
               continue;
           //修改卫星信息
           case '8':
               System.out.println("=========================================");
               find=new find().del(pre,"修改",true,find);
               if(!find)
            	   pre = new addpre().addarray(pre);
               System.out.println("=========================================");
               continue;
           case '9':
        	   System.exit(0);
               continue;
            }
        } while (true);
    }
}
