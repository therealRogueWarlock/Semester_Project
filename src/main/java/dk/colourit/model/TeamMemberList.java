package dk.colourit.model;

import java.util.ArrayList;

public class TeamMemberList {

    private ArrayList<TeamMember> teamMembers;

    public TeamMemberList() {
        teamMembers = new ArrayList<>();
    }

    public TeamMemberList(ArrayList<TeamMember> teamMembers) {
        this.teamMembers = new ArrayList<>(teamMembers);
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

    public TeamMemberList getCopy(){
        ArrayList<TeamMember> teamMembersCopy = new ArrayList<>();

        for (TeamMember teamMember: teamMembers){
            teamMembersCopy.add(teamMember.getCopy());
        }
        return new TeamMemberList(teamMembersCopy);
    }

    public TeamMemberList subtractArgListFromThisList(ArrayList<TeamMember> teamMembers){

        for (TeamMember teamMember:teamMembers){
            this.teamMembers.remove(teamMember);
        }

        return this;
    }


}
