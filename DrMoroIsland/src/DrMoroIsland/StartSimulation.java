package DrMoroIsland;

import java.util.HashMap;

import DrMoroIsland.IslandGuide.AnimalClassesGuide;
import DrMoroIsland.IslandModel.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class StartSimulation {

    public static void main(String[] args) throws Exception {

        new Starter().setIslandParameters();
        IslandLife.islandLifeRun();
    }
}
