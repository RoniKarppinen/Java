import java.util.Random;

public abstract class Person extends PersonID {
    // Attributes //
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NOT_AVAILABLE;

    // Constructors //
    /* Setting persons first and last name. */
    public Person(String lname, String fname) {
        setFirstName(fname);
        setLastName(lname);
    }

    // Methods //
    /* By default, returns “No name” */
    public String getFirstName() {
        return this.firstName;
    }

    /* Can be set only if the given name is not null. */
    public void setFirstName(String firstName) {
        if (firstName != null && firstName != ConstantValues.NO_NAME) {
            this.firstName = firstName;
        }
    }

    /* By default, returns “No name” */
    public String getLastName() {
        return this.lastName;
    }

    /* Can be set only if the given name is not null. */
    public void setLastName(String lastName) {
        if (lastName != null && lastName != ConstantValues.NO_NAME) {
            this.lastName = lastName;
        }
    }

    /* Returns the birthDate, by default “Not available” */
    public String getBirthDate() {
        return this.birthDate;
    }

    /*
     * If the given person id is valid (the method will have to call setPersonID),
     * the method will set the attribute
     * birthdate and return it. If the given person id is not valid, the method will
     * return “No change”. The given
     * person id cannot be null.
     */
    public String setBirthDate(String personId) {
        if (setPersonID(personId) == "Ok" && personId != null) {
            int CenturyDigits = 0;
            String Correctbdate = "";
            Correctbdate += personId.substring(0, 2) + "." + personId.substring(2, 4) + ".";
            if (personId.charAt(6) == '+') {
                CenturyDigits = 18;
            } else if (personId.charAt(6) == '-') {
                CenturyDigits = 19;
            } else if (personId.charAt(6) == 'A') {
                CenturyDigits = 20;
            }
            Correctbdate += Integer.toString(CenturyDigits) + personId.substring(4, 6);
            this.birthDate = Correctbdate;
            return birthDate;
        }
        return "No change";
    }

    /*
     * Protected method. The method will calculate a random integer for the range
     * min-max (inclusive).
     */
    protected int getRandomId(final int min, final int max) {
        Random randomnumber = new Random();
        return (min + randomnumber.nextInt(max));
    }

    /* Abstract method (no functionality). */
    public abstract String getIdString();
}
