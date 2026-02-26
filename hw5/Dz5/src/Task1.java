/*Домашня робота №5, Вус Павло, ІПЗ-1, група №1 */

import java.awt.Color;


import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class Task1 extends GraphicsProgram{
	int centerX = 250;
	int centerY = 250;
	double radius = 100;
	public void run(){
		this.setSize(centerX*2, centerY*2);
		createSun();
		createRays();
	}

	private void createRays() {
		final int Rays = 995;
		for(int i =0; i < Rays; i++){
			double angle = Math.PI*2*i/Rays;
			double pointX = centerX + radius*Math.cos(angle);
			double pointY = centerX + radius*Math.sin(angle);
			GLine ray = new GLine(centerX, centerY, pointX + radius*Math.cos(angle) , pointY + radius*Math.sin(angle));
			ray.setColor(Color.decode("#FFA500"));
			add(ray);
		}
	}

	private void createSun() {
		GOval sun = new GOval(centerX - 100,centerY - 100, radius*2, radius*2);
		sun.setFilled(true);
		sun.setColor(Color.decode("#FFFFC5"));
		add(sun);
	}
}
