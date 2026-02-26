import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;


public class GButton extends GCompound{
	public GButton(String text,int width, int height){
		rectButton = new GRect(width, height);
		rectButton.setFilled(true);
		rectButton.setColor(Color.decode("#FF6347"));
		add(rectButton, 0, 0);
		
		buttonText = new GLabel(text);
		buttonText.setFont("Anton-" + width/3);
		buttonText.setColor(Color.decode("#5C4033"));
		add(buttonText, width/2 - buttonText.getWidth()/2, height/2 + buttonText.getHeight()/4);
	}
	
	/**Private instance variables*/
	private GRect rectButton;
	private GLabel buttonText;
}
