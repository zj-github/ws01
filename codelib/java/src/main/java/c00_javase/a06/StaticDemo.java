package c00_javase.a06;
/*
��̬��static��
�÷�����һ�����η����������γ�Ա(��Ա��������Ա����).
����Ա����̬���κ󣬾Ͷ���һ�����÷�ʽ�����˿��Ա���������⣬
������ֱ�ӱ��������á�����.��̬��Ա��


static�ص㣺
1��������ļ��ض����ء�
   Ҳ��˵����̬�����������ʧ����ʧ��˵�����������������

2�������ڵĶ������
��ȷһ�㣺��̬���ȴ��ڡ������Ǻ���ڵġ�

3�������ж���������
4������ֱ�ӱ����������á�

ʵ�������������������
1�����λ�á�
	�����������ļ��ض������ڷ������С�
	ʵ���������Ŷ���Ľ����������ڶ��ڴ��С�
2���������ڣ�
	�������������������������ʧ����ʧ��
	ʵ�����������������Ŷ������ʧ����ʧ��



��̬ʹ��ע�����
1����̬����ֻ�ܷ��ʾ�̬��Ա��
	�Ǿ�̬�����ȿ��Է��ʾ�̬Ҳ���Է��ʷǾ�̬��
2����̬�����в����Զ���this��super�ؼ��֡�
	��Ϊ��̬�����ڶ�����ڡ����Ծ�̬�����в����Գ���this��
3���������Ǿ�̬�ġ�
	


��̬�����б�
�������Զ���Ĺ������ݽ��е����ռ�Ĵ洢����ʡ�ռ䡣û�б�Ҫÿһ�������ж��洢һ�ݡ�
	����ֱ�ӱ��������á�
�׶ˣ��������ڹ�����
	  ���ʳ��־����ԡ�(��̬��ã�ֻ�ܷ��ʾ�̬��)
*/

class StaticDemo {
	static class Person {
		String name;// ��Ա������ʵ��������
		static String country = "CN";// ��̬�ĳ�Ա�������������

		public static void show() {
			System.out.println("::::");
//			this.haha();
		}

		public void haha() {
		}
	}

	public static void main(String[] args) {
		Person p = new Person();
		// p.name = "zhangsan";
		// p.show();

		// System.out.println(p.country);

		// System.out.println(Person.country);

		Person.show();
	}
}