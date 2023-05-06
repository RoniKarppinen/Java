public class HourBasedPayment implements Payment {
    private double eurosPerHour;
    private double hours;

    /* The method returns the eurosPerHour */
    public double getEurosPerHour() {
        return eurosPerHour;
    }

    /* The method sets the eurosPerHour if the parameter value is > 0.0. */
    public void setEurosPerHour(double eurosPerHour) {
        if (eurosPerHour > 0.0) {
            this.eurosPerHour = eurosPerHour;
        }
    }

    /* The method returns the hours. */
    public double getHours() {
        return hours;
    }

    /* The method sets the hours if the parameter value is > 0.0. */
    public void setHours(double hours) {
        if (hours > 0.0) {
            this.hours = hours;
        }
    }

    /*
     * The method calculates the salary to be returned (based on hours and
     * eurosPerHour).
     */
    public double calculatePayment() {
        return hours * eurosPerHour;
    }
}