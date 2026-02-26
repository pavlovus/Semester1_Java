/* Завдання №6 лабораторної роботи №1, Вус Павло, ІПЗ-1, група №1
 * Послідовність сум {sn}, де sn=1+x+x2/2!+…+xn/n!, за умови 0<=x<1 "достатньо швидко" сходиться до ex. 
 * Запрограмувати обчислення ex при x [0;1) із точністю ep , тобто за потрібне число приймається перше snтаке, що | sn-sn-1 |<ep .

Розв'язати двома способами: з використанням циклів (але використовуючи рекурентність) та з використанням рекурсивних викликів методів.*/

import acm.program.ConsoleProgram;


public class Task7 extends ConsoleProgram{
	public void run(){
		findExponent();
	}
//Метод, який знаходить експоненту з заданими значеннями, доки цього хоче користувач
	private void findExponent() {
		while(true){
			println("Програма знаходить e^x через послідовність сум");
			//Запитуємо ввести необхідні змінні в потрібному діапазоні
			double x = readDouble("Введіть степінь(від 0(включно) до 1), до якого треба піднести експоненту: ");
			while(x < 0 || x >=1){
				x = readDouble("Вам порібно ввести число ВІД 0(включно) ДО 1: ");
			}
			double e = readDouble("Введіть число, яке буде найменшою різницею суми та зупинить знаходження функції: ");
			while(e < 0 || e >1){
				e = readDouble("Вам птрібно ввести число ВІД 0 ДО 1: ");
			}
			
			//Знаходимо та виводимо три варіації значення
			double resultOne = exponentRecur(x, e);
			println("Експонента рекурсивна: " + resultOne);
			double resultTwo = exponentRecurent(x, e);
			println("Експонента рекурентна: " + resultTwo);
			double resultThree = Math.exp(x);
			println("Експонента математична: " + resultThree);
			
			
			
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
//Метод, який примає степінь, точність та обраховує експонету рекурентно і повертає її значення
	private double exponentRecurent(double x, double e) {
		double sum = 1;
		double currentApplication = 1;
		int n = 1;
		while(currentApplication >= e ){
			currentApplication = currentApplication*x/n;
			sum = sum + currentApplication;
			n++;
		}
		return sum;
	}
//Метод, який приймає степінь, точнісь, створює необхідні змінні та передає їх в метод для обрахування
	private double exponentRecur(double x, double e) {
		double sum = 1;
		double currentApplication = 1;
		int n = 1;
		return findExponentRecur(x, e, sum, currentApplication, n);
	}
//Метод який рекурсивно обраховує значення експоненти та повертає його
	private double findExponentRecur(double x, double e, double sum, double currentApplication, int n) {
		if(currentApplication < e){
			return sum;
		} 
		currentApplication = currentApplication*x/n;
		sum = sum + currentApplication; 
		return findExponentRecur(x, e, sum, currentApplication, n + 1);
	}
}
