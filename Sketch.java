
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import ddf.minim.*;


public class Sketch extends PApplet {

  // PImage variable
  PImage img;
  PImage backgroundThree;
  PImage rankS;
  PImage rankA;
  PImage rankB;
  PImage rankC;
  PImage rankD;

  // Audio Varabiles
  Minim audio;
  AudioPlayer player;
  AudioPlayer playerTwo;
  AudioPlayer playerThree;
  AudioSample jack;
  AudioSample drum;
  AudioSample symbal;
  AudioSample clap;

  // Font Varaible
  PFont gameFont;

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
  double accuracy; 
  int intAccuracy;

  // Song 2 arrays 
  int [] notesYTwo = new int[737];
  int [][] noteValuesTwo = {{80,256,352,194,384,288,267,253,384,256,128,176,272,240,128,320,128,323,348,368,256,128,256,432,384,400,256,432,256,256,223,190,256,387,256,80,176,208,96,224,96,208,192,160,128,224,176,128,432,256,160,336,224,128,224,245,259,128,256,384,336,240,272,384,192,384,189,164,144,256,384,256,80,128,112,256,80,256,256,289,322,256,125,256,432,336,304,416,288,432,176,385,390,382,363,336,176,480,256,112,256,160,432,301,336,304,208,432,208,368,144,304,208,96,304,208,320,192,336,176,320,192,355,208,304,192,432,192,432,384,320,32,256,400,256,352,80,211,176,208,304,80,304,144,368,208,304,416,208,304,192,320,176,336,192,400,256,112,256,400,256,80,208,48,224,400,96,224,272,320,96,320,464,320,306,292,176,320,416,288,240,192,416,192,48,192,206,220,336,192,432,304,272,240,400,160,304,240,96,240,112,304,304,256,120,96,176,256,336,416,256,416,386,343,208,96,126,176,384,128,384,256,192,144,368,144,256,413,208,397,224,80,336,80,290,224,368,144,144,256,219,112,144,256,448,256,64,224,80,208,352,384,352,96,256,96,126,169,304,416,386,336,128,384,128,256,320,368,144,368,256,99,304,115,224,384,256,256,128,64,84,117,157,201,272,178,384,173,256,384,320,126,192,480,481,462,427,384,128,85,50,31,32,288,352,400,112,352,464,288,162,349,160,432,256,432,304,256,96,332,256,187,149,112,400,160,48,224,350,163,352,80,224,79,128,176,336,292,99,320,384,432,112,352,464,288,162,349,160,432,256,432,304,256,96,332,256,187,149,112,400,160,48,224,350,163,352,64,256,464,256,48,47,56,74,99,132,169,211,254,298,339,377,410,436,454,463,416,320,161,320,192,320,160,208,256,304,352,256,368,144,352,208,120,288,352,160,96,256,382,448,256,112,256,384,336,384,352,224,352,160,320,448,290,448,320,272,224,432,320,160,136,108,80,55,38,32,37,52,76,105,133,157,32,176,336,144,320,128,384,128,80,128,256,384,128,128,256,352,256,205,160,464,416,368,256,96,256,32,240,448,320,130,349,464,160,275,397,160,416,432,416,389,224,112,304,128,384,208,96,224,96,256,256,160,464,160,464,425,387,160,464,288,112,352,48,352,48,87,125,352,48,224,400,160,352,160,256,209,146,352,160,352,256,303,366,303,176,384,352,256,160,64,176,336,336,272,400,197,256,448,256,64,256,352,448,384,352,144,448,256,139,192,320,320,256,80,384,160,320,96,332,288,176,368,64,256,373,320,192,192,256,432,128,352,192,416,374,332,96,416,96,126,157,64,256,80,240,96,224,176,448,256,432,272,416,288,336,272,112,272,112,16,173,256,416,176,212,160,256,352,392,416,416,400,160,368,64,256,373,320,192,192,256,432,128,352,192,416,180,224,336,144,448,256,139,192,320,320,256,80,384,160,320,96,138,180,416,96,416,386,355,448,256,432,272,416,288,336,64,256,80,240,96,224,176,384,272,160,48,384,272,160,48,272,240,128,224,336,416,336,384,240,208,192,432,352,272,480,384,80,160,240,480,352,80,160,240,32,128,432,352,272,32,160,286,48,144,240,336,464,48,144,240,336,464,256,160,256,352,256,128,256,144,256,144,256,192,288,400,368,320,192,144,112,400,256}, 
  notesYTwo, {956,1285,1780,1945,2274,2769,2851,2934,3263,3428,3593,3923,4170,4252,4417,4582,4912,5406,5488,5571,5901,6065,6230,6560,6807,6890,7054,7219,7549,8043,8126,8208,8538,8703,8868,9197,9445,9527,9692,9857,10021,10186,10681,10763,10846,11175,11258,11340,11505,11835,12329,12494,12659,12824,13318,13401,13483,13813,13977,14142,14472,14719,14802,14966,15131,15461,15956,16038,16120,16450,16615,16780,17109,17357,17439,17604,17769,18098,18593,18675,18758,19087,19252,19417,19747,19994,20076,20241,20406,20571,20736,21230,21313,21395,21477,21560,21725,22054,22384,22879,23043,23208,23703,23868,24362,24692,25021,25516,25846,26175,26505,26835,27164,27494,28153,28648,28813,29142,29472,29637,29802,29966,30461,30956,31120,31285,31450,31780,32274,32357,32439,32604,32934,33428,33593,33758,34252,34417,34912,35242,35571,36065,36395,36725,37054,37384,37714,38043,38703,39197,39362,39692,40021,40186,40351,40516,40846,41010,41340,41505,41835,41999,42247,42494,42659,42824,43153,43648,43730,43813,44142,44472,44802,44966,45049,45131,45296,45461,45791,46285,46368,46450,46780,47109,47439,47604,47686,47769,47934,48098,48428,48923,49005,49087,49417,49747,50241,50736,51065,51560,51725,52054,52384,52714,52879,53373,53456,53538,53620,53703,53868,54362,54445,54527,54692,55186,55269,55351,55681,56010,56340,56505,56587,56670,56999,57329,57659,57824,58153,58483,58813,58977,59307,59637,59966,60296,60461,60791,60956,61203,61285,61532,61615,61780,62109,62439,62769,63098,63428,63758,63923,64005,64087,64252,64417,64912,64994,65076,65241,65736,65818,65901,66230,66560,66890,67054,67137,67219,67549,67879,68208,68373,68703,69032,69362,69527,69692,69857,70186,70434,70516,70598,70681,70763,70846,71175,71505,71835,72164,72329,72659,72988,73318,73483,73565,73648,73730,73813,73977,74060,74142,74225,74307,74472,74554,74637,74802,75296,75461,75791,76120,76615,76945,77439,77769,78263,78510,78593,78758,79087,79417,79747,79829,79912,80076,80571,80736,81065,81395,81890,82219,82714,83043,83538,83785,83868,84032,84362,84692,85021,85104,85186,85351,85846,86010,86340,86670,87164,87494,87988,88318,88813,89060,89142,89307,89637,89966,90296,90379,90461,90626,91120,91285,91615,91945,92439,92769,93263,93593,93923,94252,94582,94664,94747,94829,94912,94994,95076,95159,95241,95324,95406,95488,95571,95653,95736,95818,95901,96065,96395,96642,96890,97054,97219,97302,97384,97466,97549,97714,97879,98208,98538,98868,99032,99280,99362,99857,100021,100269,100516,100681,100928,101175,101340,101587,101835,102164,102494,102824,103153,103483,103813,103977,104225,104472,104637,104719,104802,105131,105626,105791,105846,105901,105956,106010,106065,106120,106175,106230,106285,106340,106395,106450,106945,107109,107274,107604,107934,108263,108593,108923,109170,109252,109417,109747,110076,110406,110571,110901,111148,111230,111560,111725,111972,112054,112549,112714,112879,113208,113538,113868,114032,114362,114692,115186,115681,116175,116670,116999,117741,117824,117906,117988,118318,118648,118977,119307,119637,130186,132164,132823,135131,135461,138098,140735,141395,142054,142713,142878,143043,143373,144032,144691,145351,146010,146669,147329,147988,148153,148318,148647,149307,149966,150626,151285,151944,152604,153263,153428,153593,153922,154582,155241,155900,156065,156230,156395,156560,157219,157878,158043,158867,159032,159197,159691,160186,160516,161010,161505,161834,162163,162493,162823,163152,163482,163812,164141,164471,164636,164965,165295,165460,165790,166284,166779,167108,167273,167603,167932,168097,168427,168757,169086,169746,169911,170240,170570,170735,171065,171559,172054,172383,172548,172878,173207,173372,173702,173784,173866,174032,174526,174691,174773,174855,175020,175350,175680,176010,176339,176834,177328,177658,177988,178318,178648,178976,179471,179965,180295,180790,181284,181614,181779,182603,182932,183262,183427,183921,184251,184746,184910,184992,185074,185157,185240,185570,185735,186064,186394,186559,186889,187383,187878,188207,188372,188702,189031,189196,189526,189856,190185,190845,191010,191339,191669,191834,192164,192658,193153,193482,193647,193977,194306,194471,194801,194883,194965,195131,195625,195790,195872,195954,196119,196449,196779,197109,197438,197933,198427,198757,199087,199417,199747,200075,200570,201064,201394,201724,202053,202383,202713,203043,203372,203702,204031,204361,204691,205021,205350,205597,205844,206009,206339,206421,206504,206669,207163,207328,207987,208317,209306,209800,209965,210625,210955,211943,212437,212602,213262,213591,214580,215074,215240,215899,216229,216723,217218,217548,217877,218207,218537,219855,220185,220514,220844,221174,221998,222493,222822,223152,223482,223811,223976,224800,225130,225625,226119,226449,226778,227108,227190,227273,227438,227520,227603,227767,227932}};
  boolean[] noteShownTwo = new boolean[737];


  // Song data Arrays
  int [] notesYThree = new int[1127];
  int [][] noteValuesThree = {{272,127,87,175,173,213,253,109,69,149,148,145,142,468,177,328,295,254,333,289,208,247,287,431,178,321,282,242,385,246,246,116,36,262,124,260,260,327,185,369,221,366,91,114,154,193,233,209,168,128,302,363,335,259,111,337,196,116,340,204,266,292,247,168,305,241,357,400,320,432,432,351,221,143,368,215,350,278,255,316,460,321,205,395,207,398,195,315,274,234,193,173,133,326,394,361,283,138,281,150,119,167,250,395,256,368,368,144,298,112,71,155,46,62,138,256,340,401,415,271,335,274,238,280,357,213,353,166,310,231,377,192,270,308,346,385,267,306,345,167,311,174,324,181,181,246,246,129,271,412,273,419,421,279,279,470,393,248,312,168,362,176,328,367,286,172,107,157,301,373,320,176,189,259,408,372,296,106,309,191,336,197,327,179,266,333,249,139,214,357,292,388,240,151,375,466,199,341,116,253,59,267,139,139,219,340,260,180,326,182,251,190,339,378,337,192,272,271,386,356,315,275,230,433,389,193,153,237,155,379,58,134,289,363,228,300,236,309,246,247,311,309,241,306,237,377,417,206,318,206,321,131,366,227,361,289,217,145,286,145,284,212,140,68,267,203,343,116,392,206,314,470,328,395,320,334,411,267,331,266,319,273,193,384,239,380,155,350,212,408,327,246,133,133,215,175,134,277,132,333,375,294,333,373,228,192,340,375,176,205,204,165,125,270,309,349,205,165,124,319,359,165,122,326,326,327,375,211,174,256,216,176,321,179,376,376,294,333,373,230,269,309,453,413,372,179,280,286,292,209,353,288,405,224,264,194,162,215,359,222,373,412,365,286,144,293,154,75,301,236,350,350,269,379,420,339,221,151,119,179,325,180,294,381,294,206,350,216,100,293,100,293,88,149,189,380,380,299,340,380,160,316,202,317,166,353,433,211,275,163,178,251,128,128,208,320,397,421,363,218,351,198,38,261,121,390,244,323,402,258,148,147,187,226,266,171,130,90,266,121,347,203,348,270,206,281,395,323,181,312,178,323,162,305,144,328,184,410,184,373,189,361,400,319,206,141,160,308,375,311,166,207,281,137,137,217,410,450,245,361,285,429,293,445,306,365,332,257,404,349,370,444,241,384,242,310,165,161,298,300,115,188,331,182,326,178,307,196,337,20,99,178,316,176,139,219,364,332,291,148,228,308,425,276,125,261,147,291,227,227,227,187,146,345,268,130,204,340,266,333,258,321,325,186,184,180,176,321,244,283,323,244,204,163,308,191,384,188,381,185,248,248,372,411,206,319,180,329,249,169,249,385,250,307,386,465,386,171,312,171,396,121,309,193,31,176,111,179,157,75,219,155,221,141,61,141,335,198,335,203,163,122,315,182,219,411,331,250,363,404,316,355,395,257,293,430,393,200,214,199,159,118,261,120,315,315,327,369,231,191,150,292,331,371,177,100,225,304,165,201,188,127,286,326,241,280,320,183,143,277,316,122,122,116,70,210,73,112,152,347,290,393,340,287,340,393,196,358,317,234,368,367,453,316,276,353,216,176,253,172,134,455,489,459,389,296,375,454,375,238,163,126,171,85,49,66,91,124,269,348,269,189,272,346,365,346,313,176,255,335,414,278,232,214,242,292,344,151,83,80,142,225,146,67,105,146,283,319,278,201,285,364,285,205,399,267,350,187,405,260,220,356,225,342,214,145,223,445,294,67,197,143,196,249,195,376,248,454,159,469,393,258,342,206,320,303,263,223,185,385,345,149,76,47,102,238,101,140,180,374,383,154,291,162,350,389,304,441,316,355,395,201,201,212,223,35,125,85,45,246,222,181,314,311,251,315,257,145,105,65,257,297,256,397,437,396,260,219,259,402,442,402,207,167,361,219,334,258,117,309,187,215,208,173,366,435,434,377,238,232,273,348,485,284,220,252,388,201,397,324,191,248,139,194,137,175,311,188,325,325,287,284,307,347,155,91,137,274,193,113,316,197,219,259,72,30,218,218,320,359,399,257,217,176,371,349,166,293,217,369,273,119,121,268,265,406,242,376,206,202,198,335,196,340,379,419,276,389,205,402,201,390,248,208,167,246,102,425,269,258,247,386,395,403,324,363,403,258,218,178,315,354,394,197,158,352,229,190,270,270,378,417,335,335,202,389,434,472,493,492,466,424,194,247,189,113,87,124,263,133,273,193,113,193,385,325,455,231,346,151,260,430,295,359,421,403,329,191,256,191,118,84,118,314,172,310,163,123,82,279,345,333,263,71,110,150,189,229,341,341,260,299,339,199,331,370,410,213,173,256,216,175,316,355,219,179,366,340,346,385,425,282,242,202,341,379,418,218,218,404,404,219,181,266,211,368,407,322,361,401,262,295,435,399,206,206,201,156,295,334,374,239,199,158,354,223,183,142,223,80,19,61,262,232,184,313,162,241,320,399,256,312,252,172,252,331,118,250,112,66,93,172,366,405,325,212,173,253,369,213,358,216,255,295,102,245,284,144,104,244,359,319,278,238,197,340,300,259,219,178,377,176,255,334,138,171,211,401,281,240,432,401,360,165,356,276,439}, 
  notesYThree, 
  {225,600,725,850,1100,1162,1225,1350,1475,1600,1850,1912,1975,2225,3100,3225,3537,3600,3725,3850,3975,4037,4100,4225,5225,5475,5537,5600,5725,5975,6100,6225,6475,6725,6975,7225,7475,7725,7975,8225,8600,8975,9225,9537,9600,9662,9725,10037,10100,10162,10225,10350,10475,10600,10725,10975,11225,11475,11725,11975,12225,12350,12475,12600,12725,12975,13225,13350,13475,13725,13850,13975,14225,14475,14725,14975,15225,15350,15475,15600,15725,15975,16225,16475,16725,16975,17225,17537,17600,17662,17725,18037,18100,18225,18350,18475,18600,18725,18975,19225,19350,19475,19600,19725,19975,20225,20475,20725,20975,21225,21350,21475,21725,21850,21975,22225,22350,22475,22600,22725,22975,23225,23350,23475,23600,23725,23975,24225,24600,24850,24975,25225,25537,25600,25662,25725,26037,26100,26162,26225,26600,26850,27100,27225,27475,27725,27975,28225,28600,28850,29100,29225,29475,29725,29975,30225,30475,30600,30850,31100,31225,31475,31725,31850,31975,32225,32350,32475,32600,32725,32850,32975,33100,33225,33350,33475,33600,33725,33975,34225,34600,34850,35100,35225,35475,35725,35975,36225,36475,36600,36850,37100,37225,37475,37725,37975,38225,38600,38850,39100,39225,39475,39725,39850,39975,40225,40350,40475,40600,40975,41100,41225,41350,41537,41600,41725,41850,41975,42225,42537,42600,42662,42725,43037,43100,43225,43350,43475,43725,43975,44225,44475,44725,44975,45225,45475,45725,45975,46225,46475,46725,46975,47225,47475,47725,47975,48100,48225,48475,48725,48975,49225,50225,50475,50725,50850,50975,51100,51225,51475,51725,51850,51975,52100,52225,52475,52725,52975,53225,53475,53725,54225,54475,54725,54850,54975,55100,55225,55475,55725,55850,55975,56100,56225,56475,56725,56975,57225,57475,57725,57850,57975,58225,58350,58475,58537,58600,58725,58975,59225,59350,59475,59537,59600,59725,59850,59975,60100,60225,60350,60475,60537,60600,60725,60787,60850,60975,61037,61100,61225,61350,61475,61600,61725,61850,61975,62100,62225,62350,62475,62537,62600,62725,62975,63225,63350,63475,63537,63600,63725,63787,63850,63975,64037,64100,64225,64350,64412,64475,64600,64725,64975,65225,65725,66225,66350,66475,66600,66725,66975,67225,67350,67475,67600,67725,67975,68225,68475,68725,68975,69225,69350,69475,69725,69850,69975,70225,70350,70475,70600,70725,70975,71225,71350,71475,71600,71725,71975,72225,72475,72725,72975,73225,73537,73600,73725,73850,73975,74037,74100,74225,75225,75475,75725,75975,76225,76475,76725,76975,77225,77350,77475,77725,77850,77975,78225,78350,78475,78600,78725,78975,79225,79475,79725,79975,80225,80600,80725,80850,80975,81225,81537,81600,81662,81725,82037,82100,82162,82225,82600,82850,83100,83225,83475,83725,83975,84225,84475,84600,84850,85100,85225,85475,85725,85975,86225,86600,86850,87100,87225,87475,87725,87850,87975,88225,88350,88475,88600,88725,88850,88975,89100,89225,89350,89475,89600,89725,89850,89975,90225,90475,90600,90850,91100,91225,91350,91475,91600,91725,91850,91975,92100,92225,92600,92850,93100,93225,93475,93725,93975,94225,94475,94600,94850,95100,95225,95475,95725,95975,96225,96350,96475,96600,96975,97100,97225,97350,97537,97600,97725,97850,97975,98225,98475,98725,98975,99225,99475,99725,99850,99975,100037,100100,100225,100475,100725,100975,101225,101475,101725,101975,102225,102475,102725,102975,103037,103100,103225,103475,103537,103600,103725,103787,103850,103975,104225,104475,104725,104975,105225,105475,105600,105725,105850,105975,106225,106475,106725,106850,106975,107100,107225,107475,107725,107850,107975,108100,108225,108475,108725,108975,109225,109475,109725,110225,110475,110725,110850,110975,111100,111225,111475,111725,111850,111975,112100,112225,112475,112725,112975,113037,113100,113225,113475,113600,113725,113850,113975,114225,114350,114475,114537,114600,114725,114850,114975,115100,115225,115350,115475,115537,115600,115725,115975,116225,116350,116475,116600,116725,116787,116850,116975,117037,117100,117225,117350,117475,117600,117725,117850,117975,118100,118225,118350,118475,118537,118600,118725,118787,118975,119037,119225,119350,119475,119600,119725,119975,120037,120100,120225,120475,120808,120891,120975,121058,121141,121225,121725,122225,122475,122600,122725,122975,123100,123162,123350,123475,123537,123725,123850,123975,124225,124350,124475,124600,124725,124850,124975,125100,125225,125350,125475,125600,125725,125850,125975,126037,126100,126225,126350,126475,126600,126725,126850,126975,127037,127100,127225,127350,127475,127600,127725,127808,127891,127975,128058,128141,128225,128350,128475,128600,128725,128850,128975,129037,129100,129225,129350,129475,129600,129725,129850,129975,130100,130225,130475,130725,130975,131225,131475,131600,131725,131975,132225,132725,133225,133725,134225,134725,135225,135475,135725,135808,135891,135975,136225,136725,137225,137725,138225,138475,138600,138850,138975,139225,139537,139600,139662,139725,140037,140100,140225,140350,140475,140600,140725,140975,141037,141100,141225,141350,141475,141725,141975,142225,142350,142475,142725,142975,143037,143100,143225,143475,143537,143600,143725,143975,144037,144100,144225,144537,144600,144725,144975,145225,145475,145725,145975,146037,146100,146225,146412,146475,146600,146787,146850,146975,147162,147225,147350,147537,147600,147725,147850,147975,148225,148600,148975,149225,149600,149912,149975,150037,150100,150225,150350,150475,150600,150725,150850,150975,151100,151225,151350,151475,151600,151725,151850,152225,152600,152725,152975,153225,153475,153725,153912,153975,154225,154600,154850,154912,154975,155037,155100,155225,155350,155475,155600,155725,155850,155975,156225,156537,156600,156725,156850,156975,157100,157225,157287,157350,157475,157537,157600,157725,157850,157975,158225,158475,158725,158975,159225,159475,159725,159975,160225,160475,160725,160975,161037,161100,161225,161475,161725,161787,161850,161975,162225,162475,162725,162975,163225,163475,163537,163600,163725,163850,164225,164475,164537,164600,164725,164787,164850,164975,165037,165100,165225,165287,165350,165475,165537,165600,165725,165850,165975,166225,166350,166475,166600,166725,166850,166975,167100,167225,167725,167787,167850,167912,167975,168037,168100,168225,168475,168725,168850,168975,169100,169225,169475,169725,169850,169975,170100,170225,170475,170725,170975,171225,171475,171725,172225,172475,172725,172850,172975,173100,173225,173475,173725,173850,173975,174100,174225,174475,174725,174975,175037,175100,175225,175350,175475,175600,175725,175787,175850,175912,175975,176225,176350,176475,176537,176600,176725,176975,177037,177100,177225,177350,177475,177537,177600,177725,177787,177975,178037,178225,178350,178475,178537,178600,178725,178787,178850,178975,179037,179100,179225,179350,179475,179600,179725,179850,179975,180100,180225,180350,180475,180537,180600,180725,180850,180975,181100,181225,181350,181475,181600,181725,181787,181850,181975,182037,182100,182225,182475,182537,182600,182725,182850,182975,183100,183225,183725,184225,184475,184725,184850,184975,185100,185225,185475,185725,185850,185975,186100,186225,186475,186725,186850,186975,187100,187225,187350,187475,187725,187850,187975,188225,188475,188725,188975,189037,189100,189225,189475,189537,189725,189787,189975,190225,190287,190350,190412,190475,190600,190662,190725,190787,190850,190975,191225,191350,191475,191600,191787,191850,191975,192162,192225,192350,192537,192600,192725,192975,193100,193225}};
  boolean[] noteShownThree = new boolean[1127];

  // Fruits Caught Variables
  double notesCaught;
  double notesMissed;
  double notesTotal;
  
  // Program state varaibles
  boolean menu = false;
  boolean songOne = false;
  boolean songTwo = false;
  boolean songThree = false;
  boolean resultScreen = true;;
   
  boolean resultOne = false;
  boolean resultTwo = false;
  boolean resultThree = false;
  boolean scoreCount = false;
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

    gameFont = createFont("Crispy Duck.ttf", 32);
    textFont(gameFont);
    textAlign(CENTER, CENTER);
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
    for (int a = 0; a < noteShownThree.length; a++){
      noteShownThree[a] = false;
    }

    // Load songs and images
    img = loadImage("fruit-catcher-idle.png");
    backgroundThree = loadImage("songThree.png");
    rankS = loadImage("ranking-s.png");
    rankA = loadImage("ranking-a.png");
    rankB = loadImage("ranking-b.png");
    rankC = loadImage("ranking-c.png");
    rankS.resize(300,364);
    rankA.resize(300,364);
    rankB.resize(300,364);
    rankC.resize(300,364);


    // load Songs
    player = audio.loadFile("audio.mp3");
    playerTwo = audio.loadFile("audio2.mp3");
    playerThree = audio.loadFile("Freeze.mp3");
    jack = audio.loadSample("soft-hitnormal2.wav");
    drum = audio.loadSample("drum-hitnormal.wav");
    symbal = audio.loadSample("drum-hitwhistle.wav");
    clap = audio.loadSample("drum-hitclap2.wav");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */

  public void draw() {

    if (menu == true){
      Menu();
    }
    if (songOne == true){
      player.play();
      menu = false;
      songOne();
      bowl();
    }
    if (songTwo == true){
      playerTwo.play();
      menu = false;
      songTwo();
      bowl();
    }
    
    if (songThree == true){
      playerThree.play();
      menu = false;
      songThree();
      bowl();
    }
    if (resultOne == true || resultTwo == true || resultThree == true || resultScreen == true){
      Results();
    }

    if (songOne == true || songTwo == true || songThree == true){
      scoreCount = true;
    }
    else {
      scoreCount = false;
    }
    if (scoreCount){
      scoring();
    }
    fill(255,255,255);
  }

  public void Menu() {
    background(0,0,0);
    rect(500, 300, 300, 50);
    rect(500, 450, 300, 50);
    rect(500, 600, 300, 50);

  }
  public void Results(){
    resultScreen = true;

    fill(0,0,0);
    rect(400, 0, 480, 720);
    textSize(100);
    fill(255,255,255);
    
    text(score, 650, 350);

    textSize(50);
    if (resultOne){
      text("Made in Love", 650, 450);
    }
    else if (resultTwo){
      text("Renatus", 650, 450);
    }
    else if (resultThree){
      text("Everything will Freeze", 650, 450);
    }

    text(intAccuracy + "%", 650, 500);

    if (accuracy >= 95){
      image(rankS, 500, -40);
    }
    else if (accuracy >= 90){
      image(rankA, 490, -40);
    }
    else if (accuracy >= 85){
      image(rankB, 500, -40);
    }
    else if (accuracy >= 80){
      image(rankC, 500, -40);
    }
    rect(540, 640, 200, 50);
  }

  public void bowl() {

    image(img, intBowlX, height - 50);

    if (boolBowlSpeedUp){
      intBowlSpeed = 30;
    }
    else {
      intBowlSpeed = 15;
    }
    if (boolBowlLeft) {
      intBowlX -= intBowlSpeed;
    }

    if (boolBowlRight){
      intBowlX += intBowlSpeed;
    }
  }

  public void scoring() {
    text(combo, intBowlX + 130, 630);
    text(score, 1000, 50);
    notesTotal = notesCaught + notesMissed;
    accuracy = notesCaught / notesTotal * 100;

    intAccuracy = (int)(accuracy);
    text(intAccuracy, 100, 50);

  }
  public void songOne() {

    image(backgroundThree, 0,0);
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
        if (notesTotal % 2 == 0){
          symbal.trigger();
        }
        else{
          jack.trigger();
        } 
        combo += 1;
        score += 300 * (1 + combo * 0.01);
        notesCaught ++;

      }
      if (dropObjectsXandYandTime[1][i] >= 720 && dropObjectsXandYandTime[1][i] <= 730 && dropShown[i] == true){
        combo = 0;
        notesMissed ++;
      }
    }
    if (notesTotal == dropObjectsXandYandTime[0].length){
      resultOne = true;
      songOne = false;
    }
    
  }
  public void songTwo() {

    image(backgroundThree, 0,0);

    playerTwo.play();
    songPosition = playerTwo.position();

    for (int i = 0; i < noteValuesTwo[0].length; i++){
      if (songPosition >= (noteValuesTwo[2][i] - 680) && songPosition <= (noteValuesTwo[2][i])){
        noteShownTwo[i] = true;
      }
      if (noteShownTwo[i]){
        ellipse(noteValuesTwo[0][i] * (float)(1.75) + 100, noteValuesTwo[1][i] , 80, 80);
        noteValuesTwo[1][i] += 15.111111111111;
      }
      if (noteValuesTwo[1][i] >= 670 && noteValuesTwo[1][i] <= 720 && 
      noteValuesTwo[0][i] * 2 > intBowlX && noteValuesTwo[0][i] * 2 < (intBowlX + 305) && noteShownTwo[i] == true){
        noteShownTwo[i] = false;
        jack.trigger();
        combo += 1;
        score += 300 * (1 + combo * 0.01);
        notesCaught ++;
      }
      if (noteValuesTwo[1][i] >= 720 && noteValuesTwo[1][i] <= 730 && noteShownTwo[i] == true){
        combo = 0;
        notesMissed ++;
      }
    }
    if (notesTotal == noteValuesTwo[0].length){
      resultTwo = true;
      songTwo = false;
    }
   
  }
  public void songThree() {
    
    image(backgroundThree, 0,0);
    
    songPosition = playerThree.position();

    for (int i = 0; i < noteValuesThree[0].length; i++){
      if (songPosition >= (noteValuesThree[2][i] - 680) && songPosition <= (noteValuesThree[2][i])){
        noteShownThree[i] = true;
      }

      if (noteShownThree[i]){
        ellipse(noteValuesThree[0][i] * (float)(1.75) + 100, noteValuesThree[1][i] , 80, 80);
        noteValuesThree[1][i] += 15.111111111111;
      }

      if (noteValuesThree[1][i] >= 670 && noteValuesThree[1][i] <= 720 && 
      noteValuesThree[0][i] * 2 > intBowlX && noteValuesThree[0][i] * 2 < (intBowlX + 305) && noteShownThree[i] == true){
        noteShownThree[i] = false;
        
        drum.trigger();
        combo += 1;
        score += 300 * (1 + combo * 0.01);
        notesCaught ++;
      }
      if (noteValuesThree[1][i] >= 720 && noteValuesThree[1][i] <= 730 && noteShownThree[i] == true){
        combo = 0;
        notesMissed ++;
      }
    }
    if (notesTotal == noteValuesThree[0].length){
      songThree = false;
      resultThree = true;
      
    }
  }
  public void mousePressed(){
    if (mouseX > 500 && mouseX < 800 && mouseY > 300 && mouseY < 350 && menu == true){
      songOne = true;
    }
    if (mouseX > 500 && mouseX < 800 && mouseY > 450 && mouseY < 500 && menu == true){
      songTwo = true;
    }
    if (mouseX > 500 && mouseX < 800 && mouseY > 600 && mouseY < 650 && menu == true){
      songThree = true;
    }
    if (mouseX > 540 && mouseX < 740 && mouseY > 640 && mouseX < 690 && resultScreen ){
      resultScreen = false;
      resultOne = false;
      resultTwo = false;
      resultThree = false;
      menu = true;
      intAccuracy = 0;
      accuracy = 0;
      score = 0;
      notesCaught = 0;
      notesMissed = 0;
      notesTotal = 0;
      combo = 0;
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


