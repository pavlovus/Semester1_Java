/*Домашнє завдання №3, Вус Павло Ігорович, ІПЗ-1, 1-ша група */


/* Програма, яка Карелом розставляє біпери по всьому світу в шаховому порядку, починаючи з клітинки (1;1), де він і розташований з початку */


import stanford.karel.SuperKarel;


public class Task1 extends SuperKarel {

	public void run() {
		putLineOfBeepers();
		comeBack();
		while(leftIsClear()){
			putNextLineOfBeepers();
			comeBack();
		}
	}

//Метод, який піднімає Керола вгору на одну клітинку, якщо є куди підійматись
	private void moveUp() {
		turnLeft();
		carefullyMove();
		turnRight();
	}

//Метод, який повертає Керола до початку рядку і ставить в вихідне положення
	private void comeBack() {
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnAround();
	}

//Метод, який ставить рядок біперів через одну клітинку, доки не зустріне стінку
	private void putLineOfBeepers() {
		putBeeper();
		while(frontIsClear()){
			carefullyMove();
			if(frontIsClear()){
				carefullyMove();
				putBeeper();
			}
		}
	}
	
//Метод, який піднімає Керола на рядок вище і розставляє біпери протилежно до попереднього рядку
	private void putNextLineOfBeepers() {
		if(beepersPresent()){
			moveUp();
			moveRightAndPutLineOfBeepers();
		} else {
			moveUp();
			putLineOfBeepers();
		}
	}
	
//Метод, який рухає Керола, перевіряючи клітинку перед ним
	private void carefullyMove() {
		if(frontIsClear()){
			move();
		}
	}
	
//Метод, який переміщає Керола вправо(якщо є куди) тільки тоді починає виставляти біпери, щоб не повторювати їхнє розташування в попередньому рядку
	private void moveRightAndPutLineOfBeepers() {
		if(frontIsClear()){
			move();
			putLineOfBeepers();
		} 
	}
}
