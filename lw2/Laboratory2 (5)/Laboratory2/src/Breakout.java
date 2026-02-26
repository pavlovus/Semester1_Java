/*
 * File: Breakout.java

 * -------------------
 * Creators: Shapoval Rodion and Vus Pavlo
 * 
 * This file will eventually implement the game of Breakout.
 */

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.util.SoundClip;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int RACKET_WIDTH = 60;
	private static final int RACKET_HEIGHT = 10;
	
	private static final int RACKET_SPEED = 30;

/** Offset of the paddle up from the bottom */
	private static final int RACKET_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final double BRICK_SEP = 5;

/** Width of a brick */
	private static final double BRICK_WIDTH =
	(double)(WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 10;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
	
/* Method: run() */	
/** Runs the Breakout program. */
	public void run() {
		setup(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		addMouseListeners();
		addKeyListeners();
		while(!end){
			while (!gameOver()) {
				restart = false;
	            moveBall();
	            checkForCollisions();
	        }
			if(!restart){
				removeForRestartScreen();
				createRestartScreen(APPLICATION_WIDTH ,APPLICATION_HEIGHT);
				restart = true;
			}
		}
	}

/** Method that is listening to mouse clicks and changes the state of program if clicked on a certain object*/
	public void mouseClicked(MouseEvent e){ 
		if(!start){
			remove(prod);
			remove(startText);
			remove(title);
			background.loop();
			addBall();
			addBricks();
			addRacket();
			addScoreText();
			addNumberOfLives();
			start = true;
		} else {
			last = new GPoint(e.getPoint()); 
			gobj = getElementAt(last);
			if(gobj == continueButton){
				removeRestartScreen();
				background.rewind();
				background.loop();
				addBall();
				addBricks();
				addRacket();
				score = 0;
				addScoreText();
				numberOfLives = NTURNS;
				addNumberOfLives();
			} else if (gobj == endButton){
				removeRestartScreen();
				addEndText();
				end = true;
			}
		}
	}
	
/** Method that checks if player lost*/
	private boolean gameOver() {
		return score == NBRICKS_PER_ROW*NBRICK_ROWS  || (numberOfLives <= 0); 
	}
	
/** Handles key press events to move the paddle left or right*/
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	    if (!gameOver()) {
	        if (key == KeyEvent.VK_LEFT) {
	            movePaddle(-RACKET_SPEED);
	        } else if (key == KeyEvent.VK_RIGHT) {
	            movePaddle(RACKET_SPEED);
	        }
	    }
	}

/** Moves the paddle left or right with a certain speed.*/
	private void movePaddle(int dx) {
	    double newX = racket.getX() + dx;
	    if (newX >= 0 && newX + RACKET_WIDTH <= APPLICATION_WIDTH) {
	        racket.move(dx, 0);
	    } else if (newX >= 0) {
	        remove(racket);
	        add(racket, APPLICATION_WIDTH - RACKET_WIDTH, APPLICATION_HEIGHT - RACKET_Y_OFFSET - RACKET_HEIGHT);
	    } else {
	        add(racket, 0, APPLICATION_HEIGHT - RACKET_Y_OFFSET - RACKET_HEIGHT);
	    }
	}

/** Adds a ball to the game at the centre of the application window.*/
	private void addBall() {
	    ball = new GOval(APPLICATION_WIDTH / 2 - BALL_RADIUS, APPLICATION_HEIGHT / 2 - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
	    ball.setFilled(true);
	    ball.setColor(Color.decode("#FFC0CB"));
	    add(ball);
	}

/** Adds bricks to the game in rows and columns with given colors.*/
	private void addBricks() {
	    for (int i = 0; i < NBRICK_ROWS; i++) {
	        for (int j = 0; j < NBRICKS_PER_ROW; j++) {
	            Brick brick;
	            if (i == 0 || i == 1)
	                brick = new Brick(BRICK_WIDTH, BRICK_HEIGHT, Color.decode("#FFC300"));
	            else if (i == 2 || i == 3)
	                brick = new Brick(BRICK_WIDTH, BRICK_HEIGHT, Color.decode("#E2725B"));
	            else if (i == 4 || i == 5)
	                brick = new Brick(BRICK_WIDTH, BRICK_HEIGHT, Color.decode("#30D5C8"));
	            else if (i == 6 || i == 7)
	                brick = new Brick(BRICK_WIDTH, BRICK_HEIGHT, Color.decode("#C5A3FF"));
	            else
	                brick = new Brick(BRICK_WIDTH, BRICK_HEIGHT, Color.decode("#0A8754"));
	            add(brick, j * (BRICK_WIDTH + BRICK_SEP), BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP));
	        }
	    }
	}

/** Removes all bricks from window*/
	private void removeAllBricks() {
	    for (int y = BRICK_Y_OFFSET; y < BRICK_Y_OFFSET + NBRICK_ROWS * (BRICK_HEIGHT + BRICK_SEP); y += (BRICK_HEIGHT + BRICK_SEP)) {
	        for (int x = 0; x < WIDTH; x += (BRICK_WIDTH + BRICK_SEP)) {
	            GObject obj = getElementAt(x + BRICK_WIDTH / 2, y + BRICK_HEIGHT / 2);
	            if (obj instanceof Brick) {
	                remove(obj);
	            }
	        }
	    }
	}

/** Adds the paddle to the game at its initial position.*/
	private void addRacket() {
	    racket = new GRect(APPLICATION_WIDTH / 2 - RACKET_WIDTH / 2, APPLICATION_HEIGHT - RACKET_Y_OFFSET - RACKET_HEIGHT, RACKET_WIDTH, RACKET_HEIGHT);
	    racket.setFilled(true);
	    racket.setColor(Color.decode("#800080"));
	    add(racket);
	}

/** Checks if the ball is stuck in the paddle and adjusts its position and velocity if necessary*/
	private void checkForBallStuckInRacket() {
	    if (ball != null && racket != null) {
	        double ballLeftX = ball.getX();
	        double ballRightX = ball.getX() + ball.getWidth();
	        double ballTopY = ball.getY();
	        double ballBottomY = ball.getY() + ball.getHeight();

	        double racketLeftX = racket.getX();
	        double racketRightX = racket.getX() + racket.getWidth();
	        double racketTopY = racket.getY();
	        double racketBottomY = racket.getY() + racket.getHeight();

	        boolean isBallStuckInRacket =
	                ballRightX > racketLeftX && ballLeftX < racketRightX &&
	                ballBottomY > racketTopY && ballTopY < racketBottomY;

	        if (isBallStuckInRacket) {
	            ball.setLocation(ball.getX(), racketTopY - ball.getHeight());
	            yVel *= -1;
	        }
	    }
	}


	
/**	Checks if ball collides with sth and bounces off*/
	private void checkForCollisions() {
	    checkForBallStuckInRacket();

	    if (ball != null) {
	        GPoint ball_point1 = new GPoint(ball.getX() + BALL_RADIUS * (Math.sqrt(2) - 1), ball.getY() + BALL_RADIUS * (Math.sqrt(2) - 1));
	        GPoint ball_point2 = new GPoint(ball.getX() + ball.getWidth() / 2, ball.getY());
	        GPoint ball_point3 = new GPoint(ball.getX() + ball.getWidth() - BALL_RADIUS * (Math.sqrt(2) - 1), ball.getY() + BALL_RADIUS * (Math.sqrt(2) - 1));
	        GPoint ball_point4 = new GPoint(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight() / 2);
	        GPoint ball_point5 = new GPoint(ball.getX() + ball.getWidth() - BALL_RADIUS * (Math.sqrt(2) - 1), ball.getY() + ball.getHeight() - BALL_RADIUS * (Math.sqrt(2) - 1));
	        GPoint ball_point6 = new GPoint(ball.getX() + ball.getWidth() / 2, ball.getY() + ball.getHeight());
	        GPoint ball_point7 = new GPoint(ball.getX() + BALL_RADIUS * (Math.sqrt(2) - 1), ball.getY() + ball.getHeight() - BALL_RADIUS * (Math.sqrt(2) - 1));
	        GPoint ball_point8 = new GPoint(ball.getX(), ball.getY() + ball.getHeight() / 2);
	        
	        if (getElementAt(ball_point2) == racket)
	        	yVel*=-1;
	        if (getElementAt(ball_point1) == racket || getElementAt(ball_point3) == racket) {
	        	yVel *= -1;
	            xVel *= -1;
	        }
	        	
	        	
	        // Перевірка горизонтальних колізій
	        if (getElementAt(ball_point2) instanceof Brick) {
	            handleCollisionsWithBrick((Brick) getElementAt(ball_point2));
	            yVel *= -1;
	        } else if (getElementAt(ball_point6) instanceof Brick) {
	        	handleCollisionsWithBrick((Brick) getElementAt(ball_point6));
	            yVel *= -1;
	        } else if (getElementAt(ball_point8) instanceof Brick) {
	            handleCollisionsWithBrick((Brick) getElementAt(ball_point8));
	            xVel *= -1;
	        } else if ( getElementAt(ball_point4) instanceof Brick) {
	        	handleCollisionsWithBrick((Brick) getElementAt(ball_point4));
	        	xVel *= -1;
	        } else if(getElementAt(ball_point1) instanceof Brick) {
	            handleCollisionsWithBrick((Brick) getElementAt(ball_point1));
	            yVel *= -1;
	            xVel *= -1;
	        } else if (getElementAt(ball_point3) instanceof Brick) {
	            handleCollisionsWithBrick((Brick) getElementAt(ball_point3));
	            yVel *= -1;
	            xVel *= -1;
	        } else if (getElementAt(ball_point5) instanceof Brick) {
	            handleCollisionsWithBrick((Brick) getElementAt(ball_point5));
	            yVel *= -1;
	            xVel *= -1;
	        } else if (getElementAt(ball_point7) instanceof Brick) {
	            handleCollisionsWithBrick((Brick) getElementAt(ball_point7));
	            yVel *= -1;
	            xVel *= -1;
	        }
	    }
	}


/**	Handles collision with a brick, plays sound, removes the brick, updates the score*/
	private void handleCollisionsWithBrick(Brick brick) {
		SoundClip point = new SoundClip("point.wav");
		point.setVolume(0.35);
		point.play();
	    removeBrick(brick);
	    score++;
	    scoreText.setLabel("SCORE: " + score);
	}
	
/**	Moves the ball and checks for collisions with the edges of the game area*/
	private void moveBall() {
		if (ball != null) {
			ball.move(xVel, yVel);
			pause(5);
			if (ball.getX() + ball.getWidth() >= WIDTH || ball.getX() <= 0)
				xVel*=-1;
			if (ball.getY() <= 0)
				yVel*=-1;
			if(ball.getY() >= HEIGHT - ball.getWidth()){
				fall.play();
				numberOfLives--;
				remove(ball);
				removeNumberOfLives();
				addNumberOfLives();
				pause(2000);
				xVel = rgen.nextDouble(0.5, 2);
				if (rgen.nextBoolean()) xVel*=-1;
				if(!gameOver()){
					addBall();
					ball.sendToBack();
					ball.sendForward();
				}
			}
		}
	}
	
/** Adds a message to the screen thanking the player for playing the game.	*/
	private void addEndText() {
		endText = new GLabel("THANK YOU FOR PLAYING!!! (;");
		endText.setFont("Anton-" + APPLICATION_WIDTH/15);
		endText.setColor(Color.decode("#7FFFD4"));
		add(endText, APPLICATION_WIDTH/2 - endText.getWidth()/2, APPLICATION_HEIGHT/2 - endText.getHeight()/2);
	}
	
/**	Removes the restart screen elements from the game screen.*/
	private void removeRestartScreen() {
		remove(transitionalText);
		transitionalText = null;
		remove(continueButton);
		continueButton = null;
		remove(endButton);
		endButton = null;
		remove(winnerText);
		endButton = null;
		remove(endScoreText);
		endScoreText = null;
	}
	
/**	Removes elements from the screen for a restart.*/
	private void removeForRestartScreen() {
		remove(scoreText);
		remove(racket);
		remove(ball);
		removeAllBricks();
		if(heartOfLife3 != null){ 
			remove(heartOfLife3);
			heartOfLife3 = null;
		}
		if(heartOfLife2 != null){ 
			remove(heartOfLife2);
			heartOfLife2 = null;
		}
		if(heartOfLife1 != null){ 
			remove(heartOfLife1);
			heartOfLife1 = null;
		}
	}
	
/**	Creates a restart screen with options to continue or end this game*/
	private void createRestartScreen(int x, int y) {
		background.stop();
		if(score == NBRICKS_PER_ROW*NBRICK_ROWS){
			victory.play();
			winnerText = new GLabel("Congratulations, you won!!!");
		} else {
			lose.play();
			winnerText = new GLabel("You lost, please, try again!!!");
		}
		winnerText.setFont("Anton-" + x/15);
		winnerText.setColor(Color.decode("#20B2AA"));
		add(winnerText, x/2 - winnerText.getWidth()/2, y/5 - winnerText.getHeight()/2);
		
		endScoreText = new GLabel("YOUR SCORE: " + score);
		endScoreText.setFont("Anton-" + APPLICATION_WIDTH/18);
		endScoreText.setColor(Color.decode("#7FFFD4"));
		add(endScoreText, x/2 - endScoreText.getWidth()/2, y/3 - scoreText.getHeight()/2);
		
		transitionalText = new GLabel("CONTINUE?");
		transitionalText.setFont("Anton-" + x/15);
		transitionalText.setColor(Color.decode("#20B2AA"));
		add(transitionalText, x/2 - transitionalText.getWidth()/2, y/2 - transitionalText.getHeight()/2);
		
		continueButton = new GButton("YES", x/5 , y/10);
		add(continueButton, x/2 - x/5 - x/10, y/2 + y/20);
		
		endButton = new GButton("NO", x/5 , y/10);
		add(endButton, x/2 + x/10, y/2 + y/20);
	}
	
/** Sets up the game environment*/
	private void setup(int x, int y) {
	    background.setVolume(0.4);
	    fall.setVolume(0.3);
	    lose.setVolume(0.4);
	    victory.setVolume(0.35);
	    this.setSize(x, y);
	    addBackground(x, y);
	    addStartText(x, y);
	    prod = addAuthors();
	    add(prod, (WIDTH - prod.getWidth())/2 , HEIGHT - prod.getHeight() );
	    xVel = rgen.nextDouble(1, 2);
	    if (rgen.nextBoolean()) xVel *= -1;
	    start = false;
	    end = false;
	}

/** Removes a life from the game display when the player loses*/
	private void removeNumberOfLives() {
	    if (numberOfLives == 2 && heartOfLife3 != null) {
	        remove(heartOfLife3);
	        heartOfLife3 = null;
	    }
	    if (numberOfLives == 1 && heartOfLife2 != null) {
	        remove(heartOfLife2);
	        heartOfLife2 = null;
	    }
	    if (numberOfLives == 0 && heartOfLife1 != null) {
	        remove(heartOfLife1);
	        heartOfLife1 = null;
	    }
	}

/** Adds the number of lives to the window.*/
	private void addNumberOfLives() {
	    if (numberOfLives >= 3 && heartOfLife3 == null) {
	        heartOfLife3 = new GImage("heart.png");
	        add(heartOfLife3, APPLICATION_WIDTH - 3 * heartOfLife3.getWidth(), APPLICATION_HEIGHT / 15 - heartOfLife3.getHeight() / 2);
	    }
	    if (numberOfLives >= 2 && heartOfLife2 == null) {
	        heartOfLife2 = new GImage("heart.png");
	        add(heartOfLife2, APPLICATION_WIDTH - 2 * heartOfLife2.getWidth(), APPLICATION_HEIGHT / 15 - heartOfLife2.getHeight() / 2);
	    }
	    if (numberOfLives >= 1 && heartOfLife1 == null) {
	        heartOfLife1 = new GImage("heart.png");
	        add(heartOfLife1, APPLICATION_WIDTH - 1 * heartOfLife1.getWidth(), APPLICATION_HEIGHT / 15 - heartOfLife1.getHeight() / 2);
	    }
	}

/** Adds the start text and title to the game window*/
	private void addStartText(int x, int y) {
	    startText = new GLabel("CLICK FOR START");
	    startText.setFont("Anton-" + x / 18);
	    startText.setColor(Color.decode("#9B30FF"));
	    add(startText, x / 2 - startText.getWidth() / 2, y / 2 - startText.getHeight() / 2);

	    title = new GLabel("BREAKOUT");
	    title.setFont("Anton-" + x / 18);
	    title.setColor(Color.decode("#9B30FF"));
	    add(title, x / 2 - title.getWidth() / 2, y / 8 - title.getHeight() / 2);
	}

/** Adds the background to the game window*/
	private void addBackground(int x, int y) {
	    GRect background = new GRect(0, 0, x, y);
	    background.setFilled(true);
	    background.setFillColor(Color.black);
	    add(background);
	}

/** Adds the score text to the game window*/
	private void addScoreText() {
	    scoreText = new GLabel("SCORE: " + score);
	    scoreText.setFont("Anton-" + APPLICATION_WIDTH / 18);
	    scoreText.setColor(Color.decode("#7FFFD4"));
	    add(scoreText, APPLICATION_WIDTH / 30, APPLICATION_HEIGHT / 10 - scoreText.getHeight() / 2);
	}

/** Removes a brick from the game and decrements the brick count*/
	private void removeBrick(Brick brick) {
	    remove(brick);
	    brick = null;
	    Brick.decrementBrickCount();
	}
	
/** Adds label of the authors of the game */
	private GLabel addAuthors() {
		GLabel production = new GLabel("PROD by P.Vus & R.Shapoval ");
		production.setColor(Color.decode("#9B30FF"));
		production.setFont("Anton-"+ WIDTH/20);
		return production;
	}

	private GPoint last;
	private GObject gobj;
	private GButton continueButton, endButton;
	private GImage heartOfLife1,heartOfLife2, heartOfLife3;
	private GOval ball;
	private GRect racket;
	private GLabel startText, title, scoreText, winnerText, transitionalText, endScoreText, endText;
	private boolean start, restart, end;
	private GLabel prod;
	private double xVel = 1;
	private double yVel = 1;
	private int score = 0;
	private int numberOfLives = NTURNS;
	
	private SoundClip lose = new SoundClip("lose.wav");
	private SoundClip fall = new SoundClip("ball_fall.wav");
	private SoundClip background = new SoundClip("background.wav");
	private SoundClip victory = new SoundClip("victory.wav");
	RandomGenerator rgen = RandomGenerator.getInstance();
}
