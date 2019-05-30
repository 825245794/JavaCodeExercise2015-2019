package bangumi;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
	static Document document;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			document = Jsoup.connect("http://bangumi.bilibili.com/anime/5851").get();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(document.text());
		Elements timeinfo = document.select("[class=info-count-item info-count-item-play]");
			System.out.println(timeinfo.text());
		timeinfo = document.select("[class=info-count-item info-count-item-fans]");
			System.out.println(timeinfo.text());
		timeinfo = document.select("[class=info-count-item info-count-item-review]");
			System.out.println(timeinfo.text());
		timeinfo = document.select("[class=info-row info-update]");
			System.out.println(timeinfo.text());
		timeinfo = document.select("[class=info-desc]");
			System.out.println(timeinfo.text());
	}

}
