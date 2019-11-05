package crm.ex;

import java.util.Scanner;

public class sd {
	public int sz;
	public int fz;
	public int mz;
	public void ss()
	{
		Scanner sc=new Scanner(System.in);
		sz=sc.nextInt();
		
		fz=sc.nextInt();
		
		mz=sc.nextInt();
		
	}
	public void sw()
	{
		System.out.println(sz+":"+fz+":"+mz);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sd f=new sd();
		f.ss();
		f.sw();
	}

}
