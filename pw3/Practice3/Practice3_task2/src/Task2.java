/*Практична №3, завдання №2, Вус Павло Ігорович, ІПЗ-1, 1-ша група */

/* Програма проводить Карола через вертикальний лабіринт, при цьому збираючи біпери в усіх клітинках.
 *  Карел починає з клітинки 1х1, обличчям на схід, стіни розташовані вертикально.
 *  Карел має закінчити свою роботу в верхньому правому кутку свого світу обличчям на схід
 */

import stanford.karel.SuperKarel;


public class Task2 extends SuperKarel{

	public void run() {
		while(frontIsClear() || beepersPresent() || leftIsClear()){
			pickBeepers();
			comeBack();
			findPass();
			if(frontIsBlocked()){
				break;
			}
			moveRight();
			comeBack();
		}
	}
// Метод, який проводить Керола на одну клітинку вправо і повертає в вихідне положення
	private void moveRight() {
		move();
		turnToNorth();
	}
// Метод, який повертає Керола на північ, тобто в вихідне положення
	private void turnToNorth() {
		if(facingSouth()){
			turnAround();
		}
		if(facingEast()){
			turnLeft();
		}
	}
// Метод, який шукає дірку в лабіринті і повертається в її сторону
	private void findPass() {
		while(rightIsBlocked()){
			if(frontIsClear()){
				move();
			} else {
				break;
			}
		}
		turnRight();
	}
// Метод, який повертає Керола до початку стовбця і повертає в вихідне положення
	private void comeBack() {
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnToNorth();
	}
// Метод, який проходить весь стовбець і збирає кожен присутній біпер
	private void pickBeepers() {
		turnToNorth();
		pickOneBeeper();
		while(frontIsClear()){
			move();
			pickOneBeeper();
		}
		
	}
// Метод, який підбирає біпер, якщо він є в клітинці
	private void pickOneBeeper() {
		if(beepersPresent()){
			pickBeeper();
		}
	}

}
