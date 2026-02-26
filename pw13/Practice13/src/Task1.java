/*Практичне завдання №12, Вус Павло, ІПЗ-1, група №1 
 * Великі числа при друку прийнято розділяти комами. Так наприклад число один мільйон при друку має виглядати - 1,000,000. Напишіть програму, що на вхід приймає число (саме число, INT), а на вихід виводить число в наведеному вище форматі.
 *  Числа мають зчитуватися до тих пір, поки користувач не введе 0. String.valueOf використовувати не можна.*/
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;


public class Task1 extends ConsoleProgram{
	
	private static final int STOP = 0;

	public void run(){
		transformationOfNumber();
	}
	
	//Метод,який розділяє по три цифри в числі комами, доки цього хоче користувач
	/**
	 * A method that starts program separates three digits in a number with commas
	 */
	private void transformationOfNumber() {
		while(true){
			int currentInput;
			String allNumbersToTransform = "";
			while(true){
				currentInput = readInt("Вводьте числа, щоб розділити їх на частини комами, коли захочете зупинитись введіть " + STOP + " : ");
				if(currentInput == STOP) break;
				allNumbersToTransform += currentInput + " ";
			} 
			
			//Знаходимо та виводимо усі перетворені числа
			printAllTransformedNumbers(allNumbersToTransform);
			
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
	
	//Метод, який розділяє стрічку з чисел і перетворює кожне з них і виводить
	/**
	 * A method that converts a set of numbers and prints the result
	 * @param numbersToTransform String with set of numbers
	 */
	private void printAllTransformedNumbers(String numbersToTransform) {
		if(numbersToTransform == ""){
			println("Ви нічого не ввели)");
		} else {
			StringTokenizer tokenizer = new StringTokenizer(numbersToTransform);
			for (int count = 1; tokenizer.hasMoreTokens(); count++){
				println("Перетворене число №" +count +": "+ transformNumber(tokenizer.nextToken()));
			}
		}
	}
	
	//Метод, який розділяє число на частини комою та повертає вже перетворене(стрічкою)
	/**
	 * A method that divides a number into parts with a comma
	 * @param number any number
	 * @return tranformed number with separetor
	 */
	private String transformNumber(String number) {
		String result = "";
		boolean isNegative = number.charAt(0)=='-';
		if(isNegative){
			number = number.substring(1);
		}
		for(int i =  0; i < number.length(); i++){
			if (i > 0 && (number.length() - i) % 3 == 0) {
                result += ",";
            }
			result = result + number.charAt(i);
		}
		if(isNegative){
			result = "-" + result;
		}
		return result;
	}
}
