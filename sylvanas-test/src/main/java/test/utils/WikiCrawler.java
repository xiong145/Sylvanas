package test.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WikiCrawler {
    public static void main(String[] args) {
        String url = "https://www.baidu.com/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements paragraphs = doc.select("head#meta");
            for (Element p : paragraphs) {
                System.out.println(p.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
