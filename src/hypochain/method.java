package hypochain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import hypochain.algorithm.evidenceAc;

public class method {
	
	private static int total = 0;
	private static int truenum = 0;
	
	private static String getHTML(String url) {
		String getHtml = " ";
		
		try {
			Document doc = Jsoup.connect(url).get();
			String html = doc.html();
			getHtml = html;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getHtml = "error";
		}		
		return getHtml;
	}
	
	public static int checkURL(String url) {
	
		int result = 0;
		String html = null;
		html = getHTML(url);
		
		if(html=="error") {
			return -1;
		}
		
		if(url.startsWith("https://")) {
			return 0;
		}
		
		evidenceAc evidenceac = new evidenceAc(url,html);
		
		process(evidenceac.ChinaTld());
		process(evidenceac.fastPage());
		process(evidenceac.IPUrl());
		process(evidenceac.javaExe());
		process(evidenceac.linkPossibility());
		process(evidenceac.RussiaTld());
		process(evidenceac.SmishingUrl());
		process(evidenceac.tagExist());
		process(evidenceac.upperAuthority());
		process(evidenceac.SpecialCharacter());
		
		result = percent();
		
		return result;
	}
	
	private static void process(boolean value) {
		
		total++;
		
		if(value) {
			truenum++;
		}
	}
	
	private static int percent() {
		
		float percentage;
		int result = 0;
		
		if(truenum!=0) {
		
		//기준 개수마다 곱하기 조정 (10)
		percentage = (float)total/(float)truenum;
		result = (int) (percentage*10);
		}
		
		return result;
	}
}
