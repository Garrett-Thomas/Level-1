package level1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Copyright The League of Amazing Programmers, 2015
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Jukebox implements Runnable, ActionListener {
	Song windows = new Song("/Users/league/Desktop/windows.mp3");
	   Song frozen = new Song("/Users/league/Desktop/frozen.mp3");
	   Song trump= new Song("/Users/league/Desktop/trump.mp3");
	   JFrame frame = new JFrame();
	   JPanel panel = new JPanel();
	   JButton Frozen = new JButton();
	   JButton Windows = new JButton();
	   JButton Trump = new JButton();
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());
		
	}

           public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song
        	   
        	 
        	   
        	   //JButton Trump = new JButton();
        	   frame.add(panel);
        	   panel.add(Windows);
        	   panel.add(Frozen);
        	   panel.add(Trump);
        	   Windows.setText("Windows Song");
        	   Frozen.setText("Let it Go");
        	   Trump.setText("Trump Grinch");
        	   Windows.addActionListener(this);
        	   Frozen.addActionListener(this);
        	   Trump.addActionListener(this);
        	   frame.setVisible(true);
        	   frame.pack();
        	   
		/*
		 * 6. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
          }
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(Windows)){
			windows.stop();
			frozen.stop();
			trump.stop();
			windows.play();
	}else if(e.getSource().equals(Frozen)){
		windows.stop();
		frozen.stop();
		trump.stop();
		frozen.play();
	}else if(e.getSource().equals(Trump)){
		windows.stop();
		frozen.stop();
		trump.stop();
		trump.play();
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}
}

