import java.io.*;
import java.util.Scanner;
class www{
public static void main(String arg[])throws IOException{
Scanner reader = new Scanner(System.in);
int x = reader.nextInt();
switch(x/10){
case 10:System.out.println('A');break;//��һ�е�System��������ɾ������Ϊ����Ϊ���
case 9:System.out.println('A');break;
case 8:System.out.println('B');break;
case 7:System.out.println('C');break;
case 6:System.out.println('D');break;
default:System.out.println('E');break;
}
}
}