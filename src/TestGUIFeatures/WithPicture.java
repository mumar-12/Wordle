package TestGUIFeatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class WithPicture extends JFrame {
	
	public static SimpleAudioPlayer audioPlayer;
	Image img; 
	
	public WithPicture(String name, String imgName, String songName) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		img = Toolkit.getDefaultToolkit().getImage(imgName);
		audioPlayer = new SimpleAudioPlayer(songName);
		this.setContentPane(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, null);
			}
		});
		setTitle(name);
		pack();
		setVisible(true);
		
	}
	public static void ohno(String[] args) throws Exception {
		String imgName = "/Users/billytheredneck/eclipse-workspace/Wordler/Wallaper.jpg";//"/Users/billytheredneck/Downloads/kqaeN5I.jpg";
		String songName = "/Users/billytheredneck/eclipse-workspace/Wordler/01 Hibachi (feat. Flipp Dinero  Jadakiss).wav";
		JFrame frame = new WithPicture("With Picture", imgName, songName);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addMouseListener(null);
		
		JButton Play_Music = new JButton("Play Music");
		Play_Music.setOpaque(true);
		Play_Music.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		Play_Music.setBackground(Color.PINK);
		Play_Music.setBounds(1180, 770, 100, 30); //1280 x 670 or 1280x800 (FullScreen)
		Play_Music.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Play_Music.getText().equals("Play Music")) {
					audioPlayer.play();
					Play_Music.setText("Pause Music");
				} else if (Play_Music.getText().equals("Pause Music")) {
					audioPlayer.pause();
					Play_Music.setText("Resume Music");
				} else if (Play_Music.getText().equals("Resume Music")) {
					try {
						audioPlayer.resumeAudio();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						e1.printStackTrace();
					}
					Play_Music.setText("Pause Music");
				}
				
			} 
			
		});
		frame.getContentPane().add(Play_Music);
	}
}