package crm.ex;

public class test2 {
	public void swap( Swap x , Swap   y)
	{
		int temp=x.num;x.num=y.num;y.num=temp;
		
	}
	public static void m()
	{
		Swap x=new Swap(100);
		Swap y=new Swap(30);
		
		test2 f=new test2();
		f.swap(x, y);
		System.out.println(x.num+" "+y.num);
		x=null;
		y=null;
		System.gc();
	}
	
	public static void main(String[] args) {
		
//		m();
//		
//		for(;;);
//		
		//try
		//{
		int x=20;
		int y=0;
		System.out.println(x/y);
//		}
//		catch(Exception ex)
//		{
//			System.out.println(ex.getMessage());
//		}
		System.out.println("¼ÌÐøÔËÓª");
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 