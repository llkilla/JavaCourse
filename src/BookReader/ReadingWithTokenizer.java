package BookReader;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReadingWithTokenizer {
	public static void main(String[] args){
		System.out.println("Количество слов в тексте: " + WordCounter());
	}
	/* Вычисление количества строк с использованием класса StringTokenizer, q с новой строки - символ окончания текста*/
	public static int WordCounter(){
		int cnt = 0;
		String str = "", strBuffered = "";
		InputStream is = System.in;
	
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
			while(!(str = reader.readLine()).equalsIgnoreCase("q")){
				strBuffered += str;
			}
			System.out.println("strBuffered " + strBuffered);
			StringTokenizer sTokenizer = new StringTokenizer(strBuffered, ".,\\()!:;— ");
			while(sTokenizer.hasMoreTokens()){
			      System.out.println(sTokenizer.nextToken());
			      cnt++;
			      }
			return cnt;
		}
		catch(IOException e){
			e.printStackTrace();
			return 0;
			}
		}
}
