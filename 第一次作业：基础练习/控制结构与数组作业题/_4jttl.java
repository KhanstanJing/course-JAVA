import java.util.Scanner;
class _4jttl {//标识符必须以字母或者下划线开头
public static void main(String args[]){
int t,f;//先定义变量，再用Scanner类，再将Scanner输入的值赋给变量
Scanner key = new Scanner(System.in);//Scanner是类，后面定义keyin或者其他自己命名的东西都可以，相当于一个对象
System.out.println("the total number of animal is ");
t = key.nextInt();
System.out.println("the total number of feet is ");
f = key.nextInt();
System.out.println("the number of chicken is"+((4*t-f)/2));//不能输入中括号，如"[(4*t-f)/2]"
System.out.println("the number of rabbit is"+(f/2-t));
}}