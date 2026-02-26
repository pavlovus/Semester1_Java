/* Практична робота №6, Вус Павло, ІПЗ-1, група №1
 * 1. Програма має рахувати числа Фібоначі і виводити результати на екран у формі:
0 - 0
1 - 1
2 - 1
3 - 2
і так далі
2. Програма має рахувати n! Число n вводить користувач.
3. Написати программу обчислення кількості (ми не знаємо кількість цифр) десяткових цифр натурального числа. Не використовувати стрічки, суто математичні операції.

 

Усі завданні мають бути реалізовані в одному класі.*/

import acm.program.ConsoleProgram;


public class Practice7 extends ConsoleProgram{
	
	public void run(){
		findFib();
		findFactorial();
		findNumberOfDigits();
	}
//Метод, який рахує всі числа Фібоначчі в кількості, яку вводить користувач, доки він цього хоче
	private void findFib() {
		while (true){
			println("Програма обраховує числа Фібоначчі в заданій кількості рекурентним і рекурсивним способом");
			//Запитуємо ввести  ціле невід'ємне число
			int n = readInt("Введіть ціле невід'ємне число, яке буде кількістю обрахованих чисел Фібоначчі: ");
			while (true){
				if(n < 0){
					n = readInt("Введіть ЦІЛЕ НЕВІД'ЄМНЕ число: ");
				} else {
					break;
				}
			}
			
			println("Рекурсивні числа Фібоначчі до " + n + " :");
			//Обраховуємо і виводимо числа Фібоначчі в заданій клькості рекурсивним способом
			for(int i = 0; i <= n; i++){
				println(i + " - " + fibRecur(i));
			}
			println("Рекурентні числа Фібоначчі до " + n + " :");
			//Обраховуємо і виводимо числа Фібоначчі в заданій клькості рекурентним способом
			for(int i = 0; i <= n; i++){
				println(i + " - " + fibRecurent(i));
			}
			
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
//Метод, який приймає індекс числа Фібоначчі, обчислює і повертає його рекурентним способом
	private int fibRecurent(int n) {
		int previousFib = 1;
		int beforePreviousFib = 0;
		int currentFib = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		for (int i = 2;i<=n;i++){
			currentFib = previousFib + beforePreviousFib;
			beforePreviousFib = previousFib;
			previousFib = currentFib;
		}
		
		return currentFib;	
	}
//Метод, який приймає індекс числа Фібоначчі, обчислює і повертає його рекурствним способом
	private int fibRecur(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibRecur(n-1) + fibRecur(n-2);
		
	}
//Метод, який обраховує факторіал числа, яке вводить користувач, доки він цього хоче
	private void findFactorial() {
		while(true){
			println("Програма обраховує факторіал рекурентним і рекурсивним способом");
			//Запитуємо ввести ціле невід'ємне число
			int n = readInt("Введіть ціле невід'ємне число, щоб знайти його факторіал: ");
			while (true){
				if(n < 0){
					n = readInt("Введіть ЦІЛЕ НЕВІД'ЄМНЕ число: ");
				} else {
					break;
				}
			}
			//Обраховуємо факторіал рекурсивним і рекурентним способами
			int factorialOne = factorialRecur(n);
			println("Рекурсивний факторіал: " + factorialOne);
			int factorialTwo = factorialRecurent(n);
			println("Рекурсивний факторіал: " + factorialTwo);
			
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
//Метод, який приймає число, обчислює його факторіал рекурентно  і повертає
	private int factorialRecurent(int n) {
		int result = 1;
		for (int i = 1;i<=n;i++)
			result*=i;
		return result;
	}
//Метод, який приймає число, обчислює його факторіал рекурсивно  і повертає
	private int factorialRecur(int n) {
		if (n==0)
			return 1;
		return n*factorialRecur(n-1);
	}
//Метод, який рахує кіл-сть цифр в натуральному числі, доки цього хоче користувач
	private void findNumberOfDigits() {
		while(true){
			println("Програма обраховує кіл-сть цифр в натуральному числі");
			//Запитуємо ввести натуральне число
			int n = readInt("Введіть натуральне число, щоб обрахувати кіл-сть його чисел : ");
			while (true){
				if(n <= 0){
					n = readInt("Введіть НАТУРАЛЬНЕ число: ");
				} else {
					break;
				}
			}
			//Обраховуємо і виводимо кіл-сть цифр
			int result = numberOfDigits(n);
			println("Кіл-сть цифр: " + result);
			
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
//Метод, який приймає число, рахує кіл-сть його цифр і повертає її
	private int numberOfDigits(int n) {
		int counter = 1;
		while (n / 10 != 0){
			n = n/10;
			counter++;
		}
		return counter;
	}
}
