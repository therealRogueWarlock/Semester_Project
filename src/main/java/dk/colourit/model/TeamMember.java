package dk.colourit.model;

public class TeamMember
{
    private String name;
    private int employeeNumber;
    private String role;
    /*
    0 = Team Member
    1 = Product Owner
    2 = Scrum Master
    3 = Project Creator
     */
    private MyDate birthday;

    public TeamMember(String name, int employeeNumber, MyDate birthday)
    {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.birthday = birthday;
//        setRole("Team Member");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getEmployeeNumber()
    {
        return employeeNumber;
    }

    public void setEmployeeNumber(int number)
    {
        employeeNumber = number;
    }

    public MyDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(MyDate myDate)
    {
        birthday = myDate.copy();
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override public String toString()
    {
        return name + " | ID: " + employeeNumber;
    }

    public TeamMember getCopy(){
        return new TeamMember(name,employeeNumber,birthday);
    }


}

class OutOfRangeException extends RuntimeException
{
    public OutOfRangeException(String message)
    {
        super(message);
    }

    @Override public String toString()
    {
        return "Role couldn't be set: " + super.getMessage();
    }
}
