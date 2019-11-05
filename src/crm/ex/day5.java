package crm.ex;


import java.util.Scanner;

public class day5 {
	public int sz;
	public int fz;
	public int mz;
	public void  setTime()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入时：");
		sz=sc.nextInt();
		System.out.println("请输入分：");
		fz=sc.nextInt();
		System.out.println("请输入秒：");
		mz=sc.nextInt();
	}
	
	public void showTime()
	{
		System.out.println(sz+":"+fz+":"+mz);
	}
	
	//对象是类的实例化，  类是对象的抽象

	public static void main(String[] args) {

		day5  d=new day5(); //对象定义
		
		d.setTime();
		d.showTime();
		sd i=new sd();
		i.sw();
		
		edc f=new edc();
	
		

	}

}
