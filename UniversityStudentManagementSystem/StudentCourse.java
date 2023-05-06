public class StudentCourse {
    // Attributes //
    private Course course;
    private int gradeNum;
    private int yearCompleted;

    // Constructors//
    public StudentCourse() {
    }

    /*
     * The constructor will set the given course, gradeNum and
     * yearCompleted for the course. Preferably, for the gradeNum the
     * method setGrade should be used.
     */
    public StudentCourse(Course course, final int gradeNum, final int yearCompleted) {
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }

    // Methods//
    /* Returns the course. */
    public Course getCourse() {
        return this.course;
    }

    /* The method will set the course */
    public void setCourse(Course course) {
        this.course = course;
    }

    /* The method will return gradeNum. */
    public int getGradeNum() {
        return this.gradeNum;
    }

    /*
     * Protected method (to be utilized from Main). The
     * method will check whether the course is graded
     * numerically or not.
     * - If the course is graded numerically, the given value
     * must be within the range (0 <= gradenum <= 5)
     * - If the course has letter grading, the value must be
     * either ‘F’ or ‘A’.
     */
    protected void setGrade(int gradeNum) {
        if (checkGradeValidity(gradeNum) == true && course.isNumericGrade() == true) {
            this.gradeNum = gradeNum;
        } else if (checkGradeValidity(gradeNum) == true && course.isNumericGrade() == false) {
            this.gradeNum = (char) gradeNum;
        }

        if (yearCompleted == 0) {
            this.yearCompleted = ConstantValues.CURRENTYEAR;
        }
    }

    /*
     * m Private method. The method will check whether the
     * given value is acceptable (0-5 or ‘F’ or ‘A’). Only if the
     * value is acceptable, the method will return true.
     */
    private boolean checkGradeValidity(final int gradeNum) {
        if (course.isNumericGrade() == true) {
            if (ConstantValues.MIN_GRADE <= gradeNum && gradeNum <= ConstantValues.MAX_GRADE) {
                return true;
            }
        } else if (course.isNumericGrade() == false) {
            if (gradeNum == ConstantValues.GRADE_FAILED || gradeNum == ConstantValues.GRADE_ACCEPTED) {
                return true;
            }
        }
        return false;
    }

    /*
     * The method will return false in case grade is MIN_GRADE
     * or GRADE_FAILED, otherwise the method will return
     * true.
     */
    public boolean isPassed() {
        if ((ConstantValues.MIN_GRADE < gradeNum && gradeNum <= ConstantValues.MAX_GRADE)
                || gradeNum == ConstantValues.GRADE_ACCEPTED) {
            return true;
        }
        return false;
    }

    /* The method will return yearCompleted. */
    public int getYear() {
        return this.yearCompleted;
    }

    /*
     * The method will set the yearCompleted if the given value
     * is within the range
     * 2000 < year <= currentYear
     */
    public void setYear(final int year) {
        if (2000 < year && year <= ConstantValues.CURRENTYEAR) {
            this.yearCompleted = year;
        }
    }

    /*
     * The method will output the expected output for an
     * object of type StudentCourse.
     * Note – if the grade is 0 (zero), the output for the grade
     * will be “Not graded” (see below). Otherwise, if the grade
     * is numeric, the numeric grade will be shown – if the
     * grade is a letter (‘A’ or ‘F’) the lette
     */
    public String toString() {
        String gradestring = "Not graded";
        if (course.isNumericGrade() == true && ConstantValues.MIN_GRADE < gradeNum
                && gradeNum <= ConstantValues.MAX_GRADE) {
            gradestring = Integer.toString(gradeNum);
        } else if (course.isNumericGrade() == false
                && (gradeNum == ConstantValues.GRADE_FAILED || gradeNum == ConstantValues.GRADE_ACCEPTED)) {
            gradestring = String.valueOf((char) gradeNum);
        }
        return "[" + course.toString() + " Year: " + getYear() + ", Grade: " + gradestring + ".]";
    }
}
