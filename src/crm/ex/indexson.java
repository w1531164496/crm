package crm.ex;

public class indexson extends index {
	
	
	public indexson() {//（）里没参数就是空
		super();//调用父类无参数
		
		// TODO Auto-generated constructor stub
	}

	public indexson(int age,String name ) {//有参数就输入父类定义的数据类型和类名
		super(age,name);//调用父类的有参数
		
		
	}

	public void del() {}

}
//子类，继承了父类的添加，查看功能，并且新作了删除功能