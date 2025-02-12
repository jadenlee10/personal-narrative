import org.code.theater.*;
import org.code.media.*;

public class Story extends Scene {

    /* 
    Instantiating arrays for agents, guns categories, 
    and maps with associated images or text.
    */
private String[] agents;
private ImageFilter[] agentsIcon;

 private String[] guns;
  private ImageFilter[] gunsIcon;
  
  private String[][] maps;
  private ImageFilter[][] mapsIcon;
  
  //Constructor
  public Story(String[] agents, ImageFilter[] agentsIcon, String[] guns, ImageFilter[] gunsIcon, String[][] maps, ImageFilter[][] mapsIcon){
     this.agents = agents;
     this.agentsIcon = agentsIcon;
     
     this.guns = guns;
    this.gunsIcon = gunsIcon;
     this.maps = maps;
     this.mapsIcon = mapsIcon;
   }


 /*
   drawScene() Method calls all the individual methods to render 
    the different sections of the scene, displaying different 
    the info from the arrays
    */
  public void drawScene(){
   drawIntro();
    drawAgentsScreen();
    drawGunsScene();
   drawMapsScene();
  }

   /*
    drawIntro() is the introduction and displays the title,
    displays the Valorant photo
     and starts the background music
    */
public void drawIntro(){
  clear("white");
  drawText("Valorant Guide", 140, 60);
  pause(.5);
  drawImage("valorant.png", 100, 120, 200);
//downloads.khinsider.com/game-soundtracks/album/valorant-official-soundtrack-2024/10.%2520Ascent%2520Map%2520Theme.mp3
  playSound("10.-Ascent-Map-Theme.wav");
  pause(1.5);
}


  /*
    This method handles displaying the agents intro section,
    showing the agents categories that Valorant use 
    and displays images of the categories
    */
public void drawAgentsScreen(){
  clear("white");
  setTextHeight(30);
drawText("Different Types of Agents", 50,40);
  pause(1);
  setTextHeight(20);
  drawText(agents[0], 40, 75); 
  drawImage(agentsIcon[0], 40, 100, 110);
  pause(0.5);
  drawText(agents[1], 40, 260);
  drawImage(agentsIcon[1], 40, 270, 110 );
  pause(0.5);
   drawText(agents[2], 260, 75);
  drawImage(agentsIcon[2], 250, 100, 110 );
pause(0.5);
   drawText(agents[3], 240, 260);
  drawImage(agentsIcon[3], 250, 270, 110 );
  pause(1.5);
}
 /*
    drawPrimary() Method shows the primary weapons in the game, (traversing the first row of the guns and guns 1d arrays)
    displaying each weapon and its image, applying filters based on the name of the weapon
    */
public void drawGunsScene() {
    clear("white");
    setTextHeight(30);
    drawText("VALORANT GUNS", 50, 40);
    pause(1);
    setTextHeight(20);

    // Predefined positions for each gun
    int[][] positions = {
        {40, 75, 40, 100},   // Gun 1
        {40, 260, 40, 270},  // Gun 2
        {220, 75, 250, 100}, // Gun 3
        {220, 260, 250, 270}  // Gun 4
    };

    // Display guns and images
    for (int i = 0; i < guns.length; i++) {
        int x = positions[i][0];
        int y = positions[i][1];
        int xx = positions[i][2];
        int yy = positions[i][3];

        drawText(guns[i], x, y);
        drawImage(gunsIcon[i], xx, yy, 150);
        pause(0.5);
    }

    // Apply filters (contrast or saturate)
    for (int i = 0; i < guns.length; i++) {
        int xx = positions[i][2];
        int yy = positions[i][3];

        String pri = guns[i];
        ImageFilter modifiedImage = gunsIcon[i];

        if (pri.toUpperCase().indexOf("O") == -1) {
            modifiedImage.adjustContrast(3); // Apply contrast
        } else {
            modifiedImage.mirrorVertical(); // Apply mirrorVertical
        }

        drawImage(modifiedImage, xx, yy, 150);
        pause(0.3);
    }

    pause(1.5);
}

  /* 
  drawMapsScene() Method shows the secondary weapons in the game, (traversing the second row of the maps and mapsIcon 2d arrays) 
  displaying each weapon and its image, applying filters based on the name of the weapon
  */
 public void drawMapsScene() {
    clear("white");
    setTextHeight(30);
    drawText("VALORANT MAPS", 20, 40);
    pause(1);
    setTextHeight(20);

    // Position tracking for 2D placement
    int[][] positions = {
        {40, 75, 40, 100},    // Row 1, Col 1
        {40, 260, 40, 270},   // Row 1, Col 2
        {220, 75, 250, 100}, // Row 1, Col 3
        {220, 260, 250, 270}  // Row 1, Col 4
    };

    // Loop through all maps (2D array processing)
    for (int i = 0; i < maps.length; i++) {  
        for (int j = 0; j < maps[i].length; j++) { 
            int index = i * maps[i].length + j; // Convert 2D index to 1D for position tracking
            if (index >= positions.length) continue; // Prevent out-of-bounds errors

            int x = positions[index][0];
            int y = positions[index][1];
            int xx = positions[index][2];
            int yy = positions[index][3];

            drawText(maps[i][j], x, y);
            drawImage(mapsIcon[i][j], xx, yy, 140);
            pause(0.5);
        }
    }

    /*
    Apply filters:
    - If the map name **contains "S"**, apply a **vertical mirror** effect.
    - Otherwise, apply **saturation**.
    */
    for (int i = 0; i < maps.length; i++) {  
        for (int j = 0; j < maps[i].length; j++) { 
            int index = i * maps[i].length + j;
            if (index >= positions.length) continue; // Prevent out-of-bounds errors

            int xx = positions[index][2];
            int yy = positions[index][3];

            if (maps[i][j].toUpperCase().indexOf("E") == -1) {
                mapsIcon[i][j].mirrorHorizontal();
            } else {
                mapsIcon[i][j].saturate(3);
            }

            drawImage(mapsIcon[i][j], xx, yy, 150);
            pause(0.3);
        }
    }

    pause(1.5);
}
  

}