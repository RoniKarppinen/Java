import java.util.ArrayList;
import java.util.List;
public class AssistantTeacher extends Employee implements Teacher, Payment{
    // Attributes
    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();
    // Constructors
    /* Sets the last and first name of the assistant teacher */
    public AssistantTeacher(String lname, String fname) {
        super(lname, fname);
    }
    // Methods
    /*Returns the string “OY_ASSISTANT_” */
    public String getEmployeeIdString() {
        return "OY_ASSISTANT_";
    }
    /*Returns a string including the data for the designated course (utilize toString method of the
    DesignatedCourse class) */
    public String getCourses() {
        StringBuilder resultstring = new StringBuilder();
        for(DesignatedCourse course : courses) {
            resultstring.append(course.toString()).append("\n");
        }
        return resultstring.toString();
    }
    /*Sets the given courses (if the given parameter is not null). */
    public void setCourses(List<DesignatedCourse> courses) {
        if (courses != null) {
            this.courses = courses;
        }
    }
    /* The method will output the expected output for an AssistantTeacher. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Teacher id: ").append(getIdString()).append("\n");
        sb.append("First name: ").append(getFirstName()).append(", Last name: ").append(getLastName()).append("\n");
        sb.append("Birthdate: ").append(getBirthDate()).append("\n");
        sb.append("Salary: ").append(String.format("%.2f", calculatePayment())).append("\n");
        sb.append("Assistant for courses:").append("\n");
        sb.append(getCourses());
        return sb.toString();
    }
}
