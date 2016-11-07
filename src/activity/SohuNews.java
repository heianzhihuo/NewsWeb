package activity;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.News;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

public class SohuNews {

	List<News> ShNews;
	
	
	static protected void getURL(String u){
		URL url;
		InputStream is;
		InputStreamReader isr;
		BufferedReader r;
		String str;
		OutputStream out = null;
		
		Pattern p1= Pattern.compile("十二大关键词解读十八届六中全会公报");
		Matcher m1;
		
		try{
			System.out.println("Reading URL: "+u);
			url = new URL(u);
			is = url.openStream();
			isr = new InputStreamReader(is);
			r = new BufferedReader(isr);
			out = new FileOutputStream("test.txt");
			//out.write(r.re);
			do {
				str = r.readLine();
				
				if(str!=null){
					byte [] temp = str.getBytes();
					out.write(temp);
				}
					
					//System.out.println(str);
			}while(str!=null);
		}catch(MalformedURLException e){
			System.out.println("Must enter a valid URL");
		}catch(IOException e){
			System.out.println("Can't connect");
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请按回车键开始");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.setProperty("http.proxyHost","socks.myhost.com");
		System.setProperty("http.proxyPort","1080");
		getURL("http://news.sohu.com/");
		System.out.println("Success");
		
	}

}
