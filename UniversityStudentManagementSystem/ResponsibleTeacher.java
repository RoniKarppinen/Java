import java.util.ArrayList;
import java.util.List;

public class ResponsibleTeacher extends Employee implements Teacher, Payment {
    // Attributes
    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();

    // Constructors
    /* Sets the last and first name of the responsible teacher. */
    public ResponsibleTeacher(String lname, String fname) {
        super(lname, fname);
    }

    // Methods
    /* Returns the string “OY_TEACHER_”. */
    public String getEmployeeIdString() {
        return "OY_TEACHER_";
    }

    /*
     * Returns a string including the data for the designated courses (utilize
     * toString method of the
     * DesignatedCourse class). Note - If the teacher is responsible for a specific
     * course, the method will add the pre-fix “Responsible teacher: “ to the course
     * output. If
     * the teacher is just a teacher, there is a pre-fix “Teacher: “.
     */
    public String getCourses() {
        StringBuilder resultstring = new StringBuilder();
        for (DesignatedCourse course : courses) {
            if (((DesignatedCourse) course).isResponsible()) {
                resultstring.append("Responsible teacher:");
            } else {
                resultstring.append("Teacher:");
            }
            resultstring.append(course.toString());
            resultstring.append("\n");
        }
        return resultstring.toString();
    }

    /* Sets the given courses (if the given parameter is not null). */
    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses;
        }
    }

    /* The method will output the expected output for a ResponsibleTeacher. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Teacher id: ").append(getIdString()).append("\n");
        sb.append("First name: ").append(getFirstName()).append(", Last name: ").append(getLastName()).append("\n");
        sb.append("Birthdate: ").append(getBirthDate()).append("\n");
        sb.append("Salary: ").append(String.format("%.2f", calculatePayment())).append("\n");
        sb.append("Teacher for courses:").append("\n");
        sb.append(getCourses());
        return sb.toString();
    }
}
