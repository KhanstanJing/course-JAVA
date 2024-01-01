public class WrapClasstest1{
public static void main(String[] args){
	Integer int1 = 120;
	Integer int2 = 120;
	Integer int3 = 129;
	Integer int4 = 129;
	Integer int5 = new Integer(120);
	System.out.println(int1 == int2);
	System.out.println(int3 == int4);
	System.out.println(int1 == int5);
}
}