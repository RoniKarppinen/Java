public class PersonID {
    // Attributes //
    private String birthDate = ConstantValues.NO_BIRTHDATE;

    // Methods //
    /* Returns the birthDate, by default “Not available” */
    public String getBirthDate() {
        return this.birthDate;
    }

    /*
     * The method will first call the method checkPersonIDNumber, if that is ok, the
     * method
     * will split the given string into format dd. mm.yyyy and check that the 7th
     * character in the person ID is
     * valid (either ‘+’, ‘-‘ or ‘A’, based on the year of birth). The method will
     * also check the given String
     * has a valid date (yymmdd with method checkBirthdate) and that the check mark
     * in the
     * given person id is correct (with method checkValidCharacter).
     * - If the given string does not have 11 characters in it or the 7th character
     * is not a valid one (see
     * method checkPersonIDNumber), the method will return “Invalid birthday!”.
     * - If the given string does not include a valid date (see method
     * checkBirthdate), the method will
     * return “Invalid birthday!”. - If the given string does not have a valid check
     * character (see method checkValidCharacter), the method will return “Incorrect
     * check mark!”.
     * - If the given string is ok, the method will set the birthdate and return
     * “Ok”.
     */
    public String setPersonID(final String personID) {
        if (personID == null) {
            return "Invalid personID!";
        }
        String Correctbdate = "";
        Correctbdate += personID.substring(0, 2) + "." + personID.substring(2, 4) + ".";
        int CenturyDigits = 0;

        if (personID.charAt(6) == '+') {
            CenturyDigits = 18;
        } else if (personID.charAt(6) == '-') {
            CenturyDigits = 19;
        } else if (personID.charAt(6) == 'A') {
            CenturyDigits = 20;
        } else {
            return "Invalid birthday";
        }
        Correctbdate += Integer.toString(CenturyDigits) + personID.substring(4, 6);
        System.out.println(Correctbdate);
        if (checkPersonIdNumber(personID) == false) {
            return "Invalid birthday!";
        } else if (checkBirthdate(Correctbdate) == false) {
            return "Invalid birthday!";
        } else if (checkValidCharacter(personID) == false) {
            return "Incorrect check mark!";
        } else {
            this.birthDate = Correctbdate;
            return "Ok";
        }
    }

    /*
     * Private method. The method will check the given string has 11 characters and
     * that the “century
     * character” in the string is a valid one, ‘+’, ‘-‘ or ‘A’
     */
    private static boolean checkPersonIdNumber(final String personID) {
        if (personID.length() == 11
                && (personID.charAt(6) == '+' || personID.charAt(6) == '-' || personID.charAt(6) == 'A')) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Private method. The method will check whether the given year is a leap year
     * or not (true = leap year).
     */
    private static boolean checkLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Private method. The method will check the last character of the person id is
     * given correctly.
     * Note – here, in this method, the value “221199-123A” can be set to be a valid
     * test value (although
     * not a valid value in real life). The formula for the calculation explained
     * here.
     * https://dvv.fi/en/personal-identity-code
     */
    private static boolean checkValidCharacter(final String personID) {
        String controlCharacters = "0123456789ABCDEFHJKLMNPRSTUVWXY";
        String fnumberString = personID.substring(0, 6);
        String rnumberString = personID.substring(7, 10);
        String WholeNumberString = fnumberString + rnumberString;
        int numbers = Integer.parseInt(WholeNumberString);
        int modulo = numbers % 31;
        if (controlCharacters.charAt(modulo) == personID.charAt(10)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Private method. The method will split the day, month and year from the given
     * string and ensures
     * the given year (positive value), the given month (1-12) and day (1-31) is
     * within those valid ranges. In
     * addition, if the previous conditions are met, the method will have to ensure
     * the given days are valid
     * for the given month. In the possible special case of February, the method
     * will have to ensure the days are correct (28 or 29 depending on whether the
     * year is a leap year or not). The method checkLeapYear is to be used here for
     * this purpose.
     */
    private static boolean checkBirthdate(final String date) {
        if (date.length() == 10) {
            int Days = Integer.parseInt(date.substring(0, 2));
            int Months = Integer.parseInt(date.substring(3, 5));
            int Years = Integer.parseInt(date.substring(6, 9));
            int Max = 0;
            if (Months == 1 || Months == 3 || Months == 5 || Months == 7 || Months == 8 || Months == 10
                    || Months == 12) {
                Max = 31;
            } else if (Months == 4 || Months == 6 || Months == 9 || Months == 11) {
                Max = 30;
            } else if (Months == 2) {
                if (checkLeapYear(Years) == true) {
                    Max = 29;
                } else {
                    Max = 28;
                }
            } else {
                Max = -1;
            }
            return (Max != -1 && Days >= 1 && Days <= Max);
        } else {
            return false;
        }
    }
}
