package a23_socket;

/*

���󣺽���һ���ı�ת����������
�ͻ��˸�����˷����ı������񵥻Ὣ�ı�ת�ɴ�д�ڷ��ظ��ͻ��ˡ�
���ҿͻ��ȿ��Բ��ϵĽ����ı�ת�������ͻ�������overʱ��ת��������

������
�ͻ��ˣ�
��Ȼ�ǲ����豸�ϵ����ݣ���ô�Ϳ���ʹ��io������������io�Ĳ���������˼����
Դ������¼�롣
Ŀ�ģ������豸�������������
���Ҳ��������ı����ݡ�����ѡ���ַ�����

����
1����������
2����ȡ����¼�롣
3�������ݷ�������ˡ�
4����ȥ����˷��صĴ�д���ݡ�
5������������Դ��

�����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʣ����뻺�塣


*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyTCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 10005);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line))
				break;
			out.println(line);
			String str = bufIn.readLine();
			System.out.println("server:" + str);

		}

		bufr.close();
		s.close();
	}
}

