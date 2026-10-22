package janetCOMP;

public abstract class Person {
    private final String personId;
    private final String name;
    private final String phoneNumber;

    private static int personCount = 0;

    protected Person(String personId, String name, String phoneNumber) {
        this.personId = personId;
        this.name = name;
        this.phoneNumber = phoneNumber;

        personCount++;
    }

    public static int getPersonCount() {
        return personCount;
    }

    public abstract String getRoleDescription();

    public void displayBasicDetails() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Person ID: " + personId
                + ", Name: " + name
                + ", Phone: " + phoneNumber
                + ", Role: " + getRoleDescription();
    }
}