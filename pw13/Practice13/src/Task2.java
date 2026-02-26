/*Практичне завдання №13, Вус Павло, ІПЗ-1, група №1 
 * Написати клас який реалізує метод, що видаляє заданий символ з стрічки і повертає результат: 
	public String removeAllOccurences(String str, char ch);	*/
import acm.program.ConsoleProgram;


public class Task2 extends ConsoleProgram{
	public void run(){
		useRemoveAllOccurences();
	}
	
	//Метод, який прибирає заданий символи зі стрічки, доки цього хоче користувач
	/**
	 * Method that uses removeAllOcurrences() as long as the user wants it
	 */
	private void useRemoveAllOccurences() {
		while(true){
			String input= readLine("Введіть стрічку, яку будемо редагувати: ");
			String toRemove = readLine("Введіть символ, який необхідно прибрати: ");
			while(toRemove.length() > 1){
				toRemove = readLine("Вам потрібно ввести ЛИШЕ ОДИН символ: ");
			}
			char charToRemove = toRemove.charAt(0);
			
			String result = removeAllOccurences(input, charToRemove);
			println("Нова стрічка: " + result);
			
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
	
	//Метод, який прибирає заданий символ зі стрічки і повертає стрічку без нього
	/**
	 * A method that removes all given character from the string
	 * @param st original string
	 * @param ch char to remove
	 * @return
	 */
	private String removeAllOccurences(String st, char ch) {
		String result = "";
		for(int i = 0; i < st.length(); i++){
			if(!(st.charAt(i)== ch)){
				result += st.charAt(i);
			}
		}
		return result;
	}
}
