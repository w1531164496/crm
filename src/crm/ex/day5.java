package crm.ex;


import java.util.Scanner;

public class day5 {
	public int sz;
	public int fz;
	public int mz;
	public void  setTime()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("������ʱ��");
		sz=sc.nextInt();
		System.out.println("������֣�");
		fz=sc.nextInt();
		System.out.println("�������룺");
		mz=sc.nextInt();
	}
	
	public void showTime()
	{
		System.out.println(sz+":"+fz+":"+mz);
	}
	
	//���������ʵ������  ���Ƕ���ĳ���

	public static void main(String[] args) {

		day5  d=new day5(); //������
		
		d.setTime();
		d.showTime();
		sd i=new sd();
		i.sw();
		
		edc f=new edc();
	
		

	}

}
