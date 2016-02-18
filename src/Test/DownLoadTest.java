package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class DownLoadTest {
	
	@Test
	public void testDown() throws Exception{
		
		OutputStream out = new FileOutputStream("c:\\test.pdf");
		String url = "http://www.gjt.org/download/time/java/tar/javatar-2.5.tar.gz";
		
		HttpClient client = new DefaultHttpClient();
		HttpGet post = new HttpGet(url);
		HttpResponse response = client.execute(post);
		HttpEntity entity = response.getEntity();
		InputStream in = entity.getContent();
		System.out.println(entity.getContentLength());
		save(in, out);
		
		out.close();
		in.close();
		
	}
	@Test
	public void fileCopy() throws IOException{
		InputStream in = new FileInputStream("f:\\ЩЈТы.rar");
		OutputStream out = new FileOutputStream("f:\\ЩЈТы22.rar");
		
		save(in, out);
		
		in.close();
		out.close();
	}
	
	public void save(InputStream in, OutputStream out) throws IOException{
		byte[] data = new byte[1024*1024];
		int length;
		while ( (length = in.read(data)) != -1){
			out.write(data, 0, length);
			out.flush();
		} 
	}
	

}
