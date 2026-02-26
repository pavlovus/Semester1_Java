/*Домашнє завдання №4 (завдання 1), Вус Павло, ІПЗ-1, 1-ша група */

import stanford.karel.SuperKarel;


public class Task2 extends SuperKarel{
	public void run(){
		putFirstLineOfBeepers();
		comeBack();
		if(leftIsClear()){
			putSecondLineOfBeepers();
		}
		while(leftIsClear() && beepersPresent()){
			putNextLineOfBeepers();
		}
	}
	
//Метод, який проставляє біперами повністю перший ряд
	private void putFirstLineOfBeepers() {
		putBeeper();
		while(frontIsClear()){
			move();
			putBeeper();
		}
	}
//Метод, який переносить перший ряд догори, крім першого і останнього біпера
	private void putSecondLineOfBeepers() {
		while(beepersPresent() && frontIsClear()){
			putUpperBeeper();
			goDown();
			carefullyMove();
		}
		comeBack();
		takeFirstBeeper();
		goDown();
		carefullyMove();
		goUp();
	}

//Метод, який копіює попередній ряд біперів і прибирає перший і останній
	private void putNextLineOfBeepers() {
		while(beepersPresent()){
			putUpperBeeper();
			goDown();
			carefullyMove();
		}
		goBack();
		comeToTheBackOfTheLine();
		takeFirstBeeper();
		turnRight();
		takeLastBeeper();
		comeToTheBackOfTheLine();
	}
//Метод, який повертає Керола на одну клітинку назад
	private void goBack() {
		turnAround();
		move();
		turnAround();
	}

//Метод, який піднімає Керола на одну клітинку догори
	private void goUp() {
		turnLeft();
		move();
		turnRight();
	}

//Метод, який повертає Керола до початку рядку з біперів
	private void comeToTheBackOfTheLine() {
		turnAround();
		move();
		while(beepersPresent()){
			move();
		}
		turnAround();
		move();
	}
//Метод, який прибирає перший біпер
	private void takeFirstBeeper() {
		turnLeft();
		move();
		carefullyPickBeeper();
	}
//Метод, який прибирає останній біпер
	private void takeLastBeeper() {
		move();
		while(beepersPresent()){
			move();
		}
		goBack();
		carefullyPickBeeper();
	}
//Метод, який підбирає біпер,якщо він є
	private void carefullyPickBeeper() {
		if(beepersPresent()){
			pickBeeper();
		}
	}

//Метод, який опускає Керола на одну клітинку вниз
	private void goDown() {
		turnAround();
		move();
		turnLeft();
	}
//Метод, який ставить біпер зверху від Керола
	private void putUpperBeeper() {
		turnLeft();
		move();
		putBeeper();
	}
//Метод, який повертає Керола до початку першого рядку
	private void comeBack() {
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnAround();
	}
//Метод, який рухає Керола вперед, якщо там немає стінки
	private void carefullyMove() {
		if(frontIsClear()){
			move();
		}
	}

}
