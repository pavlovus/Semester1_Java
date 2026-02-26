/*Домашнє завдання №6, Вус Павло, ІПЗ-1, група №1
 * Програма, що малює малює шахову дошку*/
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class Task1 extends GraphicsProgram{
	//кількість рядків
	private static final double ROWS = 3;
	//кількість стовбців
	private static final double COLUMNS = 2;
	//розмірність вікна
	private static final int X =500;
	private static final int Y =500;
	public void run(){
		this.setSize(X, Y);
		buildChessBoard(ROWS, COLUMNS);
	}
//Метод, який приймає кількість стовбців і рядків, будує шахову дошку
	private void buildChessBoard(double n, double m) {
		boolean colorHorizontal = true;
		boolean colorVertical = true;
		double sizeOfCellY = Y/ROWS;
		double sizeOfCellX = X/COLUMNS;
		for (int i = 0; i < ROWS; i++){
			for (int j = 0; j < COLUMNS; j++){
				GRect cell = new GRect(j*sizeOfCellX,(Y - sizeOfCellY) - i*sizeOfCellY ,sizeOfCellX,sizeOfCellY);
				cell.setFilled(colorHorizontal);
				colorHorizontal = !colorHorizontal;
				add(cell);
			}
			colorHorizontal = !colorVertical;
			colorVertical = !colorVertical;
		}
	}
}
