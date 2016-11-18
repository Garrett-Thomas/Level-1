float birdx = 200;
float birdy = 100;
float birdvelocity = 2;
float birdgravity = .5;
int pipex = 600;
float pipey = 200;
int pipelength = 200;
void setup() {
  size(600, 400);
}
void draw() {
  background(255, 255, 255);
  fill(000, 000, 000);
  ellipse(birdx, birdy, 25, 25);
  birdy += birdvelocity;
  birdvelocity += birdgravity;
  fill(000, 255, 000);
  rect(pipex, pipey, 25, pipelength);
    fill(000, 255, 000);
  rect(pipex, pipey+ 200, 25, pipelength);
  pipex -= 20;
  if(pipex <= -25){
    pipex = 600;
    pipey = random(200, 400);
  }
   if (intersects(birdx, birdy, pipex, pipey, pipelength) == true){
     System.exit(1);
   }
 
}
void mousePressed() {
  birdvelocity = -5;
}
boolean intersects(float birdx, float birdy, int pipex, float pipey, int pipelength) {
if (birdy > pipey - 4 && birdx > pipex && birdx < pipex + pipelength){
return true;
}
else{ 
return false;
}
}



