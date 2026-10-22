package janetCOMP;

public class Main {
    public static void main(String[] args) {
        Member member1 = Member.registerMember(
                "P101", "Amina", "555-0101", "M101", 20, 0.0);

        Member member2 = Member.registerMember(
                "P102", "Daniel", "555-0102", "M102", 25,
                "Student", 5.0);

        System.out.println("Member registrations successful.");

        member1.displayBasicDetails();
        member2.displayBasicDetails();

        Librarian librarian = new Librarian(
                "P201", "Grace", "555-0201", "S201",
                "Reference", 4200.00, 30, 120);

        SeniorLibrarian seniorLibrarian = new SeniorLibrarian(
                "P202", "Michael", "555-0202", "S202",
                "Archives", 5200.00, 40, 160,
                "Archives", 500.00);

        LibraryAssistant assistant = new LibraryAssistant(
                "P203", "Ruth", "555-0203", "S203",
                "Circulation", 3200.00, "Evening", 200.00);

        LibraryStaff[] staffMembers = {
            librarian,
            seniorLibrarian,
            assistant
        };

        for (LibraryStaff staff : staffMembers) {
            staff.displayStaffDetails();
            System.out.printf("Monthly compensation: $%.2f%n",
                    staff.calculateMonthlyCompensation());
        }

        System.out.printf("Late fee at default rate: $%.2f%n",
                librarian.calculateLateFee(3));

        System.out.printf("Late fee at supplied rate: $%.2f%n",
                librarian.calculateLateFee(3, 1.50));

        Reportable report = librarian;
        report.generateReport();

        Reservable reservation = librarian;
        reservation.reserveBook("B1001");
        reservation.reserveBook("");

        try {
            Member.registerMember(
                    "P103", "Alex", "555-0103", "M103",
                    17, 0.0);
        } catch (IllegalArgumentException exception) {
            System.out.println("Registration failed: "
                    + exception.getMessage());
        }

        System.out.println("Total people: " + Person.getPersonCount());
        System.out.println("Total members: " + Member.getMemberCount());
        System.out.println("Total staff: " + LibraryStaff.getStaffCount());
    }
}
