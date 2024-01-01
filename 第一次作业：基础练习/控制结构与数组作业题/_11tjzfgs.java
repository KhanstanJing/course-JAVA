import java.util.Scanner;
class _11tjzfgs{
public static void main(String args[]){
int e=0,s=0,n=0,o=0,i=0;
//第五次编译：初始化变量
//第三次编译：后面for循环要用到i但是前面忘记定义了
String str;
System.out.println("please type in a string!");
Scanner keyin = new Scanner(System.in);
str = keyin.nextLine();
//第五次编译：对于Scanner来说字符串类型为nextLine而不是nextString
//第四次编译：keyin.nextString后面要加括号
for(i=0;i<str.length();i++){
//第七次编译：注意边界条件。前几次编译运行的时候把输出结果写在for循环内部了，所以是每运行一次就输出一遍
//最后当i=length的时候不能输出了就自动停止了，所以有输出
//但是如果把输出结果写在for循环外部的话，由于访问越界，就不能运行了，因此得把=去掉，控制边界条件，才能运行
	if(str.charAt(i)>=48&&str.charAt(i)<=57){
//第四次编译：charAt是函数，应该是str.charAt，不是charAt
//第二次编译：判断字符串中元素ascii码的时候用charAt，str[i]是直接访问
		n++;
//第一次编译：忘记给n++e++这样的语句加;了
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
//第六次编译：之前把这个写在for循环内了，导致不断输出
System.out.println("the number of letters is"+e);
System.out.println("the number of numbers is"+n);
System.out.println("the number of spaces is"+s);
System.out.println("others in total is"+o);

}
}