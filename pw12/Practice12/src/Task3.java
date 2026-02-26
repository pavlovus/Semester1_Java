/*Практичне завдання №12, Вус Павло, ІПЗ-1, група №1 
 * За понеділком іде вівторок тощо, а за неділею – понеділок.
 *  Написати функцію обчислення за днем тижня (типу Weekd) наступного за ним дня*/
import acm.program.ConsoleProgram;


public class Task3  extends ConsoleProgram{
	public void run(){
		getNextDayByNumber();
	}
	
	//метод, що знаходить наступний день тижня ха попереднім, доки цього хоче користувач
	private void getNextDayByNumber() {
		while(true){
			String input = readLine("Введіть назву дня тижня англійською великими літерами, щоб дізнатися наступний день : ");
			while(!(input.equals("MONDAY") || input.equals("TUESDAY")|| input.equals("WEDNEASDAY") || input.equals("THURSDAY") || input.equals("FRIDAY") || input.equals("SATURDAY") || input.equals("SUNDAY"))){
				input = readLine("Введіть назви днів тижня АНГЛІЙСЬКОЮ ВЕЛИКИМИ ЛІТЕРАМИ: ");
			}
			
			//Знаходимо та виводимо результат
			Weekd intputDay = Weekd.valueOf(input);
			Weekd nextDay = intputDay.getNextDay();
			println("Наступний день тижня: " + nextDay);
			
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
