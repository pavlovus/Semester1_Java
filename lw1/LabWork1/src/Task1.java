/* Завдання №1 лабораторної роботи №1, Вус Павло, ІПЗ-1, група №1
 * Напишіть програму що малює піраміду. Піраміда складається з горизонтальних рядів цеглин. В кожному наступному ряду кількість цеглин зменшується на один. Нижче наведено приклад:
   Піраміда має розташовуватися по центру горизонталі вікна
*/

import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class Task1 extends GraphicsProgram{
	//Задаємо необхідні константи
	private static final int X = 600;
	private static final int Y = 600;
	private static final double BRICK_WIDTH = 30*2;
	private static final double BRICK_HEIGHT = 12*2;
	private static final int BRICKS_IN_BASE	 = 3;
	public void run(){
		this.setSize(X, Y);
		buildThePiramid(BRICKS_IN_BASE, BRICK_HEIGHT, BRICK_WIDTH);
	}
//Метод, який приймає кіл-сть цеглинок в основі, ширину і висоту цеглинки і будує піраміду
	private void buildThePiramid(int bricksInBase, double brickHeight, double brickWidth) {
		double centerX = X/2;
		//Змінна, яка відповідає поточній кіл-сті цеглинок
		int currentNumberOfBricks = bricksInBase;
		for (int i = 0; i < bricksInBase; i++) {
			for (int j = 0; j < currentNumberOfBricks; j++){
				//Два варіанти побудови рядка, для рядкків з парною і непарною кількістю цеглинок
				if (currentNumberOfBricks % 2 == 0){
					GRect brick = new GRect(centerX - currentNumberOfBricks/2*brickWidth + brickWidth*j, Y - brickHeight*(i+1), brickWidth, brickHeight);
					add(brick);
				} else {
					GRect brick = new GRect(centerX - (currentNumberOfBricks/2 + 0.5)*brickWidth + brickWidth*j, Y - brickHeight*(i+1), brickWidth, brickHeight);
					add(brick);
				}
			}
			//З кожним рядком зменшуємо кіл-сть цеглин на один
			currentNumberOfBricks--;
		}
	}
}
