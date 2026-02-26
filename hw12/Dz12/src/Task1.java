import acm.program.ConsoleProgram;


public class Task1 extends ConsoleProgram {
	public void run(){
		analizeString();
	}
	//Метод, який аналізує стрічку по п'яти пунктам, доки цього хоче користувач
	private void analizeString() {
		while(true){
			//Запитуємо ввести будб-яку стрічку
			String input = readLine("Введіть трічку, щоб перевірити її за критеріями: ");
			
			//Обраховуємо та виводимо результати
			int resultOne = calculateNumberOfWords(input);
			println("К-сть слів стрічці: " + resultOne);
			int resultTwo = calculateNumberOfNumbers(input);
			println("К-сть чисел стрічці: " + resultTwo);
			String resultThree = stringOnlyWithLetters(input);
			println("Стрічка, в якій тільки літери: " + resultThree);
			String resultFour = stringWithSingleGaps(input);
			println("Стрічка,  в якій множинні проміжки перетворені в один проміжок: " + resultFour);
			String resultFive = stringWithOnlyCapitalLetterWords(input);
			println("Стрічка, яка містить лише слова, що починаються з великої літери: " + resultFive);
			
			//Запитуємо чи користувач хоче продовжити
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
	//Метод, який перетворює стрічку в стрічку яка містить лише слова, що починаються з великої літери 
	/**
	 * A method that converts a string into a string containing only words beginning with an uppercase letter
	 * @param st random string
	 * @return string containing only words beginning with an uppercase letter
	 */
	private String stringWithOnlyCapitalLetterWords(String st) {
		String tranformedString = "";
		for(int i = 0; i < st.length(); i++){
			String combinationOfSymbols = "";
			if(isPunctuation(st.charAt(i))){
				//tranformedString += st.charAt(i);
				continue;
			}
			
			combinationOfSymbols += st.charAt(i);
			while (i + 1 < st.length() && !isPunctuation(st.charAt(i+1))) {
                i++;
                combinationOfSymbols += st.charAt(i);
            }
			
			if(Character.isUpperCase(combinationOfSymbols.charAt(0))){
				tranformedString += combinationOfSymbols;
				tranformedString += " ";
			}
			combinationOfSymbols = "";
		}
		return tranformedString;
	}
	//Метод, який перетворює стрічку в стрічку, в якій множинні проміжки перетворені в один проміжок
	/**
	 * A method that converts a string into a string in which multiple spans are converted to a single span
	 * @param st random string
	 * @return string in which multiple spans are converted to a single span
	 */
	private String stringWithSingleGaps(String st) {
		String tranformedString = "";
		for(int i = 0; i < st.length(); i++){
			if(st.charAt(i) == ' '){
				tranformedString += st.charAt(i);
				for(int j = i + 1; j < st.length() && st.charAt(j) == ' '; j++){
					i = j;
				}
			} else {
				tranformedString += st.charAt(i);
			}
		}
		return tranformedString;
	}
	//Метод, який перетворює стрічку в стрічку в якій прибрані усі символи, крім літер
	/**
	 * A method that converts a string into a string with all characters except letters removed
	 * @param st random string
	 * @return string with all characters except letters removed
	 */
	private String stringOnlyWithLetters(String st) {
		String tranformedString = "";
		for(int i = 0; i < st.length(); i++){
			if(Character.isUpperCase(st.charAt(i)) || Character.isLowerCase(st.charAt(i))){
				tranformedString += st.charAt(i);
			}
		}
		return tranformedString;
	}
	//Метод, який рахує кількість чисел в стрічці
	/**
	 *A method that counts the number of numbers in string
	 * @param st random string
	 * @return int number of numbers
	 */
	private int calculateNumberOfNumbers(String st) {
		int counter = 0;
		String combinationOfSymbols = "";
		for(int i = 0; i < st.length(); i++){
			if(st.charAt(i) == ' '){
				continue;
			}
			
			combinationOfSymbols += st.charAt(i);
			while (i + 1 < st.length() && st.charAt(i + 1) != ' ') {
                i++;
                combinationOfSymbols += st.charAt(i);
            }
			
			if(analizeCombinationOfSymbolsForNumber(combinationOfSymbols)){
				counter++;
			}
			combinationOfSymbols = "";
		}
		return counter;
	}
	//Метод, який перевіряє чи набір символів є числом
	/**
	 *A method that checks whether a set of characters is a number
	 * @param st random string
	 * @return boolean(is it number or not)
	 */
	private boolean analizeCombinationOfSymbolsForNumber (String combinationOfSymbols) {
		//println(combinationOfSymbols);
		int counterOfSymbols = 0;
		for(int i = 0; i < combinationOfSymbols.length(); i++){
			if(counterOfSymbols>1){
				return false;
			} else if ((combinationOfSymbols.charAt(i) == '.' || combinationOfSymbols.charAt(i) == ',') && i + 1 < combinationOfSymbols.length() && i>=1){
				counterOfSymbols++;
			} else if(!Character.isDigit(combinationOfSymbols.charAt(i))){
				return false;
			}
		}
		return true;
	}
	//Метод, який рахує кількість слів в стрічці
	/**
	 *A method that counts the number of words in string
	 * @param st random string
	 * @return int number of words
	 */
	private int calculateNumberOfWords(String st) {
		int counter = 0;
		String combinationOfSymbols = "";
		for(int i = 0; i < st.length(); i++){
			if(st.charAt(i) == ' '){
				continue;
			}
			
			combinationOfSymbols += st.charAt(i);
			while (i + 1 < st.length() && st.charAt(i + 1) != ' ') {
                i++;
                combinationOfSymbols += st.charAt(i);
            }
			if(!analizeCombinationOfSymbolsForNumber(combinationOfSymbols)){
				counter += analizeForNumberOfWords(combinationOfSymbols);
			}
			combinationOfSymbols = "";
		}
		return counter;
	}
	private int analizeForNumberOfWords(String combinationOfSymbols) {
		int counter = 0;
		for(int i = 0; i < combinationOfSymbols.length(); i++){
			if(!isPunctuation(combinationOfSymbols.charAt(i))){
				while (i + 1 < combinationOfSymbols.length() && !isPunctuation(combinationOfSymbols.charAt(i+1))) {
	                i++;
	            }
				counter++;
			}
		}
		return counter;
	}
	//Метод, який визначає чи символ є знаком пунктуації
	/**
	 *A method that determines whether a character is a punctuation mark
	 * @param st random character
	 * @return boolean(is it punctuation mark or not)
	 */
	private boolean isPunctuation(char ch){
		return ch == ' ' || ch == '?' || ch == '!' || ch == '.' || ch == ',' || ch == ';' || ch == ':' || ch == '-';
	}
}
