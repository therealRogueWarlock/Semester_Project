package dk.colourit.model;


import parser.ParserException;
import parser.XmlJsonParser;

import java.io.*;


public class ColourItFileHandler {


    public static void saveToBinary(ProjectList list) throws IOException {
        String filename = "projectList.bin";
        File file = new File(filename);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);

        ProjectList projectList = list;

        out.writeObject(projectList);
        out.close();

        System.out.println("End of data writing: " + file.getAbsolutePath());

        //should save project list to binary file.
    }
    public static void saveToBinary(TeamMemberList list) throws IOException {
        String filename = "teamMemberList.bin";
        File file = new File(filename);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);

        TeamMemberList teamMemberList = list;

        out.writeObject(teamMemberList);
        out.close();

        System.out.println("End of data writing: " + file.getAbsolutePath());
        //should save team member list to binary file.
    }

    public static void saveToXML(ProjectList list)
    {
        XmlJsonParser parser = new XmlJsonParser();

        try {
            parser.toXml(list, "ProjectData.xml");
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }

}