
import processing.core.PApplet;
import processing.core.PImage;
import ddf.minim.*;

public class Sketch extends PApplet {

  // PImage variable
  PImage img;

  // Audio Varabiles
  Minim audio;
  AudioPlayer player;
  AudioPlayer playerTwo;
  AudioSample jack;

  // Song 1 position variable
  float songPosition;


  // Bowl Varaibles
  int intBowlX = width/2;
  int intBowlSpeed = 10;


  // Movement variables
  boolean boolBowlLeft = false;
  boolean boolBowlRight = false;
  boolean boolBowlSpeedUp = false;

  // Song 1 arrays
  int[] dropObjectsY = new int[276];
  int[][]dropObjectsXandYandTime = {{195,343,216,473,216,30,227,199,262,70,228,91,205,386,192,321,294,460,315,127,49,105,243,411,256,410,256,388,380,296,214,140,215,129,304,426,239,328,161,246,70,148,313,481,381,481,299,216,390,473,300,264,123,258,236,367,405,158,114,70,249,82,348,254,95,178,433,354,274,437,181,376,314,34,210,123,271,29,192,357,197,337,183,82,237,190,167,393,306,362,476,296,87,181,167,352,203,336,376,397,387,345,413,180,348,246,134,228,66,312,99,261,359,263,165,356,454,291,193,496,211,249,353,249,68,41,77,156,394,276,491,367,263,369,265,386,90,197,90,335,411,453,447,394,312,196,413,457,490,506,500,475,435,238,485,256,128,111,66,49,66,110,167,294,339,356,339,295,238,361,382,361,290,232,290,421,479,421,361,421,479,363,206,206,217,236,261,289,317,343,362,373,375,248,264,81,142,179,436,370,301,155,221,387,440,379,342,79,127,196,332,282,419,475,500,479,424,123,215,252,13,203,272,416,351,143,401,313,160,105,84,108,163,352,406,427,403,348,206,198,252,273,249,194,118,464,479,341,326,347,486,190,170,178,316,331,192,168,194,54,354,59,185,107,181,455,245,26,132,264,350,283,90,263,256,103}, dropObjectsY,
  {3111,4133,5156,5838,7542,8565,10611,11292,12315,13679,14020,15042,16065,16747,17770,18792,19474,20838,21520,22201,22541,22882,23223,23565,24247,24929,25270,26974,28338,28679,28849,29020,29361,29531,29701,30042,30383,31065,31406,31747,32429,32940,33111,33963,34133,34304,34474,34645,34815,34986,35156,35838,36520,36861,37201,37883,38395,38565,38991,39076,39247,39588,39929,40440,40611,40951,41292,41804,41974,42315,42656,43338,43849,44020,44531,44701,45042,45383,45895,46236,46747,47770,48111,48537,48792,49474,54929,55951,56292,56633,56804,56974,57315,57656,58338,58679,59020,59361,59446,59531,59616,59701,60042,60213,60554,60724,61065,61406,61747,62258,62770,63111,63281,63622,63792,64133,64303,64644,64815,65156,65838,66349,66520,66861,67201,67371,67541,67712,67883,68224,68565,69076,69247,69588,69929,70270,70611,70951,71122,71292,71462,71632,71803,71973,72144,72315,72656,72741,72826,72911,72996,73082,73167,73338,73679,74361,79474,84929,85042,85156,85269,85383,85497,85611,85724,85838,85951,86065,86179,86292,86407,86520,86633,86748,86861,86974,87087,87202,87315,87429,87542,87656,88338,88394,88451,88508,88565,88622,88678,88735,88792,88849,88906,89020,89701,90383,90838,90895,91065,91520,91633,91747,92088,92429,93111,93566,93623,93792,94247,94361,94474,94815,95156,95269,95383,95496,95610,95838,96292,96349,96520,96974,97088,97201,97542,97883,98338,98451,98565,98678,98792,98905,99019,99247,99360,99474,99587,99701,99929,100270,100383,100497,100610,100724,100838,101292,101861,101974,102315,102656,102997,103338,103679,103906,104020,104588,104701,105042,105383,105724,106065,106747,107201,107429,107770,108111,108792,109474,112201,114929,117656,120383,122088,123111,124474,131292}};
  boolean[] dropShown = new boolean[276];

  int combo = 0; 
  int score; 

  // Song 2 arrays 
  int [] notesYTwo = new int[737];
  int [][] noteValuesTwo = {{80,256,352,194,384,288,267,253,384,256,128,176,272,240,128,320,128,323,348,368,256,128,256,432,384,400,256,432,256,256,223,190,256,387,256,80,176,208,96,224,96,208,192,160,128,224,176,128,432,256,160,336,224,128,224,245,259,128,256,384,336,240,272,384,192,384,189,164,144,256,384,256,80,128,112,256,80,256,256,289,322,256,125,256,432,336,304,416,288,432,176,385,390,382,363,336,176,480,256,112,256,160,432,301,336,304,208,432,208,368,144,304,208,96,304,208,320,192,336,176,320,192,355,208,304,192,432,192,432,384,320,32,256,400,256,352,80,211,176,208,304,80,304,144,368,208,304,416,208,304,192,320,176,336,192,400,256,112,256,400,256,80,208,48,224,400,96,224,272,320,96,320,464,320,306,292,176,320,416,288,240,192,416,192,48,192,206,220,336,192,432,304,272,240,400,160,304,240,96,240,112,304,304,256,120,96,176,256,336,416,256,416,386,343,208,96,126,176,384,128,384,256,192,144,368,144,256,413,208,397,224,80,336,80,290,224,368,144,144,256,219,112,144,256,448,256,64,224,80,208,352,384,352,96,256,96,126,169,304,416,386,336,128,384,128,256,320,368,144,368,256,99,304,115,224,384,256,256,128,64,84,117,157,201,272,178,384,173,256,384,320,126,192,480,481,462,427,384,128,85,50,31,32,288,352,400,112,352,464,288,162,349,160,432,256,432,304,256,96,332,256,187,149,112,400,160,48,224,350,163,352,80,224,79,128,176,336,292,99,320,384,432,112,352,464,288,162,349,160,432,256,432,304,256,96,332,256,187,149,112,400,160,48,224,350,163,352,64,256,464,256,48,47,56,74,99,132,169,211,254,298,339,377,410,436,454,463,416,320,161,320,192,320,160,208,256,304,352,256,368,144,352,208,120,288,352,160,96,256,382,448,256,112,256,384,336,384,352,224,352,160,320,448,290,448,320,272,224,432,320,160,136,108,80,55,38,32,37,52,76,105,133,157,32,176,336,144,320,128,384,128,80,128,256,384,128,128,256,352,256,205,160,464,416,368,256,96,256,32,240,448,320,130,349,464,160,275,397,160,416,432,416,389,224,112,304,128,384,208,96,224,96,256,256,160,464,160,464,425,387,160,464,288,112,352,48,352,48,87,125,352,48,224,400,160,352,160,256,209,146,352,160,352,256,303,366,303,176,384,352,256,160,64,176,336,336,272,400,197,256,448,256,64,256,352,448,384,352,144,448,256,139,192,320,320,256,80,384,160,320,96,332,288,176,368,64,256,373,320,192,192,256,432,128,352,192,416,374,332,96,416,96,126,157,64,256,80,240,96,224,176,448,256,432,272,416,288,336,272,112,272,112,16,173,256,416,176,212,160,256,352,392,416,416,400,160,368,64,256,373,320,192,192,256,432,128,352,192,416,180,224,336,144,448,256,139,192,320,320,256,80,384,160,320,96,138,180,416,96,416,386,355,448,256,432,272,416,288,336,64,256,80,240,96,224,176,384,272,160,48,384,272,160,48,272,240,128,224,336,416,336,384,240,208,192,432,352,272,480,384,80,160,240,480,352,80,160,240,32,128,432,352,272,32,160,286,48,144,240,336,464,48,144,240,336,464,256,160,256,352,256,128,256,144,256,144,256,192,288,400,368,320,192,144,112,400,256}, 
  notesYTwo, {956,1285,1780,1945,2274,2769,2851,2934,3263,3428,3593,3923,4170,4252,4417,4582,4912,5406,5488,5571,5901,6065,6230,6560,6807,6890,7054,7219,7549,8043,8126,8208,8538,8703,8868,9197,9445,9527,9692,9857,10021,10186,10681,10763,10846,11175,11258,11340,11505,11835,12329,12494,12659,12824,13318,13401,13483,13813,13977,14142,14472,14719,14802,14966,15131,15461,15956,16038,16120,16450,16615,16780,17109,17357,17439,17604,17769,18098,18593,18675,18758,19087,19252,19417,19747,19994,20076,20241,20406,20571,20736,21230,21313,21395,21477,21560,21725,22054,22384,22879,23043,23208,23703,23868,24362,24692,25021,25516,25846,26175,26505,26835,27164,27494,28153,28648,28813,29142,29472,29637,29802,29966,30461,30956,31120,31285,31450,31780,32274,32357,32439,32604,32934,33428,33593,33758,34252,34417,34912,35242,35571,36065,36395,36725,37054,37384,37714,38043,38703,39197,39362,39692,40021,40186,40351,40516,40846,41010,41340,41505,41835,41999,42247,42494,42659,42824,43153,43648,43730,43813,44142,44472,44802,44966,45049,45131,45296,45461,45791,46285,46368,46450,46780,47109,47439,47604,47686,47769,47934,48098,48428,48923,49005,49087,49417,49747,50241,50736,51065,51560,51725,52054,52384,52714,52879,53373,53456,53538,53620,53703,53868,54362,54445,54527,54692,55186,55269,55351,55681,56010,56340,56505,56587,56670,56999,57329,57659,57824,58153,58483,58813,58977,59307,59637,59966,60296,60461,60791,60956,61203,61285,61532,61615,61780,62109,62439,62769,63098,63428,63758,63923,64005,64087,64252,64417,64912,64994,65076,65241,65736,65818,65901,66230,66560,66890,67054,67137,67219,67549,67879,68208,68373,68703,69032,69362,69527,69692,69857,70186,70434,70516,70598,70681,70763,70846,71175,71505,71835,72164,72329,72659,72988,73318,73483,73565,73648,73730,73813,73977,74060,74142,74225,74307,74472,74554,74637,74802,75296,75461,75791,76120,76615,76945,77439,77769,78263,78510,78593,78758,79087,79417,79747,79829,79912,80076,80571,80736,81065,81395,81890,82219,82714,83043,83538,83785,83868,84032,84362,84692,85021,85104,85186,85351,85846,86010,86340,86670,87164,87494,87988,88318,88813,89060,89142,89307,89637,89966,90296,90379,90461,90626,91120,91285,91615,91945,92439,92769,93263,93593,93923,94252,94582,94664,94747,94829,94912,94994,95076,95159,95241,95324,95406,95488,95571,95653,95736,95818,95901,96065,96395,96642,96890,97054,97219,97302,97384,97466,97549,97714,97879,98208,98538,98868,99032,99280,99362,99857,100021,100269,100516,100681,100928,101175,101340,101587,101835,102164,102494,102824,103153,103483,103813,103977,104225,104472,104637,104719,104802,105131,105626,105791,105846,105901,105956,106010,106065,106120,106175,106230,106285,106340,106395,106450,106945,107109,107274,107604,107934,108263,108593,108923,109170,109252,109417,109747,110076,110406,110571,110901,111148,111230,111560,111725,111972,112054,112549,112714,112879,113208,113538,113868,114032,114362,114692,115186,115681,116175,116670,116999,117741,117824,117906,117988,118318,118648,118977,119307,119637,130186,132164,132823,135131,135461,138098,140735,141395,142054,142713,142878,143043,143373,144032,144691,145351,146010,146669,147329,147988,148153,148318,148647,149307,149966,150626,151285,151944,152604,153263,153428,153593,153922,154582,155241,155900,156065,156230,156395,156560,157219,157878,158043,158867,159032,159197,159691,160186,160516,161010,161505,161834,162163,162493,162823,163152,163482,163812,164141,164471,164636,164965,165295,165460,165790,166284,166779,167108,167273,167603,167932,168097,168427,168757,169086,169746,169911,170240,170570,170735,171065,171559,172054,172383,172548,172878,173207,173372,173702,173784,173866,174032,174526,174691,174773,174855,175020,175350,175680,176010,176339,176834,177328,177658,177988,178318,178648,178976,179471,179965,180295,180790,181284,181614,181779,182603,182932,183262,183427,183921,184251,184746,184910,184992,185074,185157,185240,185570,185735,186064,186394,186559,186889,187383,187878,188207,188372,188702,189031,189196,189526,189856,190185,190845,191010,191339,191669,191834,192164,192658,193153,193482,193647,193977,194306,194471,194801,194883,194965,195131,195625,195790,195872,195954,196119,196449,196779,197109,197438,197933,198427,198757,199087,199417,199747,200075,200570,201064,201394,201724,202053,202383,202713,203043,203372,203702,204031,204361,204691,205021,205350,205597,205844,206009,206339,206421,206504,206669,207163,207328,207987,208317,209306,209800,209965,210625,210955,211943,212437,212602,213262,213591,214580,215074,215240,215899,216229,216723,217218,217548,217877,218207,218537,219855,220185,220514,220844,221174,221998,222493,222822,223152,223482,223811,223976,224800,225130,225625,226119,226449,226778,227108,227190,227273,227438,227520,227603,227767,227932}};
  boolean[] noteShownTwo = new boolean[737];

  
  
  // Program state varaibles
  boolean menu = true;
  boolean songOne = false;
  boolean songTwo = false;
  boolean resultScreen = false; 


  /**
   * 
   */

  public void settings() {
	// put your size call here
    size(1280, 720);
  }

  /** 
   * 
   */

  public void setup() {
    
    // Initiate Audio
    audio = new Minim(this);
    
    // Set Framerate
    frameRate(60);

    // Intialize Arrays 
    for (int x = 0; x < dropShown.length; x++){
      dropShown[x] = false;
    }
    for (int j = 0; j < noteShownTwo.length; j++ ){
      noteShownTwo[j] = false;
    }

    // Load songs and images
    img = loadImage("fruit-catcher-idle.png");
    player = audio.loadFile("audio.mp3");
    playerTwo = audio.loadFile("audio2.mp3");
    jack = audio.loadSample("soft-hitnormal2.wav");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */

  public void draw() {

    background(0,0,0);
    if (menu == true){
      Menu();
    }
    if (songOne == true){
      player.play();
      menu = false;
      bowl();
      songOne();
    }
    if (songTwo == true){
      playerTwo.play();
      menu = false;
      bowl();
      songTwo();
    }
    fill(255,255,255);
  }

  public void Menu() {
    background(0,0,0);
    rect(500, 300, 300, 50);
    rect(500, 500, 300, 50);
    
  }

  public void bowl() {

    image(img, intBowlX, height - 50);

    if (boolBowlSpeedUp){
      intBowlSpeed = 25;
    }
    else {
      intBowlSpeed = 10;
    }
    if (boolBowlLeft) {
      intBowlX -= intBowlSpeed;
    }

    if (boolBowlRight){
      intBowlX += intBowlSpeed;
    }
  }

  public void songOne() {

    player.play();
    songPosition = player.position();

    for (int i = 0; i < dropObjectsXandYandTime[0].length; i++){
      if (songPosition >= (dropObjectsXandYandTime[2][i] - 680) && songPosition <= (dropObjectsXandYandTime[2][i])){
        dropShown[i] = true;
      }
      if (dropShown[i]){
        ellipse(dropObjectsXandYandTime[0][i] * 2, dropObjectsXandYandTime[1][i] , 80, 80);
        dropObjectsXandYandTime[1][i] += 15.111111111111;
      }
      if (dropObjectsXandYandTime[1][i] >= 670 && dropObjectsXandYandTime[1][i] <= 720 && 
      dropObjectsXandYandTime[0][i] * 2 > intBowlX && dropObjectsXandYandTime[0][i] * 2 < (intBowlX + 305) && dropShown[i] == true){
        dropShown[i] = false;
        jack.trigger();
        combo += 1;
        score += 300 * (1 + combo * 0.01);
      }
      if (dropObjectsXandYandTime[1][i] >= 720 && dropObjectsXandYandTime[1][i] <= 730 && dropShown[i] == true){
        combo = 0;
      }
    }
    // print combo
    text(combo, intBowlX + 130, 630);
    text(score, 1000, 50);

  }
  public void songTwo() {

    playerTwo.play();
    songPosition = playerTwo.position();

    for (int i = 0; i < noteValuesTwo[0].length; i++){
      if (songPosition >= (noteValuesTwo[2][i] - 680) && songPosition <= (noteValuesTwo[2][i])){
        noteShownTwo[i] = true;
      }
      if (noteShownTwo[i]){
        ellipse(noteValuesTwo[0][i] * 2, noteValuesTwo[1][i] , 80, 80);
        noteValuesTwo[1][i] += 15.111111111111;
      }
      if (noteValuesTwo[1][i] >= 670 && noteValuesTwo[1][i] <= 720 && 
      noteValuesTwo[0][i] * 2 > intBowlX && noteValuesTwo[0][i] * 2 < (intBowlX + 305) && noteShownTwo[i] == true){
        noteShownTwo[i] = false;
        jack.trigger();
        combo += 1;
        score += 300 * (1 + combo * 0.01);
      }
      if (noteValuesTwo[1][i] >= 720 && noteValuesTwo[1][i] <= 730 && noteShownTwo[i] == true){
        combo = 0;
      }
    }
    // print combo
    text(combo, intBowlX + 130, 630);
    text(score, 1000, 50);


  }
  public void mousePressed(){
    if (mouseX > 500 && mouseX < 800 && mouseY > 300 && mouseY < 350 && menu == true){
      songOne = true;
    }
    if (mouseX > 500 && mouseX < 800 && mouseY > 500 && mouseY < 550 && menu == true){
      songTwo = true;
    }
  }

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


