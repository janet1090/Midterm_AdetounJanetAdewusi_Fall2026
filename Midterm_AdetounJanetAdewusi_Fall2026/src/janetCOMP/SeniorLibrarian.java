package janetCOMP;

public class SeniorLibrarian extends Librarian {
    private final String specialization;
    private final double seniorityAllowance;

    public SeniorLibrarian(String personId, String name,
                           String phoneNumber, String staffId,
                           String department, double monthlySalary,
                           int dailyIssueLimit, int booksProcessed,
                           String specialization,
                           double seniorityAllowance) {
        super(personId, name, phoneNumber, staffId, department,
                monthlySalary, dailyIssueLimit, booksProcessed);

        this.specialization = specialization;
        this.seniorityAllowance = seniorityAllowance;
    }

    @Override
    public String getRoleDescription() {
        return "Senior Librarian";
    }

    @Override
    public double calculateMonthlyCompensation() {
        return super.calculateMonthlyCompensation()
                + seniorityAllowance;
    }

    @Override
    public void displayStaffDetails() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Specialization: " + specialization
                + ", Seniority Allowance: $" + seniorityAllowance;
    }
}
