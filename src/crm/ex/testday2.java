package crm.ex;

import java.util.Random;
import java.util.Scanner;

public class testday2 {

	/**
	 * 封装消息方法
	 * @param msg 要显示的信息
	 */
	public static void sout(String msg)
	{
		System.out.println(msg);
	}
	
	
	public static void menu()
	{
		sout("*****猜数字*****");
		sout("*  1.开始游戏   *");
		sout("*  2.难度调整   *");
		sout("*  3.退出游戏   *");
		sout(" *************");			
	}
	
	
	public static void playGame(int level)
	{
		Random ra = new Random();/*随机分配数值*/
		int suijishu = 0;/*定义数值 suijishu*/
		suijishu = ra.nextInt((100) + 1);/*1-100随机分配*/
		int i=0;/*定义值i*/
		for ( i = 1; i <=level; i++) {
			sout("请输入1-100的数字");/*输入数字*/
			int shu = 0;/*定义一个值*/
			Scanner acc = new Scanner(System.in);/*获取*/
			shu = acc.nextInt();/*获取*/
			if (suijishu < shu) {
				sout("数字过大");
			} else if (suijishu > shu) {
				sout("数字过小");
			} else if (suijishu == shu) {
				sout("恭喜你赢了");
				break;
			}
			
	
	}
		if(i>level)
		{ 
			sout("游戏失败,正确答案是:"+suijishu);
			
		}
	}
	
	
	
	public static int setLevel()
	{
		sout("****难度调整****");
		sout("*    1.简单      *");
		sout("*    2.正常      *");
		sout("*    3.困难      *");
		sout(" *************");
		int nandu=0;
		Scanner sc = new Scanner(System.in);/*获取*/
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
				
		/*猜数字游戏*/
		int level=6;/*难度调整，等级设定，case1+case2共用一个*/
	while(true) {	
		
		menu();
		
		int xuanze=0;/*定义值，变量名xuanze*/
		Scanner sc=new Scanner(System.in);/*获取变量*/
		xuanze=sc.nextInt();/*获取变量*/
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
