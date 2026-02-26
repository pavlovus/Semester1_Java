/* Домашня робота №6,завдання №2, Вус Павло, ІПЗ-1, група №1
 * Намалювати обличчя робота.

Обличчя складається з чотирьох частинок - голова, два ока, і рот

Використати константи HEAD_WIDTH, HEAD_HEIGHT, EYE_RADIUS, MOUTH_WIDTH, MOUTH_HEIGHT

Малюнок розміщується по центру вікна. При зміні розмірів вікна обличчя розміщується по центру вікна*/

import java.awt.Color;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class Task2 extends GraphicsProgram{
	//Задаємо необхідні константи
	private static final int X = 600;
	private static final int Y = 600;
	private static final int HEAD_WIDTH = 400;
	private static final int HEAD_HEIGHT = 200;
	private static final int MOUSE_WIDTH = 100;
	private static final int MOUSE_HEIGHT = 50;
	private static final int EYE_RADIUS = 25;
	public void run(){
		//Задаємо розмір світу та будуємо роботу
		this.setSize(X, Y);
		buildRobot();
	}
	
	private void buildRobot() {
		//Знаходимо центр
		double centerX = X/2;
		double centerY = Y/2;
		
		//Будуємо голову, рот і очі
		buildHead(HEAD_HEIGHT, HEAD_WIDTH, centerX, centerY);
		buildMouse(centerX, centerY, MOUSE_WIDTH, MOUSE_HEIGHT, HEAD_HEIGHT);
		buildEyes(HEAD_HEIGHT, HEAD_WIDTH, centerX, centerY, EYE_RADIUS);
	}

//Метод, який приймає необхідні розміри і будує очі
	private void buildEyes(int headHeight, int headWidth, double centerX, double centerY, int eyeRadius) {
		GOval leftEye = new GOval(centerX - headWidth/4 - eyeRadius, centerY - eyeRadius, eyeRadius*2, eyeRadius*2);
		leftEye.setColor(Color.decode("#A9A9A9"));
		leftEye.setFilled(true);
		add(leftEye);
		
		GOval rightEye = new GOval(centerX + headWidth/4 - eyeRadius, centerY - eyeRadius, eyeRadius*2, eyeRadius*2);
		rightEye.setColor(Color.decode("#A9A9A9"));
		rightEye.setFilled(true);
		add(rightEye);
	}
//Метод, який приймає необхідні розміри і будує рот
	private void buildMouse(double centerX, double centerY, int mouseWidth, int mouseHeight, int headHeight) {
		GRect mouse = new GRect(centerX - mouseWidth/2, centerY - mouseHeight/2 + headHeight/4, mouseWidth, mouseHeight);
		mouse.setColor(Color.decode("#A9A9A9"));
		mouse.setFilled(true);
		add(mouse);
	}
//Метод, який приймає необхідні розміри і будує голову, вуха і антенну
	private void buildHead(int headHeight, int headWidth, double centerX, double centerY) {
		GOval leftEar = new GOval(centerX - headWidth/2 - headHeight/8, centerY - headHeight/8, headHeight/4, headHeight/4);
		leftEar.setFillColor(Color.decode("#D3D3D3"));
		leftEar.setFilled(true);
		leftEar.setColor(Color.decode("#A9A9A9"));
		add(leftEar);
		
		GOval rightEar = new GOval(centerX + headWidth/2 - headHeight/8, centerY - headHeight/8, headHeight/4, headHeight/4);
		rightEar.setFillColor(Color.decode("#D3D3D3"));
		rightEar.setFilled(true);
		rightEar.setColor(Color.decode("#A9A9A9"));
		add(rightEar);
		
		GRect head = new GRect(centerX - headWidth/2, centerY - headHeight/2, headWidth, headHeight);
		head.setFillColor(Color.decode("#D3D3D3"));
		head.setFilled(true);
		head.setColor(Color.decode("#A9A9A9"));
		add(head);
		
		GRect antenna = new GRect(centerX - headWidth/80, centerY - headHeight/2 - headHeight/4, headWidth/40, headHeight/4);
		antenna.setColor(Color.decode("#A9A9A9"));
		antenna.setFilled(true);
		add(antenna);
		
		GOval headOfAntenna = new GOval(centerX - headHeight/8, centerY - headHeight, headHeight/4, headHeight/4);
		headOfAntenna.setFillColor(Color.decode("#D3D3D3"));
		headOfAntenna.setFilled(true);
		headOfAntenna.setColor(Color.decode("#A9A9A9"));
		add(headOfAntenna);
		
		/*GLine center = new GLine (centerX, centerY + headHeight/2, centerX, centerY - headHeight/2);
		add(center);
		
		GLine center1 = new GLine (centerX - headWidth/2, centerY, centerX + headWidth/2, centerY);
		add(center1);*/
	}
}
