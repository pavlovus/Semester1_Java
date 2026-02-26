import stanford.karel.SuperKarel;


public class Task2 extends SuperKarel{

	public void run(){
		moveToTheDoor();
		pickNewspaper();
		comeBack();
	}
	public void moveToTheDoor(){
		while(leftIsBlocked()){
			if(frontIsClear()){
				move();
			} else {
				turnRight();
			}
		}
	}
	public void pickNewspaper(){
		turnLeft();
		move();
		pickBeeper();
	}
	public void comeBack(){
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnRight();
		while(frontIsClear()){
			move();
		}
		turnRight();
		putBeeper();
	}

}
