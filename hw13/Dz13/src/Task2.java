/*Домашнє завдання №13, Вус Павло, ІПЗ-1, група №1 
 * Написати програму, що копіює зміст тектового файлу в інший з розширення ".bak". Назва файлу вводиться користувачем.*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

//C:\Users\Pavlo\Desktop\test.txt
//C:\Users\Pavlo\Desktop\test1.txt
public class Task2 extends ConsoleProgram{
	public void run(){
		reserveCopyOfFile();
	}
	
	private void reserveCopyOfFile() {
		while(true){
			BufferedReader myR = openFile("Введіть шлях до файлу, який будемо копіювати з розширенням bak: ");
			String newName = readLine("Введіть назву копії: ");
			try{
				//Створюємо копію з необхідним розширенням
				PrintWriter wr = new PrintWriter(new FileWriter("C:\\Users\\Pavlo\\Desktop\\" + newName + ".bak"));
				while (true){
					String s;
					s = myR.readLine();
					if (s==null) break;
					//Записуємо в неї кожну стрічку з оригінального файлу
					wr.println(s);
				}
				myR.close();
				wr.close();
			}catch (IOException e){
				throw new ErrorException(e);
			}
			
			//Запитуємо чи користувач хоче продовжувати
			int choice = readInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу:");
			while(true){
				if(choice == 0){
					println("Програма завершена!");
					return;
				} else if(choice == 1){
					break;
				} else if(choice != 0 && choice != 1){
					choice = readInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу:");
				} 
			}
		}
	}

	//Метод, який відкриває файл по шляху до нього
	/**
	 *  Method that opens the file by the path to it
	 * @param input path to the file
	 * @return BufferedReader of this file if it was found
	 */
	private BufferedReader openFile(String input) {
		BufferedReader file = null;
		while (file == null){
			try{
				String name = readLine(input);
				file = new BufferedReader( new FileReader(name));
			} catch (FileNotFoundException e){
				println("Файл не знайдено");	
			} 
		}
		return file;
	}
}
