import java.util.Scanner;
class _4jttl {//��ʶ����������ĸ�����»��߿�ͷ
public static void main(String args[]){
int t,f;//�ȶ������������Scanner�࣬�ٽ�Scanner�����ֵ��������
Scanner key = new Scanner(System.in);//Scanner���࣬���涨��keyin���������Լ������Ķ��������ԣ��൱��һ������
System.out.println("the total number of animal is ");
t = key.nextInt();
System.out.println("the total number of feet is ");
f = key.nextInt();
System.out.println("the number of chicken is"+((4*t-f)/2));//�������������ţ���"[(4*t-f)/2]"
System.out.println("the number of rabbit is"+(f/2-t));
}}