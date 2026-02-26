/*Практичне завдання №14, Вус Павло, ІПЗ-1, група №1 
 * Порахувати кількість входжень заданого користувачем слова в файлі.*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

//C:\Users\Pavlo\Desktop\test.txt
//C:\Users\Pavlo\Desktop\test1.txt
public class Task1 extends ConsoleProgram{
	public void run(){
		findNumberOfWordInFile();
	}
	//Метод, який шукає к-сть вказаного слова в файлі, доки цього хоче користувач
	/**
	 * A method that searches for the given word in a file as long as the user wants it
	 */
	private void findNumberOfWordInFile() {
		while(true){
			BufferedReader myR = myReader("Введіть назву файлу, в якому будемо шукати слово: ");
			String input = readLine("Введіть слово, яке будемо шукати без розділових знаків!!!: ");
			while(havePunctuationMarks(input)){
				input = readLine("Введіть слово, яке будемо шукати БЕЗ ЖОДНИХ РОЗДІЛОВИХ ЗНАКІВ!!!: ");
			}
			try {
				int counter = 0;
				while (true){
					//В кожній стрічці шукаємо фразу і додаємо
					String st;
					st = myR.readLine();
					if (st==null) break;
					counter += searchForWord(st, input);
				}
				myR.close();
				//Виводимо результат обробки
				if(counter == 0){
					println("В цьому файлі немає цього слова або файл пустий)");
				} else {
					println("Слово присутнє " + counter + " разів");
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

	//Метод, який рахує к-сть вживання слова в стрічці
	/**
	 * A method that counts the number of times a word is used in a string
	 * @param st random string
	 * @param input word without punctuation marks 
	 * @return number of appearances
	 */
	private int searchForWord(String st, String input) {
		int numberOfAppearances = 0;
		StringTokenizer tokenizer = new StringTokenizer(st, " ,.?!;:-/");
		for (int i = 0; tokenizer.hasMoreTokens(); i++){
			if(tokenizer.nextToken().equals(input)){
				numberOfAppearances++;
			}
		}
		return numberOfAppearances;
	}
	
	//Метод, який визначає чи є в стрічці розділові знаки
	/**
	 *A method that determines whether a string has punctuation marks
	 * @param st random string
	 * @return boolean(has punctuation marks or not)
	 */
	private boolean havePunctuationMarks(String input) {
		for(int i = 0; i < input.length(); i++){
			if(isPunctuation(input.charAt(i))){
				return true;
			}
		}
		return false;
	}
	
	//Метод, який визначає чи символ є знаком пунктуації
	/**
	 *A method that determines whether a character is a punctuation mark
	 * @param st random character
	 * @return boolean(is it punctuation mark or not)
	 */
	private boolean isPunctuation(char ch){
		return ch == ' ' || ch == '?' || ch == '!' || ch == '.' || ch == ',' || ch == ';' || ch == ':' || ch == '-'  || ch == '/';
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
