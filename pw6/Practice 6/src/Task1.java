/* Ïğàêòè÷íà ğîáîòà ¹6, Âóñ Ïàâëî, ²ÏÇ-1, ãğóïà ¹1
 * 1. Îá÷èñë³òü çíà÷åííÿ ôóíêö³¿ òà âèâåä³òü éîãî íà åêğàí.

ó=ÌÀÕ(a, b, c, d)
y=x4
y=ax2+bx+c
Çíà÷åííÿ a, b, c, d òà õ çàäàşòüñÿ ç êëàâ³àòóğè òà âèêîğèñòîâóşòüñÿ äëÿ äëÿ âñ³õ 3 ï³äçàäà÷*/

import acm.program.ConsoleProgram;


public class Task1 extends ConsoleProgram{
	public void run(){
		findMax();
		raiseToTheForthPower();
		findQuadraticFunction();
	}
//Ìåòîä, ÿêèé çíàõîëèòü çíà÷åííÿ òğåòüî¿ ôóíêö³¿, ïîêè öüîãî õî÷å êîğèñòóâà÷
	private void findQuadraticFunction() {
		while(true){
			println("Ââåä³òü êîåô³ö³åíòè ³ àğãóìåíò êâàäğàòíîãî ìíîãî÷ëåíà");
			double a = readInt("Ââåä³òü ïåğøèé êîåô³ö³ºíò:");
			double b = readInt("Ââåä³òü äğóãèé êîåô³ö³ºíò:");
			double c = readInt("Ââåä³òü òğåò³é êîåô³ö³ºíò:");
			double x = readInt("Ââåä³òü àğãóìåíò:");
			
			double result = calculateQuadraticFunction(a, b, c, x);
			println("Çíà÷åííÿ êâàäğàòè÷íî¿ ôóíêö³¿: " + result);
			
			int choice = readInt("Ïğîäîâæóºìî? Ââåä³òü 1 äëÿ ïğîäîâæåííÿ àáî 0 äëÿ âèõîäó:");
			if(choice == 0){
				println("Ïğîãğàìà çàâåğøåíà!");
				break;
			} else if(choice != 0 && choice != 1){
				choice = readInt("Âè ââåëè ³íøå ÷èñëî!!!. Âàì ïîòğ³áíî ââåñòè 1 äëÿ ïğîäîâæåííÿ àáî 0 äëÿ âèõîäó:");
			}	
		}
	}
//Ìåòîä, ïğèéìàº êîåô³ö³ºíòè ³ àğãóìåíò ³ îá÷èñëşº çíà÷åííÿ êâàäğàòè÷íî¿ ôóíêö³¿
	private double calculateQuadraticFunction(double a, double b, double c, double x) {
		return a*x*x + b*x +c;
	}
//Ìåòîä, ÿêèé çíàõîëèòü çíà÷åííÿ äğóãî¿ ôóíêö³¿, ïîêè öüîãî õî÷å êîğèñòóâà÷
	private void raiseToTheForthPower() {
		while(true){
			println("Ââåäåíå ÷èñëî ï³äíåñåòüñÿ äî ÷åòâåğòîãî ñòåïåíÿ");
			double x = readInt("Ââåä³òü ÷èñëî:");
			
			double result = calculateTheForthPower(x);
			println("Öå ÷èñëî â ÷åòâåğòîìó ñòåïåí³ äîğ³âíşº: " + result);
			
			int choice = readInt("Ïğîäîâæóºìî? Ââåä³òü 1 äëÿ ïğîäîâæåííÿ àáî 0 äëÿ âèõîäó:");
			if(choice == 0){
				println("Ïğîãğàìà çàâåğøåíà!");
				break;
			} else if(choice != 0 && choice != 1){
				choice = readInt("Âè ââåëè ³íøå ÷èñëî!!!. Âàì ïîòğ³áíî ââåñòè 1 äëÿ ïğîäîâæåííÿ àáî 0 äëÿ âèõîäó:");
			}	
		}
	}
//Ìåòîä, ÿêèé ïğèéìàº ÷èñëî ³ ï³äíîñèòü éîãî äî ÷åòâåğòîãî ñòåïåíÿ
	private double calculateTheForthPower(double x) {
		return x*x*x*x;
	}
//Ìåòîä, ÿêèé çíàõîëèòü íàéá³ëüøå ç ÷îòèğüîõ, ïîêè öüîãî õî÷å êîğèñòóâà÷
	private void findMax() {
		while (true){
			println("Ââåä³òü ÷îòèğè ÷èñëà, ùîá çíàéòè íàéá³ëüøå ç íèõ");
			double a = readInt("Ââåä³òü ö³ëå ÷èñëî:");
			double b = readInt("Ââåä³òü ö³ëå ÷èñëî:");
			double c = readInt("Ââåä³òü ö³ëå ÷èñëî:");
			double d = readInt("Ââåä³òü ö³ëå ÷èñëî:");
			
			double maxNumber = calculateMax(a, b, c, d);
			println("Íàéá³ëüøå ÷èñëî: " + maxNumber);
			
			int choice = readInt("Ïğîäîâæóºìî? Ââåä³òü 1 äëÿ ïğîäîâæåííÿ àáî 0 äëÿ âèõîäó:");
			if(choice == 0){
				println("Ïğîãğàìà çàâåğøåíà!");
				break;
			} else if(choice != 0 && choice != 1){
				choice = readInt("Âè ââåëè ³íøå ÷èñëî!!!. Âàì ïîòğ³áíî ââåñòè 1 äëÿ ïğîäîâæåííÿ àáî 0 äëÿ âèõîäó:");
			}	
		}
		
	}
//Ìåòîä, ÿêèé ïğèéìàº ÷îòèğè ÷èñëà ³ ïîâåğòàº íàéá³ëüøå ç íèõ
	private double calculateMax(double a, double b, double c, double d) {
		if(a>=b && a>=c && a>=d){
			return a;
		} else if (b>=a && b>=c && b>=d){
			return b;
		} else if(c>=a && c>=b && c>=d){
			return c;
		} else if(d>=a && d>=b && d>=c){
			return d;
		} else {
			return 0;
		}
	}
}
