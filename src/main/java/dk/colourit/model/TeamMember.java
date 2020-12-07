package dk.colourit.model;

public class TeamMember {

    private String name;
    private int employeeNumber;
    private int role;
    private MyDate birthday;

    public TeamMember(String name, int employeeNumber, MyDate birthday) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.birthday = birthday;
        setRole(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int number) {
        employeeNumber = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate myDate) {
        birthday = myDate.copy();
    }

    public String getRole() {
        switch (role) {
            case (1):
                return "Product Owner";
            case (2):
                return "Scrum Master";
            case (3):
                return "Project Creator";
            default:
                return "Team Member";
        }
    }

    public void setRole(int role) {
        this.role = role;
    }

}
