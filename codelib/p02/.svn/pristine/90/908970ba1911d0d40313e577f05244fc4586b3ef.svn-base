package cn.innohub.crawler.parse.t17;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;

public class HttpUtils {     
    public static String getCotnent(String url) throws IOException {     
        Runtime rt = Runtime.getRuntime();     
        Process p = rt.exec("E:\\devsf\\javadev\\phantomjs\\bin\\phantomjs.exe E:\\devsf\\javadev\\phantomjs\\bin\\test01.js "+url);//这里我的codes.js是保存在c盘下面的phantomjs目录     
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));     
        StringBuffer sbf = new StringBuffer();     
        String tmp = "";     
        while((tmp = br.readLine())!=null){ 
        	System.out.println(tmp+"\n");
            sbf.append(tmp);     
        }     
        //System.out.println(sbf.toString());     
        return sbf.toString();     
    }     
     
    public static void main(String[] args) throws IOException {     
        String a = getCotnent("http://www.renrentou.com/");  
        FileUtils.write(new File("e:\\t.txt"), a);
//        System.out.println(a);
    }     
} 