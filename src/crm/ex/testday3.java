package crm.ex;

import java.util.Scanner;

public class testday3 {

	
	
	
	public static double js(double a,String b,double c) {
		
		double d=0;
		if(b.equals("+"))
		{
			 d=a+c;
			
		}
		
		else if(b.equals("-"))
		{
			 d=a-c;
		}
		 
		else if(b.equals("*"))
		 {
			 d=a*c;
		 }
		else if(b.equals("/"))
		 {
			 d=a/c;
		 }
		
		return d;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {System.out.println("请输入数字");
		double a=0;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		System.out.println("请输入数字");
		double c=0;
		
		c=sc.nextDouble();
		sc.nextLine();
		System.out.println("请输入运算符:");
		String b=" ";
		b=sc.nextLine();
		double d=0;
		d=js(a,b,c);
		
		 System.out.println(d);
		
	}

}
}
