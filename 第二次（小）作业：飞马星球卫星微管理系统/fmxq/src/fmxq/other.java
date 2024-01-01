package fmxq;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

class Satellite {                                                         //类
    private String ID;
    private String Name;
    private double Gps;
    private boolean Flag;
 
    public String getID() {
        return ID;
    }
 
    public String getName() {
        return Name;
    }
 
    public double getGps() {
        return Gps;
    }
 
    public boolean getFlag() {
        return Flag;
    }
 
    public void setID(String ID) {
        this.ID = ID;
    }
 
    public void setName(String name) {
        Name = name;
    }
 
    public void setGps(double gps) {
        Gps = gps;
    }
 
    public void setFlag(boolean flag) {
        Flag = flag;
    }
    
    public static ArrayList Satellite(){                                  //默认构造方法
        Satellite s1=new Satellite("CS0001","红旗一号",1.5,true);
        Satellite s2=new Satellite("CS0002","红旗二号",2.0,true);
        Satellite s3=new Satellite("CS0003","红旗三号",2.5,false);
        Satellite s4=new Satellite("CS0004","风云一号",3.0,true);
        Satellite s5=new Satellite("CS0005","风云二号",3.5,true);
        ArrayList<Satellite> pre=new ArrayList<Satellite>();
        pre.add(s1);
        pre.add(s2);
        pre.add(s3);
        pre.add(s4);
        pre.add(s5);
        return pre;
    }
 
    public Satellite(String ID, String Name, double Gps, boolean Flag) {            //带参数构造方法
        this.ID = ID;
        this.Name = Name;
        this.Gps = Gps;
        this.Flag = Flag;
    }
}

//设置抽象类。设置该类的目的在于预先储存一些后面将会用到的方法，以便让后面的子类可以继承
//additem中主要预留了添加名称、添加位置（半径）、添加状态以及添加卫星几个方法
abstract class additem{                                                
        boolean decide;
        abstract String addidname (ArrayList pre,String mm,boolean find);
        abstract double addgps (ArrayList pre);
        abstract boolean addflag (ArrayList pre);
        abstract ArrayList addarray(ArrayList pre);
    }

//add继承抽象类additem，目的在于添加卫星
class add extends additem{
        void Cheak(Iterator itr21,String mm,String id,boolean find){          //find=true指id
            for (;itr21.hasNext(); ) {
                Satellite data = (Satellite) itr21.next();
                if (find?id.equals(data.getID()):id.equals(data.getName())) {
                    System.out.print("请重新输入创建卫星的"+mm+",原因是:\t");
                    System.out.println("与已有卫星"+id+"重复");
                    decide = true;
                }
            }
        }
        String addidname(ArrayList pre,String mm,boolean find) {
            String id= "point";
            do {
                Iterator itr21 = pre.iterator();
                System.out.print(mm + ": ");
                Scanner inputid = new Scanner(System.in);
                id = inputid.nextLine();
                decide = false;
                if (find) {
                    if (id.length() != 6) {
                        decide = true;
                        System.out.print("请重新输入创建卫星的" + mm + ",原因是:");
                        if (id.length() < 6) System.out.println(mm + "过短");
                        if (id.length() > 6) System.out.println(mm + "过长");
                    } else {
                        if (id.matches("^[A-Z]{2}[0-9]{4}$")) {
                            Cheak(itr21,mm,id,find);
                        } else {
                            decide = true;
                            System.out.print("请重新输入创建卫星的" + mm + ",原因是:");
                            System.out.println("输入格式错误");
                        }
                    }
                }else Cheak(itr21,mm,id,find);
            } while (decide);
            return id;
        }
        double addgps(ArrayList pre){
        	return 0;
        	}
        boolean addflag(ArrayList pre){
        	return false;
        	}
        ArrayList addarray(ArrayList pre){
        	return pre;
        	}
        }

class addgps extends  additem{
         String addidname(ArrayList pre,String mm,boolean find){return "point";};
         double addgps(ArrayList pre){
            double gps;
            do{
                Iterator itr23=pre.iterator();
                Iterator itr24=pre.iterator();
                Iterator itr25=pre.iterator();
                System.out.print("轨道半径: ");
                Scanner inputgps1=new Scanner(System.in);
                gps =inputgps1.nextDouble();
                decide =false;
                if (gps<1.2){
                    decide = true;
                    System.out.print("请重新输入卫星的轨道半径,原因是:");
                    System.out.println("轨道半径过小");
                }else {
                    for (; itr23.hasNext(); ) {
                        Satellite data = (Satellite) itr23.next();
                        if (gps == data.getGps()) {
                            decide = true;
                            System.out.print("请重新输入卫星的轨道半径,原因是:");
                            System.out.println("与已有卫星轨道相同");
                        }
                    }
                    for (; itr24.hasNext(); ) {
                        Satellite data1 = (Satellite) itr24.next();
                        if (gps == data1.getGps() - 0.2) {
                            decide = true;
                            System.out.print("请重新输入卫星的轨道半径,原因是:");
                            System.out.println("与已有卫星轨道相距较近");
                        }
                    }
                    for (; itr25.hasNext(); ) {
                        Satellite data2 = (Satellite) itr25.next();
                        if (gps == data2.getGps() + 0.2) {
                            decide = true;
                            System.out.print("请重新输入卫星的轨道半径,原因是:");
                            System.out.println("与已有卫星轨道相距较近");
                        }
                    }
                }
            }while(decide);
            return  gps;
        }
         boolean addflag(ArrayList pre){return false;};
         ArrayList addarray(ArrayList pre){return pre;};
    }

class addflag extends additem{
        String addidname(ArrayList pre,String mm,boolean find){
        	return "point";
        	}
        double addgps(ArrayList pre){
        	return 0;
        	}
        boolean addflag(ArrayList pre){
            boolean flag;
            do{
                System.out.print("是否激活: ");
                Scanner inputflag=new Scanner(System.in);
                flag=inputflag.nextBoolean();
                if (flag == true || flag == false){
                    decide=false;
                }else {
                    decide=true;
                    System.out.print("请重新输入卫星是否激活,原因是:");
                    System.out.println("激活密码错误");
                }
            }while(decide);
            return  flag;
        }
        ArrayList addarray(ArrayList pre){return pre;};
    }

class addpre extends additem{
    String addidname(ArrayList pre,String mm,boolean find){
    	return "point";
    	}
    double addgps(ArrayList pre){
    	return 0;
    	}
    boolean addflag(ArrayList pre){
    	return false;
    	}
    ArrayList addarray(ArrayList pre){
        String id = new add().addidname(pre,"COSPARID",true);
        String name=new add().addidname(pre,"名称",false);
        double gps = new addgps().addgps(pre);
        boolean flag =new addflag().addflag(pre);
        Satellite s=new Satellite(id,name,gps,flag);
        pre.add(s);
        return pre;
    };
}

class enable {                                      //封锁激活类
    void enable(boolean find, ArrayList pre, boolean deci,String nn) {
        System.out.println("请输入"+nn+"卫星的信息");
        Scanner in = new Scanner(System.in);
        String activation = in.nextLine();
        Iterator itr4 = pre.iterator();
        find = true;
        while (itr4.hasNext()) {
            Satellite data = (Satellite) itr4.next();
            if (data.getID().equals(activation) || data.getName().equals(activation)) {
                find = false;
                if (deci?!data.getFlag():data.getFlag()) {
                        data.setFlag(deci);
                        System.out.println("已"+nn+"卫星可返回查看");
                    }else{
                        System.out.println("该卫星无需被"+nn+"，原本"+nn);
                    }
                }
        }
        if (find)
            System.out.println("没有找见该卫星");
    }
}

//下面来编写查询类，这个类的目的是用于显示列表，可以拓展理解为显示一个操作系统中（用户所要查询）的储存信息
//在本作业的应用中，该类用于case1和case6，即显示当前活动卫星列表和显示失活卫星列表
//该类中发挥作用的是look函数
class see{                 
    void look(ArrayList pre,boolean ss,boolean find){
        System.out.println("COSPARID\t\t卫星名称\t轨道半径\t是否可用");
        Iterator itr1 = pre.iterator();
        //iterator为一种接口，提供一种遍历集合类元素的方式，翻译为迭代器，通过iterator，我们可以在不知道集合内部实现的情况下，按照特定的顺序一词访问集合中的每一个元素。同时，我们可以在遍历的过程中对于集合进行修改
        //这里，我们将动态数组的迭代器赋与itr1，即itr1
        while (itr1.hasNext()) {
        	//hasNext是iterator接口中的一个方法，如果仍有元素可以迭代，则返回true
            find = false;
            Satellite data = (Satellite) itr1.next();
            //iterator.next()是返回迭代的下一个元素，该函数的语法为：E next()，E表示集合中的元素类型
            //运行时，如果集合中有下一个元素，则返回下一个元素并将迭代器的位置向前移动；如没有下一个元素，则抛出"No Such Element Exception"异常
            if(ss){
            	//ss这个变量的设置在于应对不同的case，case1中要求输出全部的卫星，case6要求输出失活的卫星，ss的值如果是true则对应case1，如果是false则对应与case6
            	//这启发我们在想要实现类似的两个功能的时候（在本作业中体现为都是输出列表信息，但是是不同的信息，一个是全部的，一个是失活的），可以通过在输出函数中设置不同的boolean值来完成
            	//如果是更多种类的功能的话，应该也可以设置不同的值（例如整数1、2、3等，而后使用if语句对于每个值分别进行输出）
            	System.out.println(data.getID() + "\t\t\t" + data.getName() + " " + data.getGps() + "\t  " + data.getFlag());
            	}
            else{
                if(find)
                    System.out.println("无封锁卫星");
                if(data.getFlag() == false)
                {
                    find= true;
                    System.out.println(data.getID() + "\t\t\t" + data.getName() + " " + data.getGps() + "\t  " + data.getFlag());
                }
 
            }
        }
    }
}

//在本作业的应用中，该类用于case3、7和8，即删除旧卫星、按名称模糊查找卫星和修改卫星信息
class find{
    boolean del(ArrayList pre,String mm,boolean deci,boolean find){
    	//和查询类类似，我们在这里采用设置一个mm变量的方式来实现类似的三个功能，三个case中分别给mm赋值'删除'、'查找'、修改'
        System.out.println("请输入"+mm+"卫星的编号");
        //设置读取器，用来读取将要被操作的卫星的信息
        Scanner i = new Scanner(System.in);
        //在这里我们采用输入卫星编号的方式来对卫星进行操作，也可以对于代码进行修改，来用名字来对卫星进行操作
        String message = i.nextLine();
        Iterator itr3 = pre.iterator();
        find = true;
        while (itr3.hasNext()) {
            Satellite data = (Satellite) itr3.next();
                if (data.getID().equals(message) || data.getName().equals(message)) {
                	//在case3、7、8中，deci的值分别为true、false、true，即在删除和修改时启用下面这个if语句，在模糊查找时不启用
                    if(deci){
                        itr3.remove();
                        find = false;
                        if(mm!="修改")
                        	System.out.println("已"+mm+"卫星可返回查看");
                        break;
                    }else{
                        find = false;
                        System.out.println("COSPARID\t\t卫星名称 轨道半径 是否可用");
                        System.out.println(data.getID() + "\t\t\t" + data.getName() + " " + data.getGps() + "\t  " + data.getFlag());
                        break;
                    }
            }
        }
        if(find)
            System.out.println("没有找到该卫星");
        return find;
    }
}