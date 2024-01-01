import java.util.Scanner;
class _7pdrn{
public static void main(String args[]){
int y;
Scanner keyin = new Scanner(System.in);
System.out.println("please type in a year");
y = keyin.nextInt();
//第一次编辑：最开始的时候Scanner keyin = new Scanner(System.in);写在System.out.println("please type in a year");前面了
//导致运行的时候要你先输入一个数而后才会蹦出来please type in a year
//第二次编辑：问题的关键在于System.out.println("please type in a year");和y = keyin.nextInt();的顺序
//不过Scanner keyin = new Scanner(System.in);不管怎么样都要放在y = keyin.nextInt();的前面
//不然会出现编译的时候y没有定义的情况
if(y<1000|y>5000){
	System.out.println("the year is not in the range!");
}
else{if(y%4 == 0){
//注意逻辑判断是==而不是=
		System.out.println("the year is run year!");
}
	else{
		System.out.println("the year is not run year!");
}
}
}
}