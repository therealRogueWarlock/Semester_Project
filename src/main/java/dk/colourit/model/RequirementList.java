package dk.colourit.model;

import java.io.Serializable;
import java.util.ArrayList;

public class RequirementList implements Serializable {
	private final ArrayList<Requirement> requirements;

	public RequirementList( ) {
		requirements = new ArrayList<>();
	}

	public ArrayList<Requirement> getRequirements( ) {
		return requirements;
	}

	public Requirement getRequirementByName(String requirementName) {
		for (Requirement requirement : requirements) {
			if (requirement.getRequirementName().equals(requirementName)) {
				return requirement;
			}
		}
		return null;
	}

	public RequirementList getPriorityList( ) {
		RequirementList priorityList = new RequirementList();
		for (Requirement requirement : requirements) {
			if (requirement.getPriority() > 0) {
				priorityList.addRequirement(requirement);
			}
		}
		return priorityList;
	}

	public void addRequirement(Requirement requirement) {
		requirements.add(requirement);
	}

	public void removeRequirement(String requirementName) {
		for (Requirement requirement : requirements) {
			if (requirement.getRequirementName().equalsIgnoreCase(requirementName)) {
				requirements.remove(requirement);
				break;
			}
		}
	}

	public ArrayList<Requirement> getFinishedRequirements( ) {
		ArrayList<Requirement> returnArrayList = new ArrayList<>();
		for (Requirement requirement : requirements
		) {
			if (requirement.getStatus().equalsIgnoreCase("Finished"))
				returnArrayList.add(requirement);
		}
		return returnArrayList;
	}
}
