import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

 class fruits {
  int x;
  int y;
  boolean shown;

  public int getX(){
    return x;
  }
  public void setX(int x){
    this.x = x;
  }
  public int getY(){
    return y;
  }
  public void setY(int y){
    this.y = y;
  }
  public boolean getShown(){
    return shown;
  }
  public void setShown (boolean shown){
    this.shown = shown;
  }
}

public class Sketch extends PApplet {
  

  PImage img;

  int intBowlX = width/2;
  int intBowlSpeed = 10;

  boolean boolBowlLeft = false;
  boolean boolBowlRight = false;
  boolean boolBowlSpeedUp = false;

  ArrayList<fruits> fruitslist = new ArrayList<fruits>();

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

    if (boolBowlSpeedUp){
      intBowlSpeed = 25;
    }
    else{
      intBowlSpeed = 10;
    }
    if (boolBowlLeft) {
      intBowlX -= intBowlSpeed;
    }
    if (boolBowlRight){
      intBowlX += intBowlSpeed;
    }


	  
	// sample code, delete this stuff
  

  }
  public void drops(){

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
    if (key == ' '){
      boolBowlSpeedUp = true;
    }
  }
  public void keyReleased() {
    if (key == 'a'){
      boolBowlLeft = false;
    }
    if (key == 'd'){
      boolBowlRight = false;
    }
    if (key == ' '){
      boolBowlSpeedUp = false;
    }
  }
}
