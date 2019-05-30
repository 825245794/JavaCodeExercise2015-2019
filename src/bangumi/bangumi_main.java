package bangumi;

import java.io.IOException;
import java.net.MalformedURLException;

import org.xml.sax.SAXException;

public class bangumi_main {

	public static void main(String[] args) throws MalformedURLException,IOException, SAXException {
		 bangumi_GUI a=new  bangumi_GUI();
		 new Thread(a).start();
	}
		// TODO Auto-generated method stub
//		try {
//			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://www.jb51.net");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
