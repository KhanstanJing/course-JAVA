import java.util.Scanner;
class _7pdrn{
public static void main(String args[]){
int y;
Scanner keyin = new Scanner(System.in);
System.out.println("please type in a year");
y = keyin.nextInt();
//��һ�α༭���ʼ��ʱ��Scanner keyin = new Scanner(System.in);д��System.out.println("please type in a year");ǰ����
//�������е�ʱ��Ҫ��������һ��������Ż�ĳ���please type in a year
//�ڶ��α༭������Ĺؼ�����System.out.println("please type in a year");��y = keyin.nextInt();��˳��
//����Scanner keyin = new Scanner(System.in);������ô����Ҫ����y = keyin.nextInt();��ǰ��
//��Ȼ����ֱ����ʱ��yû�ж�������
if(y<1000|y>5000){
	System.out.println("the year is not in the range!");
}
else{if(y%4 == 0){
//ע���߼��ж���==������=
		System.out.println("the year is run year!");
}
	else{
		System.out.println("the year is not run year!");
}
}
}
}