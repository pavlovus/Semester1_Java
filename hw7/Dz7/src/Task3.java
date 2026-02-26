/* Домашня робота №6,завдання №3, Вус Павло, ІПЗ-1, група №1
 * Реалізувати програму з лекції Ханойські вежі. З клавіатури вводиться число дисків на першій голці і голка на яку необхідно перенести диски.
 *  Ваша програма має вивести на екран послідовність дій для перенесення дисків та кількість кроків.*/

import acm.program.ConsoleProgram;


public class Task3 extends ConsoleProgram{
	private int COUNTER;
	public void run(){
		while(true){
			println("Програма розв'язує головоломку Ханойські вежі");
			//Просимо ввести кількіть дисків на першій голці
			int disks = readInt("Введіть кіл-сть дисків на першій голці: ");
			while (true){
				if(disks <= 0){
					disks = readInt("Введіть НАТУРАЛЬНЕ число: ");
				} else {
					break;
				}
			}
			
			int a = 1;
			//Просимо вибрати, на яку гілку переставляти
			int b = readInt("Виберіть, на яку голку будемо переставляти: ");
			while(b != 2 && b != 3){
				b = readInt("Вам необхібно ввести 2 АБО 3: ");
			}
			int c;
			if(b==2){
				c = 3;
			} else {
				c = 2;
			}
			
			COUNTER = 0;
			transferDisks(disks, a, b, c);
			println("Переміщення завершено!!!");
			println("Кількість кроків для переходу: " + COUNTER);
			
			//Запитуємо, чи користувач бажає продовжити
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
//Метод, який розв'язує головоломку і переставляє диски за необхідним алгоритмом
	private void transferDisks(int disks, int currentTower, int transferTo, int auxilaryTower) {
		if (disks == 1){
			disk(currentTower, transferTo);
			COUNTER++;
		} else {
			transferDisks(disks - 1, currentTower, auxilaryTower, transferTo);
			disk(currentTower, transferTo);
			COUNTER++;
			transferDisks(disks - 1, auxilaryTower, transferTo, currentTower);
		}
	}
//Метод, який переставляє диск з одної гілки на іншу і виводить це
	private void disk(int a, int b) {
		println("Один диск з " + a + " до " + b);
	}
}
