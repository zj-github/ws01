package c00_javase.a03_cycle;
/*
1,��ȡ1~10�ĺͣ�����ӡ��

*/

class  ForTest2
{
	public static void main(String[] args) 
	{

		/*
	
		//1,����������ڴ洢���ϱ仯�ĺ͡�
		int sum = 0;

		//2�������������¼ס���ϱ仯�ı��ӵ�����
		int x = 1;
		//3������ѭ�����ظ��ӷ��Ĺ��̡�
		while(x<=10)
		{
			sum = sum + x;
			x++;

		}
		System.out.println("sum="+sum);

		*/
		/*
		ѭ��ע�⣺
		һ��Ҫ��ȷ��Щ�����Ҫ����ѭ������Щ����Ҫ��
		*/
		/*
	  0+1
		1+2
		 3+3
		   6+4
		   */
		//��for�����֡�
		int sum = 0;

		for(int x=0; x<=10; x++)
		{
			sum += x;
			
		}
		System.out.println("for sum = "+sum);

		/*
		��ʵ������ۼ�˼�롣
		ԭ����ͨ��������¼סÿ�α仯�Ľ����
		ͨ��ѭ������ʽ�������ۼӶ�����

		*/
	}
}