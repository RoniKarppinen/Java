public class Course {
    // Attributes //
    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private Character courseBase = ' ';
    private int courseType;
    private int period;
    private double credits = 0.0;
    private boolean numericGrade = false;

    // Constructors //
    public Course() {
    }

    /*
     * The constructor must set the attribute values (and check for valid
     * values for most of those – preferably by utilizing methods of the
     * class (setName, setCourseCode, setCourseType, setPeriod, setCredits).
     */
    public Course(String name, final int code, Character courseBase, final int type, final int period,
            final double credits, boolean numericGrade) {
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
    }

    /* The constructor must set the attribute values. */
    public Course(Course course) {
        this.name = course.getName();
        this.courseCode = course.getCourseCode();
        this.courseBase = course.getCourseBase();
        this.courseType = course.getCourseType();
        this.period = course.getPeriod();
        this.credits = course.getCredits();
        this.numericGrade = course.isNumericGrade();
    }

    // Methods //
    /* Returns the course name */
    public String getName() {
        return this.name;
    }

    /*
     * The method will set the name of the course if the name is not empty or null.
     */
    public void setName(String name) {
        String empty = "";
        if (name != null && name != empty) {
            this.name = name;
        }
    }

    /*
     * The method will return the string description of the course type (0 =
     * “Optional” and 1 = “Mandatory”
     */
    public String getCourseTypeString() {
        if (courseType == ConstantValues.MANDATORY) {
            return "Mandatory";
        } else {
            return "Optional";
        }
    }

    /* The method will return the type of the course (0 or 1). */
    public int getCourseType() {
        return this.courseType;
    }

    /* The method will set the type if the value is either 0 or 1. */
    public void setCourseType(final int type) {
        if (type == 0 || type == 1) {
            this.courseType = type;
        }
    }

    /* The method will return the courseCode. */
    public String getCourseCode() {
        return this.courseCode;
    }

    /*
     * If the courseCode is valid (0 < courseCode < 1000000) and courseBase is valid
     * (‘A’, or ‘P’, or ‘S’),
     * the method will set the courseCode as e.g., 811322A
     * (concatenate the courseCode and courseBase) and set the courseBase.
     */
    public void setCourseCode(final int courseCode, Character courseBase) {
        if (0 < courseCode && courseCode < 1000000 && (courseBase == 'A' || courseBase == 'P' || courseBase == 'S')) {
            String courseCodeString = Integer.toString(courseCode);
            String WholeCourseCodeString = courseCodeString + courseBase;
            this.courseCode = WholeCourseCodeString;
            this.courseBase = courseBase;
        }
    }

    /* The method will return the courseBase */
    public Character getCourseBase() {
        return this.courseBase;
    }

    /* The method will return the period of the course. */
    public int getPeriod() {
        return this.period;
    }

    /*
     * The method will set the period if the given period is within the limits
     * (MIN_PERIOD <= period <= MAX_PERIOD).
     */
    public void setPeriod(final int period) {
        if (ConstantValues.MIN_PERIOD <= period && period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }

    /* The method will return the number of credits */
    public double getCredits() {
        return this.credits;
    }

    /*
     * Private method. The method will set the credits if the given value is within
     * the limits
     * (MIN_CREDITS < credits <= MAX_COURSE_CREDITS)
     */
    private void setCredits(final double credits) {
        if (ConstantValues.MIN_CREDITS <= credits && credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    /* The method will return numericGrade */
    public boolean isNumericGrade() {
        return numericGrade;
    }

    /* The method will set numericGrade. */
    public void setNumericGrade(boolean numericGrade) {
        this.numericGrade = numericGrade;
    }

    /* The method will output the expected output for an object of type Course.) */
    public String toString() {
        if (getCredits() < 10) {
            return "[" + getCourseCode() + " ( " + String.format("%.2f", getCredits()) + "cr), " + '"' + getName() + '"'
                    + ". " + getCourseTypeString() + ", period: " + getPeriod() + ".]";
        } else {
            return "[" + getCourseCode() + " (" + String.format("%.2f", getCredits()) + "cr), " + '"' + getName() + '"'
                    + ". " + getCourseTypeString() + ", period: " + getPeriod() + ".]";
        }
    }
}
