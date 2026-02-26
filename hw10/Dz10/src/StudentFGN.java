
public class StudentFGN extends StudentKMA{
	//Створюємо чотири конструктора для класу
	public StudentFGN(){
		setJob(false);
		setCoursesHeard(0);
		setBooksRead(0);
		setLevelOfExestentialCrisis(0);
	}
	public StudentFGN(String fullName){
		super(fullName);
		setJob(false);
		setCoursesHeard(0);
		setBooksRead(0);
		setLevelOfExestentialCrisis(0);
	}
	public StudentFGN(String fullName, int year){
		super(fullName, year);
		setJob(false);
		setCoursesHeard(0);
		setBooksRead(0);
		setLevelOfExestentialCrisis(0);
	}
	public StudentFGN(String fullName, int year, boolean budget){
		super(fullName, year, budget);
		setJob(false);
		setCoursesHeard(0);
		setBooksRead(0);
		setLevelOfExestentialCrisis(0);
	}
	//Геттери та сеттери
	public static String getFaculty() {
		return faculty;
	}
	public void setJob(boolean job) {
		this.job = job;
	}
	public boolean isJob() {
		return job;
	}
	public void setCoursesHeard(int coursesHeard) {
		this.coursesHeard = coursesHeard;
	}
	public int getCoursesHeard() {
		return coursesHeard;
	}
	public void setLevelOfExestentialCrisis(int levelOfExestentialCrisis) {
		this.levelOfExestentialCrisis = levelOfExestentialCrisis;
	}
	public int getLevelOfExestentialCrisis() {
		return levelOfExestentialCrisis;
	}
	public void setBooksRead(int booksRead) {
		this.booksRead = booksRead;
	}
	public int getBooksRead() {
		return booksRead;
	}
	//Метод toString, який конвертує об'єкт в рядок
	public String toString(){
		return "ПІБ: " + fullName + ", рік навчання: " + year +  ", факультет: " + faculty +  ", курсів прослухано " + coursesHeard +", книг прочитано: " + booksRead +", бюджет: " + budget + ", стан активності: " + active + ", робота: " + job + ", рівень екзестенційної кризи: " + levelOfExestentialCrisis;
	}
	
	//Метод, який записує студента на курс
	public void enrollCourse(){
		coursesHeard++;
	}
	//Метод, який читає книжку
	public void readABook(){
		booksRead++;
		levelOfExestentialCrisis++;
	}
	//Метод, який проходить сесію
	public void passSesion(){
		setLevelOfExestentialCrisis(0);
	}
	//Змінна класу
	private static String faculty = "ФГН";
	//Змінні екземпляру
	private boolean job;
	private int coursesHeard;
	private int levelOfExestentialCrisis;
	private int booksRead;
}
