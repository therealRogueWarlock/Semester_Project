package dk.colourit.model;


import parser.ParserException;
import parser.XmlJsonParser;

import java.io.*;


public class ColourItFileHandler {

    public static void saveToBinary(ProjectList projectList) throws IOException {
        String filename = "projectList.bin";
        File file = new File(filename);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);


        out.writeObject(projectList);
        out.close();

        System.out.println("End of data writing: " + file.getAbsolutePath());

        //should save project list to binary file.
    }


    public static void saveToBinary(TeamMemberList employeeList) throws IOException {
        String filename = "employeeList.bin";
        File file = new File(filename);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);

        out.writeObject(employeeList);
        out.close();

        System.out.println("End of data writing: " + file.getAbsolutePath());
        //should save team member list to binary file.
    }


    public static ProjectList readProjectListFromBin() throws IOException, ClassNotFoundException {

        String filename = "projectList.bin";
        File file = new File(filename);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fis);

        ProjectList projectList = (ProjectList) in.readObject();

        in.close(); // Close the file

        System.out.println("End reading data from file: " + file.getAbsolutePath());

        return projectList;
    }


    public static TeamMemberList readTeamMemberListFromBin() throws IOException, ClassNotFoundException {

        String filename = "employeeList.bin";
        File file = new File(filename);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fis);

        TeamMemberList list1 = (TeamMemberList) in.readObject();

        in.close(); // Close the file

        System.out.println("End reading data from file: " + file.getAbsolutePath());

        return list1;
    }


    public static void saveToXML(ProjectList list) {
        XmlJsonParser parser = new XmlJsonParser();
        try {
            parser.toXml(list, "../Sep_Website/ProjectData.xml");
            System.out.println("Saved Xml file to Website folder");
        } catch (ParserException e) {
            System.out.println(e.getCause() + ": the file was not saved");
        }
    }

    public static void saveToXML(TeamMemberList list) {
        XmlJsonParser parser = new XmlJsonParser();

        try {
            parser.toXml(list, "EmployeeData.xml");
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}