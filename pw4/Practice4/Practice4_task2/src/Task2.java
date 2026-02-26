/*Практична робота №4, Вус Павло, ІПЗ-1, 1-ша група */

import stanford.karel.SuperKarel;


public class Task2 extends SuperKarel{
	public void run(){
		putLineOfBeepers();
		turnAround();
		findCenter();
		putBeeper();
	}
//Метод, який проставляє рядок біперів
	private void putLineOfBeepers() {
		/*putBeeper();*/
		while(frontIsClear()){
			move();
			putBeeper();
		}
	}
//Метод, який знаходить центр через почергове підбирання біперів з країв
	private void findCenter() {
		while(beepersPresent()){
			pickBeeper();
			moveToTheNextSide();
		}
		turnToEast();
	}
//Метод, який повертає Керола обличчям на схід, якщо він так не стоїть
	private void turnToEast() {
		if(facingWest()){
			turnAround();
		}
	}
//Метод, який переходить до краю рядка з біперів
	private void moveToTheNextSide() {
		move();
		while(beepersPresent()){
			move();
		}
		turnAround();
		move();
	}
}
