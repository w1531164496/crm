package crm.ex;

public class index {
	public int age=0;
	public String name;
	public index() //�����޲������췽��
	{
		this.age=0;//�趨һ����ʼֵ
		this.name="������";
	}
	public index(int age,String name)//�����в������췽��
	{
		this.age =age;//��������������ڲ����﷽�����������ֵ
		this.name=name;
	}
	public void add() {System.out.println(age);System.out.println(name);}//���ӷ���ֱ�����롣
	public void select() {}

}
//���࣬����ֻ�����ӺͲ鿴����ӵ�У�ɾ�����ܣ�������󷽷�������ԭ����ԭ�л�������ӡ�