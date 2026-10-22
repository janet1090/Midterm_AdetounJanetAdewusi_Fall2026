package janetCOMP;

public class Member extends Person {
    private final String memberNumber;
    private final int age;
    private final String membershipType;
    private double outstandingFees;

    private static int memberCount = 0;

    private Member(String personId, String name, String phoneNumber,
                   String memberNumber, int age, String membershipType,
                   double outstandingFees) {
        super(personId, name, phoneNumber);

        this.memberNumber = memberNumber;
        this.age = age;
        this.membershipType = membershipType;
        this.outstandingFees = outstandingFees;

        memberCount++;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    @Override
    public String getRoleDescription() {
        return "Library Member";
    }

    public static Member registerMember(String personId, String name,
            String phoneNumber, String memberNumber, int age,
            double outstandingFees) {
        if (personId == null || personId.trim().equals("")
                || name == null || name.trim().equals("")
                || phoneNumber == null || phoneNumber.trim().equals("")
                || memberNumber == null || memberNumber.trim().equals("")
                || age < 18 || outstandingFees < 0) {
            throw new IllegalArgumentException(
                    "Invalid member registration details.");
        }

        return new Member(personId, name, phoneNumber, memberNumber, age,
                "Basic", outstandingFees);
    }

    public static Member registerMember(String personId, String name,
            String phoneNumber, String memberNumber, int age,
            String membershipType, double outstandingFees) {
        if (personId == null || personId.trim().equals("")
                || name == null || name.trim().equals("")
                || phoneNumber == null || phoneNumber.trim().equals("")
                || memberNumber == null || memberNumber.trim().equals("")
                || membershipType == null
                || membershipType.trim().equals("")
                || age < 18 || outstandingFees < 0) {
            throw new IllegalArgumentException(
                    "Invalid member registration details.");
        }

        return new Member(personId, name, phoneNumber, memberNumber, age,
                membershipType, outstandingFees);
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Member Number: " + memberNumber
                + ", Age: " + age
                + ", Membership Type: " + membershipType
                + ", Outstanding Fees: $" + outstandingFees;
    }
}
