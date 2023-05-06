public class DesignatedCourse {
    // Attributes
    private Course course;
    private boolean responsible;
    private int year;

    // Constructors
    public DesignatedCourse() {

    }

    public DesignatedCourse(Course course, boolean resp, int year) {
        this.course = course;
        this.year = year;
    }

    // Methods
    /* Returns the course */
    public Course getCourse() {
        return this.course;
    }

    /* Sets the given course (if not null). */
    public void setCourse(Course course) {
        if (course != null) {
            this.course = course;
        }
    }

    /* false = not responsible, true = responsible */
    public boolean isResponsible() {
        return this.responsible;
    }

    /* Sets the given value. */
    public boolean getResponsible() {
        return this.responsible;
    }

    /* Returns the responsible */
    public void setResponsible(boolean responsible) {
        this.responsible = responsible;
    }

    /* Returs the year. */
    public int getYear() {
        return this.year;
    }

    /*
     * The method sets the given year if the value is 2000 <= year <= (current year
     * +1 ).
     */
    public void setYear(int year) {
        if (2000 <= year && year <= ConstantValues.CURRENTYEAR + 1) {
            this.year = year;
        }
    }

    /* The method will output the expected output for a DesignatedCourse. */
    public String toString() {
        return "[course=" + course + ", year=" + getYear() + "]";
    }
}
