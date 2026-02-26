/*Практичне завдання №12, Вус Павло, ІПЗ-1, група №1 
 * Написати программу, що робить перевірку, чи є значення символьної змінної, що введена з клавіатури (повертаються одразу всі три результати) :

	-цифрою від '0' до '9';
	-малою латинською літерою;
	-латинською літерою (великою чи малою)*/
import acm.program.ConsoleProgram;


public class Task1 extends ConsoleProgram{
	public void run(){
		checkThreePoints();
	}
//Метод, який перевіряє три пункти з умови, доки цього хоче користувач
	private void checkThreePoints() {
		while(true){
			//Зчитуємо символ, який ввів користувач
			String input = readLine("Введіть символ, щоб перевірити його за критеріями: ");
			while(input.length() > 1){
				input = readLine("Вам потрібно ввести ЛИШЕ ОДИН символ: ");
			}
			char ch = input.charAt(0);
			
			//Обраховуємо результати та записуємо в змінні
			boolean resultOne = checkForNumber(ch);
			boolean resultTwo = checkForSmallLetter(ch);
			boolean resultThree = checkForLetter(ch);
			
			//Виводимо їх на екран
			if(resultOne){
				println("Чи є цифрою від '0' до '9'? - Так");
			} else {
				println("Чи є цифрою від '0' до '9'? - Ні");
			}
			if(resultTwo){
				println("Чи є малою латинською літерою? - Так");
			} else {
				println("Чи є малою латинською літерою? - Ні");
			}
			if(resultThree){
				println("Чи є латинською літерою (великою чи малою)? - Так");
			} else {
				println("Чи є латинською літерою (великою чи малою)? - Ні");
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

	//Метод, що перевіряє чи введений символ є латинською літерою
	private boolean checkForLetter(char ch) {
		if((ch<'a' || ch>'z') && (ch<'A' || ch>'Z'))
			return false;
		return true;
	}

	//Метод, що перевіряє чи введений симол є малою латинською літерою
	private boolean checkForSmallLetter(char ch) {
		if(ch<'a' || ch>'z')
			return false;
		return true;
	}

	//Метод, що перевіряє чи введений симол є цифрою від '0' до '9'
	private boolean checkForNumber(char ch) {
		if(ch<'0' || ch>'9')
			return false;
		return true;
	}
}
