/**  
* @Title: SalUtils.java
* @Package web
* @Description: TODO(用一句话描述该文件做什么)
* @author A18ccms A18ccms_gmail_com  
* @date 2018年1月8日 下午6:08:46
* @version V1.0  
*/
package web;

/**
 * @ClassName: SalUtils
 * @Description:
 * @author LJL
 * @date 2018/01/08 18:08:46
 *
 */
import java.security.cert.CertificateException;  
import java.security.cert.X509Certificate;  
   
import javax.net.ssl.HostnameVerifier;  
import javax.net.ssl.HttpsURLConnection;  
import javax.net.ssl.SSLContext;  
import javax.net.ssl.SSLSession;  
import javax.net.ssl.TrustManager;  
import javax.net.ssl.X509TrustManager;  
  
public class SalUtils {private static void trustAllHttpsCertificates() throws Exception {  
    TrustManager[] trustAllCerts = new TrustManager[1];  
    TrustManager tm = new miTM();  
    trustAllCerts[0] = tm;  
    SSLContext sc = SSLContext.getInstance("SSL");  
    sc.init(null, trustAllCerts, null);  
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());  
}  
  
static class miTM implements TrustManager,X509TrustManager {  
    public X509Certificate[] getAcceptedIssuers() {  
        return null;  
    }  
  
    public boolean isServerTrusted(X509Certificate[] certs) {  
        return true;  
    }  
  
    public boolean isClientTrusted(X509Certificate[] certs) {  
        return true;  
    }  
  
    public void checkServerTrusted(X509Certificate[] certs, String authType)  
            throws CertificateException {  
        return;  
    }  
  
    public void checkClientTrusted(X509Certificate[] certs, String authType)  
            throws CertificateException {  
        return;  
    }  
}  
   
/** 
 * 忽略HTTPS请求的SSL证书，必须在openConnection之前调用 
 * @throws Exception 
 */  
public static void ignoreSsl() throws Exception{  
    HostnameVerifier hv = new HostnameVerifier() {  
        public boolean verify(String urlHostName, SSLSession session) {   
            return true;  
        }  
    };  
    trustAllHttpsCertificates();  
    HttpsURLConnection.setDefaultHostnameVerifier(hv);  
}  
  
}  