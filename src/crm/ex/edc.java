package crm.ex;

import java.util.Scanner;

public class edc {
	public int s;
	public int f;
	public int m;
	public void outTime()
	{
		Scanner sc=new Scanner(System.in);
		s=sc.nextInt();
		f=sc.nextInt();
		m=sc.nextInt();
		
	}
	private void ontLin()
	{
		System.out.println(s+":"+f+":"+m);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		edc f=new edc();
		f.outTime();
		f.ontLin();
	}

}
