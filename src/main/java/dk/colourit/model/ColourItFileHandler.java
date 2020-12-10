package dk.colourit.model;


import parser.ParserException;
import parser.XmlJsonParser;


public class ColourItFileHandler {


    public static void save(ProjectList list)
    {
        saveToXML(list);
    }

    private static void saveToXML(ProjectList list)
    {

        XmlJsonParser parser = new XmlJsonParser();

        try {
            parser.toXml(list, "dataObjects.xml");
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }










}