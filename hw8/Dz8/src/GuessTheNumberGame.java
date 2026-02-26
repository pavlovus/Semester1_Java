/*Домашня робота №8, Вус Павло, ІПЗ-1, група №1
 * Ви маєте написати програму, що загадує число строго в діапазоні від 1 до 100 і очікує відповідей користувача. Ви маєте рахувати кількість спроб користувача.В кінці гри вивести за скільки спроб вгадали число.

По завершенні гри пропонуєте розпочати її знову.*/

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;


public class GuessTheNumberGame extends ConsoleProgram{
	public void run(){
		playGuessTheNumberGame();
	}
//Метод, який запускає гру в "Вгадай число", доки цього хоче користувач
	private void playGuessTheNumberGame() {
		while(true){
			println("Це гра, де ви вгадуєте число від 1 до 100");
			//Генеруємо загадане число
			int number = generateNumber();
			
			//Просимо користувача вгадати і рахуємо спроби, поки він не вгадає загадане число
			int guessedNumber = readInt("Введіть число від 1 до 100(не включно): ");
			while(guessedNumber < 1 || guessedNumber > 100){
				guessedNumber = readInt("Вам потрібно ввести число ВІД 1 ДО 100(не включно)!!!: ");
			}
			int counter = 1;
			while(guessedNumber != number){
				//Виводимо, яким є загадане число відносно того, що ввів користувач 
				if(number > guessedNumber ){
					println("Загадане число БІЛЬШЕ за ваше");
				} else if(number < guessedNumber){
					println("Загадане число МЕНШЕ за ваше");
				}
				guessedNumber = readInt("Введіть нове число від 1 до 100(не включно): ");
				while(guessedNumber < 1 || guessedNumber > 100){
					guessedNumber = readInt("Вам потрібно ввести число ВІД 1 ДО 100(не включно)!!!: ");
				}
				counter++;
			}
			
			//Виводимо повідомлення про те, що користувач вгадав і виводимо к-сть спроб, які для цього знадобились
			println("ПРАВИЛЬНО!!! Ви вгадали загадане число!");
			println("К-сть спроб, які для цього знадобились: " + counter);
			
			
			//Запитуємо, чи користувач бажає продовжити
			int choice = readInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу: ");
			while(true){
				if(choice == 0){
					println("Програма завершена!");
					return;
				} else if(choice == 1){
					break;
				} else if(choice != 0 && choice != 1){
					choice = readInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу: ");
				} 
			}
		}
	}
//Метод,який генерує випадкове число в необхідному діапазоні
	private int generateNumber() {
		return rgen.nextInt(1, 100);
	}

	private RandomGenerator rgen = RandomGenerator.getInstance();
}
