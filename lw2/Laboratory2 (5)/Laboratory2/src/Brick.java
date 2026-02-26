import acm.graphics.GRect;

public class Brick extends GRect {
	
	/**Variable that controls number of bricks*/
	private static int brickCount;
	
	public Brick(double width ,int height, java.awt.Color color) {
		super(width, height);
		super.setFilled(true);
		super.setFillColor(color);
		super.setColor(color);	
		brickCount++;
	}
	
	/**Returns the number of bricks*/
	public static int getBrickCount() {
		return brickCount;
	}
	
	/**Checks if bricks are left on the screen*/
	public static boolean bricksAreLeft() {
		if (brickCount == 0) return false;
		return true;
 	}
	
	/**Decrements the number of bricks by one*/
	public static void decrementBrickCount() {
		brickCount--;
	}
}
