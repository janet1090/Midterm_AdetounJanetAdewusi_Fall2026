package janetCOMP;

public abstract class LibraryStaff extends Person {
    private final String staffId;
    private final String department;
    private final double monthlySalary;

    private static int staffCount = 0;

    protected LibraryStaff(String personId, String name, String phoneNumber,
                           String staffId, String department,
                           double monthlySalary) {
        super(personId, name, phoneNumber);

        this.staffId = staffId;
        this.department = department;
        this.monthlySalary = monthlySalary;

        staffCount++;
    }

    public static int getStaffCount() {
        return staffCount;
    }

    protected double getMonthlySalary() {
        return monthlySalary;
    }

    public abstract double calculateMonthlyCompensation();

    public void displayStaffDetails() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Staff ID: " + staffId
                + ", Department: " + department
                + ", Monthly Salary: $" + monthlySalary;
    }
}
