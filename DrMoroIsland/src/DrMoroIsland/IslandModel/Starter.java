package DrMoroIsland.IslandModel;

import DrMoroIsland.IslandGuide.AnimalClassesGuide;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Starter {
    public void setIslandParameters () {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = builder.parse(new File("C://test/islandFile.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NodeList height = document.getDocumentElement().getElementsByTagName("width").item(0).getChildNodes();
        int islandHeight = Integer.parseInt(height.item(0).getNodeValue());

        NodeList width = document.getDocumentElement().getElementsByTagName("width").item(0).getChildNodes();
        int islandWidth = Integer.parseInt(width.item(0).getNodeValue());

        HashMap<Class, Integer> appearedAnimals = new HashMap<>();

        NodeList myIslandAnimals = document.getDocumentElement().getElementsByTagName("animal");
        for (int i = 0; i < myIslandAnimals.getLength(); i++) {
            Node myIslandAnimal = myIslandAnimals.item(i);
            NamedNodeMap attributes = myIslandAnimal.getAttributes();

            int numberOfAnimal = Integer.parseInt(attributes.getNamedItem("count").getNodeValue());

            if (numberOfAnimal > 0) {
                appearedAnimals.put(AnimalClassesGuide.getAnimalClassesForXmlfile().get(attributes.getNamedItem("class").getNodeValue()),
                        Integer.parseInt(attributes.getNamedItem("count").getNodeValue()));
            }
        }

        try {
            IslandModel.islandCreate(islandHeight, islandWidth, appearedAnimals);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
