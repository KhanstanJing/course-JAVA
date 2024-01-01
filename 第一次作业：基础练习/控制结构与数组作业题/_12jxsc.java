import java.util.Scanner;
class _12jxsc{
public static void main(String args[]){
	int i,j;
	double b;
	System.out.println("please type in the sequence:");
	double a[] = new double[10];
	Scanner keyin = new Scanner(System.in);
	for(i=0;i<10;i++){
		a[i] = keyin.nextDouble();
	}
	//在这一步输入数组元素的时候如果用e代替则不能赋值
	for(i=0;i<10;i++){
		for(j=i+1;j<10;j++){
			if(a[i]<=a[j]){
				b=a[i];
				a[i]=a[j];
				a[j]=b;
			}
		}
	}
	System.out.println("the ordered sequence is:");
	for(double e:a){
		System.out.println(e);
	//应该是e初始化之后有值之后才能利用它遍历数组中元素
	}
}
}