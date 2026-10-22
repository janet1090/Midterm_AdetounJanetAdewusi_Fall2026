package janetCOMP;

public class Librarian extends LibraryStaff
        implements Reportable, Reservable {

    private final int dailyIssueLimit;
    private final int booksProcessed;

    public Librarian(String personId, String name, String phoneNumber,
                     String staffId, String department,
                     double monthlySalary, int dailyIssueLimit,
                     int booksProcessed) {
        super(personId, name, phoneNumber, staffId, department,
                monthlySalary);

        this.dailyIssueLimit = dailyIssueLimit;
        this.booksProcessed = booksProcessed;
    }

    @Override
    public String getRoleDescription() {
        return "Librarian";
    }

    @Override
    public double calculateMonthlyCompensation() {
        return getMonthlySalary() + (booksProcessed * 2.00);
    }

    public double calculateLateFee(int daysOverdue) {
        if (daysOverdue < 0) {
            throw new IllegalArgumentException(
                    "Overdue days cannot be negative.");
        }

        return calculateLateFee(daysOverdue, 1.00);
    }

    public double calculateLateFee(int daysOverdue, double dailyRate) {
        if (daysOverdue < 0 || dailyRate <= 0) {
            throw new IllegalArgumentException(
                    "Overdue days must be non-negative and the rate must be positive.");
        }

        return daysOverdue * dailyRate;
    }

    @Override
    public void generateReport() {
        System.out.println("Librarian Report:");
        displayStaffDetails();
        System.out.println("Monthly Compensation: $"
                + calculateMonthlyCompensation());
    }

    @Override
    public void reserveBook(String bookId) {
        if (bookId == null || bookId.trim().equals("")) {
            System.out.println("Reservation failed: Book ID is required.");
        } else {
            System.out.println("Book " + bookId + " reserved successfully.");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Daily Issue Limit: " + dailyIssueLimit
                + ", Books Processed: " + booksProcessed;
    }
}
