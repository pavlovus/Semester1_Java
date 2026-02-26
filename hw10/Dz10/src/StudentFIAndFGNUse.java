import acm.program.ConsoleProgram;


public class StudentFIAndFGNUse extends ConsoleProgram{
	public void run(){
		//Створюємо і виводимо нові об'єкти
		StudentFI st1 = new StudentFI();
		println(st1);
		st1.setFullName("Ігор Федорович");
		StudentFI st2 = new StudentFI("Жозе Моуріньйо");
		println(st2);
		StudentFGN st3 = new StudentFGN("Олег Тимошенко", 6);
		println(st3);
		StudentFGN st4 = new StudentFGN("Петро Порошенко", 2, false);
		println(st4);
		
		//Викликаємо довільні методи, які з'явились в цих класів та виводимо знову об'єкти і їхню к-сть
		st1.doKarel();
		st2.enrollCourse();
		st2.passSesion();
		st3.enrollCourse();
		st4.readABook();
		println(st1);
		println(st2);
		println(st3);
		println(st4);
		println(st1.getNumberOfStudents());
	}
}
