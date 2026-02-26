/*Домашнє завдання №13, Вус Павло, ІПЗ-1, група №1 

 * Написати програму, що замінює підстрічку в файлі заданою стрічкою*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

//C:\Users\Pavlo\Desktop\test3.txt
public class Task1 extends ConsoleProgram{
	public void run(){
		substringInFile();
	}
	//Метод, який замінює підстрічку в файлі на іншу підстрічку
	/**
	 * A method that replaces a substring in a file with another substring
	 */
	private void substringInFile() {
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
            String stringToChange = readLine("Яку підстрічку замінюємо: ");
            String stringToChangeFor = readLine("На що замінюємо: ");

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
                    //Замінюємо підстрічки в рядку
                    while (positionOfSubstring(line, stringToChange) >= 0) {
                        line = replaceSubstring(line, stringToChange, stringToChangeFor);
                    }
                    writer.println(line);
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
	
	//Метод, який заміняє підстрічку в стрічці на іншу підстрічку
	/**
	 * A method that replaces a substring in the string with another substring
	 * @param originalStr original String
	 * @param editedStr string to change
	 * @param changeStr string to change for
	 * @return String that was changed
	 */
	private String replaceSubstring(String originalStr, String editedStr, String changeStr) {
		int pos = positionOfSubstring(originalStr,editedStr);
		if(pos<0)
			return originalStr;
		String res = "";
		for (int i=0;i<pos;i++)
			res+=originalStr.charAt(i);
		res+=changeStr;
		for (int i=pos+editedStr.length();i<originalStr.length();i++)
			res+=originalStr.charAt(i);
		return res;
	}
	
	//Метод, який шукає підстрічку в стрічці
	/**
	 * A method that looks for a substring in the string
	 * @param originalStr original String
	 * @param editedStr string to find
	 * @return position of searched string in original
	 */
	private int positionOfSubstring(String originalStr, String editedStr) {
		if (originalStr==null||originalStr.length()==0)
			return -1;
		if (editedStr==null||editedStr.length()==0)
			return -1;
		if (editedStr.length()>originalStr.length())
			return -1;
		
		for (int i=0;i<=originalStr.length()-editedStr.length();i++){
			boolean hasSubstring =true;
			for(int j=0;j<editedStr.length();j++){
				if (originalStr.charAt(i+j)!=editedStr.charAt(j)){
					hasSubstring = false;
					break;
				}
			}
			if (hasSubstring)
				return i;
		}
		return -1;
	}
}
