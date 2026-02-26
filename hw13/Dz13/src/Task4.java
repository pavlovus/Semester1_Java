/*Домашнє завдання №13, Вус Павло, ІПЗ-1, група №1 
 * Здійснити шифрування файлу використовуючи зсув символів.*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

//C:\Users\Pavlo\Desktop\test4.txt
public class Task4 extends ConsoleProgram{
	public void run(){
		encryptionOfFile();
	}
	//Метод, який шифрує всі латинські літери в файлі
	/**
	 * A method that encrypts all Latin letters in a file
	 */
	private void encryptionOfFile() {
		while(true){
			String pathToFile = null;
			while(true){
				pathToFile = readLine("Введіть шлях до файлу, який будемо змінювати: ");
                File inputFile = new File(pathToFile);
                if (inputFile.exists() && inputFile.isFile()) {
                    break;
                }
                println("Файл не знайдено. Введіть правильний шлях.");
			}
            int difference = readInt("Введіть зсув для шифрування: ");

            File inputFile = new File(pathToFile);
            File tempFile = new File(inputFile.getParent(), "temp.txt");

            BufferedReader reader = null;
            PrintWriter writer = null;
            try {
                //Відкриваємо файли і записуємо інформацію зі змінами в тимчасовий файл
                reader = new BufferedReader(new FileReader(inputFile));
                writer = new PrintWriter(new FileWriter(tempFile));

                String line;
                while ((line = reader.readLine()) != null) {
                    String newLine = encryptLine(line, difference);
                    writer.println(newLine);
                }
                reader.close();
                writer.close();
            } catch (IOException e) {
                throw new ErrorException("Помилка під час роботи з файлами: " + e.getMessage());
            }
            
            //Читаємо дані з тимчасового файлу назад в оригінальний
            BufferedReader tempReader = null;
            PrintWriter originalWriter = null;
            try {
                tempReader = new BufferedReader(new FileReader(tempFile));
                originalWriter = new PrintWriter(new FileWriter(inputFile));

                String tempLine;
                while ((tempLine = tempReader.readLine()) != null) {
                    originalWriter.println(tempLine);
                }
                println("Файл успішно змінено!");
                tempReader.close();
                originalWriter.close();
            } catch (IOException e) {
                throw new ErrorException("Помилка під час запису в оригінальний файл: " + e.getMessage());
            }
            //Видаляємо тимчасовий файл
            tempFile.delete();

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
	
	//Метод, який шифрує всі латинські літери в стрічці
	/**
	 * A method that encrypts all Latin letters in a string
	 * @param line
	 * @param difference
	 * @return
	 */
	private String encryptLine(String line, int difference) {
	    String result = "";
	    for (int i = 0; i < line.length(); i++) {
	        char currentChar = line.charAt(i);
	        if (currentChar >= 'A' && currentChar <= 'Z') {
	        	//Для великих літер
	            currentChar = (char) ('A' + (currentChar - 'A' + difference % 26 + 26) % 26);
	        } else if (currentChar >= 'a' && currentChar <= 'z') {
	        	//Для малих літер
	            currentChar = (char) ('a' + (currentChar - 'a' + difference % 26 + 26) % 26);
	        }
	        result += currentChar;
	    }
	    return result;
	}
}
