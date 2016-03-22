package BookReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadingWithStringMethods {

	public static void main(String[] args) {
		System.out.println("Количество слов в тексте: " + WordCounter());
	}
	/* Вычисление количества строк с использованием методов класса String, q с новой строки - символ окончания текста*/
	public static int WordCounter(){
		String str = "", strBuffered = "";
		String[] strArr;
		InputStream is = System.in;
	
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
			while(!(str = reader.readLine()).equalsIgnoreCase("q")){
				strBuffered += str;
			}
			System.out.println("strBuffered " + strBuffered);
			strArr = strBuffered.split("(\\s*[.,\\()!:;—«»]+\\s*)+|(\\s+)");
			for (String s : strArr){
				System.out.println(s);
			}
			return strArr.length;
		}
		catch(IOException e){
			e.printStackTrace();
			return 0;
			}
		}
}
