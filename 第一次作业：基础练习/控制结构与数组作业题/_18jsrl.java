import java.util.Scanner;
class _18jsrl{
public static void main(String args[]){
	int y,m,d,wd;
	Scanner keyin=new Scanner(System.in);
	System.out.println("please type in the year:");
	y=keyin.nextInt();
	System.out.println("please type in the month:");
	m=keyin.nextInt();
	if(m==1|m==2){
		m=m+12;
		y=y-1;
		}
	System.out.println("please type in the day:");
	d=keyin.nextInt();
	wd=(d+26*(m+1)/10+(21*((y-y%100)/100)+5*(y%100))/4)%7;
	System.out.println("the date is:"+wd);
}
}