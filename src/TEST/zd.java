package TEST;

import java.io.IOException;

public class zd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Runtime.getRuntime().exec("sudo chmod 755 /usr/local/apache-tomcat-9.0.0.M11/bin/*.sh");
		
			Runtime.getRuntime().exec("cd /usr/local/apache-tomcat-9.0.0.M11");
			Runtime.getRuntime().exec("shutdown.sh");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
