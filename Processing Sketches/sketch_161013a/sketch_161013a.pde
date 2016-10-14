int hopdist = 20;
int frogx = 400;
int frogy = 0;
Car car1 = new Car(800, 50, 50, random(20) - 7); 
Car car2 = new Car(800, 100, 50, random(20) - 10); 
Car car3 = new Car(800, 150, 50, random(20) - 9); 
Car car4 = new Car(800, 200, 50, random(20) - 10); 
Car car5 = new Car(800, 250, 50, random(20) - 5);
Car car6 = new Car(800, 300, 50, random(20)); 
Car car7 = new Car(800, 350, 50, random(20) - 5); 
void setup(){
  size(800,400);
  
}
void draw(){
  background(000, 000, 000);
  fill(000,255,00);
  ellipse(frogx, frogy, 25, 25);
  println(mouseX);
  println(frogx);
  car1.display();
  car2.display();
  car3.display();
  car4.display();
  car5.display();
  car6.display();
  car7.display();
  car1.carMove();
  car2.carMove();
  car3.carMove();
  car4.carMove();
  car5.carMove();
  car6.carMove();
  car7.carMove();
  intersects(car1);
  intersects(car2);
  intersects(car3);
  intersects(car4);
  intersects(car5);
  intersects(car6);
  intersects(car7);
  if(frogy >= 375){
    println("You Won");
    System.exit(1);
  }
}
class Car{
  
  float carX;
  int carY;
  int carSize;
  float carSpeed; 
  float getX() {
    return carX;
  }int getY() {
    return carY;
  }int getSize() {
    return carSize;
  }void gameOver(){
    
    
  }
  Car( float carX, int carY, int carSize, float carSpeed){
    this.carX = carX;
    this.carY = carY;
    this.carSize = carSize;
    this.carSpeed = carSpeed;
  }
  void display() 
  {
    fill(0,255,0);
    rect(carX, carY, carSize, 50);
  }
  void carMove(){
    carX -= carSpeed;
    if(carX <= -carSize){
     carX = 800;
    }else if(carX >= 800 && carSpeed <= 0){
      carX = -carSize;
      
    }
    
  }
}
void keyPressed()
{
  if(key == CODED){
      if(keyCode == UP)
      {
      frogy -= hopdist;//Frog Y position goes up
      frogOut();
      }
      else if(keyCode == DOWN)
      {
        frogy += hopdist;//Frog Y position goes down 
        frogOut();
      }
      else if(keyCode == RIGHT)
      {
       frogx += hopdist;//Frog X position goes right
       frogOut();
      }
      else if(keyCode == LEFT)
      {
        frogx -= hopdist;//Frog X position goes left
        frogOut();
      }
   }
}void frogOut(){
  if(frogx <= 0){
    frogx += hopdist;
    println("test");
  }else if(frogx >= 800){
    frogx -= hopdist;
    
  }else if(frogy <= 0){
    frogy += hopdist;
    
  }else if(frogy >= 400){
    frogy -= hopdist;
  }
  
}
boolean intersects(Car car) {
if ((frogy > car.getY() && frogy < car.getY()+50) && (frogx > car.getX() && frogx < car.getX()+car.getSize())){
  System.exit(1);
    return true;
}
    else {
        return false;
    }
}