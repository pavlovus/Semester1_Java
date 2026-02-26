/*Практична робота №8, Вус Павло, ІПЗ-1, група №1
 * Написати програму, що дозволяє двом гравцям, грати в кості.
Кількість кубиків, що кидає кожен гравець визначається на початку гри. Кількість сторін у кубика також задається на початку гри.

Реалізувати можливість вибору: 1)гра може тривати визначену кількість кроків, 2) після кожного ходу питається у гравців, чи продовжувати гру.
Виводяться також всі проміжні результати.

В кінці має бути визначений переможець. І пропозиція почати грати знову.*/

import acm.program.ConsoleProgram;
import acm.util.*;


public class BoneGame extends ConsoleProgram{
	public void run(){
		playBoneGame();
	}
//Метод, який запускає гру в кості
	private void playBoneGame() {
		while(true){
			println("Це гра, де двоє гравців грають в кості");
			//Запитуємо необхідні змінні для гри
			int numberOfDices = readInt("Введіть кількість кубиків, які кидає кожен гравець кожного ходу: ");
			while(numberOfDices < 1){
				numberOfDices = readInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
			}
			int numberOfFaces = readInt("Введіть кількість граней, які є на кубику: ");
			while(numberOfFaces < 2){
				numberOfFaces = readInt("Вам потрібно ввести НАТУРАЛЬНЕ число БІЛЬШЕ ЗА 2: ");
			}
			
			//Запитуємо користувача обрати один з двох режимів гри
			println("Оберіть режим гри: ");
			int choiceOfRegime = readInt("Натисніть 1, щоб гра тривала визначену кіл-сть кроків, або 2, щоб завершити, коли ви цього захочете: ");
			while(choiceOfRegime != 1 && choiceOfRegime != 2){
				choiceOfRegime = readInt("Вам потрібно ввести 1 АБО 2!!!: ");
			}
			
			if (choiceOfRegime  == 1){
				playRegimeOne(numberOfDices, numberOfFaces);
			} else {
				playRegimeTw0(numberOfDices, numberOfFaces);
			}
			
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
//Метод, який запускає гру в другому режимі
	private void playRegimeTw0(int numberOfDices, int numberOfFaces) {
		println("Ви обрали другий режим!");
		int totalPlayerOne = 0;
		int totalPlayerTwo = 0;
		int counter = 1;
		
		//Робимо перше вкидання
		println("ВКИДАННЯ №" + counter);
		println("Гравець 1: ");
		totalPlayerOne += rollTheDice(numberOfDices, numberOfFaces);
		println("Гравець 2: ");
		totalPlayerTwo += rollTheDice(numberOfDices, numberOfFaces);
		
		//Робимо наступні вкидання і виводить проміжні підсумки, доки цього хоче користувач
		while(true){
			int choice = readInt("Продовжуємо? Введіть 1 для продовження гри або 0, щоб завершити гру та підвести підсумки: ");
			while(choice != 0 && choice != 1){
				choice = readInt("ВВЕДІТЬ 0 АБО 1!!!!: ");
			}
			if(choice == 1){
				counter++;
				println("ВКИДАННЯ №" + counter);
				println("Гравець 1: ");
				totalPlayerOne += rollTheDice(numberOfDices, numberOfFaces);
				println("Гравець 2: ");
				totalPlayerTwo += rollTheDice(numberOfDices, numberOfFaces);
				println("Сумарно вибив гравець №1: " + totalPlayerOne);
				println("Сумарно вибив гравець №2: " + totalPlayerTwo);
			} else {
				break;
			}
		}
		//Виводимо результат гри
		println("ПIДСУМОК для гравця №1: " + totalPlayerOne);
		println("ПІДСУМОК для гравця №2: " + totalPlayerTwo);
		if (totalPlayerOne > totalPlayerTwo){
			println("ГРАВЕЦЬ №1 ПЕРЕМІГ!!!");
		} else if(totalPlayerTwo > totalPlayerOne){
			println("ГРАВЕЦЬ №2 ПЕРЕМІГ!!!");
		} else {
			println("НІЧИЯ!!!");
		}
		
	}
//Метод, який запускає гру в першому режимі
	private void playRegimeOne(int numberOfDices, int numberOfFaces) {
		println("Ви обрали перший режим!");
		int numberOfRolls = readInt("Введіть скільки разів обидва гравці будуть кидати кубики: ");
		//Запитуємо вказати кількість вкидань
		while(numberOfRolls < 1){
			numberOfRolls = readInt("Вам потрібно ввести НАТУРАЛЬНЕ число: ");
		}
		int totalPlayerOne = 0;
		int totalPlayerTwo = 0;
		
		//Виконуємо вказану к-сть вкидань
		for(int i = 1; i <= numberOfRolls; i++){
			println("ВКИДАННЯ №" + i);
			println("Гравець 1: ");
			totalPlayerOne += rollTheDice(numberOfDices, numberOfFaces);
			println("Гравець 2: ");
			totalPlayerTwo += rollTheDice(numberOfDices, numberOfFaces);
		}
		//Виводимо результат гри
		println("ПIДСУМОК для гравця №1: " + totalPlayerOne);
		println("ПІДСУМОК для гравця №2: " + totalPlayerTwo);
		if (totalPlayerOne > totalPlayerTwo){
			println("ГРАВЕЦЬ №1 ПЕРЕМІГ!!!");
		} else if(totalPlayerTwo > totalPlayerOne){
			println("ГРАВЕЦЬ №2 ПЕРЕМІГ!!!");
		} else {
			println("НІЧИЯ!!!");
		}
	}
//Метод, який кидає кубик один раз та виводить, що випало
	private int rollTheDice(int numberOfDices, int numberOfFaces) {
		int total = 0;
		for (int i = 0; i < numberOfDices; i++) {
			total += rgen.nextInt(1, numberOfFaces);
		}
		println("Випало " + total);
		return total;
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
