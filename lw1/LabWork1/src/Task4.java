/* Завдання №4 лабораторної роботи №1, Вус Павло, ІПЗ-1, група №1
 * Написати програму, що запитує у користувача два числа і обраховує корень квадратний з суми їх квадратів.*/

import acm.program.ConsoleProgram;

public class Task4 extends ConsoleProgram{
	public void run(){
		pythagoreanTheorem();
	}
//Метод, який обраховує теорему Піфагора, доки цього хоче користувач
	private void pythagoreanTheorem() {
		while (true){
			//Вводимо два числа з клавіатури
			println("Введіть два числа, для яких обрахується теорема Піфагора");
			double a = readInt("Введіть число a:");
			double b = readInt("Введіть число b:");
			
			//Викликаємо метод, записуємо його результат в змінну і виводимо
			double result = calculatePythagoreanTheorem(a, b);
			println("Результат с: " + result);
			 
			//Запитуємо, чи користувач хоче продовжити
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
//Метод, який приймає два числа і обраховує для них корінь з суми квадратів
	private double calculatePythagoreanTheorem(double a, double b) {
		return Math.sqrt(a*a + b*b);
	}
}
