package level1;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;
public class SimonSays extends KeyAdapter {

 
 // Complete steps 1 - 7 before you test
 JFrame frame;// 1. Make a JFrame variable 
 
 	HashMap<Integer,String> images = new HashMap<Integer, String>();
 	private int imageIndex;
 	private int tries = 0;
 	private int simonSays = 0;
 	Date timeAtStart;
 	private  void makeAlbum() {
 images.put(new Integer(KeyEvent.VK_UP), "uparrow.png");
 images.put(new Integer(KeyEvent.VK_DOWN), "downarrow.png");
 images.put(new Integer(KeyEvent.VK_LEFT), "leftarrow.png");
 images.put(new Integer(KeyEvent.VK_RIGHT), "rightarrow.png");// 2. add 4 images which match keyboard keys like this: images.put(new Integer(KeyEvent.VK_UP), "image.jpg");
  	
JOptionPane.showMessageDialog(null, "Press the matching key when Simon says"); // 3. Tell the user to "Press the matching key when 'Simon says' otherwise press a different key"
timeAtStart = new Date();
 showImage();// 4. call the method to show an image


 	}
	public void keyPressed(KeyEvent e) {
    	int keyCode = e.getKeyCode();
    	int score = 0;// 16. make a points variable to track the score. tell the user their score at the end.
    	if(imageIndex == keyCode && simonSays == 1){
    		score++;
    		speak("Correct");
    	}if(imageIndex == keyCode && simonSays == 2){
    		score--;
    		speak("Incorrect, you know you can google it");
    	}
    	//18.   if the keyCode doesn't match the imageIndex and "Simon didn't say..."  increase their score	
    	//19. Use the speak method to tell the user if they were correct or not
    	tries++;
//13. increment tries by 1
  	
    	if(tries >= 9){
    		speak("youre score is" + score);
    		speak("your time was");
    		 Date timeAtEnd = new Date();
    		System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
    		System.exit(0);

    	}//14. if tries is greater than 9 (or however many you want)
    	
    	//15.    	exit the program


    	frame.dispose();;//11. dispose of the frame
   	
    	showImage();//12. call the method to show an image


	}
	private void showImage() {
    	frame = new JFrame();//5. initialize your frame to a new JFrame()
	 
    	frame.setVisible(true);//6. set the frame to visible
	
  	  frame.add(getNextRandomImage()); //7. rename to the name of your frame
    	
    	frame.setSize(400, 400);// 8. set the size of the frame 
     	
    	frame.addKeyListener(this);// 9. add a key listener to the frame
    	simonSays = new Random().nextInt(2);
    	if(simonSays == 1){
   	 speak("Simon says press the key of");
    	}else if(simonSays == 2){
    		speak("press the key of");//10. Use the speak method to either say "Simon says press this key" or "Press this key"
    	}
    	//Hint: use the simonSays int and a random number
	}
	private Component getNextRandomImage() {
    	this.imageIndex = new Random().nextInt(4) + 37;
    	return loadImage(images.get(imageIndex));
	}
	private JLabel loadImage(String fileName) {
    	URL imageURL = getClass().getResource(fileName);
    	Icon icon = new ImageIcon(imageURL);
    	return new JLabel(icon);
	}
  void speak(String words) {
  	  try {
  	   Runtime.getRuntime().exec("say " + words).waitFor();
  	  } catch (Exception e) {
  	   e.printStackTrace();
  	  }
   	}
	public static void main(String[] args) throws Exception {
	 new SimonSays().makeAlbum();
	}
}









