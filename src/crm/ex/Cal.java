package crm.ex;

import java.util.Scanner;

public class Cal {

	public static double num1;
	public static double num2;
	public static double result;
	
	public static String oper;
	
	
	
	public static void getInput()
	{
		System.out.println("�����������һ��");
		Scanner sc=new Scanner(System.in);
		num1=sc.nextDouble();
		System.out.println("���������������");
		
		num2=sc.nextDouble();
		sc.nextLine();
		System.out.println("�����������(+-*/)��");
		oper=sc.nextLine();
		
		
	}
	public static void showResult()
	{
		System.out.println(result);
	}
	public static void add()
	{
		result=num1+num2;
	}
	public static void sub()
	{
		result=num1-num2;
	}
	public static void mul()
	{
		result=num1*num2;
	}
	public static void div()
	{
		result=num1/num2;
	}
	
	
	public static void main(String[] args) {
		
		getInput();
		if(oper.equals("+"))
		{
			add();
		}
		else if(oper.equals("-"))
		{
			sub();
		}
		else if(oper.equals("*"))
		{
			mul();
		}
		else
		{
			div();
		}
		
		showResult();
	}

}
