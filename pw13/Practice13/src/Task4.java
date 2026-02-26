/*Практичне завдання №13, Вус Павло, ІПЗ-1, група №1 
 * Написати програму, що шукає в тексті файлу задану фразу і виводить інформацію про її наявність та кількість.*
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

public class Task4 extends ConsoleProgram{
	public void run(){
		while(true){
			BufferedReader myR = myReader("Введіть назву файлу, в якому будемо шукати фразу: ");
			String input = readLine("Введіть фразу, яку будемо шукати: ");
			try {
				int counter = 0;
				while (true){
					//В кожній стрічці шукаємо фразу і додаємо
					String st;
					st = myR.readLine();
					if (st==null) break;
					counter += searchForPhrase(st, input);
				}
				myR.close();
				//Виводимо результат обробки
				if(counter == 0){
					println("В цьому файлі немає цієї фрази або файл пустий)");
				} else {
					println("Фраза присутня " + counter + " разів");
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
	
	//Метод, який шукає к-сть повторень фрази в стрічці
	/**
	 * Searches the number of repetitions of a phrase in a string
	 * @param line line to search in
	 * @param searchFor phrase to search for
	 * @return number of appearances of this phrase
	 */
	private int searchForPhrase(String line, String searchFor) {
		int numberOfAppearences = 0;
		int currentIndex = 0;
		while ((currentIndex = line.indexOf(searchFor, currentIndex)) > -1){
			numberOfAppearences++;
			currentIndex += searchFor.length();
		}
		return numberOfAppearences;
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
