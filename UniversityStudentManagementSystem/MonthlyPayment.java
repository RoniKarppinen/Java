public class MonthlyPayment implements Payment {
    // Attributes
    private double salary;

    // Methods
    /* The method returns the salary */
    public double getSalary() {
        return salary;
    }

    /* The method sets the salary if the value is > 0.0 */
    public void setSalary(double salary) {
        if (salary > 0.0) {
            this.salary = salary;
        }
    }

    /* The method returns the salary. */
    public double calculatePayment() {
        return salary;
    }
}
