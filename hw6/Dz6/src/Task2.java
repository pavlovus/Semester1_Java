/*Домашнє завдання №6, Вус Павло, ІПЗ-1, група №1
 * Програма, що малює стовпчики з біперів через кожні 50(або інше задане число) пікселів
 * Кольори біперів чергуються. Висота кожного наступного стовпчика більша за попередню на задане число біперів
 * Розмір біперів 50х50 (або інше задане число)*/

import acm.graphics.GLine;
import acm.program.GraphicsProgram;


public class Task2 extends GraphicsProgram{
	//розмірність ромба
	private static final int SIZE = 50;
	//відстань між стовпцями
	private static final int SPACE_X = 50 + SIZE;
	//відстань між рядками
	private static final int SPACE_Y = 10 + SIZE;
	//початкова кількість біперів
	private static final int START_WITH = 3;
	//різниця між стовпцями
	private static final int DIFFERENCE = 1;
	//розмірність вікна
	private static final int X =700;
	private static final int Y =500;
	public void run(){
		this.setSize(X, Y);
		//Малюємо всі біпери
		for (int i = 0; SPACE_X*i < X - SIZE; i++){
			for (int j = 0; j < START_WITH + DIFFERENCE*i && SPACE_Y*j < Y - SIZE; j++){
				addRhomb(SPACE_X*i, SPACE_Y*j);
			}
		}
	}
//Метод, який приймає координати ромба і малює його
	private void addRhomb(int x, int y) {
		GLine lineOne = new GLine(x,Y -y - SIZE/2, SIZE/2 + x, Y -y - SIZE);
		add(lineOne);
		GLine lineTwo = new GLine(SIZE/2 + x, Y -y - SIZE, SIZE + x,Y -y - SIZE/2);
		add(lineTwo);
		GLine lineThree = new GLine(SIZE +x,Y -y - SIZE/2, SIZE/2 +x,Y -y);
		add(lineThree);
		GLine lineFour = new GLine(SIZE/2 +x, Y -y, x,Y -y - SIZE/2);
		add(lineFour);
	}
}
