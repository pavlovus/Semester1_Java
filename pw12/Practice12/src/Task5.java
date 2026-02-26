/*Практичне завдання №12, Вус Павло, ІПЗ-1, група №1 
 * Написати процедуру обчислення за цілим N>3 таких натуральних A і B, що 5A-2B=N, причому A+B мінімально*/
import acm.program.ConsoleProgram;


public class Task5 extends ConsoleProgram{
	public void run(){
		findAAndBFromFormula();
	}
	//Метод, який запитує число n і знаходить мінімальні A+B, доки цього хоче користувач
	private void findAAndBFromFormula() {
		while(true){
			//Запитуємо n строго більше трьох
			int n = readInt("Введіть ціле n>3, щоб обчислити такі натуральні A і B, щоб 5A-2B=N, причому A+B мінімально: ");
			while(n <= 3){
				n = readInt("Введіть число CТРОГО БІЛЬШЕ ЗА 3: ");
			}
			
			//Вводимо необхідні змінні
			int minSum = Integer.MAX_VALUE;
	        int bestA = -1;
	        int bestB = -1;

	        //Перебираємо всі значення A, та записуєсо найменше з них в відповідну змінну
	        for (int a = 1; a <= n; a++) {
	            int b = (5*a - n) / 2;
	            if ((5*a - n) % 2 == 0 && b > 0) {
	                int sumAB = a + b;
	                if (sumAB < minSum) {
	                    minSum = sumAB;
	                    bestA = a;
	                    bestB = b;
	                }
	            }
	        } 
	        //Виводимо результат
	        println("Значення А, при якому сума А і В - мінімальна: " + bestA);
	        println("Значення B, при якому сума А і В - мінімальна: " + bestB);
			
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
}
