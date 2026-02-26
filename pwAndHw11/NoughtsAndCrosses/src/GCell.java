import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GRect;


public class GCell extends GCompound{
	public GCell(int x, int y, int width, int height){
		cell = new GRect(x, y, width, height);
		cell.setFilled(true);
		cell.setFillColor(Color.white);
		add(cell);
	}
	/**
	 * Method that adds cross to the cell using image
	 */
	public void addCross(){
		setCross(true);
		cellImage = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\NoughtsAndCrosses\\pictures\\closePrj.png");
		cellImage.scale(cell.getWidth()/90, cell.getHeight()/90);
		add(cellImage, cell.getX()+ cell.getWidth()/7, cell.getY() + cell.getHeight()/7);
	}
	/**
	 * Method that adds nought to the cell using image
	 */
	public void addNought(){
		setNought(true);
		cellImage = new GImage("C:\\Users\\Pavlo\\acmWorkspace\\NoughtsAndCrosses\\pictures\\rec.png");
		cellImage.scale(cell.getWidth()/90, cell.getHeight()/90);
		add(cellImage, cell.getX()+ cell.getWidth()/7, cell.getY() + cell.getHeight()/7);
	}
	//Getters and setters
	public void setCross(boolean cross) {
		this.cross = cross;
	}
	public boolean isCross() {
		return cross;
	}
	public void setNought(boolean nought) {
		this.nought = nought;
	}
	public boolean isNought() {
		return nought;
	}
	public boolean isFree() {
		if(!nought && !cross){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Method that finds middle of cell for X
	 * @return middle of cell for X
	 */
	public double getMiddleX(){
		return (cell.getX() + cell.getWidth()/2);
	}
	/**
	 * Method that finds middle of cell for Y
	 * @return middle of cell for Y
	 */
	public double getMiddleY(){
		return (cell.getY() + cell.getHeight()/2);
	}
	//private instance variables
	private boolean cross = false;
	private boolean nought = false;
	private GRect cell;
	private GImage cellImage;
}
