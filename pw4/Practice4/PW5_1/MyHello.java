import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class MyHello extends GraphicsProgram{

	public void run(){
		this.setSize(500, 500);
		GLabel surname = new GLabel("Vus",50,50);
		surname.setFont("SansSerif-30");
		surname.setColor(Color.RED);
		add(surname);
		GLabel name = new GLabel("Pavlo",200,200);
		name.setFont("Consolas-30");
		name.setColor(Color.GREEN);
		add(name);
		GLabel secondName = new GLabel("Igorovich",400, 400);
		secondName.setFont("Calibri-30");
		secondName.setColor(Color.BLUE);
		add(secondName);
	}
}
