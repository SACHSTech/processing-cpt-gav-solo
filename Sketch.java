import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  PImage img;

  int intBowlX = width/2;

  int intBowlSpeed = 10;

  boolean boolBowlLeft = false;
  boolean boolBowlRight = false;

	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1280, 720);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    
    img = loadImage("fruit-catcher-idle.png");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    background(0,0,0);
    image(img, intBowlX, height - 50);

    if (boolBowlLeft) {
      intBowlX -= 10;
    }
    if (boolBowlRight){
      intBowlX += 10;
    }


	  
	// sample code, delete this stuff

  }
  
  // define other methods down here.
  public void keyPressed() {
    System.out.println("keypressed");

    if (key == 'a'){
      boolBowlLeft = true;
      System.out.println("a");
    }
    if (key == 'd'){
      boolBowlRight = true;
      System.out.println("d");

    }
  }
  public void keyReleased() {
    if (key == 'a'){
      boolBowlLeft = false;
    }
    if (key == 'd'){
      boolBowlRight = false;
    }
  }

}
