import stanford.karel.SuperKarel;


public class Task1 extends SuperKarel{

	public void run(){
		turnLeft();
		drawLetterV();
	}
	private void drawLetterV () {
		for (int i=0; i<10; i++){
			putBeeper();
			if (frontIsClear()){
				move();
			} else {
				turnRight();
			}
		}
		move();
		putBeeper();
		for (int i=0; i<2; i++){
			move();
			turnRight();
			move();
			putBeeper();
			turnLeft();
		}
		turnRight();
		move();
		putBeeper();
		move();
		turnRight();
		move();
		putBeeper();
		move();
		turnLeft();
		move();
		putBeeper();
		turnLeft();
		for (int i=0; i<2; i++){
			move();
			turnRight();
			move();
			putBeeper();
			turnLeft();
		}
		turnRight();
		move();
		putBeeper();
		move();
		turnRight();
		move();
		putBeeper();
		move();
		putBeeper();
		turnAround();
	}
}