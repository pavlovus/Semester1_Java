import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;


public class StudentKMAUse extends ConsoleProgram {
	public void run(){
		//Створюємо і виводимо нові об'єкти та їхню к-сть
		StudentKMA st1 = new StudentKMA();
		println(st1);
		st1.setFullName("Ігор Федорович");
		StudentKMA st2 = new StudentKMA("Жозе Моуріньйо");
		println(st2);
		StudentKMA st3 = new StudentKMA("Олег Тимошенко", 6);
		println(st3);
		StudentKMA st4 = new StudentKMA("Петро Порошенко", 2, false);
		println(st4);
		println(st1.getNumberOfStudents());
		
		//Викликаємо метод переходу до наступного року з випадковими оцінками та виводимо знову об'єкти і їхню к-сть
		st1.toNextYear(rgen.nextInt(1, 100));
		st2.toNextYear(rgen.nextInt(1, 100));
		st3.toNextYear(rgen.nextInt(1, 100));
		st4.toNextYear(rgen.nextInt(1, 100));
		println(st1);
		println(st2);
		println(st3);
		println(st4);
		println(st1.getNumberOfStudents());
	}
	RandomGenerator rgen = RandomGenerator.getInstance();
}
