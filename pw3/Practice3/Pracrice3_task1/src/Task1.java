/*Практична №3, завдання №1, Вус Павло Ігорович, ІПЗ-1, 1-ша група */



/* Програма проводить Карола через лабіринт, при цьому збираючи біпери в усіх клітинках.
 *  Карел починає з клітинки 1х1, обличчям на схід, стіни розташовані горизонтально.
 *  Карел має закінчити свою роботу в верхньому правому кутку свого світу обличчям на схід
 */

import stanford.karel.SuperKarel;


public class Task1 extends SuperKarel {
	public void run (){
		while(frontIsClear() || beepersPresent() || leftIsClear()){
			pickBeepers();
			comeBack();
			findPass();
			if(frontIsBlocked()){
				break;
			}
			moveUp();
			comeBack();
		} 
	}
// Метод, який піднімає Керола на одну клітинку вгору і повертає в вихідне положення
	private void moveUp() {
		move();
		turnToEast();
	}
// Метод, який шукає дірку в лабіринті і повертається в її сторону
	private void findPass() {
		while(leftIsBlocked()){
			if(frontIsClear()){
				move();
			} else{
				turnRight();
				break;
			}
		}
		turnLeft();
	}
// Метод, який повертає Керола до початку рядку і повертає в вихідне положення
	private void comeBack() {
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnToEast();
		
	}
// Метод, який проходить весь рядок і збирає кожен присутній біпер
	private void pickBeepers() {
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
// Метод, який повертає Керола на схід, тобто в вихідне положення
	private void turnToEast(){
		if(facingNorth()){
			turnRight();
		}
		if(facingWest()){
			turnAround();
		}
	
	}
}
