import java.awt.Color;

import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.util.SoundClip;


public class PlayPlaneGame extends GraphicsProgram{
	public static final int X = 1000;
	public static final int Y = 650;
	public static final int BASELINE = 550;
	private static final int DELAY = 10;
	private static final int PLANE_SPEED = 4;
	private static final int BULLET_SPEED = 10; 
	private static final int MAX_AIM_SPEED = 5;
	private static final int EXPLOSION_LIFE_TIME = 100;
	

	public void run() {
		setup(X, Y);
		addMouseListeners();
        while (true) {
        	gameActive = !gameOver();
            if (gameActive) {
                movePlane();
                moveBullet();
                moveAims();
                checkExplosionsLifeTime();
                checkForCollisions();
                pause(DELAY);
            } else if (gameOver() && start){
            	createRestartScreen(X, Y);
                pause(250); 
                removeForRestart(); 
            }
        }
    }
	
	private void createRestartScreen(int x, int y) {
		winnerText.setFont("Anton-" + x/25);
		winnerText.setColor(Color.decode("#D3D3D3"));
		add(winnerText, x/2 - winnerText.getWidth()/2, y/5 - winnerText.getHeight()/2);
		
		transitionalText = new GLabel("CONTINUE?");
		transitionalText.setFont("Anton-" + x/25);
		transitionalText.setColor(Color.decode("#D3D3D3"));
		add(transitionalText, x/2 - transitionalText.getWidth()/2, y/2 - transitionalText.getHeight()/2);
		
		continueButton = new GButton("YES", x/10 , y/13);
		add(continueButton, x/2 - x/10 - x/20, y/2 + y/26);
		
		endButton = new GButton("NO", x/10 , y/13);
		add(endButton, x/2 + x/20, y/2 + y/26);
		if(plane != null) {
			remove(plane);
			plane = null;
		}
	}

	private void setup(int x, int y) {
		this.setSize(x, y);
		setBackground(x, y);
		addStartText(x, y);
		addTitle(x,y);
		addSounds();
		start = false;
	}

	private void addSounds() {
		explosionSound = new SoundClip("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\sounds\\explosionSound.wav");
		explosionSound.setVolume(0.2);
		winSound = new SoundClip("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\sounds\\winSound.wav");
		winSound.setVolume(1);
		loseSound = new SoundClip("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\sounds\\loseSound.wav");
		loseSound.setVolume(1);
	}

	public void mouseClicked(MouseEvent e) {
		if(!start){
			remove(startText);
			remove(title);
			addPlane(0, 0);
			addAims(X, Y, BASELINE);
			start = true;
			gameActive = true;
			planeToLeft = false;
		} else if (bullet == null && gameActive) { 
				bullet = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\bombPlaneGame.png");  
				if (planeToLeft){
					add(bullet, plane.getX() - plane.getWidth()/2 - bullet.getWidth()/2 , plane.getY() +  plane.getHeight()/2);
				} else {
					add(bullet, plane.getX() + plane.getWidth()/2 - bullet.getWidth()/2, plane.getY() +  plane.getHeight()/2); 
				}
		} else {
			last = new GPoint(e.getPoint()); 
			gobj = getElementAt(last);
			if(gobj == continueButton){
				removeForRestart();
				addPlane(0, 0);
				addAims(X, Y, BASELINE);
				gameActive = true;
				planeToLeft = false;
			} else if (gobj == endButton){
				removeForRestart();
				addEndText(X, Y);
				start = false;
			}
		}
	}
	
	private void addEndText(int x, int y) {
		endText = new GLabel("THANK YOU FOR PLAYING!!! (;");
		endText.setFont("Anton-" + x/28);
		endText.setColor(Color.decode("#D3D3D3"));
		add(endText, x/2 - endText.getWidth()/2, y/2 - endText.getHeight()/2);
	}

	private void removeForRestart() {
		remove(title);
		remove(transitionalText);
		remove(continueButton);
		remove(endButton);
		remove(winnerText);
		removeBullet();
		removeExplosions();
	}

	private void removeBullet() {
		if(bullet != null){
			remove(bullet); 
			bullet = null;
		}
	}

	private void removeAims() {
		if(aimOne != null){
			remove(aimOne);
			aimOne=null;
		}
		if( aimTwo != null){
			remove(aimTwo);
			aimTwo=null;
		}
		if( aimThree != null){
			remove(aimThree);
			aimThree=null;
		}
		if( aimFour != null){
			remove(aimFour);
			aimFour=null;
		}
		if( aimFive != null){
			remove(aimFive);
			aimFive=null;
		}
	}

	private void removeExplosions() {
		if(explosionOne != null){
			remove(explosionOne);
			explosionOne = null;
		}
		if( explosionTwo != null){
			remove(explosionTwo);
			explosionTwo = null;
		}
		if( explosionThree != null){
			remove(explosionThree);
			explosionThree = null;
		}
		if( explosionFour != null){
			remove(explosionFour);
			explosionFour = null;
		}
		if( explosionFive != null){
			remove(explosionFive);
			explosionFive = null;
		}
		if( planeExplosion != null){
			remove(planeExplosion);
			planeExplosion = null;
		}
	}

	private void checkExplosionsLifeTime() {
		if( explosionOne != null){
			if(explosionOneLifeTime > 0){
				explosionOneLifeTime--;
			} else{
				remove(explosionOne);
				explosionOne = null;
			}
		}
		if( explosionTwo != null){
			if(explosionTwoLifeTime > 0){
				explosionTwoLifeTime--;
			} else{
				remove(explosionTwo);
				explosionTwo = null;
			}
		}
		if( explosionThree != null){
			if(explosionThreeLifeTime > 0){
				explosionThreeLifeTime--;
			} else{
				remove(explosionThree);
				explosionThree = null;
			}
		}
		if( explosionFour != null){
			if(explosionFourLifeTime > 0){
				explosionFourLifeTime--;
			} else{
				remove(explosionFour);
				explosionFour = null;
			}
		}
		if( explosionFive != null){
			if(explosionFiveLifeTime > 0){
				explosionFiveLifeTime--;
			} else{
				remove(explosionFive);
				explosionFive = null;
			}
		}
	}

	private void moveAims() {
		moveAimOne();
		moveAimTwo();
		moveAimThree();
		moveAimFour();
		moveAimFive();
	}

	private void moveAimFive() {
		if(aimFiveSpeed != 0 && aimFive != null){
			if (aimFiveToLeft) { 
				aimFive.move(-aimFiveSpeed, 0); 
				if (aimFive.getX() <= aimFourMaxMove) { 
					aimFiveToLeft = false;
				} 
			} else { 
				aimFive.move(aimFiveSpeed, 0); 
				if (aimFive.getX() >= aimFiveMaxMove - aimFive.getWidth()) { 
					aimFiveToLeft = true; 
				} 
			}
		}
	}

	private void moveAimFour() {
		if(aimFourSpeed != 0 && aimFour != null){
			if (aimFourToLeft) { 
				aimFour.move(-aimFourSpeed, 0); 
				if (aimFour.getX() <= aimThreeMaxMove) { 
					aimFourToLeft = false;
				} 
			} else { 
				aimFour.move(aimFourSpeed, 0); 
				if (aimFour.getX() >= aimFourMaxMove - aimFour.getWidth()) { 
					aimFourToLeft = true; 
				} 
			}
		}
	}

	private void moveAimThree() {
		if(aimThreeSpeed != 0 && aimThree != null){
			if (aimThreeToLeft) { 
				aimThree.move(-aimThreeSpeed, 0); 
				if (aimThree.getX() <= aimTwoMaxMove) { 
					aimThreeToLeft = false;
				} 
			} else { 
				aimThree.move(aimThreeSpeed, 0); 
				if (aimThree.getX() >= aimThreeMaxMove - aimThree.getWidth()) { 
					aimThreeToLeft = true; 
				} 
			}
		}
	}

	private void moveAimTwo() {
		if(aimTwoSpeed != 0 && aimTwo != null){
			if (aimTwoToLeft) { 
				aimTwo.move(-aimTwoSpeed, 0); 
				if (aimTwo.getX() <= aimOneMaxMove) { 
					aimTwoToLeft = false;
				} 
			} else { 
				aimTwo.move(aimTwoSpeed, 0); 
				if (aimTwo.getX() >= aimTwoMaxMove - aimTwo.getWidth()) { 
					aimTwoToLeft = true; 
				} 
			}
		}
	}

	private void moveAimOne() {
		if(aimOneSpeed != 0 && aimOne != null){
			if (aimOneToLeft) { 
				aimOne.move(-aimOneSpeed, 0); 
				if (aimOne.getX() <= MAX_AIM_SPEED) { 
					aimOneToLeft = false;
				} 
			} else { 
				aimOne.move(aimOneSpeed, 0); 
				if (aimOne.getX() >= aimOneMaxMove - aimOne.getWidth()) { 
					aimOneToLeft = true; 
				} 
			}
		}
	}

	private void checkForCollisions() {
		if (bullet != null) { 
			GObject collObj =  getElementAt(bullet.getX() + bullet.getWidth()/2, bullet.getY() + bullet.getHeight()); 
			if (collObj == aimOne) {
				deathAimOneX = aimOne.getX();
				deathAimOneY = aimOne.getY(); 
				remove(aimOne); 
				remove(bullet); 
				aimOne = null; 
				bullet = null;
				explosionSound.play();
				explosionOne = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\explosionPlaneGame.png");
				add(explosionOne, deathAimOneX, deathAimOneY);
				explosionOneLifeTime = EXPLOSION_LIFE_TIME;
				
			}
			if (collObj == aimTwo) { 
				deathAimTwoX = aimTwo.getX();
				deathAimTwoY = aimTwo.getY(); 
				remove(aimTwo); 
				remove(bullet); 
				aimTwo = null; 
				bullet = null;
				explosionSound.play();
				explosionTwo = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\explosionPlaneGame.png");
				add(explosionTwo, deathAimTwoX, deathAimTwoY);
				explosionTwoLifeTime = EXPLOSION_LIFE_TIME;
			} 
			if (collObj == aimThree) { 
				deathAimThreeX = aimThree.getX();
				deathAimThreeY = aimThree.getY(); 
				remove(aimThree); 
				remove(bullet); 
				aimThree = null; 
				bullet = null;
				explosionSound.play();
				explosionThree = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\explosionPlaneGame.png");
				add(explosionThree, deathAimThreeX, deathAimThreeY);
				explosionThreeLifeTime = EXPLOSION_LIFE_TIME;
			} 
			if (collObj == aimFour) { 
				deathAimFourX = aimFour.getX();
				deathAimFourY = aimFour.getY(); 
				remove(aimFour); 
				remove(bullet); 
				aimFour = null; 
				bullet = null;
				explosionSound.play();
				explosionFour = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\explosionPlaneGame.png");
				add(explosionFour, deathAimFourX, deathAimFourY);
				explosionFourLifeTime = EXPLOSION_LIFE_TIME;
			} 
			if (collObj == aimFive) { 
				deathAimFiveX = aimFive.getX();
				deathAimFiveY = aimFive.getY(); 
				remove(aimFive); 
				remove(bullet); 
				aimFive = null; 
				bullet = null;
				explosionSound.play();
				explosionFive = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\explosionPlaneGame.png");
				add(explosionFive, deathAimFiveX, deathAimFiveY);
				explosionFiveLifeTime = EXPLOSION_LIFE_TIME;
			}
		} 
		if (aimOne == null && aimTwo == null && aimThree == null && aimFour == null && aimFive == null){
			winnerText = new GLabel("Congratulations, you won!!!");
			winSound.play();
		}
		checkForPlaneCrush();
	}

	private void checkForPlaneCrush() {
		if(plane.getY() >= BASELINE - plane.getHeight()){
			explosionSound.play();
			planeExplosion = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\explosionPlaneGame.png");
			add(planeExplosion, 0, BASELINE - planeExplosion.getHeight());
			removeAims();
			winnerText = new GLabel("You lost, please, try again!!!");
			loseSound.play();
		}
	}

	private void moveBullet() {
		 if (bullet != null) {
	            bullet.move(0, BULLET_SPEED);
	            if (bullet.getY() >= BASELINE - bullet.getHeight()) {
	                remove(bullet);
	                bullet = null;
	            }
	        }
	}

	private void movePlane() {
		if (planeToLeft) { 
			plane.move(-PLANE_SPEED, 0); 
			if (plane.getX() <= plane.getWidth()) { 
				planeToLeft = false;
				plane.move(0, plane.getHeight());
				addPlane(0, plane.getY());

			} 
		} else { 
			plane.move(PLANE_SPEED, 0); 
			if (plane.getX() >= getWidth() - plane.getWidth()) { 
				planeToLeft = true; 
				plane.move(0, plane.getHeight());
				flipPlane(X, plane.getY());
			} 
		}
	}

	private boolean gameOver() { 
		return (aimOne == null && aimTwo == null && aimThree == null && aimFour == null && aimFive == null) || (plane.getY() >= BASELINE - plane.getHeight() ); 
	}
	
	private void addPlane(double x, double y) {
		if(plane != null){
			remove(plane);
		}
		plane = new GPolygon ();
		drawPlane(75, 50);
		plane.setFilled(true);
		plane.setFillColor(Color.decode("#D3D3D3"));
		add(plane, x, y);
	}
	
	private void flipPlane(double x,double y) {
		remove(plane);
		plane = new GPolygon ();
		drawReversePlane(75, 50);
		plane.setFilled(true);
		plane.setFillColor(Color.decode("#D3D3D3"));
		add(plane, x, y);
	}

	private void drawReversePlane(int width, int height) {
		plane.addVertex(0, height/5);
		plane.addVertex(-width/7.5, height*3/5);
		plane.addVertex(-width*2/5, height*3/5);
		plane.addVertex(-width/3, height);
		plane.addVertex(-width*7/15, height);
		plane.addVertex(-width*3/5, height*3/5);
		plane.addVertex(-width*13/15,height*3/5);
		plane.addVertex(-width, height/2);
		plane.addVertex(-width*13/15, height*2/5);
		plane.addVertex(-width*3/5, height*2/5);
		plane.addVertex(-width*2/5, height*2/5);
		plane.addVertex(-width*3/5, height*2/5);
		plane.addVertex(-width*7/15, 0);
		plane.addVertex(-width/3, 0);
		plane.addVertex(-width*2/5, height*2/5);
		plane.addVertex(-width/7.5,height*2/5);
		plane.addVertex(-width/15, height/5);
		plane.addVertex(0, height/5);
	}

	private void drawPlane(int width, int height) {
		plane.addVertex(0, height/5);
		plane.addVertex(width/7.5, height*3/5);
		plane.addVertex(width*2/5, height*3/5);
		plane.addVertex(width/3, height);
		plane.addVertex(width*7/15, height);
		plane.addVertex(width*3/5, height*3/5);
		plane.addVertex(width*13/15,height*3/5);
		plane.addVertex(width, height/2);
		plane.addVertex(width*13/15, height*2/5);
		plane.addVertex(width*3/5, height*2/5);
		plane.addVertex(width*2/5, height*2/5);
		plane.addVertex(width*3/5, height*2/5);
		plane.addVertex(width*7/15, 0);
		plane.addVertex(width/3, 0);
		plane.addVertex(width*2/5, height*2/5);
		plane.addVertex(width/7.5,height*2/5);
		plane.addVertex(width/15, height/5);
		plane.addVertex(0, height/5);
	}

	private void addAims(int x, int y, int baseline) {
		distributeIcons();
		aimOne = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\aimPlaneGame" + iconOne +".png");
		add(aimOne, rgen.nextDouble(0, x/5 -aimOne.getWidth()), baseline - aimOne.getHeight());
		aimOneSpeed = rgen.nextInt(0, MAX_AIM_SPEED);
		aimOneToLeft =rgen.nextBoolean();
		aimTwo = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\aimPlaneGame" + iconTwo +".png");
		add(aimTwo, rgen.nextDouble(aimOne.getX() + aimOne.getWidth(), x*2/5 -aimTwo.getWidth()), baseline - aimTwo.getHeight());
		aimTwoSpeed = rgen.nextInt(0, MAX_AIM_SPEED);
		aimTwoToLeft =rgen.nextBoolean();
		aimThree = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\aimPlaneGame" + iconThree +".png");
		add(aimThree, rgen.nextDouble(aimTwo.getX() + aimTwo.getWidth(), x*3/5 -aimThree.getWidth()), baseline - aimThree.getHeight());
		aimThreeSpeed = rgen.nextInt(0, MAX_AIM_SPEED);
		aimThreeToLeft =rgen.nextBoolean();
		aimFour = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\aimPlaneGame" + iconFour +".png");
		add(aimFour,rgen.nextDouble(aimThree.getX() + aimThree.getWidth(), x*4/5 -aimFour.getWidth()), baseline - aimFour.getHeight());
		aimFourSpeed = rgen.nextInt(0, MAX_AIM_SPEED);
		aimFourToLeft =rgen.nextBoolean();
		aimFive = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\aimPlaneGame" + iconFive +".png");
		add(aimFive, rgen.nextDouble(aimFour.getX() + aimFour.getWidth(), x -aimFive.getWidth()), baseline - aimFive.getHeight());
		aimFiveSpeed = rgen.nextInt(0, MAX_AIM_SPEED);
		aimFiveToLeft =rgen.nextBoolean();
		aimOneMaxMove = aimTwo.getX();
		aimTwoMaxMove = aimThree.getX();
		aimThreeMaxMove = aimFour.getX();
		aimFourMaxMove = aimFive.getX();
		aimFiveMaxMove = x;
	}
	public void distributeIcons() {
        iconOne = rgen.nextInt(1,5);
        do {
        	iconTwo = rgen.nextInt(1,5);
        } while (iconTwo == iconOne);
        
        do {
        	iconThree = rgen.nextInt(1,5);
        } while (iconThree == iconOne || iconThree == iconTwo);
        
        do {
        	iconFour = rgen.nextInt(1,5);
        } while (iconFour == iconOne || iconFour == iconTwo || iconFour == iconThree);
        
        iconFive = 15 - (iconOne + iconTwo + iconThree + iconFour);
	}
	private void addStartText(int x, int y) {
		startText = new GLabel("CLICK ON THE SCREEN TO START");
		startText.setFont("Anton-" + x/25);
		startText.setColor(Color.decode("#D3D3D3"));
		add(startText, x/2 - startText.getWidth()/2, y/2 - startText.getHeight()/2);
	}
	
	private void addTitle(int x, int y) {
		title = new GLabel("PlaneGame");
		title.setFont("Anton-" + x/25);
		title.setColor(Color.decode("#D3D3D3"));
		add(title, x/2 - title.getWidth()/2, y/10 - title.getHeight()/2);
	}
	
	private void setBackground(int x, int y) {
		background = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\backgroundPlaneGame.jfif");
		background.scale(1.4);
		add(background, 0, 0);
		ground = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\PlaneGame\\pictures\\groundPlaneGame.png");
		ground.scale(3,1);
		add(ground, 0, background.getHeight()-200);
	}
	private SoundClip explosionSound, winSound, loseSound;
	private GPoint last;
	private GObject gobj;
	private double aimOneMaxMove, aimTwoMaxMove, aimThreeMaxMove, aimFourMaxMove, aimFiveMaxMove, deathAimOneX, deathAimOneY,  deathAimTwoX, deathAimTwoY, deathAimThreeX, deathAimThreeY, deathAimFourX, deathAimFourY, deathAimFiveX, deathAimFiveY;
	private int aimOneSpeed, aimTwoSpeed, aimThreeSpeed, aimFourSpeed, aimFiveSpeed, explosionOneLifeTime, explosionTwoLifeTime, explosionThreeLifeTime, explosionFourLifeTime, explosionFiveLifeTime, iconOne, iconTwo, iconThree, iconFour, iconFive;
	private boolean start, gameActive, planeToLeft, aimOneToLeft, aimTwoToLeft, aimThreeToLeft, aimFourToLeft, aimFiveToLeft;
	private GLabel startText, title, transitionalText, winnerText, endText;
	private GImage background, ground, bullet, aimOne, aimTwo, aimThree, aimFour, aimFive, explosionOne, explosionTwo, explosionThree, explosionFour, explosionFive, planeExplosion;
	private GPolygon plane;
	private GButton continueButton, endButton;
	RandomGenerator rgen = RandomGenerator.getInstance();
}
