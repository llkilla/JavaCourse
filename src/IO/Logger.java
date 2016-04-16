package IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

enum logLevel {
	WARN, INFO, TRACE, CRITICAL
};

public class Logger {
	public File file;
	public logLevel level;
	public String message;
	public static long initTime;

	static class CustomThread implements Runnable {
		FileWriter fw;
		logLevel level;

		public CustomThread(FileWriter fw, logLevel level) {
			this.fw = fw;
			this.level = level;
		}

		@Override
		public void run() {
			long  timeWorking = 0;
			Random random = new Random();

			{
				while (timeWorking <= 60000) {
					try {
						put(fw, level, "message");

						Thread.sleep(random.nextInt(5000));
						timeWorking = System.currentTimeMillis() - initTime;

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		String fname = System.getProperty("user.dir") + "\\logger.txt";
		long timeWorking = 0;

		initTime = System.currentTimeMillis();

		System.out.println("Начало работы программы... ");
		try {
			FileWriter fw = new FileWriter(fname, true);

			System.out.println("Запуск потоков...");

			Thread warnThread = new Thread(new CustomThread(fw, logLevel.WARN));
			warnThread.start();

			Thread infoThread = new Thread(new CustomThread(fw, logLevel.INFO));
			infoThread.start();

			Thread traceThread = new Thread(new CustomThread(fw, logLevel.TRACE));
			traceThread.start();

			Thread criticalThread = new Thread(new CustomThread(fw, logLevel.CRITICAL));
			criticalThread.start();

			while (timeWorking <= 65000) { /*Оставим запас 5 секунд */
				Thread.sleep(1000);
				timeWorking = System.currentTimeMillis() - initTime;
			}
			if (timeWorking > 65000) {
				System.out.println("Прерываем все потоки!");

				warnThread.interrupt();
				infoThread.interrupt();
				traceThread.interrupt();
				criticalThread.interrupt();

				fw.close();
			}

			System.out.println("Печатаем содержимое полученного файла: ");
			
			File file = new File(fname);
			FileReader fr = new FileReader(file);
			char[] text = new char[(int) file.length()];

			fr.read(text);

			System.out.println(text);
			
			fr.close();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void put(FileWriter fw, logLevel level, String message) {
		DateFormat customDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		try {
			fw.write(customDateFormat.format(System.currentTimeMillis()) + " " + level.toString() + " " + message
					+ System.getProperty("line.separator"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
