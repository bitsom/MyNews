

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class RssFeedHandler {

	public static void parseRss(String urlAdd){
		//String urlAdd = "http://feeds.bbci.co.uk/news/world/rss.xml";
		//rssUrl = new URL(urlAdd);
		try{
		Document doc = Jsoup.connect(urlAdd).get();
		
		if (doc != null)
        {
           // ToldotItem item = null;

            String cssPath = "item";
            Elements links = doc.select("item");

            for (org.jsoup.nodes.Element link : links) {

                org.jsoup.nodes.Document docInner = Jsoup.parse(link.outerHtml());
               // item = new ToldotItem();
                   Elements linksInner = docInner.select("title");
                   String title =    linksInner.text();
                   

                    linksInner = docInner.select("pubDate");
                    String pubDate  = linksInner.text();

                    linksInner = docInner.select("link");
                    String _link  = linksInner.text();

                    linksInner = docInner.select("description");
                    String description  = linksInner.text();

                    linksInner = docInner.select("guid");
                    String guid  = linksInner.text();

                    linksInner = docInner.select("author");
                    String author  = linksInner.text();

                    linksInner = docInner.select("media|thumbnail ");
                    String thumbnail  = linksInner.attr("url");

                    linksInner = docInner.select("media|content");
                
                    if (linksInner.size()>0)
                    {
                    	//Log.d(Helpers.TAG, "links: "+linksInner.size());
                    	String video  = linksInner.attr("url");
                    	String videoFileSize  = linksInner.attr("fileSize");
                    	String videoDuration  = linksInner.attr("duration");
                    }
                    linksInner = docInner.select("media|content");
                    if (linksInner.size()>0)
                    {
                    	String audio  = linksInner.attr("url");
                    	String audioFileSize  = linksInner.attr("fileSize");
                        String audioDuration  = linksInner.attr("duration");
                    }
               // list.add(item);

            }
        }
		}catch(Exception e){
			System.out.println("Exception e");
		}
	}
	
	public static void main(String[] args) {
		String urlAdd = "http://feeds.bbci.co.uk/news/world/rss.xml";
		parseRss(urlAdd);
	}

}
