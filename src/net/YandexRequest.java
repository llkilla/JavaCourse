package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class YandexRequest {

/*
 * Текст запроса: литература по java
 * 	https://yandex.ru/search/?lr=65&msid=22912.3568.1460908407.6659&text=%D0%BB%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D1%83%D1%80%D0%B0+%D0%BF%D0%BE+java&suggest_reqid=143144779142107732648606954390875&csg=1567%2C3898%2C9%2C12%2C1%2C0%2C0
 */

	public static void main(String[] args) {
		String charset = java.nio.charset.StandardCharsets.UTF_8.name();
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36";
		/*
		 * Параметры можно передать в виде одной строки при создании URL (без кодирования), так тоже будет работать
		 * */
		String params = "lr=65" + "&msid=22912.3568.1460908407.6659" + "&text=%D0%BB%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D1%83%D1%80%D0%B0+%D0%BF%D0%BE+java" +
				 "&suggest_reqid=143144779142107732648606954390875" + "&csg=1567%2C3898%2C9%2C12%2C1%2C0%2C0";
		
		String lr = "65";
		String msid = "22912.3568.1460908407.6659";
		String text = "%D0%BB%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D1%83%D1%80%D0%B0+%D0%BF%D0%BE+java";
		String suggest_reqid = "143144779142107732648606954390875";
		String csg = "1567%2C3898%2C9%2C12%2C1%2C0%2C0";
		String query;
		String responseBody;
		
		try {
			query = String.format("lr=%s&msid=%s&text=%s&suggest_reqid=%s&csg=%s", 
				     URLEncoder.encode(lr, charset), 
				     URLEncoder.encode(msid, charset),
				     URLEncoder.encode(text, charset),
				     URLEncoder.encode(suggest_reqid, charset),
				     URLEncoder.encode(csg, charset));
		
			URL yaURL = new URL("https://www.yandex.ru" + "/search/?" + query);
			URLConnection yaConnection = yaURL.openConnection();
									
			yaConnection.setRequestProperty("User-Agent", userAgent);
			
			yaConnection.setRequestProperty("Accept-Charset", charset);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(yaConnection.getInputStream()));
	        
	        while ((responseBody = br.readLine()) != null)
	            System.out.println(responseBody);

	        br.close();    
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
