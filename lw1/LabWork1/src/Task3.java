/* Завдання №3 лабораторної роботи №1, Вус Павло, ІПЗ-1, група №1
 * Написати програму, що малює часткову діаграму класів acm.program, як показано в прикладі
 * Діаграма має вписуватись у розміри вікна і розташовуватися по центру вікна.*/

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class Task3 extends GraphicsProgram{
	private static final int X = 630;
	private static final int Y = 420;
	public void run(){
		this.setSize(X, Y);
		buildDiagram();
	}
	//Метод, який будує будує задану діаграму відносно розмірів вікна
	private void buildDiagram() {
		//Знаходимо необхідні змінні для побудови діаграми
		double centerX = X/2;
		double centerY = Y/2;
		double rectHeight = Y/10;
		double rectWidth = X/5;

		buildMainRect(centerX,centerY, rectHeight, rectWidth);
		buildCentralRect(centerX,centerY, rectHeight, rectWidth);
		buildLeftRect(centerX,centerY, rectHeight, rectWidth);
		buildRightRect(centerX,centerY, rectHeight, rectWidth);
		buildLinesBetweenRects(centerX,centerY, rectHeight, rectWidth);
	}
	
//Метод, який приймає координату центру, висоту і ширину блока діаграми і будує лінії з центрів нижніх блоків до центру головного блоку 
	private void buildLinesBetweenRects(double centerX, double centerY, double rectHeight, double rectWidth) {
		GLine centralLine = new GLine(centerX, centerY - rectHeight/2, centerX, centerY + rectHeight/2);
		add(centralLine);
		GLine leftLine = new GLine(centerX, centerY - rectHeight/2, centerX - rectWidth/5 - rectWidth, centerY + rectHeight/2 );
		add(leftLine);
		GLine rightLine = new GLine(centerX, centerY - rectHeight/2,centerX + rectWidth/5 + rectWidth,centerY + rectHeight/2);
		add(rightLine);
	}
	
//Метод, який приймає координату центру, висоту і ширину блока діаграми і будує правий блок з текстом
	private void buildRightRect(double centerX, double centerY, double rectHeight, double rectWidth) {
		GRect rightRect = new GRect(centerX + rectWidth/2 + rectWidth/5 ,centerY + rectHeight/2, rectWidth, rectHeight);
		add(rightRect);
		
		GLabel rightText = new GLabel ("DialogProgram", centerX, centerY - rectHeight);
		int fontSize = X/40;
		rightText.setFont("Arial-" + fontSize);
		double textWidth = rightText.getWidth();
		double textHeight = rightText.getHeight();
		rightText.setLocation(centerX - textWidth/2 + rectWidth/5 + rectWidth, centerY + rectHeight + textHeight/2);
		add(rightText);
	}
	
//Метод, який приймає координату центру, висоту і ширину блока діаграми і будує лівий блок з текстом
	private void buildLeftRect(double centerX, double centerY, double rectHeight, double rectWidth) {
		GRect leftRect = new GRect(centerX - rectWidth*1.5 - rectWidth/5 ,centerY + rectHeight/2, rectWidth, rectHeight);
		add(leftRect);
		
		GLabel leftText = new GLabel ("GraphicsProgram", centerX, centerY - rectHeight);
		int fontSize = X/40;
		leftText.setFont("Arial-" + fontSize);
		double textWidth = leftText.getWidth();
		double textHeight = leftText.getHeight();
		leftText.setLocation(centerX - textWidth/2 - rectWidth/5 - rectWidth, centerY + rectHeight + textHeight/2);
		add(leftText);
	}
//Метод, який приймає координату центру, висоту і ширину блока діаграми і будує центральний блок з текстом
	private void buildCentralRect(double centerX, double centerY, double rectHeight, double rectWidth) {
		GRect centralRect = new GRect(centerX - rectWidth/2,centerY + rectHeight/2, rectWidth, rectHeight);
		add(centralRect);
		
		GLabel centralText = new GLabel ("ConsoleProgram", centerX, centerY - rectHeight);
		int fontSize = X/40;
		centralText.setFont("Arial-" + fontSize);
		double textWidth = centralText.getWidth();
		double textHeight = centralText.getHeight();
		centralText.setLocation(centerX - textWidth/2, centerY + rectHeight + textHeight/2);
		add(centralText);
	}
//Метод, який приймає координату центру, висоту і ширину блока діаграми і будує головний блок з текстом
	private void buildMainRect(double centerX, double centerY, double rectHeight, double rectWidth) {
		GRect mainRect = new GRect(centerX - rectWidth/2,centerY - rectHeight*1.5, rectWidth, rectHeight);
		add(mainRect);
		
		GLabel mainText = new GLabel ("Program", centerX, centerY - rectHeight);
		int fontSize = X/40;
		mainText.setFont("Arial-" + fontSize);
		double textWidth = mainText.getWidth();
		double textHeight = mainText.getHeight();
		mainText.setLocation(centerX - textWidth/2, centerY - rectHeight + textHeight/2);
		add(mainText);
	}
}
