package dk.colourit.model;

import java.util.ArrayList;

public class RequirementList {

	private ArrayList<Requirement> requirements;


	public RequirementList(ArrayList<Requirement> requirements) {
		this.requirements = requirements;
	}

	public ArrayList<Requirement> getRequirements() {
		return requirements;
	}


	public Requirement getRequirementByName(String requirementName) {

		for (Requirement requirement:requirements){
			if (requirement.getName().equals(requirementName)){
				return requirement;
			}
		}

		return null;
	}


	public RequirementList getPriorityList() {
		ArrayList<Requirement> returnArray = new ArrayList<>();

		for (Requirement requirement: requirements){
			if (requirement.isHighPriority()){
				returnArray.add(requirement);
			}
		}


		if (returnArray.isEmpty()){
			return null;
		}else{
			return new RequirementList(returnArray);
		}

	}


	public void addRequirement(Requirement requirement) {
		requirements.add(requirement);
	}


	public void removeRequirement(Requirement requirement) {
		requirements.remove(requirement);
	}

}
