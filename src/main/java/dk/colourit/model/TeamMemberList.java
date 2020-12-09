package dk.colourit.model;

import java.util.ArrayList;

public class TeamMemberList {

    private ArrayList<TeamMember> teamMembers;

    public TeamMemberList() {
        teamMembers = new ArrayList<>();
    }

    public ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public TeamMember getTeamMember(String searchMethod, String searchTerm) {

        if (searchMethod.equalsIgnoreCase("id")) {
            for (TeamMember teamMember : teamMembers) {
                if (teamMember.getEmployeeNumber() == Integer.parseInt(searchTerm))
                    return teamMember;
            }
        }

        if (searchMethod.equalsIgnoreCase("name")) {
            for (TeamMember teamMember : teamMembers) {
                if (teamMember.getName().equalsIgnoreCase(searchTerm))
                    return teamMember;
            }
        }
        return null;
    }

    public void addTeamMember(TeamMember teamMember) {
        teamMembers.add(teamMember);
    }

    public void removeTeamMember(TeamMember teamMember) {

        teamMembers.remove(teamMember);

    }

}
