package crawler.httpunit;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class Test01 {
	public static   void main(String[] args) throws Exception{
		WebConversation wc = new WebConversation();
//		WebResponse wr = wc.getResponse( "http://www.innohub.net/sciencemarket/article/index.html" );
//		WebResponse wr = wc.getResponse( "http://www.innohub.net/sciencemarket/article/detail.html?id=1298" );
		
//		WebRequest wreq =
		
		WebResponse wr = wc.getResponse( "https://www.baidu.com" );
		System.out.println( wr.getText() );
	}
}
