import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;


public class GButton extends GCompound{
	public GButton(String text,int width, int height){
		rectButton = new GRect(width, height);
		rectButton.setFilled(true);
		rectButton.setColor(Color.decode("#D3D3D3"));
		add(rectButton, 0, 0);
		
		buttonText = new GLabel(text);
		buttonText.setFont("Anton-" + width/5);
		buttonText.setColor(Color.decode("#1A1A5E"));
		add(buttonText, width/2 - buttonText.getWidth()/2, height/2 + buttonText.getHeight()/4);
	}
	//private instance variables
	private GRect rectButton;
	private GLabel buttonText;
}
