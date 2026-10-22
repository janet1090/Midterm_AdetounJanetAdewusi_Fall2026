# Library Management System

Java console application for the Maple Leaf Public Library practical assignment.

## Requirements

- Java 21 or higher
- Eclipse IDE or another Java IDE

## Run the application in Eclipse

1. Open the project in Eclipse.
2. Expand `src`, then expand the `janetCOMP` package.
3. Right-click `Main.java`.
4. Select **Run As → Java Application**.
5. View the results in the Console.

The project is configured with JavaSE-25, which is Java 21 or higher.

## Class hierarchy

- `Person` is an abstract class.
  - `Member` extends `Person`.
  - `LibraryStaff` is an abstract class that extends `Person`.
    - `Librarian` extends `LibraryStaff`.
      - `SeniorLibrarian` extends `Librarian`.
    - `LibraryAssistant` extends `LibraryStaff`.

`Librarian` implements the `Reportable` and `Reservable` interfaces. This combines class inheritance with interfaces, demonstrating hybrid inheritance.

Java classes cannot extend multiple classes. Interfaces provide another way for a class to promise different behaviours without extending multiple classes.

## Object-oriented concepts demonstrated

- Abstract classes and abstract methods: `Person`, `LibraryStaff`
- Inheritance: `Member`, `LibraryStaff`, `Librarian`, `SeniorLibrarian`, `LibraryAssistant`
- Static counters: total people, members, and staff
- Final fields: identity and role-specific information
- Method overloading: `registerMember()` and `calculateLateFee()`
- Method overriding: role descriptions, compensation, and staff details
- Runtime polymorphism: a `LibraryStaff` array calls methods on different staff objects
- Interfaces: `Reportable` and `Reservable`

## Test cases

| Test | Input or action | Expected result | Observed result |
|---|---|---|---|
| 1 | Register a member without a membership type | Registration succeeds with the basic type | Successful |
| 2 | Register a member with the `Student` type | Registration succeeds with the supplied type | Successful |
| 3 | Register a member aged 17 | Registration is rejected | Rejected with an error message |
| 4 | Calculate the fee for 3 overdue days using the default rate | `$3.00` | `$3.00` |
| 5 | Calculate the fee for 3 days at `$1.50` per day | `$4.50` | `$4.50` |
| 6 | Calculate monthly compensation for each staff type | Librarian: `$4,440.00`; Senior Librarian: `$6,020.00`; Assistant: `$3,400.00` | Values displayed |
| 7 | Display counters after creating the valid objects | 5 people, 2 members, 3 staff | 5 people, 2 members, 3 staff |
| 8 | Reserve book `B1001`, then try an empty book ID | First succeeds; second fails | Both messages displayed |