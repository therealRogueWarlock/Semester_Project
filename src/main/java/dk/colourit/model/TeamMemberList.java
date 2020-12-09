package dk.colourit.model;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamMemberList {

//	private ArrayList<TeamMember> teamMembers;
	private HashMap<TeamMember, String> teamMembersHash;

	public TeamMemberList() {
		teamMembersHash = new HashMap<>();
	}

	public TeamMemberList(HashMap<TeamMember, String> teamMembers) {
		this.teamMembersHash = new HashMap<>(teamMembers);
	}

	public HashMap<TeamMember, String> getTeamMembers() {
		return teamMembersHash;
	}

	public TeamMember getTeamMember(String searchMethod, String searchTerm) {

		if (searchMethod.equalsIgnoreCase("id")) {
			for (TeamMember teamMember : teamMembersHash.keySet()) {
				if (teamMember.getEmployeeNumber() == Integer.parseInt(searchTerm))
					return teamMember;
			}
		}

		if (searchMethod.equalsIgnoreCase("name")) {
			for (TeamMember teamMember : teamMembersHash.keySet()) {
				if (teamMember.getName().equalsIgnoreCase(searchTerm))
					return teamMember;
			}
		}
		return null;
	}

	public void addTeamMember(TeamMember teamMember, String role) {
		teamMembersHash.put(teamMember, role);
	}

	public void removeTeamMember(TeamMember teamMember) {

		teamMembersHash.remove(teamMember);
	}

	public TeamMemberList getCopy() {
		return new TeamMemberList(teamMembersHash);
	}

	public HashMap<TeamMember,String> getRemainingTeamMembers(HashMap<TeamMember,String> teamMembers) {
		HashMap<TeamMember,String> returnHash = getTeamMembers();

		for (TeamMember teamMember : teamMembers.keySet()) {
			returnHash.remove(teamMember);
		}
		return returnHash;
	}

	public ArrayList<TeamMember> getRemainingTeamMembers(ArrayList<TeamMember> teamMembers) {
		ArrayList<TeamMember> returnArray = toArrayList();

		for (TeamMember teamMember : teamMembers) {
			returnArray.remove(teamMember);
		}
		return returnArray;
	}

	public ArrayList<TeamMember> toArrayList(){
		return new ArrayList<TeamMember>(teamMembersHash.keySet());
	}
}
