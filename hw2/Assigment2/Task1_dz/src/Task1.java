import stanford.karel.SuperKarel;


public class Task1 extends SuperKarel{

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
		if (noBeepersPresent()){
			turnLeft();
			move();
		}
	}
	public void pickNewspaper(){
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
