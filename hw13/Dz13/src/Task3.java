/*Домашнє завдання №13, Вус Павло, ІПЗ-1, група №1 
 * Написати програму, що відкриває файл на читання і формує два інших файли. 
 * Перший файл формується з непарних стрічок початкового файлу, а інший з парних.*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

//C:\Users\Pavlo\Desktop\test2.txt
public class Task3 extends ConsoleProgram{
	public void run(){
		createFilesWithOddAndPairLines();
	}
	
	private void createFilesWithOddAndPairLines() {
		while(true){
			BufferedReader myR = openFile("Введіть шлях до файлу, з якого будемо створювати два нових з парними і непарними рядками: ");
			String oddName = readLine("Введіть назву нового файлу з непарними рядками: ");
			String pairName = readLine("Введіть назву нового файлу з парними рядками: ");
			try{
				//Створюємо два нових файли
				PrintWriter odd = new PrintWriter(new FileWriter("C:\\Users\\Pavlo\\Desktop\\" + oddName + ".txt"));
				PrintWriter pair = new PrintWriter(new FileWriter("C:\\Users\\Pavlo\\Desktop\\" + pairName + ".txt"));
				println("Зміст оригінального файлу:");
				int counter = 0;
				while (true){
					String s;
					s = myR.readLine();
					if (s==null) break;
					println(s);
					counter++;
					//Парні рядки додаємо в один
					if(counter%2 == 0){
						pair.println(s);
					} else {
					//Непарні в інший
						odd.println(s);
					}
				}
				if(counter == 0){
					println("Схоже, що цей файл пустий)");
				}
				myR.close();
				odd.close();
				pair.close();
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
