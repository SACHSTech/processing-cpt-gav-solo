import processing.core.PApplet;
import processing.core.PIMage;

public class Sketch extends PApplet {

  PImage img;
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
    img = loadImage()
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
	// sample code, delete this stuff

  }
  
  // define other methods down here.
}