/* Завдання №2 лабораторної роботи №1, Вус Павло, ІПЗ-1, група №1
 * Ви маєте написати програму, що малює зображення "мішень для лучника"
 * Мішень має розташовуватися по центру вікна. Мають бути використані константи:
- ширира світу;
- висота світу;
- кількість кругів.*/

import java.awt.Color;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;


public class Task2 extends GraphicsProgram{
	private static final int X =600;
	private static final int Y =600;
	private static final int NUMBER_OF_CIRCLES = 4;
	private static final double RADIUS = 15*3;
	
	public void run(){
		this.setSize(X, Y);
		buildTheTarget(NUMBER_OF_CIRCLES);
	}
//Метод, який приймає задану кіл-сть кругів і будує мішень
	private void buildTheTarget(int numberOfCircles) {
		//Знаходимо центр
		double centerX = X/2;
		double centerY = Y/2;
		//Задаємо колір початкового круга так, щоб найменший завжди був червоний
		boolean color;
		if(numberOfCircles % 2 == 0){
			color = false;
		}  else {
			color = true;
		}
		//Малюємо задану кількість кругів з заданим кольором, від найбільшого до найменшого
		for (int i = -numberOfCircles +1; i < 1; i++){
			GOval circle = new GOval(centerX - RADIUS + i*RADIUS,centerY - RADIUS + i*RADIUS, RADIUS*2*(-i + 1), RADIUS*2*(-i + 1));
			circle.setFilled(true);
			if(color){
				circle.setFillColor(Color.red);
			} else {
				circle.setFillColor(Color.white);
			}
			color = !color;
			add(circle);
		}
	}
}
