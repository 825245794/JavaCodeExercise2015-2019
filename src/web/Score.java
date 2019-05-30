package web;
import java.util.ArrayList;

import java.util.List;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class Score{

public List<String> courseName = new ArrayList<String>();

public List<String> score = new ArrayList<String>();

public Score(String result) {

parseHtml(result);

}

//解析html

public void parseHtml(String result){

Document doc = Jsoup.parse(result,"UTF-8");

Elements elements = doc.getElementsByClass("smartTr");

for (Element element : elements) {

Elements e = element.select("td");

courseName.add(e.get(4).text());

score.add(e.get(5).text());

}

}

}



