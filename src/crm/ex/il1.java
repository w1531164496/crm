package crm.ex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.*;



public class il1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	Scanner sc=new Scanner(System.in);
//	String i=sc.nextLine();
//		System.out.println(i.length());//读取你的字符长度
//	System.out.println(i.charAt(3));//读取数值中的第三位
//
//		int temp;
//		temp=i.lastIndexOf('.');//从最后一个.输出
//		System.out.println(i.substring(temp+1));//截取的位置
//		
//		
//		String j=i.concat("hheheheheheh");//连接函数
//		System.out.print(j);
		/*
		 * int [] ar= {10,23,60,40,50};//直接输出数组
		 * System.out.println(ar.length);//.length字符串长度
		 * 
		 * for(int ji=0;ji<5;ji++) { System.out.println(ar[ji]); }
		 * 
		 */
		
		
		
		
		
		
//				String content = "010-32434283";//正则表达数
//
//		      //String pattern = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
//		      
//		     
//		      String pattern = "^0[1-9][0-9]([0-9]{0,1})-\\d{7,8}$";
//			    
//		      
//		      
//		      
//		      
//		      
//		 
//		      boolean isMatch = Pattern.matches(pattern, content);
//		      System.out.println( isMatch);
		
		
//		Date c1=new Date();
//		System.out.print(c1.toString() );
//		 SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
//		 System.out.print(ft.format(c1));
//		 System.out.printf("%s %tB %<te, %<tY",  "Due date:", c1);
//		
		
		
		
		
//		try {
//			
//			
////			OutputStream os=new FileOutputStream("d:\\a.txt");
//			
////			os.write(48);	os.write(48);	os.write(48);
////			os.close();
////			
//			InputStream is=new FileInputStream("d:\\a.txt","utf-8");
//			int size=is.available();
//			char ch;
//			for(int i=0;i<size;i++)
//			{
//				 ch=(char)is.read();
//				 System.out.print(ch);
//				
//			}
//			is.close();
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
		
			String fileContent = "";
			try {
			File f = new File("d:\\img.jpg");
			if(f.isFile()&&f.exists()){
			InputStreamReader read = new InputStreamReader(new FileInputStream(f),"UTF-8");
			BufferedReader reader=new BufferedReader(read);
			String line;
			while ((line = reader.readLine()) != null) {
			fileContent += line;
			}
			read.close();
			System.out.println(fileContent);
			}
			} catch (Exception e) {
			
			}
			
		
		
		
		
		
		
		
	}

}
