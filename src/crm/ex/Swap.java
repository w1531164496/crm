package crm.ex;

public class Swap {

	public int num;
	public Swap(int num)
	{
		this.num=num;
		System.out.println("对象创建");
	}
	public void finalize( )
	{
		System.out.println("对象对象释放");
	}
}
