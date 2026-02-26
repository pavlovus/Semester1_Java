/*Практичне завдання №12, Вус Павло, ІПЗ-1, група №1 
 *  Написати "найпростіший калькулятор", що отримує на вхід 2 числа і операцію над ними після чого повертає результат обчислень.*/
import acm.program.ConsoleProgram;


public class Task4 extends ConsoleProgram{
	public void run(){
		doSimpleCalculator();
	}

	private void doSimpleCalculator() {
		while(true){
			//Запитуємо два числа
			double firstInput = readDouble("Введіть перше число: ");
			double secondInput = readDouble("Введіть друге число: ");
			
			//Обчислюємо та виводимо результати
			double resultOfAddition = addition(firstInput, secondInput);
			println(firstInput + " + " + secondInput + " = " + resultOfAddition);
			double resultOfSubtraction = subtraction(firstInput, secondInput);
			println(firstInput + " - " + secondInput + " = " + resultOfSubtraction);
			double resultOMultiplication = multiplication(firstInput, secondInput);
			println(firstInput + " * " + secondInput + " = " + resultOMultiplication);
			if(secondInput != 0){
				double resultOfDivision = division(firstInput, secondInput);
				println(firstInput + " / " + secondInput + " = " + resultOfDivision);
			} else {
				println("На нуль ділити не можна");
			}
			
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
	//Метод, що ділення два числа
	private double division(double firstNumber, double secondNumber) {
		return firstNumber / secondNumber;
	}
	//Метод, що множення два числа
	private double multiplication(double firstNumber, double secondNumber) {
		return firstNumber * secondNumber;
	}
	//Метод, що віднімання два числа
	private double subtraction(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}
	//Метод, що додає два числа
	private double addition(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}
}
