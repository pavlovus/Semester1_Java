
public class StudentFI extends StudentKMA{
	public StudentFI(){
		//Створюємо чотири конструктора для класу
		setHoursOfSleep(8);
		setCoursesHeard(0);
		setStressLevel(0);
		setHoursOfPractice(0);
	}
	public StudentFI(String fullName){
		super(fullName);
		setHoursOfSleep(8);
		setCoursesHeard(0);
		setStressLevel(0);
		setHoursOfPractice(0);
	}
	public StudentFI(String fullName, int year){
		super(fullName, year);
		setHoursOfSleep(8);
		setCoursesHeard(0);
		setStressLevel(0);
		setHoursOfPractice(0);
	}
	public StudentFI(String fullName, int year, boolean budget){
		super(fullName, year, budget);
		setHoursOfSleep(8);
		setCoursesHeard(0);
		setStressLevel(0);
		setHoursOfPractice(0);
	}
	
	//Геттери та сеттери
	public void setCoursesHeard(int lectionsHeard) {
		this.coursesHeard = lectionsHeard;
	}
	public int getCoursesHeard() {
		return coursesHeard;
	}
	public void setHoursOfSleep(int hoursOfSleep) {
		this.hoursOfSleep = hoursOfSleep;
	}

	public int getHoursOfSleep() {
		return hoursOfSleep;
	}
	public static String getFaculty() {
		return faculty;
	}
	public void setStressLevel(int stressLevel) {
		this.stressLevel = stressLevel;
	}
	public int getStressLevel() {
		return stressLevel;
	}
	public void setHoursOfPractice(int hoursOfPractice) {
		this.hoursOfPractice = hoursOfPractice;
	}
	public int getHoursOfPractice() {
		return hoursOfPractice;
	}
	//Метод toString, який конвертує об'єкт в рядок
	public String toString(){
		return "ПІБ: " + fullName + ", рік навчання: " + year +  ", факультет: " + faculty +  ", курсів прослухано " + coursesHeard +", годин практики: " + hoursOfPractice + ", бюджет: " + budget + ", стан активності: " + active + ", к-сть годин сну: " + hoursOfSleep + ", рівень стресу: " + stressLevel;
	}
	
	//Метод, який записує студента на курс
	public void enrollCourse(){
		coursesHeard++;
		if(hoursOfSleep > 0){
			hoursOfSleep--;
		}
	}
	//Метод, який проходить сесію
	public void passSesion(){
		setHoursOfSleep(8);
		setStressLevel(0);
	}
	//Метод, який проходить Керола
	public void doKarel(){
		stressLevel++;
		hoursOfPractice++;
	}
	//Змінна класу
	private static String faculty = "ФІ";
	//Змінні екземпляру
	private int hoursOfSleep;
	private int stressLevel;
	private int hoursOfPractice;
	private int coursesHeard;
}
