import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating the responsible teacher and setting birthdate and salary
        ResponsibleTeacher mickey = new ResponsibleTeacher("Mickey", "Mouse");
        mickey.setBirthDate("230498-045T");
        MonthlyPayment salary = new MonthlyPayment();
        salary.setSalary(756.85);
        mickey.setPayment(salary);
        // Creating the assistant teacher and setting birthdate and salary
        AssistantTeacher goofyTheDog = new AssistantTeacher("Goofy", "The Dog");
        goofyTheDog.setBirthDate("141200A2315");
        HourBasedPayment Pay = new HourBasedPayment();
        Pay.setEurosPerHour(3.5);
        Pay.setHours(11.0);
        goofyTheDog.setPayment(Pay);
        // Creating student object
        Student donald = new Student("Donald", "Duck");
        // Creating course objects
        Course course1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
        Course course2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
        Course course3 = new Course("More basic studies", 223344, 'a', 1, 1, 50.5, true);
        Course course4 = new Course("Even more basic studies", 556677, 'a', 0, 3, 50.0, true);
        Course course5 = new Course("Final basic studies", 123123, 'A', 1, 4, 50.5, true);
        Course course6 = new Course("Programming 2", 616161, 'A', 1, 3, 25.0, true);
        Course course7 = new Course("All kinds of master studies", 717171, 'P', 0, 2, 45.0, true);
        Course course8 = new Course("More master studies", 818181, 'A', 1, 1, 25.0, true);
        Course course9 = new Course("Even more master studies", 919191, 'S', 1, 3, 20.0, true);
        Course course10 = new Course("Extra master studies", 666666, 'S', 0, 5, 8.0, false);
        Course course11 = new Course("Final master studies", 888888, 'S', 1, 5, 18.0, false);
        // Creating designated course objects and adding them to arraylist
        List<DesignatedCourse> designatedCourses = new ArrayList<>();
        designatedCourses.add(new DesignatedCourse(course3, true, 2023));
        designatedCourses.add(new DesignatedCourse(course4, false, 2023));
        designatedCourses.add(new DesignatedCourse(course10, false, 2023));
        designatedCourses.add(new DesignatedCourse(course11, true, 2023));
        // Setting designated courses for responsible teacher and assistant teacher
        mickey.setCourses(designatedCourses);
        goofyTheDog.setCourses(designatedCourses);
        // Printing out the responsible teacher and assistant teacher info
        System.out.println(mickey.toString());
        System.out.println(goofyTheDog.toString());
        // Creating student course objects
        StudentCourse studentCourse1 = new StudentCourse(course1, 1, 2013);
        StudentCourse studentCourse2 = new StudentCourse(course2, 1, 2014);
        StudentCourse studentCourse3 = new StudentCourse(course3, 1, 2015);
        StudentCourse studentCourse4 = new StudentCourse(course4, 4, 2016);
        StudentCourse studentCourse5 = new StudentCourse(course5, 5, 2017);
        StudentCourse studentCourse6 = new StudentCourse(course6, 1, 2018);
        StudentCourse studentCourse7 = new StudentCourse(course7, 1, 2019);
        StudentCourse studentCourse8 = new StudentCourse(course8, 2, 2020);
        StudentCourse studentCourse9 = new StudentCourse(course9, 2, 2021);
        StudentCourse studentCourse10 = new StudentCourse(course10, 'A', 2021);
        StudentCourse studentCourse11 = new StudentCourse(course11, 'f', 2022);
        // Creating degree objects
        Degree degree = new Degree();
        Degree degree2 = new Degree();
        // Creating a list for bachelor courses and adding certain student courses to it
        List<StudentCourse> bachelorcourses = new ArrayList<>();
        bachelorcourses.add(studentCourse1);
        bachelorcourses.add(studentCourse2);
        bachelorcourses.add(studentCourse3);
        bachelorcourses.add(studentCourse4);
        bachelorcourses.add(studentCourse5);
        // Creating a list for master courses and adding certain student courses to it
        List<StudentCourse> mastercourses = new ArrayList<>();
        mastercourses.add(studentCourse6);
        mastercourses.add(studentCourse7);
        mastercourses.add(studentCourse8);
        mastercourses.add(studentCourse9);
        mastercourses.add(studentCourse10);
        mastercourses.add(studentCourse11);
        // Setting degree titles and thesis titles
        degree.setDegreeTitle("Bachelor of Science");
        degree2.setDegreeTitle("Master of Science");
        degree.setTitleOfThesis("Christmas - The most wonderful time of the year");
        degree2.setTitleOfThesis("Dreaming of a white Christmas");
        // Adding student courses to the degree
        degree.addStudentCourses(bachelorcourses);
        degree.addStudentCourses(mastercourses);
        // Setting graduation year and starting year for student object
        donald.setStartYear(2001);
        donald.setGraduationYear(2020);
        // Printing out the student
        System.out.println(donald.toString());
        // Setting birthdate and thesis titles for student object
        donald.setBirthDate("230498-045T");
        donald.setTitleOfThesis(0, "Bachelor thesis title");
        donald.setTitleOfThesis(1, "Master thesis title");
        // Adding courses to student's degrees
        donald.addCourses(0, bachelorcourses);
        donald.addCourses(1, mastercourses);
        // Printing out the student object.
        System.out.println(donald.toString());

    }
}