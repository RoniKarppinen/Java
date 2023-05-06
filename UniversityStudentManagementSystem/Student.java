import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends Person {
    // Attributes //
    private int id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
    private int startYear = ConstantValues.CURRENTYEAR;
    private int graduationYear;
    /*
     * ArrayList of the student’s degree studies (class Degree) (0 = bachelor, 1 =
     * master, 2 = reserved for doctoral studies)
     */
    private List<Degree> degrees = new ArrayList<>();

    // Constructors
    /*
     * The id for the student will also be set in the constructor (note
     * inheritance).
     */
    public Student(String lname, String fname) {
        super(lname, fname);
        setId(id);
        Degree degree1 = new Degree();
        Degree degree2 = new Degree();
        Degree degree3 = new Degree();

        degrees.add(degree1);
        degrees.add(degree2);
        degrees.add(degree3);
    }

    // Methods //
    /* Returns the id. */
    public int getId() {
        return this.id;
    }

    /* Allowed values are 1-100, otherwise not set. */
    public void setId(final int id) {
        if (id >= 1 && id <= 100)
            this.id = id;
        else {
            getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);
        }
    }

    /* By default, current year (if not set). */
    public int getStartYear() {
        return this.startYear;
    }

    /*
     * The year must be after 2000 and cannot be in the future, i.e., 2000 <
     * startYear <= current year.
     */
    public void setStartYear(final int startYear) {
        if (2000 < startYear && startYear <= 2023) {
            this.startYear = startYear;
        }
    }

    /* Returns the graduation year. */
    public int getGraduationYear() {
        return this.graduationYear;
    }

    /*
     * Utilize the method canGraduate here. The graduation year can be set only if
     * the student has
     * a) completed all required credits (both bachelor & masters) plus the titles
     * of both theses are in place and
     * b) the given year is within the timeframe from the start of the studies to
     * this date (neither before the
     * start of the studies nor in the future). If…
     * • a student cannot graduate (above case a), the method will return “Check
     * amount of required credits”.
     * • the given year is invalid (above case b), the method will return “Check
     * graduation year”.
     * • both cases are fine, the method will return “Ok”.
     */
    public String setGraduationYear(final int graduationYear) {
        if (canGraduate() == false) {
            return "Check amount of required credits";
        } else if (startYear > graduationYear && graduationYear > ConstantValues.CURRENTYEAR) {
            return "Check graduation year";
        } else {
            this.graduationYear = graduationYear;
            return "Ok";
        }
    }

    /*
     * The method will set the title for the given degree (see
     * class Degree) if the given index is valid (0 <= i <
     * number of degrees) and the given title is not null
     */
    public void setDegreeTitle(final int i, String dName) {
        if (0 <= i && i < degrees.size() && dName != null && degrees != null) {
            this.degrees.get(i).setDegreeTitle(dName);
        }
    }

    /*
     * The method will add the course for the given degree
     * (see class Degree) if the given index is valid (0 <= i <
     * number of degrees) and the given course is not null.
     */
    public boolean addCourse(final int i, StudentCourse course) {
        if (0 <= i && i < degrees.size() && course != null) {
            if (degrees.get(i).addStudentCourse(course) == true) {
                return true;
            }
        }
        return false;
    }

    /*
     * The method will add the courses for the given degree
     * (see class Degree) if the given index is valid (0 <= i <
     * number of degrees) and the given ListArray or single
     * course is not null. The method will return the number
     * of added courses.
     */
    public int addCourses(final int i, List<StudentCourse> courses) {
        int coursecount = 0;
        if (0 <= i && i < degrees.size() && courses != null && courses.size() > 0) {
            for (StudentCourse course : courses) {
                if (addCourse(i, course)) {
                    coursecount += 1;
                }
            }
        }
        return coursecount;
    }

    /*
     * The method will print all the student’s possible
     * courses from all degrees (not null values). See classes
     * Degree and StudentCourse.
     */
    public void printCourses() {
        for (int j = 0; j < degrees.size(); j++) {
            for (int i = 0; i < degrees.get(j).getCourses().size(); i++) {
                if (degrees.get(j).getCourses().get(i) != null) {
                    System.out.println(degrees.get(j).getCourses().get(i));
                }
            }
        }
    }

    /*
     * The method will print all the student’s degrees (not
     * null values). See class Degree.
     */
    public void printDegrees() {
        for (int i = 0; i < degrees.size(); i++) {
            System.out.println(degrees.get(i).toString());
        }
    }

    /*
     * The method will set the title for the given thesis (see
     * class Degree) if the given index is valid (0 <= i <
     * degreeCount) and the given title is not null.
     */
    public void setTitleOfThesis(final int i, String title) {
        if (0 <= i && i < degrees.size() && title != null) {
            this.degrees.get(i).setTitleOfThesis(title);
        }
    }

    /*
     * Returns the information whether the student has
     * graduated or not (based on the graduationYear).
     */
    public boolean hasGraduated() {
        if (canGraduate() == true && graduationYear > 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Private method. The method will check the required
     * studies for graduation, i.e., the student has enough of
     * required credits (all and mandatory, for both bachelor
     * and masters) and the student has titles for both
     * theses (bachelor and masters).
     * Use ConstantValues.BACHELOR_MANDATORY,
     * ConstantValues.MASTER_MANDATORY,
     * ConstantValues.BACHELOR_CREDITS and
     * ConstantValues.MASTER_CREDITS.
     */
    private boolean canGraduate() {
        if ((ConstantValues.BACHELOR_CREDITS <= degrees.get(0).getCredits()
                && degrees.get(0).getTitleOfThesis() != ConstantValues.NO_TITLE
                && ConstantValues.BACHELOR_MANDATORY <= degrees.get(0).getCredits()) &&
                (ConstantValues.MASTER_CREDITS <= degrees.get(1).getCredits()
                        && degrees.get(1).getTitleOfThesis() != ConstantValues.NO_TITLE
                        && ConstantValues.MASTER_MANDATORY <= degrees.get(1).getCredits())) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * The method will check if the student has graduated or
     * not and will return the number of years used for the
     * studies.
     */
    public int getStudyYears() {
        if (hasGraduated() == true) {
            return (graduationYear - startYear);
        } else {
            return (ConstantValues.CURRENTYEAR - startYear);
        }
    }

    /*  */
    public String status() {
        if (hasGraduated() == true) {
            return "Status: The student has graduated in " + getGraduationYear() + "\n";
        } else {
            return "Status: The student has not graduated, yet." + "\n";
        }
    }

    /*
     * Own method. Checks if the student has the required credits for the Bachelors
     * and will print out the output according to the amount Bachelors credits
     */
    public String checkCreditsForBachelor() {
        if (degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS) {
            return "Total bachelor credits completed (" + degrees.get(0).getCredits() + "/180) \n";
        } else {
            return "Missing bachelor credits " + (180.0 - (double) degrees.get(0).getCredits()) + " ("
                    + degrees.get(0).getCredits() + "/180) \n";
        }
    }

    /*
     * Own method. Checks if the student has the required credits for the Masters
     * and will print out the output according to the amount Masters credits
     */
    public String checkCreditsForMasters() {
        if (degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS) {
            return "Total master's credits completed (" + degrees.get(1).getCredits() + "/120) \n";
        } else {
            return "Missing master's credits " + (120.0 - (double) degrees.get(1).getCredits()) + " ("
                    + degrees.get(1).getCredits() + "/120) \n";
        }
    }

    /*
     * Own method. Checks if the student has the required mandatory credits for the
     * Bachelors and will print out the output according to the amount Bachelors
     * credits
     */
    public String checkMandatoryCreditsForBachelor() {
        if (degrees.get(0).getCreditsByType(1) >= ConstantValues.BACHELOR_MANDATORY) {
            return "All mandatory bachelor credits completed (" + degrees.get(0).getCredits() + "/150) \n";
        } else {
            return "Missing mandatory bachelor credits " + (150.0 - (double) degrees.get(0).getCreditsByType(1)) + " ("
                    + degrees.get(0).getCredits() + "/150) \n";
        }
    }

    /*
     * Own method. Checks if the student has the required mandatory credits for the
     * Masters and will print out the output according to the amount Masters credits
     */
    public String checkMandatoryCreditsForMasters() {
        if (degrees.get(1).getCreditsByType(1) >= ConstantValues.MASTER_MANDATORY) {
            return "All mandatory master credits completed (" + degrees.get(1).getCredits() + "/50) \n";
        } else {
            return "Missing mandatory master's credits " + (50.0 - (double) degrees.get(1).getCreditsByType(1)) + " ("
                    + degrees.get(1).getCredits() + "/50) \n";
        }
    }

    /* The method will output the expected output for a student. */
    public String toString() {
        List<Double> BachelorAllInfo = degrees.get(0).getGPA(ConstantValues.ALL);
        List<Double> MasterAllInfo = degrees.get(1).getGPA(ConstantValues.ALL);
        double sumBachelorGrades = BachelorAllInfo.get(0);
        double countBachelorCourses = BachelorAllInfo.get(1);
        double sumMasterGrades = MasterAllInfo.get(0);
        double countMasterCourses = MasterAllInfo.get(1);
        double totalGPA = ((sumBachelorGrades + sumMasterGrades) / (countBachelorCourses + countMasterCourses));
        double BachelorGPA = (sumBachelorGrades / countBachelorCourses);
        double MasterGPA = (sumMasterGrades / countMasterCourses);
        StringBuilder sb = new StringBuilder();
        double creditSum = 0.0;
        sb.append("Student id:").append(id).append("\n")
                .append("First Name: ").append(getFirstName()).append(", Last Name: ").append(getLastName())
                .append("\n")
                .append("Date of birth: ").append(getBirthDate()).append("\n")
                .append(status()).append("\n")
                .append("Start year: ").append(startYear).append(" (studies have lasted for ").append(getStudyYears())
                .append(" years)").append("\n")
                .append("Total Credits: ");
        for (int i = 0; i < degrees.size(); i++) {
            creditSum += degrees.get(i).getCredits();
        }
        sb.append(creditSum).append(" [GPA = ").append(String.format("%.2f", totalGPA)).append(")").append("\n")
                .append("Bachelor credits: ").append(degrees.get(0).getCredits()).append("\n")
                .append(checkCreditsForBachelor())
                .append(checkMandatoryCreditsForBachelor())
                .append("GPA of Bachelor studies: ").append(String.format("%.2f", BachelorGPA)).append("\n")
                .append("Title of BSc Thesis: ").append('"').append(degrees.get(0).getTitleOfThesis()).append('"')
                .append("\n")
                .append("Master credits: ").append(degrees.get(1).getCredits()).append("\n")
                .append(checkCreditsForMasters())
                .append(checkMandatoryCreditsForMasters())
                .append("GPA of Master studies: ").append(String.format("%.2f", MasterGPA)).append("\n")
                .append("Title of MSc Thesis: ").append('"').append(degrees.get(1).getTitleOfThesis()).append('"')
                .append("\n");
        String result = sb.toString();
        return result;
    }

    /*
     * The method will return a string of a user id (“Student
     * id: nnn”).
     */
    public String getIdString() {
        return "Student id: " + getId();
    }

}
