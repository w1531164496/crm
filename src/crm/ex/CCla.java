package crm.ex;

import java.util.Scanner;

public class CCla {
	public static int a;
	public static int b;
	public static int jieugo;
	public static void input()
	{
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
	}
	public static int max(int a,int b)
	{
		
		if(a>b)
		{
			return a;
		}
		else
		{
		return b;}
		
	}
	public static void show()
	{
		System.out.println(jieugo);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input();
		int x=max(20,30);
		
		System.out.print(x);
		//show();
	}
	
	

}
