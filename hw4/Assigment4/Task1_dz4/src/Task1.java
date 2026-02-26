/*Домашнє завдання №4 (завдання 1), Вус Павло, ІПЗ-1, 1-ша група */

import stanford.karel.SuperKarel;


public class Task1 extends SuperKarel{
	public void run(){
		while(frontIsClear()){
			move();
			checkCard();
			move();
		}
	}
//Метод, який перевіряє наявність біпера в центрі і в залежності від цього проставляє або забирає біпери з кожної клітинки
	private void checkCard() {
		if(beepersPresent()){
			putAllBeepers();
		} else {
			takeAllBeepers();
		}
	}
//Метод, який забирає всі біпери з обох сторін і повертає Керола в центр
	private void takeAllBeepers() {
		takeRightPart();
		comeBack();
		takeLeftPart();
		comeBack();
	}
//Метод, який прибирає біпери з лівої частини
	private void takeLeftPart() {
		turnLeft();
		while(frontIsClear()){
			move();
			pickAllPresentBeepers();
		}
	}
//Метод, який забирає всі біпери з клітинки
	private void pickAllPresentBeepers() {
		while(beepersPresent()){
			pickBeeper();
		}
	}
//Метод, який прибирає біпери з правої частини
	private void takeRightPart() {
		turnRight();
		while(frontIsClear()){
			move();
			pickAllPresentBeepers();
		}
	}
//Метод, який проставляє біпери з обох сторін і повертає Керола в центр
	private void putAllBeepers() {
		putRightPart();
		comeBack();
		putLeftPart();
		comeBack();
	}
//Метод, який повертає Керола в центр
	private void comeBack() {
		turnAround();
		while(leftIsBlocked()){
			move();
		}
		turnToEast();
	}
//Метод, який повертає Керола на схід, тобто в початкове положення
	private void turnToEast() {
		if(facingSouth()){
			turnLeft();
		}
		if(facingNorth()){
			turnRight();
		}
	}
//Метод, який проставляє біпери в лівій частини
	private void putLeftPart() {
		turnLeft();
		while(frontIsClear()){
			move();
			pickAllPresentBeepers();
			putBeeper();
		}
	}
//Метод, який проставляє біпери в правій частини
	private void putRightPart() {
		turnRight();
		while(frontIsClear()){
			move();
			pickAllPresentBeepers();
			putBeeper();
		}
	}
}
