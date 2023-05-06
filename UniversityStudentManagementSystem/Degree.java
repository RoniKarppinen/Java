import java.util.ArrayList;
import java.util.List;

public class Degree {
    // Attributes
    static final int MAX_COURSES = 50;
    private String degreeTitle = ConstantValues.NO_TITLE;
    private String titleOfThesis = ConstantValues.NO_TITLE;
    private List<StudentCourse> myCourses = new ArrayList<>(MAX_COURSES);

    // Methods
    /* Returns the courses of this degree. */
    public List<StudentCourse> getCourses() {
        return myCourses;
    }

    /*
     * The method will set the courses if the object is not null and courses can be
     * added. The method should utilize the method addStudentCourse (see below).
     */
    public void addStudentCourses(List<StudentCourse> courses) {
        if (courses != null && myCourses.size() < MAX_COURSES) {
            for (int i = 0; i < courses.size(); i++) {
                addStudentCourse(courses.get(i));
            }
        }
    }

    /*
     * The method will set the course if the method is not null and the number of
     * added courses is less than MAX_COURSES.
     */
    public boolean addStudentCourse(StudentCourse course) {
        if (course != null && myCourses.size() < MAX_COURSES) {
            myCourses.add(course);
            return true;
        }
        return false;
    }

    /* The method returns the degreeTitle. */
    public String getDegreeTitle() {
        return this.degreeTitle;
    }

    /* The method will set the degreeTitle if the given string is not null. */
    public void setDegreeTitle(String degreeTitle) {
        if (degreeTitle != null) {
            this.degreeTitle = degreeTitle;
        }
    }

    /* The method will return the title of the thesis */
    public String getTitleOfThesis() {
        return this.titleOfThesis;
    }

    /* The method will set the titleOfThesis is the given string is not null. */
    public void setTitleOfThesis(String titleOfThesis) {
        if (titleOfThesis != null) {
            this.titleOfThesis = titleOfThesis;
        }
    }

    /*
     * The method will return the sum of the credits for all completed courses for a
     * given base (‘P’, ‘A’ or ‘S’).
     */
    public double getCreditsByBase(Character base) {
        double BaseSum = 0.0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i) != null && myCourses.get(i).isPassed() == true
                    && myCourses.get(i).getCourse().getCourseBase() == base) {
                BaseSum += myCourses.get(i).getCourse().getCredits();
            }
        }
        return BaseSum;
    }

    /*
     * The method will return the sum of the credits for all completed courses for a
     * given type (0 = optional , 1 = mandatory).
     */
    public double getCreditsByType(final int courseType) {
        double TypeSum = 0.0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i) != null && myCourses.get(i).isPassed() == true
                    && myCourses.get(i).getCourse().getCourseType() == courseType) {
                TypeSum += myCourses.get(i).getCourse().getCredits();
            }
        }
        return TypeSum;
    }

    /* The method will return the sum of all completed courses (see below). */
    public double getCredits() {
        double AllCreditSum = 0.0;
        for (int i = 0; i < myCourses.size(); i++) {
            if (myCourses.get(i) != null && myCourses.get(i).isPassed() == true) {
                AllCreditSum += myCourses.get(i).getCourse().getCredits();
            }
        }
        return AllCreditSum;
    }

    /*
     * Private method. The method will returnthe boolean value whether a course is
     * completed or not.
     * - If the course is not null and the course has numeric grading, the course is
     * completed if the grade is > 0. - If the course is not null and the course
     * has letter grading the course is completed if the grade is ‘A’.
     */
    private boolean isCourseCompleted(StudentCourse c) {
        if (c.isPassed() == true) {
            return true;
        } else {
            return false;
        }
    }

    /* The method will output all StudentCourses (which are not null). */
    public void printCourses() {
        for (StudentCourse course : myCourses) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }

    /*
     * The method will calculate the sum, count and average of the given type of
     * courses
     * for the degree (type => OPTIONAL, MANDATORY, ALL) – and store those
     * values to the list (as double values) in that given order (sum, count,
     * average). If
     * there are no courses, the values will be set to 0.0.
     */
    public List<Double> getGPA(int type) {
        List<Double> result = new ArrayList<Double>();
        double sum = 0.0;
        double count = 0.0;
        for (StudentCourse course : myCourses) {
            if (ConstantValues.ALL == type || (course.getCourse().getCourseType() == type)) {
                if (course.getCourse().isNumericGrade() == true) {
                    sum += course.getGradeNum();
                    count++;
                }
            }
        }
        double average = count > 0 ? sum / count : 0.0;
        result.add(sum);
        result.add((double) count);
        result.add(average);
        return result;
    }

    /* The method will output the expected output for an object of type Degree. */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Degree [Title: \"").append(getDegreeTitle()).append("\" (courses: ").append(myCourses.size())
                .append(")\n")
                .append("Thesis title: \"").append(getTitleOfThesis()).append("\"\n");
        for (int i = 0; i < myCourses.size(); i++) {
            sb.append(i + 1).append(". ").append(myCourses.get(i)).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
