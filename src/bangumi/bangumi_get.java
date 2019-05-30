package bangumi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class bangumi_get {
	//String path="/Users/LJL/Desktop/img/";
	javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView(); 
	//String path="C:\\Users\\LJL\\Desktop\\img\\";
	//String path=fsv.getDefaultDirectory()+"\\bagu_img\\";
	String path=fsv.getDefaultDirectory()+"/bagu_img/";
	private static final long serialVersionUID = 1L;
	
	String[][] name=new String[7][30];
	String[][] time=new String[7][30];
	String[][] url=new String[7][30];
	String[][] image=new String[7][30];
	String[][] jishu=new String[7][30];
	String[] weekcontent=new String[7];
	String[][] zrs=new String[7][30];
	String[][] zfs=new String[7][30];
	String[][] dms=new String[7][30];
	String[][] gxsj=new String[7][30];
	String[][] jj=new String[7][30];
	int[] counter=new int[7];
	String totalweek=null;
	int week=0;
	Document doc=null;
	public String[][] getZrs() {
		return zrs;
	}

	public void setZrs(String[][] zrs) {
		this.zrs = zrs;
	}

	public String[][] getZfs() {
		return zfs;
	}

	public void setZfs(String[][] zfs) {
		this.zfs = zfs;
	}

	public String[][] getDms() {
		return dms;
	}

	public void setDms(String[][] dms) {
		this.dms = dms;
	}

	public String[][] getGxsj() {
		return gxsj;
	}

	public void setGxsj(String[][] gxsj) {
		this.gxsj = gxsj;
	}

	public String[][] getJj() {
		return jj;
	}

	public void setJj(String[][] jj) {
		this.jj = jj;
	}

	
	
	public String[][] getName() {
		return name;
	}

	public void setName(String[][] name) {
		this.name = name;
	}

	public String[][] getTime() {
		return time;
	}

	public void setTime(String[][] time) {
		this.time = time;
	}

	public String[][] getUrl() {
		return url;
	}

	public void setUrl(String[][] url) {
		this.url = url;
	}

	public String[][] getImage() {
		return image;
	}

	public void setImage(String[][] image) {
		this.image = image;
	}

	public String[][] getJishu() {
		return jishu;
	}

	public void setJishu(String[][] jishu) {
		this.jishu = jishu;
	}

	public int[] getCounter() {
		return counter;
	}

	public void setCounter(int[] counter) {
		this.counter = counter;
	}

	
	
	public bangumi_get(){
		connect();
		subweekcontent();
		selected();
		//recommand();
		jiazai();
	}
	
	public void jiazai(){
		for(int i=0;i<url.length;i++){
			for(int j=0;j<url[i].length;j++){
				if(url[i][j]!=null){
					try {
						Document document = Jsoup.connect("http://"+url[i][j]).get();
						Elements timeinfo = document.select("[class=info-count-item info-count-item-play]");
						zrs[i][j]=timeinfo.text();
					timeinfo = document.select("[class=info-count-item info-count-item-fans]");
						zfs[i][j]=timeinfo.text();
					timeinfo = document.select("[class=info-count-item info-count-item-review]");
						dms[i][j]=timeinfo.text();
					timeinfo = document.select("[class=info-row info-update]");
						gxsj[i][j]=timeinfo.text();
					timeinfo = document.select("[class=info-desc]");
						jj[i][j]=timeinfo.text();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public void recommand(){
		try {
			  HttpUnitOptions.setExceptionsThrownOnScriptError(false);
	    	  WebConversation wc=new WebConversation();//初始化httpunit
	          GetMethodWebRequest req =new GetMethodWebRequest("http://www.bilibili.com");
	          WebResponse rep =wc.getResponse(req);
	          System.out.println(rep.getText());
	          totalweek=rep.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		match(totalweek,"a","href");
	}
	public void connect(){
		try {
			doc = Jsoup.connect("http://bangumi.bilibili.com/anime/timeline").get();
			totalweek=String.valueOf(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "网络连接出现问题，请检查网络连接");
			System.exit(0);
		}
	}
	public void selected(){ 
		for(int i=0;i<7;i++){
			Document document =Jsoup.parse(weekcontent[i]);
			Elements timeinfo = document.select(".update-time");
			Elements nameinfo = document.select(".t");
			Elements jishuinfo = document.select(".update-info");
			int j=0;
			for(int k=0;k<timeinfo.size();k++) {
				//System.out.println(e.text());
				time[i][j]=timeinfo.get(j).text();
				name[i][j]=nameinfo.get(j).text();
				jishu[i][j]=jishuinfo.get(j).text();
				try{
				int begin=weekcontent[i].indexOf("<img src=");
				int end=weekcontent[i].indexOf("72x96.jpg");
				image[i][j]=weekcontent[i].substring(begin+12, end+9);
				begin=weekcontent[i].indexOf("//bangumi.bilibili.com/anime/");
				end=weekcontent[i].indexOf("\" data-type=\"anime\"");
				url[i][j]=weekcontent[i].substring(begin+2, end);;
				weekcontent[i]=weekcontent[i].substring(begin+250);}catch(Exception e){}
				j++;
				}
			counter[i]=j;
			}
		for(int i=0;i<time.length;i++){
				//System.out.println(counter[i]+"周"+i);
				for(int j=0;j<time[i].length;j++){
					if(time[i][j]!=null){
					downImg("http://"+image[i][j],i,j);
					//System.out.println(time[i][j]+name[i][j]+"  "+jishu[i][j]+"  "+image[i][j]+"  "+url[i][j]);
					}
				}
			
		}
	}
	
	public void subweekcontent(){
		int begin,end;
		for(int i=0;i<7;i++){
			if(i==6){
				begin=totalweek.indexOf("week-icon week-day-"+i);
				weekcontent[i]=totalweek.substring(begin);
				end=weekcontent[i].indexOf("week-icon week-day-0");
				weekcontent[i]=weekcontent[i].substring(0,end);
				continue;
			}
		begin=totalweek.indexOf("week-icon week-day-"+i);
		weekcontent[i]=totalweek.substring(begin);
		end=weekcontent[i].indexOf("week-icon week-day-"+(i+1));
		weekcontent[i]=weekcontent[i].substring(0,end);
		}
		
		//System.out.println(weekcontent[3]);
	}
	
	    
	    /** 
	     * 获取指定HTML标签的指定属性的值 
	     * @param source 要匹配的源文本 
	     * @param element 标签名称 
	     * @param attr 标签的属性名称 
	     * @return 属性值列表 
	     */  
	    public void match(String source, String element, String attr) {  
	        List<String> result = new ArrayList<String>();  
	        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";  
	        Matcher m = Pattern.compile(reg).matcher(source);  
	        while (m.find()) {  
	            String r = m.group(1);  
	            result.add(r);  
	        }  
	        for(int i=0;i<result.size();i++){
	        //System.out.println(result.get(i)); 
	        }
	    }  
	      
	    private void downImg(String src,int x,int y){
	    	javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView(); 
	    	File f=new File(fsv.getDefaultDirectory().toString()+"/bagu_img/");
	    	//fsv.getDefaultDirectory()+"\\bagu_img"
	    	if(!f.exists()){
	    		f.mkdirs();
	    	}
	    	@SuppressWarnings({ "resource", "deprecation" })
			HttpClient httpClient=new DefaultHttpClient();
			File fileDir=new File(path);
			if(!fileDir.exists()){
			fileDir.mkdirs();
			}
			File file=new File(path+String.valueOf(x)+String.valueOf(y)+".tmp");
			if(file.exists()){
			file.delete();
			}
			InputStream input = null;
			FileOutputStream out= null;
			HttpGet httpGet=new HttpGet(src);
			try {
			HttpResponse response=httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			input = entity.getContent();
			int p=-1;
			byte[] byt=new byte[1];
			out=new FileOutputStream(file);
			while((p=input.read(byt))!=-1){
			out.write(byt);
			out.flush();
			}
			out.close();
			//System.out.println("图片下载成功！");
			file.renameTo(new File(path+String.valueOf(x)+String.valueOf(y)+".jpg"));
			} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}}
	    
	public static void main(String[] args) throws MalformedURLException,IOException, SAXException {
		 bangumi_get a=new  bangumi_get();
		
		
	}
}
