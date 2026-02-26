/*Практична робота №5, Вус Павло, ІПЗ-1, група №1 */

import java.awt.Color;


import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;


public class House extends GraphicsProgram {
	public void run(){
		this.setSize(600, 400);
		
		setWorld();
		drawLeftCloud();
		drawRightCloud();
		drawFume();
		drawChimney();
		drawFence();
		drawHouse();
	}
//Метод, який через цикл створює паркан, який складається з вертикальних перегородок і горизонтальних з'єднань
	private void drawFence() {
		for(int i=0; i<27; i++){
			GRect upperConnection= new GRect(110 + i*15, 260, 5, 5);
			upperConnection.setFilled(true);
			upperConnection.setColor(Color.decode("#C4A484"));
			if(i == 26){
				upperConnection.setVisible(false);
			}
			add(upperConnection);
			
			GRect lowerConnection = new GRect(110 + i*15, 290, 5, 5);
			lowerConnection.setFilled(true);
			lowerConnection.setColor(Color.decode("#C4A484"));
			if(i == 26){
				lowerConnection.setVisible(false);
			}
			add(lowerConnection);
			
			GRect partition = new GRect(100 + i*15,250, 10, 50);
			partition.setFilled(true);
			partition.setColor(Color.decode("#A1662F"));
			add(partition);
		}
	}
	
//Метод, який через цикл малює дим за допомогою кругів
	private void drawFume() {
		for(int i=0; i<10; i++){
			GOval fumes = new GOval(360 - i*5,52 - i*7, 7 + i*2, 7 + i*2);
			fumes.setFilled(true);
			fumes.setColor(Color.decode("#dbd5d5"));
			add(fumes);
		}
	}

//Метод, який створює димар з труби і верхнього розширення
	private void drawChimney() {
		GRect chimney = new GRect(350,50, 20, 40);
		chimney.setFilled(true);
		chimney.setColor(Color.decode("#a18678"));
		add(chimney);
		
		GRect chimneyTop = new GRect(345,50, 30, 5);
		chimneyTop.setFilled(true);
		chimneyTop.setColor(Color.decode("#a18678"));
		add(chimneyTop);
	}

//Метод, який створює землю, небо і траву
	private void setWorld(){
		GRect sky = new GRect(0,0,600,300);
		sky.setFilled(true);
		sky.setColor(Color.decode("#039dfc"));
		add(sky);
		
		GRect grass = new GRect(0,300,600,20);
		grass.setFilled(true);
		grass.setColor(Color.decode("#67fc03"));
		add(grass);
		
		GRect ground = new GRect(0,320,600,280);
		ground.setFilled(true);
		ground.setColor(Color.decode("#6b392a"));
		add(ground);
	}

//Метод, який створює ліву хмару з трьох овалів
	private void drawLeftCloud(){
		GOval leftCloudFirstPart = new GOval(50,50,100,50);
		leftCloudFirstPart.setFilled(true);
		leftCloudFirstPart.setColor(Color.decode("#dbd5d5"));
		add(leftCloudFirstPart);
		
		GOval leftCloudSecondPart = new GOval(80,40,50,40);
		leftCloudSecondPart.setFilled(true);
		leftCloudSecondPart.setColor(Color.decode("#dbd5d5"));
		add(leftCloudSecondPart);
		
		GOval leftCloudThirdPart = new GOval(60,45,30,30);
		leftCloudThirdPart.setFilled(true);
		leftCloudThirdPart.setColor(Color.decode("#dbd5d5"));
		add(leftCloudThirdPart);
	}
	
//Метод, який створює ліву хмару з трьох овалів
	private void drawRightCloud(){
		GOval rightCloudFirstPart = new GOval(450,50,100,50);
		rightCloudFirstPart.setFilled(true);
		rightCloudFirstPart.setColor(Color.decode("#dbd5d5"));
		add(rightCloudFirstPart);
		
		GOval rightCloudSecondPart = new GOval(480,40,50,40);
		rightCloudSecondPart.setFilled(true);
		rightCloudSecondPart.setColor(Color.decode("#dbd5d5"));
		add(rightCloudSecondPart);
		
		GOval rightCloudThirdPart = new GOval(460,45,30,30);
		rightCloudThirdPart.setFilled(true);
		rightCloudThirdPart.setColor(Color.decode("#dbd5d5"));
		add(rightCloudThirdPart);
	}

//Метод, який створює будинок з основної частини, даху, дверей і вікон
	private void drawHouse() {
		GRect houseMainPart = new GRect(200,100,200,200);
		houseMainPart.setFilled(true);
		houseMainPart.setColor(Color.decode("#ebb69b"));
		add(houseMainPart);
		
		drawRoof();
		drawTheDoors();
		drawWindows();
	}

//Метод, який малює три вікна
	private void drawWindows() {
		drawFirstFloorWindow();
		drawSecondFloorFirstWindow();
		drawSecondFloorSecondWindow();
	}

//Метод, який малює друге вікно
	private void drawFirstFloorWindow() {
		GRect firstFloorWindow = new GRect(225,225, 50, 50);
		firstFloorWindow.setFilled(true);
		firstFloorWindow.setFillColor(Color.decode("#dcf4f5"));
		firstFloorWindow.setColor(Color.decode("#cc3300"));
		add(firstFloorWindow);
		
		GLine verticalLineOfWindow = new GLine(250, 225, 250, 275);
		verticalLineOfWindow.setColor(Color.decode("#cc3300"));
		add(verticalLineOfWindow);
		
		GLine horizontalLineOfWindow = new GLine(225, 250, 275, 250);
		horizontalLineOfWindow.setColor(Color.decode("#cc3300"));
		add(horizontalLineOfWindow);
	}
//Метод, який малює перше вікно
	private void drawSecondFloorFirstWindow() {
		GRect secondFloorFirstWindow = new GRect(225,125, 50, 50);
		secondFloorFirstWindow.setFilled(true);
		secondFloorFirstWindow.setFillColor(Color.decode("#dcf4f5"));
		secondFloorFirstWindow.setColor(Color.decode("#cc3300"));
		add(secondFloorFirstWindow);
		
		GLine verticalLineOfWindow = new GLine(250, 125, 250, 175);
		verticalLineOfWindow.setColor(Color.decode("#cc3300"));
		add(verticalLineOfWindow);
		
		GLine horizontalLineOfWindow = new GLine(225, 150, 275, 150);
		horizontalLineOfWindow.setColor(Color.decode("#cc3300"));
		add(horizontalLineOfWindow);
	}
//Метод, який малює третє вікно
	private void drawSecondFloorSecondWindow() {
		GRect secondFloorSecondWindow = new GRect(325,125, 50, 50);
		secondFloorSecondWindow.setFilled(true);
		secondFloorSecondWindow.setFillColor(Color.decode("#dcf4f5"));
		secondFloorSecondWindow.setColor(Color.decode("#cc3300"));
		add(secondFloorSecondWindow);
		
		GLine verticalLineOfWindow = new GLine(350, 125, 350, 175);
		verticalLineOfWindow.setColor(Color.decode("#cc3300"));
		add(verticalLineOfWindow);
		
		GLine horizontalLineOfWindow = new GLine(325, 150, 375, 150);
		horizontalLineOfWindow.setColor(Color.decode("#cc3300"));
		add(horizontalLineOfWindow);
	}
	
//Метод, який малює двері з ручкою до них
	private void drawTheDoors() {
		GRect theDoors = new GRect(350,250, 25, 50);
		theDoors.setFilled(true);
		theDoors.setColor(Color.decode("#cc3300"));
		add(theDoors);
		
		GOval doorHandle = new GOval(368, 275, 5, 5);
		doorHandle.setFilled(true);
		doorHandle.setColor(Color.decode("#FFD700"));
		add(doorHandle);
	}

//Метод, який через цикл малює дах
	private void drawRoof(){
		for(int i=200; i>100; i--){
			int x = 200 - i;
			GLine lineOfRoof = new GLine(200 + x, i/2, 200 + i, i/2);
			lineOfRoof.setColor(Color.decode("#A44A4A"));
			add(lineOfRoof);
		}
	}
	
}
