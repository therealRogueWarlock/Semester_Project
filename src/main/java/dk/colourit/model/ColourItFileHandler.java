package dk.colourit.model;


import parser.ParserException;
import parser.XmlJsonParser;


public class ColourItFileHandler {


    public static void saveToBinary(ProjectList list)
    {
        //should save project list to binary file.
    }
    public static void saveToBinary(TeamMemberList list)
    {
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