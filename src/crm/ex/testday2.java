package crm.ex;

import java.util.Random;
import java.util.Scanner;

public class testday2 {

	/**
	 * ��װ��Ϣ����
	 * @param msg Ҫ��ʾ����Ϣ
	 */
	public static void sout(String msg)
	{
		System.out.println(msg);
	}
	
	
	public static void menu()
	{
		sout("*****������*****");
		sout("*  1.��ʼ��Ϸ   *");
		sout("*  2.�Ѷȵ���   *");
		sout("*  3.�˳���Ϸ   *");
		sout(" *************");			
	}
	
	
	public static void playGame(int level)
	{
		Random ra = new Random();/*���������ֵ*/
		int suijishu = 0;/*������ֵ suijishu*/
		suijishu = ra.nextInt((100) + 1);/*1-100�������*/
		int i=0;/*����ֵi*/
		for ( i = 1; i <=level; i++) {
			sout("������1-100������");/*��������*/
			int shu = 0;/*����һ��ֵ*/
			Scanner acc = new Scanner(System.in);/*��ȡ*/
			shu = acc.nextInt();/*��ȡ*/
			if (suijishu < shu) {
				sout("���ֹ���");
			} else if (suijishu > shu) {
				sout("���ֹ�С");
			} else if (suijishu == shu) {
				sout("��ϲ��Ӯ��");
				break;
			}
			
	
	}
		if(i>level)
		{ 
			sout("��Ϸʧ��,��ȷ����:"+suijishu);
			
		}
	}
	
	
	
	public static int setLevel()
	{
		sout("****�Ѷȵ���****");
		sout("*    1.��      *");
		sout("*    2.����      *");
		sout("*    3.����      *");
		sout(" *************");
		int nandu=0;
		Scanner sc = new Scanner(System.in);/*��ȡ*/
		nandu=sc.nextInt();
		
		switch(nandu)
		{
		case 1:
			return 6;
			
		case 2:
			return 5;
			
		default:
			return 3;
			
		}
	}
	
	
	public static void main(String[] args) {
				
		/*��������Ϸ*/
		int level=6;/*�Ѷȵ������ȼ��趨��case1+case2����һ��*/
	while(true) {	
		
		menu();
		
		int xuanze=0;/*����ֵ��������xuanze*/
		Scanner sc=new Scanner(System.in);/*��ȡ����*/
		xuanze=sc.nextInt();/*��ȡ����*/
		switch(xuanze)
		{
		case 1:
			playGame(level);
			break;
			
		case 2:
			level=setLevel();
			break;
			
			
		case 3:
			return ;
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
