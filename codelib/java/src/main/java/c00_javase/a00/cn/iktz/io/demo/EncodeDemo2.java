package c00_javase.a00.cn.iktz.io.demo;
class EncodeDemo2 
{
	public static void main(String[] args) throws Exception
	{
		String s = "ÁªÍ¨";

		byte[] by = s.getBytes("gbk");

		for(byte b : by)
		{
			System.out.println(Integer.toBinaryString(b&255));
		}


		System.out.println("Hello World!");
	}
}
