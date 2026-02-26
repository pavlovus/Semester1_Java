import stanford.karel.SuperKarel;


public class Task3 extends SuperKarel {


	public void run() {
		while(frontIsClear()){
			buildColumn();
			for (int i=0; i<4;i++){
				move();
			}
		}
		buildColumn();
	}
	private void buildColumn(){
		turnLeft();
		while(frontIsClear()){
			if(noBeepersPresent()){
				putBeeper();
			}
			move();
		}
		if(noBeepersPresent()){
			putBeeper();
		}
		comeDown();
	}
	private void comeDown(){
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnLeft();
	}

}
