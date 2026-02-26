/* Практична робота №6, Вус Павло, ІПЗ-1, група №1
 * 2. Розв'яжіть рівняння та виведіть на екран результат.

y=x4
y=ax2+bx+c
y=ax+c
Значення a, b, c, у задаються з клавіатури та використовуються для для всіх 3 підзадач*/

import acm.program.ConsoleProgram;


public class Task2 extends ConsoleProgram{
	public void run(){
		findSolutionToEquationOne();
		findSolutionToEquationTwo();
		findSolutionToEquationThree();
	}
//Метод, який розв'язує третє рівняння, поки цього хоче користовач
	private void findSolutionToEquationThree() {
		while (true) {
			println("Введіть коефіцієнти і значення лінійного рівняння ");
			double a = readDouble("Введіть число a:");
			double c = readDouble("Введіть число c:");
			double y = readDouble("Введіть число y:");
			
			if(y==0 && a==0 && c==0){
				println("x є R");
			} else if ( y!=0 && a==0 && c==0){
				println("Розв'язків немає");
			} else if ( y==0 && a==0 && c!=0){
				println("Розв'язків немає");
			} else {
				double result = calculateEquationThree(a,c, y);
				println("Відповідь: " + result);
			}
			
			int choice = readInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу:");
			if(choice == 0){
				println("Програма завершена!");
				break;
			} else if(choice != 0 && choice != 1){
				choice = readInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу:");
			}
		}
	}
//Метод, який приймає коефіцієнти і повертає розв'язок до лінійного рівняння 
	private double calculateEquationThree(double a, double c, double y) {
		return (y - c)/a;
	}
//Метод, який розв'язує друге рівняння, поки цього хоче користовач
	private void findSolutionToEquationTwo() {
		while (true) {
			println("Введіть коефіцієнти і значення квадратного рівняння ");
			double a = readDouble("Введіть число a:");
			double b = readDouble("Введіть число b:");
			double c = readDouble("Введіть число c:");
			double y = readDouble("Введіть число y:");
			
			if(y==0 && a==0 && b==0 && c==0){
				println("x є R");
			} else if ( y!=0 && a==0 && b==0 && c==0){
				println("Розв'язків немає");
			} else if (b*b - 4*a*c < 0){
				println("Розв'язків немає");
			} else if (y==0 && a==0 && b==0 && c!=0){
				println("Розв'язків немає");
			} else if (a==0){
				double result = calculateEquationThree(b,c, y);
				println("Єдиний корінь: " + result);
			} else {
				double resultOne = calculateFirstRoot(a, b, c, y);
				double resultTwo = calculateSecondRoot(a, b, c, y);
				if (resultOne == resultTwo){
					println("Єдиний корінь: " + resultOne);
				} else {
					println("Перший корінь: " + resultOne + ", другий корінь: " + resultTwo);
				}
			}
			
			int choice = readInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу:");
			if(choice == 0){
				println("Програма завершена!");
				break;
			} else if(choice != 0 && choice != 1){
				choice = readInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу:");
			}
		}
	}
//Метод, який знаходить другий корінь квадратного рівняння
	private double calculateSecondRoot(double a, double b, double c, double y) {
		return ((-b - Math.sqrt(b*b - 4*a*(c-y)))/2*a);
	}
//Метод, який знаходить перший корінь квадратного рівняння
	private double calculateFirstRoot(double a, double b, double c, double y) {
		return ((-b + Math.sqrt(b*b - 4*a*(c-y)))/2*a);
	}
//Метод, який розв'язує перше рівняння, поки цього хоче користовач
	private void findSolutionToEquationOne() {
		while(true){
			println("Введіть число, якому буде дорівнювати x в 4 степні");
			double y = readDouble("Введіть число:");
			
			if(y < 0){
				println("Розв'язків немає");
			} else {
				double result = calculateEquationOne(y);
				println("Відповідь: " + result);
			}
			
			
			int choice = readInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу:");
			if(choice == 0){
				println("Програма завершена!");
				break;
			} else if(choice != 0 && choice != 1){
				choice = readInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу:");
			}	
		}
	}
//Метод, який приймає значення х в четвертому степені і знаходить його
	private double calculateEquationOne(double x) {
		return Math.sqrt(Math.sqrt(x));
	}
	
}
