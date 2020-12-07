package dk.colourit.model;

import java.util.ArrayList;

public class RequirementList {

    private ArrayList<Requirement> requirements;

    public RequirementList() {
        requirements = new ArrayList<>();
    }

//    public RequirementList(ArrayList<Requirement> requirements) {
//        this.requirements = requirements;
//    }

    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    public Requirement getRequirementByName(String requirementName) {

        for (Requirement requirement : requirements) {
            if (requirement.getName().equals(requirementName)) {
                return requirement;
            }
        }

        return null;
    }

    public RequirementList getPriorityList() {
        RequirementList priorityList = new RequirementList();

        for (Requirement requirement : requirements) {
            if (requirement.isHighPriority()) {
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
            if (requirement.getName().equalsIgnoreCase(requirementName)) {
                requirements.remove(requirement);
                break;
            }
        }
    }
}
