import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

  //Defines an array of agents categories 
 String[] agents = {"Duelist", "Initiator", "Controller", "Sentinel" };
    // Creates image filters for equipmentIcons
  ImageFilter[] agentsIcon = { new ImageFilter("duelist.png"), new ImageFilter("initiator.png"), new ImageFilter("controller.png"), new ImageFilter("sentinel.png")};

     // Defines an array of guns categories
    String[] guns = {"Pistols", "Shotguns", "Rifles", "Snipers"}; 
        // Creates image filters for categoryIcons
    ImageFilter[] gunsIcon = {new ImageFilter("classic.jpg"), new ImageFilter("shotgun.jpg"), new ImageFilter("rifle.jpg"), new ImageFilter("sniper.jpg")};
 
 // Defines a 2D array for the maps
    String[][] maps =  {{"Lotus", "Ascent", "Abyss", "Haven"},
                            {"Bind", "Icebox", "Breeze", "Fracture"},
                            {"Pearl", "Sunset", "Arc Thrower", "Split"},
                           };
    ImageFilter[][] mapsIcon = {{new ImageFilter("lotus.jpg"), new ImageFilter("ascent.jpg"), new ImageFilter("abyss.jpg"), new ImageFilter("haven.jpg")}};

    //Initializes the Story object with all defined variables/arrays
Story scene = new Story (agents, agentsIcon, guns, gunsIcon, maps, mapsIcon);
    // Draw the scene based on the Story class
    scene.drawScene();
    //Play the Scene in the Theater
    Theater.playScenes(scene);
  }
}
