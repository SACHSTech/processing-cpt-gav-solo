
import processing.core.PApplet;
import processing.core.PImage;
import ddf.minim.*;

public class Sketch extends PApplet {
  
  PImage img;
  Minim audio;
  Minim audio2;
  AudioPlayer player;
  AudioSample jack;

  float songPosition;
  float songPosInBeats;

  int intBowlX = width/2;
  int intBowlSpeed = 10;

  boolean boolBowlLeft = false;
  boolean boolBowlRight = false;
  boolean boolBowlSpeedUp = false;

  int[] dropObjectsX = {195,343,216,473,216,30,227,199,262,70,228,91,205,386,192,321,294,460,315,127,49,105,243,411,256,410,256,388,380,296,214,140,215,129,304,426,239,328,161,246,70,148,313,481,381,481,299,216,390,473,300,264,123,258,236,367,405,158,114,70,249,82,348,254,95,178,433,354,274,437,181,376,314,34,210,123,271,29,192,357,197,337,183,82,237,190,167,393,306,362,476,296,87,181,167,352,203,336,376,397,387,345,413,180,348,246,134,228,66,312,99,261,359,263,165,356,454,291,193,496,211,249,353,249,68,41,77,156,394,276,491,367,263,369,265,386,90,197,90,335,411,453,447,394,312,196,413,457,490,506,500,475,435,238,485,256,128,111,66,49,66,110,167,294,339,356,339,295,238,361,382,361,290,232,290,421,479,421,361,421,479,363,206,206,217,236,261,289,317,343,362,373,375,248,264,81,142,179,436,370,301,155,221,387,440,379,342,79,127,196,332,282,419,475,500,479,424,123,215,252,13,203,272,416,351,143,401,313,160,105,84,108,163,352,406,427,403,348,206,198,252,273,249,194,118,464,479,341,326,347,486,190,170,178,316,331,192,168,194,54,354,59,185,107,181,455,245,26,132,264,350,283,90,263,256,103};
  int[] dropTiming = {3111,4133,5156,5838,7542,8565,10611,11292,12315,13679,14020,15042,16065,16747,17770,18792,19474,20838,21520,22201,22541,22882,23223,23565,24247,24929,25270,26974,28338,28679,28849,29020,29361,29531,29701,30042,30383,31065,31406,31747,32429,32940,33111,33963,34133,34304,34474,34645,34815,34986,35156,35838,36520,36861,37201,37883,38395,38565,38991,39076,39247,39588,39929,40440,40611,40951,41292,41804,41974,42315,42656,43338,43849,44020,44531,44701,45042,45383,45895,46236,46747,47770,48111,48537,48792,49474,54929,55951,56292,56633,56804,56974,57315,57656,58338,58679,59020,59361,59446,59531,59616,59701,60042,60213,60554,60724,61065,61406,61747,62258,62770,63111,63281,63622,63792,64133,64303,64644,64815,65156,65838,66349,66520,66861,67201,67371,67541,67712,67883,68224,68565,69076,69247,69588,69929,70270,70611,70951,71122,71292,71462,71632,71803,71973,72144,72315,72656,72741,72826,72911,72996,73082,73167,73338,73679,74361,79474,84929,85042,85156,85269,85383,85497,85611,85724,85838,85951,86065,86179,86292,86407,86520,86633,86748,86861,86974,87087,87202,87315,87429,87542,87656,88338,88394,88451,88508,88565,88622,88678,88735,88792,88849,88906,89020,89701,90383,90838,90895,91065,91520,91633,91747,92088,92429,93111,93566,93623,93792,94247,94361,94474,94815,95156,95269,95383,95496,95610,95838,96292,96349,96520,96974,97088,97201,97542,97883,98338,98451,98565,98678,98792,98905,99019,99247,99360,99474,99587,99701,99929,100270,100383,100497,100610,100724,100838,101292,101861,101974,102315,102656,102997,103338,103679,103906,104020,104588,104701,105042,105383,105724,106065,106747,107201,107429,107770,108111,108792,109474,112201,114929,117656,120383,122088,123111,124474,131292};
  
  int [] dropObjectsY = new int[276];
  boolean[] dropShown = new boolean[276];
  boolean[] dropPlayed = new boolean[276];
  
  int combo = 0; 


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
    audio = new Minim(this);
    audio2 = new Minim(this);
    frameRate(60);
    for (int x = 0; x < dropShown.length; x++){
      dropShown[x] = false;
      dropObjectsY[x] = 0;
      dropPlayed[x] = false;
    }
    

    img = loadImage("fruit-catcher-idle.png");

    player = audio.loadFile("audio.mp3");
    player.play();
    jack = audio2.loadSample("soft-hitnormal2.wav");
    //file = new SoundFile(this, "audio.mp3");
    //file.play();
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    int time = millis();
    
    background(0,0,0);
    image(img, intBowlX, height - 50);
    //System.out.println(combo )

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
    fill(255,255,255);

    for (int i = 0; i < dropObjectsX.length; i++){
      if (time >= (dropTiming[i]) && time <= (dropTiming[i] + 750)){
        dropShown[i] = true;

      }
      if (dropShown[i]){
        ellipse(dropObjectsX[i] * 2, dropObjectsY[i] , 60, 60);
        dropObjectsY[i] += 15.111111111111;
      }
      if (dropObjectsY[i] >= 670 && dropObjectsY[i] <= 720){
        if (dropObjectsX[i] * 2 > intBowlX && dropObjectsX[i] * 2 < (intBowlX + 305) && dropPlayed[i] == false){
          dropPlayed[i] = true;
          dropShown[i] = false;
          jack.trigger();

          combo += 1;
        }
        // Remeber about where the y value is
      }
      
    }
  }
    


	  
	// sample code, delete this stuff
  
  
  public void drops(){
    
  }
  // define other methods down here.
  public void keyPressed() {

    if (key == 'a'){
      boolBowlLeft = true;
    }
    if (key == 'd'){
      boolBowlRight = true;
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


