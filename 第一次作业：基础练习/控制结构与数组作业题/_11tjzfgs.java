import java.util.Scanner;
class _11tjzfgs{
public static void main(String args[]){
int e=0,s=0,n=0,o=0,i=0;
//����α��룺��ʼ������
//�����α��룺����forѭ��Ҫ�õ�i����ǰ�����Ƕ�����
String str;
System.out.println("please type in a string!");
Scanner keyin = new Scanner(System.in);
str = keyin.nextLine();
//����α��룺����Scanner��˵�ַ�������ΪnextLine������nextString
//���Ĵα��룺keyin.nextString����Ҫ������
for(i=0;i<str.length();i++){
//���ߴα��룺ע��߽�������ǰ���α������е�ʱ���������д��forѭ���ڲ��ˣ�������ÿ����һ�ξ����һ��
//���i=length��ʱ��������˾��Զ�ֹͣ�ˣ����������
//���������������д��forѭ���ⲿ�Ļ������ڷ���Խ�磬�Ͳ��������ˣ���˵ð�=ȥ�������Ʊ߽���������������
	if(str.charAt(i)>=48&&str.charAt(i)<=57){
//���Ĵα��룺charAt�Ǻ�����Ӧ����str.charAt������charAt
//�ڶ��α��룺�ж��ַ�����Ԫ��ascii���ʱ����charAt��str[i]��ֱ�ӷ���
		n++;
//��һ�α��룺���Ǹ�n++e++����������;��
	}else{
		if((str.charAt(i)>='A'&&str.charAt(i)<='Z')||(str.charAt(i)>='a'&&str.charAt(i)<='z')){
			e++;
		}else{
			if(str.charAt(i)==32){
				s++;
			}else{
				o++;
				}
			}
		}
	}
//�����α��룺֮ǰ�����д��forѭ�����ˣ����²������
System.out.println("the number of letters is"+e);
System.out.println("the number of numbers is"+n);
System.out.println("the number of spaces is"+s);
System.out.println("others in total is"+o);

}
}