package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.8"
				+ "/crazyck101/feed?fields=id,likes.limit(0).summary(total_count),reactions.limit(0).summary(total_count)"
				+ "&access_token=186351491872243%7CWSWcwXuO-5LwkTAZwtyiFuMXffY";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,likes,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String likes = data.select("likes").text();
			String reactions = data.select("reactions").text();
			// FIXIT
			//String reactions = "id,按讚數,心情";


			output += id+"\","+likes+","+reactions+"\n";
		}

		System.out.println( output );
	} 
}
