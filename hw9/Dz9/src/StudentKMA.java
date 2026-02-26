
public class StudentKMA {
	//Ñòâîğşºìî ÷îòèğè êîíñòğóêòîğà äëÿ êëàñó
	public StudentKMA(){
		setFullName("Unknown");
		setYear(1);
		setActive(true);
		setBudget(true);
		numberOfStudents++;
	}
	public StudentKMA(String fullName){
		this.setFullName(fullName);
		setYear(1);
		setActive(true);
		setBudget(true);
		numberOfStudents++;
	}
	public StudentKMA(String fullName, int year){
		this.setFullName(fullName);
		setYear(year);
		setActive(true);
		setBudget(true);
		numberOfStudents++;
	}
	public StudentKMA(String fullName, int year, boolean budget){
		this.setFullName(fullName);
		this.setYear(year);
		setActive(true);
		this.setBudget(budget);
		numberOfStudents++;
	}
	//Ãåòòåğè òà ñåòòåğè
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setYear(int year) {
		if (year > 0 && year < 7){
			this.year = year;
		}
	}
	public int getYear() {
		return year;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	public void setBudget(boolean budget) {
		this.budget = budget;
	}
	public boolean isBudget() {
		return budget;
	}
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	//Ìåòîä toString, ÿêèé êîíâåğòóº îá'ºêò â ğÿäîê
	public String toString(){
		return "Ï²Á: " + fullName + ", ğ³ê íàâ÷àííÿ: " + year + ", áşäæåò: " + budget + ", ñòàí àêòèâíîñò³: " + active;
	}
	
	//Ìåòîä, ÿêèé ïåğåâîäèòü àáî íå ïåğåâîäèòü ñòóäåíòà íà íàñòóïíèé ğ³ê â çàëåæíîñò³ â³ä îö³íêè, ÿêó ïğèéìàº
	/**
	 * This method change StudentKMA object state based on his current grade
	 * @param grade int from 0 to 100
	 */
	public void toNextYear(int grade){
		if(checkResults(grade) && year != 6){
			year++;
		} else {
			active = false;
			numberOfStudents--;
		}
	}
	//Ìåòîä, ÿêèé çì³íşº íàø îá'ºêò â çàëåæíîñò³ â³ä îö³íêè, ÿêó ïğèéìàº
	private boolean checkResults(int grade) {
		if(grade < 60 && budget == true){
			budget = false;
			return true;
		} else if (grade < 60 && budget == false) {
			return false;
		} else {
			return true;
		}
	}

	//Çì³íí³ åêçåìïëÿğó
	private String fullName;
	private int year;
	private boolean active;
	private boolean budget;
	//Çì³ííà êëàñó
	private static int numberOfStudents = 0;
}
