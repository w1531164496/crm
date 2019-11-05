package crm.ex;

public class index {
	public int age=0;
	public String name;
	public index() //定义无参数构造方法
	{
		this.age=0;//设定一个初始值
		this.name="无名氏";
	}
	public index(int age,String name)//定义有参数构造方法
	{
		this.age =age;//让他这个参数等于测试里方法调用输入的值
		this.name=name;
	}
	public void add() {System.out.println(age);System.out.println(name);}//增加方法直接输入。
	public void select() {}

}
//父类，方法只有增加和查看，想拥有，删除功能，面向对象方法：开闭原则在原有基础上添加。