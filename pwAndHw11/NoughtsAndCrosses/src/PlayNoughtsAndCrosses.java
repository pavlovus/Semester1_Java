// Практична №11, гра в хрестики-нулики, Вус Павло, група №1, ІПЗ-1
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;


public class PlayNoughtsAndCrosses extends GraphicsProgram{
	public static final int X = 1000;
	public static final int Y = 650;
	//Initialization
	public void init(){
		setup(X, Y);
		addMouseListeners();
	}
	//Setup of the starting scenery
	/**
	 * Receiving size of the world and doing setup for start
	 */
	private void setup(int x, int y) {
		this.setSize(x, y);
		addBackground(x, y);
		addStartText(x, y);
		start = false;
	}
	//Adding of starting text
	private void addStartText(int x, int y) {
		startText = new GLabel("Клікніть на екран, щоб розпочати");
		startText.setFont("Anton-" + x/28);
		startText.setColor(Color.white);
		add(startText, x/2 - startText.getWidth()/2, y/2 - startText.getHeight()/2);
		
		title = new GLabel("ХРЕСТИКИ-НУЛИКИ");
		title.setFont("Anton-" + x/28);
		title.setColor(Color.white);
		add(title, x/2 - title.getWidth()/2, y/10 - title.getHeight()/2);
	}
	//Adding of black background
	private void addBackground(int x, int y) {
		GRect background = new GRect(0, 0, x, y);
		background.setFilled(true);
		background.setFillColor(Color.black);
		add(background);
	}
	//Listeners for start click, click on continue button, end button, choose of the side buttons and playinng game
	public void mouseClicked(MouseEvent e){ 
		if (!active) {
			if(!start){
				//first click for start
				remove(startText);
				choiceOfTheSide(X, Y);
				start = true;
				active = true;
			} else {
				//Choose to continue or not for next times
				last = new GPoint(e.getPoint()); 
				gobj = getElementAt(last);
				if(gobj == continueButton){
					removeForRestart();
					choiceOfTheSide(X, Y);
					active = true;
				} else if (gobj == endButton){
					removeForRestart();
					addEndText(X, Y);
				}
			}
		} else {
			last = new GPoint(e.getPoint()); 
			gobj = getElementAt(last);
			//Choice of the side buttons
			if(gobj == buttonCrosses){
				choiceOfTheSide = true;
				remove(choiceText);
				remove(buttonCrosses);
				remove(buttonNoughts);
				startGame(choiceOfTheSide);
			}else if(gobj == buttonNoughts){
				choiceOfTheSide = false;
				remove(choiceText);
				remove(buttonCrosses);
				remove(buttonNoughts);
				startGame(choiceOfTheSide);
			}
			//Click on cell to put cross or nought
			if(gobj instanceof GCell && active){
				GCell currentCell = (GCell) gobj;
				//For crosses
				if (choiceOfTheSide && currentCell.isFree()){
					currentCell.addCross();
					//Check for win after your move
					if(checkForWin()){
						endGame(X,Y);
					} else {
						//Random move of opponent
						generateMove();
						//Check for win of the opponent
						if(checkForWin()){
							endGame(X,Y);
						} 
					}
					//For noughts
				} else if(!choiceOfTheSide && currentCell.isFree()){
					currentCell.addNought();
					//Check for win after your move
					if(checkForWin()){
						endGame(X,Y);
					} else {
						//Random move of opponent
						generateMove();
						//Check for win of the opponent
						if(checkForWin()){
							endGame(X,Y);
						}
					}
				}
			}
		}
	}
	//Adding ending text
	private void addEndText(int x, int y) {
		endText = new GLabel("ДЯКУЮ ЗА ГРУ!!! (;");
		endText.setFont("Anton-" + x/28);
		endText.setColor(Color.white);
		add(endText, x/2 - endText.getWidth()/2, y/2 - endText.getHeight()/2);
	}
	//Remove scenery for restart
	/**
	 * Method that removes everything for restart of the game
	 */
	private void removeForRestart() {
		remove(winnerText);
		remove(transitionalText);
		remove(continueButton);
		remove(endButton);
		remove(winLine);
		remove(cellOne);
		remove(cellTwo);
		remove(cellThree);
		remove(cellFour);
		remove(cellFive);
		remove(cellSix);
		remove(cellSeven);
		remove(cellEight);
		remove(cellNine);
	}
	//Ending screen in case of win
	/**
	 * Method that ends game in case of win of one side
	 * @param x
	 * @param y
	 */
	private void endGame(int x, int y) {
		active = false;
		winnerText = new GLabel(currentWinner);
		winnerText.setFont("Anton-" + x/28);
		winnerText.setColor(Color.white);
		add(winnerText, x/2 - winnerText.getWidth()/2, y/5 - winnerText.getHeight()/2);
		
		transitionalText = new GLabel("Бажаєте продовжити гру?");
		transitionalText.setFont("Anton-" + x/28);
		transitionalText.setColor(Color.white);
		add(transitionalText, x/2 - transitionalText.getWidth()/2, y*3/4 - transitionalText.getHeight()/2);
		
		continueButton = new GButton("Так", x/10 , y/13);
		add(continueButton, x/2 - x/10 - x/20, y*4/5);
		
		endButton = new GButton("Ні", x/10 , y/13);
		add(endButton, x/2 + x/20, y*4/5);
	}
	//Checking all win scenarios
	/**
	 * Method that check for win of both sides
	 * @return true - if someone won, false - if not
	 */
	private boolean checkForWin() {
		if(cellOne.isCross() && cellFour.isCross() && cellSeven.isCross()){
			buildWinLine(cellOne, cellSeven);
			currentWinner = "Хрестики перемогли!!!";
			return true;
		} else if(cellTwo.isCross() && cellFive.isCross() && cellEight.isCross()){
			buildWinLine(cellTwo, cellEight);
			currentWinner = "Хрестики перемогли!!!";
			return true;
		} else if(cellThree.isCross() && cellSix.isCross() && cellNine.isCross()){
			buildWinLine(cellThree, cellNine);
			currentWinner = "Хрестики перемогли!!!";
			return true;
		} else if(cellOne.isCross() && cellTwo.isCross() && cellThree.isCross()){
			buildWinLine(cellOne, cellThree);
			currentWinner = "Хрестики перемогли!!!";
			return true;
		} else if(cellFour.isCross() && cellFive.isCross() && cellSix.isCross()){
			buildWinLine(cellFour, cellSix);
			currentWinner = "Хрестики перемогли!!!";
			return true;
		} else if(cellSeven.isCross() && cellEight.isCross() && cellNine.isCross()){
			buildWinLine(cellSeven, cellNine);
			currentWinner = "Хрестики перемогли!!!";
			return true;
		} else if(cellOne.isCross() && cellFive.isCross() && cellNine.isCross()){
			buildWinLine(cellOne, cellNine);
			currentWinner = "Хрестики перемогли!!!";
			return true;
		} else if(cellThree.isCross() && cellFive.isCross() && cellSeven.isCross()){
			buildWinLine(cellThree, cellSeven);
			currentWinner = "Хрестики перемогли!!!";
			return true;
		} else if(cellOne.isNought() && cellFour.isNought() && cellSeven.isNought()){
			buildWinLine(cellOne, cellSeven);
			currentWinner = "Нулики перемогли!!!";
			return true;
		} else if(cellTwo.isNought() && cellFive.isNought() && cellEight.isNought()){
			buildWinLine(cellTwo, cellEight);
			currentWinner = "Нулики перемогли!!!";
			return true;
		} else if(cellThree.isNought() && cellSix.isNought() && cellNine.isNought()){
			buildWinLine(cellThree, cellNine);
			currentWinner = "Нулики перемогли!!!";
			return true;
		} else if(cellOne.isNought() && cellTwo.isNought() && cellThree.isNought()){
			buildWinLine(cellOne, cellThree);
			currentWinner = "Нулики перемогли!!!";
			return true;
		} else if(cellFour.isNought() && cellFive.isNought() && cellSix.isNought()){
			buildWinLine(cellFour, cellSix);
			currentWinner = "Нулики перемогли!!!";
			return true;
		} else if(cellSeven.isNought() && cellEight.isNought() && cellNine.isNought()){
			buildWinLine(cellSeven, cellNine);
			currentWinner = "Нулики перемогли!!!";
			return true;
		} else if(cellOne.isNought() && cellFive.isNought() && cellNine.isNought()){
			buildWinLine(cellOne, cellNine);
			currentWinner = "Нулики перемогли!!!";
			return true;
		} else if(cellThree.isNought() && cellFive.isNought() && cellSeven.isNought()){
			buildWinLine(cellThree, cellSeven);
			currentWinner = "Нулики перемогли!!!";
			return true;
		} else if (!(cellOne.isFree()||cellTwo.isFree()||cellThree.isFree()||cellFour.isFree()||cellFive.isFree()||cellSix.isFree()||cellSeven.isFree()||cellEight.isFree()||cellNine.isFree())){
			currentWinner = "Нічия!!!";
			return true;
		}
		return false;
	}
	/**
	 * Building win line
	 * @param startCell first cell of row
	 * @param endCell last cell of row
	 */
	private void buildWinLine(GCell startCell, GCell endCell) {
		winLine = new GLine(startCell.getMiddleX(), startCell.getMiddleY(), endCell.getMiddleX(), endCell.getMiddleY());
		winLine.setColor(Color.red);
		add(winLine);
	}
	/**
	 * Buildinf field for game and generating first move if needed
	 * @param choiceOfTheSide What side are you playing for
	 */
	private void startGame(boolean choiceOfTheSide) {
		createFieldForGame(X,Y);
		if(!choiceOfTheSide){
			generateMove();
		}
	}
	/**
	 * Method that generates random move of the opponent
	 */
	private void generateMove() {
		while(cellOne.isFree()||cellTwo.isFree()||cellThree.isFree()||cellFour.isFree()||cellFive.isFree()||cellSix.isFree()||cellSeven.isFree()||cellEight.isFree()||cellNine.isFree()){
			int numberOfRandomCell = rgen.nextInt(1, 9);
			if(choiceOfTheSide){
				if (tryAddNought(numberOfRandomCell)) {
	                return;
	            }
			} else {
				 if (tryAddCross(numberOfRandomCell)) {
		                return;
		         }
			}
		}
	}
	/**
	 * Method that tries to add cross to the cell if it is free
	 * @param numberOfRandomCell number of chosen randomly cell
	 * @return if it free or not
	 */
	private boolean tryAddCross(int numberOfRandomCell) {
		switch(numberOfRandomCell){
		case 1:
			if(cellOne.isFree()){
				cellOne.addCross();
				return true;
			}
		case 2:
			if(cellTwo.isFree()){
				cellTwo.addCross();
				return true;
			}
		case 3:
			if(cellThree.isFree()){
				cellThree.addCross();
				return true;
			}
		case 4:
			if(cellFour.isFree()){
				cellFour.addCross();
				return true;
			}
		case 5:
			if(cellFive.isFree()){
				cellFive.addCross();
				return true;
			}
		case 6:
			if(cellSix.isFree()){
				cellSix.addCross();
				return true;
			}
		case 7:
			if(cellSeven.isFree()){
				cellSeven.addCross();
				return true;
			}
		case 8:
			if(cellEight.isFree()){
				cellEight.addCross();
				return true;
			}
		case 9:
			if(cellNine.isFree()){
				cellNine.addCross();
				return true;
			}
		}
		return false;
	}
	/**
	 * Method that tries to add nought to the cell if it is free
	 * @param numberOfRandomCell number of chosen randomly cell
	 * @return if it free or not
	 */
	private boolean tryAddNought(int numberOfRandomCell) {
		switch(numberOfRandomCell){
		case 1:
			if(cellOne.isFree()){
				cellOne.addNought();
				return true;
			}
		case 2:
			if(cellTwo.isFree()){
				cellTwo.addNought();
				return true;
			}
		case 3:
			if(cellThree.isFree()){
				cellThree.addNought();
				return true;
			}
		case 4:
			if(cellFour.isFree()){
				cellFour.addNought();
				return true;
			}
		case 5:
			if(cellFive.isFree()){
				cellFive.addNought();
				return true;
			}
		case 6:
			if(cellSix.isFree()){
				cellSix.addNought();
				return true;
			}
		case 7:
			if(cellSeven.isFree()){
				cellSeven.addNought();
				return true;
			}
		case 8:
			if(cellEight.isFree()){
				cellEight.addNought();
				return true;
			}
		case 9:
			if(cellNine.isFree()){
				cellNine.addNought();
				return true;
			}
		}
		return false;
	}
	/**
	 * Method that creates nine cells with use of window size
	 * @param x
	 * @param y
	 */
	private void createFieldForGame(int x, int y) {
		cellOne = new GCell(x/2 - x/30 - x/15, y/2 - x/30 - x/15, x/15, x/15);
		add(cellOne);
		cellTwo = new GCell(x/2 - x/30, y/2 - x/30 - x/15, x/15, x/15);
		add(cellTwo);
		cellThree = new GCell(x/2 + x/30, y/2 - x/30 - x/15, x/15, x/15);
		add(cellThree);
		cellFour = new GCell(x/2 - x/30 - x/15, y/2 - x/30, x/15, x/15);
		add(cellFour);
		cellFive = new GCell(x/2 - x/30, y/2 - x/30, x/15, x/15);
		add(cellFive);
		cellSix = new GCell(x/2 + x/30, y/2 - x/30, x/15, x/15);
		add(cellSix);
		cellSeven = new GCell(x/2 - x/30 - x/15, y/2 + x/30, x/15, x/15);
		add(cellSeven);
		cellEight = new GCell(x/2 - x/30, y/2 + x/30, x/15, x/15);
		add(cellEight);
		cellNine = new GCell(x/2 + x/30, y/2 + x/30, x/15, x/15);
		add(cellNine);
	}
	/**
	 * Creating choice of the side screen with size of the window
	 * @param x
	 * @param y
	 */
	private void choiceOfTheSide(int x, int y) {
		choiceText = new GLabel("Оберіть, за кого хочете грати");
		choiceText.setFont("Anton-" + x/28);
		choiceText.setColor(Color.white);
		add(choiceText, x/2 - choiceText.getWidth()/2, y/2 - choiceText.getHeight()/2);
		
		buttonCrosses = new GButton("Хрестики", x/10 , y/13);
		add(buttonCrosses, x/2 - x/10 - x/20, y/2 + y/26);
		
		buttonNoughts = new GButton("Нулики", x/10 , y/13);
		add(buttonNoughts, x/2 + x/20, y/2 + y/26);
	}
	//Private instance variables
	private GLine winLine;
	private String currentWinner;
	private GCell cellOne, cellTwo, cellThree, cellFour, cellFive, cellSix, cellSeven, cellEight, cellNine;
	private GObject gobj; 
	private GPoint last; 
	private GButton buttonCrosses, buttonNoughts, continueButton, endButton;
	private GLabel choiceText, winnerText, startText, transitionalText, title, endText;
	private boolean start, active, choiceOfTheSide;
	RandomGenerator rgen = RandomGenerator.getInstance();
}
