/*Практичне завдання №13, Вус Павло, ІПЗ-1, група №1 
 * Написати програму, що читає текстову інформацію з файлу і виводить на екран
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;


public class Task3 extends ConsoleProgram{
	public void run(){
		while(true){
			BufferedReader myR = myReader("Введіть назву файлу з якого будемо виводити інформацію: ");
			try {
				int counter = 0;
				while (true){
					//Виводимо кожну стрічку файлу
					String st;
					st = myR.readLine();
					if (st==null) break;
					counter++;
					println(st);
				}
				myR.close();
				if(counter == 0){
					println("Схоже, що цей файл пустий)");
				}
			}catch (IOException e) {
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
	private BufferedReader myReader(String input) {
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
