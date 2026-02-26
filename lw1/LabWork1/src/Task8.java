/* Завдання №6 лабораторної роботи №1, Вус Павло, ІПЗ-1, група №1
 * Послідовність сум {sn}, де sn=1-x2/2!+…+(-1)nx2n/(2n)!, за умови |x|<= p /4 "достатньо швидко" сходиться до cos(x).
 *  Запрограмувати обчислення cos(x) при x [-p /4; p/4] з точністю ep , тобто за потрібне число приймається перше snтаке, що | sn-sn-1 |<ep .

Розв'язати двома способами: з використанням циклів (але використовуючи рекурентність) та з використанням рекурсивних викликів методів.*/

import acm.program.ConsoleProgram;


public class Task8 extends ConsoleProgram{
	public void run(){
		findCos();
	}
//Метод, який знаходить косинус з заданими значеннями, доки цього хоче користувач
	private void findCos() {
		while(true){
			println("Програма знаходить cos(x) через послідовність сум");
			//Запитуємо ввести необхідні змінні в потрібному діапазоні
			double x = readDouble("Введіть аргумент(від -p/4 до p/4), від якого треба знайти косинус: ");
			while(x <= -Math.PI/4 || x >= Math.PI/4){
				x = readDouble("Вам порібно ввести число ВІД -p/4 ДО p/4 (включно): ");
			}
			double e = readDouble("Введіть число, яке буде найменшою різницею суми та зупинить знаходження функції: ");
			while(e < 0 || e > 1){
				e = readDouble("Вам птрібно ввести число ВІД 0 ДО 1: ");
			}
			
			//Знаходимо та виводимо три варіації значення
			double resultOne = cosRecur(x, e);
			println("Косинус рекурсивний: " + resultOne);
			double resultTwo = cosRecurent(x, e);
			println("Косинус рекурентний: " + resultTwo);
			double resultThree = Math.cos(x);
			println("Косинус математични1: " + resultThree);
			
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
//Метод, який примає степінь, точність та обраховує косинус рекурентно і повертає її значення
	private double cosRecurent(double x, double e) {
		double sum = 1;
		double currentApplication = 1;
		int n = 1;
		while(Math.abs(currentApplication) >= e ){
			currentApplication = currentApplication*(-1)*(x*x)/(2*n*(2*n-1));
			sum = sum + currentApplication;
			n++;
		}
		return sum;
	}
//Метод, який приймає степінь, точнісь, створює необхідні змінні та передає їх в метод для обрахування
	private double cosRecur(double x, double e) {
		double sum = 1;
		double currentApplication = 1;
		int n = 1;
		return findCosRecur(x, e, sum, currentApplication, n);
	}
//Метод який рекурсивно обраховує значення косинусу та повертає його
	private double findCosRecur(double x, double e, double sum, double currentApplication, int n) {
		if(Math.abs(currentApplication) < e){
			return sum;
		} 
		currentApplication = currentApplication*(-1)*(x*x)/(2*n*(2*n-1));
		sum = sum + currentApplication; 
		return findCosRecur(x, e, sum, currentApplication, n + 1);
	}
}
