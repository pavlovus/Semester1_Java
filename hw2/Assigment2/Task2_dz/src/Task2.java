import stanford.karel.SuperKarel;


public class Task2 extends SuperKarel{

	public void run(){
		while(frontIsClear() || leftIsClear()){
			findPass();
			if(frontIsBlocked()){
				break;
			}
			moveUp();
			turnBack();
		}
	}
	private void turnBack() {
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnAround();
	}
	private void moveUp(){
		while(frontIsClear()){
			move();
		}
		turnRight();
	}
	private void findPass(){
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
	
}