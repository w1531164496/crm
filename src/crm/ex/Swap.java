package crm.ex;

public class Swap {

	public int num;
	public Swap(int num)
	{
		this.num=num;
		System.out.println("���󴴽�");
	}
	public void finalize( )
	{
		System.out.println("��������ͷ�");
	}
}
