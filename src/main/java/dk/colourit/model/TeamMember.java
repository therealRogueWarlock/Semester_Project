package dk.colourit.model;

import java.io.Serializable;

public class TeamMember implements Serializable
{
    private String memberName;
    private int employeeNumber;
    private String role;
    /*
    0 = Team Member
    1 = Product Owner
    2 = Scrum Master
    3 = Project Creator
     */
    private MyDate birthday;

    public TeamMember(String MemberName, int employeeNumber, MyDate birthday)
    {
        this.memberName = MemberName;
        this.employeeNumber = employeeNumber;
        this.birthday = birthday;
//        setRole("Team Member");
    }

    public String getMemberName()
    {
        return memberName;
    }

    public void setMemberName(String memberName)
    {
        this.memberName = memberName;
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
        return memberName + " | ID: " + employeeNumber;
    }

    public TeamMember getCopy(){
        return new TeamMember(memberName,employeeNumber,birthday);
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
