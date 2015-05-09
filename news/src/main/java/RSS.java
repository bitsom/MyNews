
import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class RSS {
	
	public static void main(String[] args){
		//System.out.println(readRSS("http://rss.cnn.com/rss/edition.rss"));
		//readRSS("http://rss.cnn.com/rss/edition.rss");
		readRSS("http://feeds.bbci.co.uk/news/world/rss.xml");
		
	}
	
	public static void readRSS(String urlAdd){
		
		URL rssUrl;
		try {
			rssUrl = new URL(urlAdd);
			Document doc = Jsoup.connect(urlAdd).get();
			
			Elements item = doc.select("item");
			
		/*	for (Element src : item) {
				//System.out.println("items : " + src);
				
				Elements elm = src.children();
				for(Element e : elm){
					//System.out.println(e);
					
				if (e.tagName().equals("title")){
					Element title = e.tagName("title");
					String _titile = title.text();
					
					System.out.println("_titile " + _titile);
				}
				
				else if (e.tagName().equals("description")){
					Element desc = e.tagName("description");
					String _des  = desc.text();
					
					System.out.println("_des " + _des);
				}
					
				else if (e.tagName().equals("guid")){
					Element guid = e.tagName("guid");
					String _guid  = guid.text();
					
					System.out.println("_guid " + _guid);
				}	
					
				else if (e.tagName().equals("pubdate")){
					Element pubdate = e.tagName("pubdate");
					String _pubdate  = pubdate.text();
					
					System.out.println("_pubdate " + _pubdate);
				}		
					
			  else if (e.tagName().equals("media")){
					Element media = e.tagName("media");
					String _media  = media.textNodes().get(0).text();
					System.out.println("_media " + _media);
				}else{
					System.out.println(" else " + e);
				}
				
				
					
				}
	        }
			
			Elements title = item.select("title");
			Elements desc = doc.select("description");
	        Elements guid = doc.select("guid");
	        Elements pubDate = doc.select("description");
	        Elements media = doc.select("guid");
	        
	        
	        
	        
	       // Elements imports = doc.select("link[href]");

	      /*  print("\nMedia: (%d)", media.size());
	        for (Element src : media) {
	            if (src.tagName().equals("img"))
	                print(" * %s: <%s> %sx%s (%s)",
	                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
	                        trim(src.attr("alt"), 20));
	            else
	                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
	        }

	        print("\nImports: (%d)", imports.size());
	        for (Element link : imports) {
	            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
	        }
			*/
			
		/*	BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
			String sourcCode = "";
			String line = "";
			while((line = in.readLine())!=null){
				System.out.println(line);
			} */
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
	
	private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

}
