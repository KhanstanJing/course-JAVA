class StringBuildertest{
public static void main(String[] args){
	StringBuilder sb1 = new StringBuilder("LanZhou");
	StringBuilder sb2 = new StringBuilder("LanZhou");
	System.out.println(sb1 == sb2);
	System.out.println("sb2's capacity="+sb2.capacity());
	StringBuilder sb3 = sb2;
	System.out.println(sb3 == sb2);
	sb3.append("University");
	System.out.println("sb2 now="+sb2);
}
}