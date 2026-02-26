import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;


public class Practice10 extends ConsoleProgram{
	public void run(){
		println("Метод №1, що 10 разів виводить на екран ім'я й прізвище:");
		nameAndSurnameTenNimes();
		println("Метод №2, що виводить таблицю квадратів перших десяти цілих позитивних чисел:");
		tableOfSquaresOfFirstTenNumbers();
		println("Метод №3, що виводить таблицю квадратів перших п'яти цілих позитивних непарних чисел:");
		tableOfSquaresOfFirstFiveOddNumbers();
		println("Метод №4,що обчислює суму перших n цілих позитивних цілих чисел. Кількість сумуємих чисел повинна вводитися під час роботи програми:");
		doSumOfNaturalNumbers();
		println("Метод №5,що обчислює суму перших n членів ряду 1, 3, 5, 7, .... Кількість сумуємих чисел повинна вводитися під час роботи програми:");
		doSumOfNaturalOddNumbers();
		println("Метод №6, що обчислює суму перших n членів ряду 1+1/2+1/3+1/4+...:");
		doGarmSum();
		println("Метод №7, що виводить таблицю степенів двійки (від нульової до десятої):");
		tableOfSquaresOfTwo();
		println("Метод №8, що обчислює факторіал уведеного із клавіатури числа:");
		findFactorial();
		println("Метод №9, що виводить таблицю значень функції y = -2,4х^2+5х-3 у діапазоні від -2 до 2 із кроком 0,5:");
		tableOfFunction();
		println("Метод №10, що генерує 10 випадкових чисел у діапазоні від 1 до 10, виводить ці числа на екран й обчислює їх середнє арифметичне:");
		tenRandomNumbers();
		println("Метод №11, що виводить на екран таблицю вартості, наприклад, яблук у діапазоні від 100 гм. до 1 кг із кроком 100:");
		doPriceTable();
		println("Метод №12 для перевірки вміння складати й віднімати числа в межах 100");
		checkSkills();
		println("Метод №13, що обчислює суму й середнє арифметичне послідовності позитивних чисел, які вводяться із клавіатури");
		doSumAndArithmeticMean();
		println("Метод №14, що визначає максимальне число з уведеної із клавіатури послідовності позитивних чисел (довжина послідовності не обмежена");
		findMax();
		println("Метод №15, що перевіряє, чи є ціле число, уведене користувачем, простим");
		doSimpleNumberCheck();
		println("Метод №16, що задумує число в діапазоні від 1 до 100 і пропонує користувачеві вгадати число за 7 спроб");
		playGuessTheNumber();
	}
	//Метод, який запускає гру в "Вгадай число за 7 спроб", доки цього хоче користувач
	private void playGuessTheNumber() {
		while(true){
			println("Це гра, де ви вгадуєте число від 1 до 100 за 7 спроб");
			//Генеруємо загадане число
			int number = generateNumber();
			
			//Просимо користувача вгадати і рахуємо спроби, поки він не вгадає загадане число
			int guessedNumber = readInt("Введіть число від 1 до 100: ");
			while(guessedNumber < 1 || guessedNumber > 100){
				guessedNumber = readInt("Вам потрібно ввести число ВІД 1 ДО 100!!!: ");
			}
			int counter = 1;
			while(guessedNumber != number && counter < 7){
				//Виводимо, яким є загадане число відносно того, що ввів користувач 
				if(number > guessedNumber ){
					println("Загадане число БІЛЬШЕ за ваше");
				} else if(number < guessedNumber){
					println("Загадане число МЕНШЕ за ваше");
				}
				guessedNumber = readInt("Введіть нове число від 1 до 100(не включно): ");
				while(guessedNumber < 1 || guessedNumber > 100){
					guessedNumber = readInt("Вам потрібно ввести число ВІД 1 ДО 100(не включно)!!!: ");
				}
				counter++;
			}
			
			//Виводимо повідомлення про те, що користувач вгадав і виводимо к-сть спроб, які для цього знадобились або те, що він не вгадав
			if (guessedNumber != number){
				println("На жаль, ви не вгадали за 7 спроб. Загадане число було - " + number);
			} else {
				println("ПРАВИЛЬНО!!! Ви вгадали загадане число!");
				println("К-сть спроб, які для цього знадобились: " + counter);
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
	//Метод,який генерує випадкове число в необхідному діапазоні
	private int generateNumber() {
		return rgen.nextInt(1, 100);
	}

	private void doSimpleNumberCheck() {
		while(true){
			int n = readInt("Введіть натуральне число, щоб дізнатись чи воно просте: ");
			while (n < 1){
				n = readInt("Введіть НАТУРАЛЬНЕ число: ");
			}
			
			
			boolean result = simpleNumberCheck(n);
			if(result){
				if(n != 1){
					println("Введене число просте");
				} else {
					println("Введене число ні просте, ні сладене");
				}
			} else {
				println("Введене число НЕ просте");
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

	private boolean simpleNumberCheck(int n) {
		int counter = 0;
		for(int i = 2; i < n; i++){
			if(n % i == 0)
				counter++;
		}
		if(counter != 0){
			return false;
		} else
			return true;
	}

	private void findMax() {
		while(true){
			int a;
			int stop = 0;
			int MAX = stop;	
			println("Вводьте числову послідовність, коли захочете завершити введіть " + stop);
			do {
				a = readInt("Введіть ціле число:");
				if(MAX == stop){
					MAX = a;
				} else if (a != stop){
					if(MAX < a)
						MAX = a;
				}
			} while (a!=stop);
			if(MAX !=stop){
				println("Найбільше: " + MAX);
			} else {
				println("Нічого не введено");
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

	private void doSumAndArithmeticMean() {
		while(true){
			double a;
			int stop = 0;
			int counter = 0;
			double sum = 0;
			println("Вводьте числову послідовність, коли захочете завершити введіть " + stop);
			do {
				a = readInt("Введіть ПОЗИТИВНЕ число:");
				if(a > 0){
					sum += a;
					counter++;
				}
			} while (a!=stop);
			println("Сума всіх введених чисел: " + sum);
			if (counter == 0){
				println("Середнього арифметичного немає, бо нічого не введено");
			} else {
				println("Середнє арифметичне всіх введених чисел: " + sum/counter);
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

	private void checkSkills() {
		while(true){
			println("Програма виводить 10 прикладів, ви маєте на них правильно відповісти");
			
			int correctAnswers = 0;
			for(int i = 0; i<10; i++){
				boolean operation = rgen.nextBoolean();
				if(operation){
					int firstNumber = rgen.nextInt(1, 99);
					int secondNumber = rgen.nextInt(1, 100-firstNumber);
					int result = readInt(firstNumber + " + " + secondNumber + " = ");
					if(result == firstNumber + secondNumber)
						correctAnswers++;
				} else {
					int firstNumber = rgen.nextInt(1, 99);
					int secondNumber = rgen.nextInt(1, firstNumber);
					int result = readInt(firstNumber + " - " + secondNumber + " = ");
					if(result == firstNumber - secondNumber)
						correctAnswers++;
				}
			}
			println("Оцінювання завершено!!!");
			if(correctAnswers == 10){
				println("Оцінка: відмінно");
			} else if(correctAnswers > 7){
				println("Оцінка: добре");
			} else if(correctAnswers > 5){
				println("Оцінка: задовільно");
			} else {
				println("Оцінка: погано");
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

	private void doPriceTable() {
		while(true){
			double n = readDouble("Введіть ціну за 1 кг товару, щоб вивести таблицю вартості: ");
			while (n < 1){
				n = readDouble("Введіть НАТУРАЛЬНЕ число: ");
			}
			
			priceTable(n);
			
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

	private void priceTable(double n) {
		for(int i = 100; i <= 1000; i += 100){
			println(i + " - " + n*0.1*(i/100));
		}
	}

	private void tenRandomNumbers() {
		double sum =0;
		for(int i = 0; i < 10; i++){
			int randomNumber = rgen.nextInt(1, 10);
			println(randomNumber);
			sum += randomNumber;
		}
		println("Середнє арифметична: " + sum/10);
	}

	private void tableOfFunction() {
		for(double i = -2; i <= 2; i += 0.5){
			println(i + " - " + (-2.4*i*i + 5*i - 3));
		}
	}
	
	private void findFactorial() {
		while(true){
			int n = readInt("Введіть ціле невід'ємне число, щоб знайти його факторіал: ");
			while (n < 0){
				n = readInt("Введіть ЦІЛЕ НЕВІД'ЄМНЕ число: ");
			}
			int factorialOne = factorialRecur(n);
			println("Факторіал від " + n +" : " + factorialOne);
			
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
	
	private int factorialRecur(int n) {
		if (n==0)
			return 1;
		return n*factorialRecur(n-1);
	}
	
	private void tableOfSquaresOfTwo() {
		for(int i =0; i <=10; i++){
			println("2 в степені " + i + " - " + Math.pow(2, i));
		}
	}

	private void doGarmSum() {
		while(true){
			int n = readInt("Введіть к-сть натуральних чисел, сума яких виведеться: ");
			while (n < 1){
				n = readInt("Введіть НАТУРАЛЬНЕ число: ");
			}
			double result = garmSum(n);
			println("Результат: " + result);
			
			//Запитуємо чи продовжувати
			int choice = readInt("Продовжуємо? Введіть 1, щоб продовжити, або 0 завершити: ");
			while(true){
				if(choice == 0){
					println("Програму завершено!");
					return;
				} else if(choice == 1){
					break;
				} else if(choice != 0 && choice != 1){
					choice = readInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу: ");
				} 
			}
		}
	}

	private double garmSum(int n) {
		double sum = 0;
		for(double i = 1; i <= n; i++){
			sum += 1/i;
		}
		return sum;
	}

	private void doSumOfNaturalOddNumbers() {
		while(true){
			int n = readInt("Введіть к-сть натуральних чисел, сума яких виведеться: ");
			while (n < 1){
				n = readInt("Введіть НАТУРАЛЬНЕ число: ");
			}
			int result = sumOfNaturalOddNumbers(n);
			println("Результат: " + result);
			
			//Запитуємо чи продовжувати
			int choice = readInt("Продовжуємо? Введіть 1, щоб продовжити, або 0 завершити: ");
			while(true){
				if(choice == 0){
					println("Програму завершено!");
					return;
				} else if(choice == 1){
					break;
				} else if(choice != 0 && choice != 1){
					choice = readInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу: ");
				} 
			}
		}
	}

	private int sumOfNaturalOddNumbers(int n) {
		return n*n;
	}

	private void doSumOfNaturalNumbers() {
		while(true){
			int n = readInt("Введіть к-сть натуральних чисел, сума яких виведеться: ");
			while (n < 1){
				n = readInt("Введіть НАТУРАЛЬНЕ число: ");
			}
			int result = sumOfNaturalNumbers(n);
			println("Результат: " + result);
			
			//Запитуємо чи продовжувати
			int choice = readInt("Продовжуємо? Введіть 1, щоб продовжити, або 0 завершити: ");
			while(true){
				if(choice == 0){
					println("Програму завершено!");
					return;
				} else if(choice == 1){
					break;
				} else if(choice != 0 && choice != 1){
					choice = readInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу: ");
				} 
			}
		}
	}

	private int sumOfNaturalNumbers(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++){
			sum += i;
		}
		return sum;
	}

	private void tableOfSquaresOfFirstFiveOddNumbers() {
		for(int i = 1; i<=9; i+=2){
			println(i + " - " + i*i);
		}
	}

	private void tableOfSquaresOfFirstTenNumbers() {
		for(int i = 1; i <= 10; i++){
			println(i + " - " + i*i);
		}
	}

	private void nameAndSurnameTenNimes() {
		for(int i = 0; i < 10; i++){
			println("Вус Павло");
		}
	}
	RandomGenerator rgen = RandomGenerator.getInstance();
}
