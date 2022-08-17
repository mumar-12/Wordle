package Wordler;

import TestGUIFeatures.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;



public class Wordler_GUI {

	JFrame frame;

	private JTextField Guess_1;
	private JTextField Guess_2;
	private JTextField Guess_3;
	private JTextField Guess_4;
	private JTextField Guess_5;
	private JTextField Guess_6;

	static JLabel Progress;
	private static JLabel Feedback;

	private String imgName;
	private String songName;
	private JButton Play_Music_Button;
	private final Icon notStartedIcon = new ImageIcon(Controller.DIRECTORY + "Not Playing.png");
	private final Icon pauseIcon = new ImageIcon(Controller.DIRECTORY + "Paused.png"); 
	private final Icon playingIcon = new ImageIcon(Controller.DIRECTORY + "Playing.png"); 

	private JLabel LETTER_Q;
	private JLabel LETTER_W;
	private JLabel LETTER_E;
	private JLabel LETTER_R;
	private JLabel LETTER_T;
	private JLabel LETTER_Y;
	private JLabel LETTER_U;
	private JLabel LETTER_I;
	private JLabel LETTER_O;
	private JLabel LETTER_P;
	private JLabel LETTER_A;
	private JLabel LETTER_S;
	private JLabel LETTER_D;
	private JLabel LETTER_F;
	private JLabel LETTER_G;
	private JLabel LETTER_H;
	private JLabel LETTER_J;
	private JLabel LETTER_K;
	private JLabel LETTER_L;
	private JLabel LETTER_Z;
	private JLabel LETTER_X;
	private JLabel LETTER_C;
	private JLabel LETTER_V;
	private JLabel LETTER_B;
	private JLabel LETTER_N;
	private JLabel LETTER_M;

	private JButton Guess1_1;
	private JButton Guess1_2;
	private JButton Guess1_3;
	private JButton Guess1_4;
	private JButton Guess1_5;
	private JButton Guess2_1;
	private JButton Guess2_2;
	private JButton Guess2_3;
	private JButton Guess2_4;
	private JButton Guess2_5;
	private JButton Guess3_1;
	private JButton Guess3_2;
	private JButton Guess3_3;
	private JButton Guess3_4;
	private JButton Guess3_5;
	private JButton Guess4_1;
	private JButton Guess4_2;
	private JButton Guess4_3;
	private JButton Guess4_4;
	private JButton Guess4_5;
	private JButton Guess5_1;
	private JButton Guess5_2;
	private JButton Guess5_3;
	private JButton Guess5_4;
	private JButton Guess5_5;
	private JButton Guess6_1;
	private JButton Guess6_2;
	private JButton Guess6_3;
	private JButton Guess6_4;
	private JButton Guess6_5;

	private JButton Submit_Button;
	private JButton New_Game_Button;
	private static int currGuessCount;

	private static String currGuess;
	private static String currLetter;
	private static final int NUM_BUTTONS = 6;
	private HashMap <String, JTextField> guessMap = new HashMap<>();
	private HashMap <String, JLabel> letters = new HashMap<>();
	private JButton[][] buttonColors = new JButton[NUM_BUTTONS+1][NUM_BUTTONS];

	{
		Random rand = new Random();
		String imgPath = "";
		String songPath = "";
		int randomPosition = rand.nextInt(6);
		switch (randomPosition) {
		case 0: 
			imgPath = "Wallpaper.jpg";
			break;
		case 1: 
			imgPath = "Wallpaper 2.jpg";
			break;
		case 2: 
			imgPath = "Wallpaper 3.png";
			break;
		case 3: 
			imgPath = "Wallpaper 4.png";
			break;
		case 4: 
			imgPath = "Wallpaper 5.jpg";
			break;
		default: 
			imgPath = "Wallpaper 6.png";
			break;
			
		}
		randomPosition = rand.nextInt(7);
		switch (randomPosition) {
		case 0: 
			songPath = "Dark Thoughts";
			break;
		case 1: 
			songPath = "Fleur de Lis";
			break;
		case 2: 
			songPath = "Hibachi";
			break;
		case 3: 
			songPath = "River Flows In You";
			break;
		case 4: 
			songPath = "Relaxing 1";
			break;
		case 5: 
			songPath = "Relaxing 2";
			break;
		case 6: 
			songPath = "Relaxing 3";
			break;
		}
		imgName = Controller.DIRECTORY + imgPath;//"/Users/billytheredneck/Downloads/kqaeN5I.jpg";
		songName = Controller.DIRECTORY + songPath + ".wav";
	}

	private void initalValues(){
		currGuessCount = 1;
		currGuess = "Guess_1";
		currLetter = "";

		guessMap.put("Guess_1", Guess_1);
		guessMap.put("Guess_2", Guess_2);
		guessMap.put("Guess_3", Guess_3);
		guessMap.put("Guess_4", Guess_4);
		guessMap.put("Guess_5", Guess_5);
		guessMap.put("Guess_6", Guess_6);

		letters.put("Q", LETTER_Q);
		letters.put("W", LETTER_W);
		letters.put("E", LETTER_E);
		letters.put("R", LETTER_R);
		letters.put("T", LETTER_T);
		letters.put("Y", LETTER_Y);
		letters.put("U", LETTER_U);
		letters.put("I", LETTER_I);
		letters.put("O", LETTER_O);
		letters.put("P", LETTER_P);
		letters.put("A", LETTER_A);
		letters.put("S", LETTER_S);
		letters.put("D", LETTER_D);
		letters.put("F", LETTER_F);
		letters.put("G", LETTER_G);
		letters.put("H", LETTER_H);
		letters.put("J", LETTER_J);
		letters.put("K", LETTER_K);
		letters.put("L", LETTER_L);
		letters.put("Z", LETTER_Z);
		letters.put("X", LETTER_X);
		letters.put("C", LETTER_C);
		letters.put("V", LETTER_V);
		letters.put("B", LETTER_B);
		letters.put("N", LETTER_N);
		letters.put("M", LETTER_M);

		buttonColors[1][1] = Guess1_1;
		buttonColors[1][2] = Guess1_2;
		buttonColors[1][3] = Guess1_3;
		buttonColors[1][4] = Guess1_4;
		buttonColors[1][5] = Guess1_5;

		buttonColors[2][1] = Guess2_1;
		buttonColors[2][2] = Guess2_2;
		buttonColors[2][3] = Guess2_3;
		buttonColors[2][4] = Guess2_4;
		buttonColors[2][5] = Guess2_5;

		buttonColors[3][1] = Guess3_1;
		buttonColors[3][2] = Guess3_2;
		buttonColors[3][3] = Guess3_3;
		buttonColors[3][4] = Guess3_4;
		buttonColors[3][5] = Guess3_5;

		buttonColors[4][1] = Guess4_1;
		buttonColors[4][2] = Guess4_2;
		buttonColors[4][3] = Guess4_3;
		buttonColors[4][4] = Guess4_4;
		buttonColors[4][5] = Guess4_5;

		buttonColors[5][1] = Guess5_1;
		buttonColors[5][2] = Guess5_2;
		buttonColors[5][3] = Guess5_3;
		buttonColors[5][4] = Guess5_4;
		buttonColors[5][5] = Guess5_5;

		buttonColors[6][1] = Guess6_1;
		buttonColors[6][2] = Guess6_2;
		buttonColors[6][3] = Guess6_3;
		buttonColors[6][4] = Guess6_4;
		buttonColors[6][5] = Guess6_5;

	}


	//Creates a TextField where there is a limit to the amount of characters
	// that can be typed
	class JTextFieldLimit extends PlainDocument {

		private int limit;

		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
		}

		@Override
		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null || !str.toLowerCase().matches("(^[a-z|\\?]{1}$|[a-z]\\s|\\?\\s)+"))
				return;
			if ((getLength() + str.length()) <= limit) {
				offset = getLength();
				str = str.toLowerCase().matches("^[a-z|\\?]{1}$")? str + " ": str;
				super.insertString(offset, str.toUpperCase(), attr);
			} 
		}
	}

	//Creates a mouse where clicking does absolutely goddang nothing
	private class MyMouseListener extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent e) {
			// do nothing...
		}
	}

	//Creates a Rotatable JLabel
	private class RotateLabel extends JLabel {
		public RotateLabel(String text) {
			super(text);
			Font font = new Font("Verdana", Font.ITALIC, 10);
			FontMetrics metrics = new FontMetrics(font){};
			Rectangle2D bounds = metrics.getStringBounds(text, null);
			setBounds(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
		}
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D gx = (Graphics2D) g;
			gx.rotate(Math.toRadians(270), getX() + getWidth()/2, getY() + getHeight()/2);
			super.paintComponent(g);
		}
	}



	/**
	 * Create the application.
	 */
	public Wordler_GUI() {
		initialize();
		initalValues();
	}
	
	/**
	 * Create a dummy gui
	 */
	
	public Wordler_GUI(String dummy) {
		frame = new JFrame(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		//TextField Button Functionality
		ActionListener pressSubmit = new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				Submit_Button.doClick();
			} 

		};

		class backspaceAction extends AbstractAction {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					guessMap.get(currGuess).setText(
							guessMap.get(currGuess).getText().substring(
									0, guessMap.get(currGuess).getText().length()-2));
				} catch (StringIndexOutOfBoundsException e1) {
					guessMap.get(currGuess).setText("");

				}
			}
		}


		//Frame Stuff
		
		try {
			frame = new WithPicture("Wordler", imgName, songName);
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e3) {
			e3.printStackTrace();
		}
		 
		//frame = new JFrame();
		//frame.setLayout(new FlowLayout());
		frame.getRootPane().setDefaultButton(Submit_Button);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addMouseListener(null);
		//frame.pack();
		//frame.setVisible(true);
		


		Play_Music_Button = new JButton(notStartedIcon);
		Play_Music_Button.setOpaque(true);
		Play_Music_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		Play_Music_Button.setBackground(Color.WHITE);
		Play_Music_Button.setBounds(1255, 640, 25, 30); //1280 x 670 or 1280x800 (FullScreen)
		Play_Music_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Play_Music_Button.getIcon().equals(notStartedIcon)) {
					WithPicture.audioPlayer.play();
					Play_Music_Button.setIcon(playingIcon);
				} else if (Play_Music_Button.getIcon().equals(playingIcon)) {
					WithPicture.audioPlayer.pause();
					Play_Music_Button.setIcon(pauseIcon);
				} else if (Play_Music_Button.getIcon().equals(pauseIcon)) {
					try {
						WithPicture.audioPlayer.resumeAudio();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						e1.printStackTrace();
					}
					Play_Music_Button.setIcon(playingIcon);
				}

			} 

		});

		//Guess 1 TextField
		Guess_1 = new JTextField();
		Guess_1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_1.setCaretPosition(Guess_1.getDocument().getLength());
			}
		});
		Guess_1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "do something");
		Guess_1.getActionMap().put("do something", new backspaceAction());

		//Guess 2 TextField
		Guess_2 = new JTextField();
		Guess_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_2.setCaretPosition(Guess_2.getDocument().getLength());
			}
		});
		Guess_2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "do something");
		Guess_2.getActionMap().put("do something", new backspaceAction());

		//Guess 3 TextField
		Guess_3 = new JTextField();
		Guess_3.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_3.setCaretPosition(Guess_3.getDocument().getLength());
			}
		});
		Guess_3.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_3.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_3.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "do something");
		Guess_3.getActionMap().put("do something", new backspaceAction());

		//Guess 4 TextField
		Guess_4 = new JTextField();
		Guess_4.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_4.setCaretPosition(Guess_4.getDocument().getLength());
			}
		});
		Guess_4.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_4.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_4.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "do something");
		Guess_4.getActionMap().put("do something", new backspaceAction());

		//Guess 5 TextField
		Guess_5 = new JTextField();
		Guess_5.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_5.setCaretPosition(Guess_5.getDocument().getLength());
			}
		});
		Guess_5.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_5.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_5.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "do something");
		Guess_5.getActionMap().put("do something", new backspaceAction());

		Guess_6 = new JTextField();
		Guess_6.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_6.setCaretPosition(Guess_6.getDocument().getLength());
			}
		});
		Guess_6.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_6.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_6.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "do something");
		Guess_6.getActionMap().put("do something", new backspaceAction());

		Progress = new JLabel("? ? ? ? ?");
		Progress.setForeground(Color.WHITE);
		Progress.setBackground(new Color(100,100,100,0));
		Progress.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Progress.setFont(new Font("Courier", Font.PLAIN, 60));
		Progress.setBounds(196, 509, 383, 71);
		frame.getContentPane().add(Progress);
		
		Guess_6.setDocument(new JTextFieldLimit(10));
		Guess_6.setForeground(Color.WHITE);
		Guess_6.setBackground(new Color(100,100,100,0));
		Guess_6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_6.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_6.setBounds(196, 425, 383, 71);
		frame.getContentPane().add(Guess_6);
		Guess_6.addActionListener(pressSubmit);
		Guess_6.setColumns(15);
		Guess_6.setEnabled(false);
		Guess_6.setDisabledTextColor(Color.WHITE);
		
		Guess_5.setDocument(new JTextFieldLimit(10));
		Guess_5.setForeground(Color.WHITE);
		Guess_5.setBackground(new Color(100,100,100,0));
		Guess_5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_5.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_5.setBounds(196, 341, 383, 71);
		frame.getContentPane().add(Guess_5);
		Guess_5.addActionListener(pressSubmit);
		Guess_5.setColumns(15);
		Guess_5.setEnabled(false);
		Guess_5.setDisabledTextColor(Color.WHITE);
		
		Guess_4.setDocument(new JTextFieldLimit(10));
		Guess_4.setForeground(Color.WHITE);
		Guess_4.setBackground(new Color(100,100,100,0));
		Guess_4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_4.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_4.setBounds(196, 257, 383, 71);
		frame.getContentPane().add(Guess_4);
		Guess_4.addActionListener(pressSubmit);
		Guess_4.setColumns(15);
		Guess_4.setEnabled(false);
		Guess_4.setDisabledTextColor(Color.WHITE);
		
		Guess_3.setDocument(new JTextFieldLimit(10));
		Guess_3.setForeground(Color.WHITE);
		Guess_3.setBackground(new Color(100,100,100,0));
		Guess_3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_3.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_3.setBounds(196, 173, 383, 71);
		frame.getContentPane().add(Guess_3);
		Guess_3.addActionListener(pressSubmit);
		Guess_3.setColumns(15);
		Guess_3.setEnabled(false);
		Guess_3.setDisabledTextColor(Color.WHITE);
		
		Guess_2.setDocument(new JTextFieldLimit(10));
		Guess_2.setForeground(Color.WHITE);
		Guess_2.setBackground(new Color(100,100,100,0));
		Guess_2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_2.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_2.setBounds(196, 89, 383, 71);
		frame.getContentPane().add(Guess_2);
		Guess_2.addActionListener(pressSubmit);
		Guess_2.setColumns(15);
		Guess_2.setEnabled(false);
		Guess_2.setDisabledTextColor(Color.WHITE);
		
		Guess_1.setDocument(new JTextFieldLimit(10));
		Guess_1.setForeground(Color.WHITE);
		Guess_1.setBackground(new Color(100,100,100,0));
		Guess_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_1.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_1.setBounds(196, 6, 383, 71);
		frame.getContentPane().add(Guess_1);
		Guess_1.addActionListener(pressSubmit);
		Guess_1.setColumns(15);
		Guess_1.setDisabledTextColor(Color.WHITE);
		frame.getContentPane().add(Play_Music_Button);

		Feedback = new JLabel("");
		Feedback.setHorizontalAlignment(SwingConstants.LEFT);
		Feedback.setForeground(Color.WHITE);
		Feedback.setBackground(new Color(100,100,100,0));
		Feedback.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Feedback.setFont(new Font("Courier", Font.PLAIN, 30));
		Feedback.setBounds(196, 593, 383, 71);
		frame.getContentPane().add(Feedback);

		//Background Colors for all the Guesses
		Guess1_1 = new JButton("");
		Guess1_1.setEnabled(false);
		Guess1_1.setOpaque(true);
		Guess1_1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess1_1.setBackground(Color.PINK);
		Guess1_1.setBounds(188, 6, 60, 71);
		frame.getContentPane().add(Guess1_1);

		Guess1_2 = new JButton("");
		Guess1_2.setEnabled(false);
		Guess1_2.setOpaque(true);
		Guess1_2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess1_2.setBackground(Color.PINK);
		Guess1_2.setBounds(258, 6, 60, 71);
		frame.getContentPane().add(Guess1_2);

		Guess1_3 = new JButton("");
		Guess1_3.setEnabled(false);
		Guess1_3.setOpaque(true);
		Guess1_3.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess1_3.setBackground(Color.PINK);
		Guess1_3.setBounds(330, 6, 60, 71);
		frame.getContentPane().add(Guess1_3);

		Guess1_4 = new JButton("");
		Guess1_4.setEnabled(false);
		Guess1_4.setOpaque(true);
		Guess1_4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess1_4.setBackground(Color.PINK);
		Guess1_4.setBounds(404, 6, 60, 71);
		frame.getContentPane().add(Guess1_4);

		Guess1_5 = new JButton("");
		Guess1_5.setEnabled(false);
		Guess1_5.setOpaque(true);
		Guess1_5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess1_5.setBackground(Color.PINK);
		Guess1_5.setBounds(474, 6, 60, 71);
		frame.getContentPane().add(Guess1_5);

		Guess2_1 = new JButton("");
		Guess2_1.setEnabled(false);
		Guess2_1.setBackground(Color.LIGHT_GRAY);
		Guess2_1.setOpaque(true);
		Guess2_1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess2_1.setBounds(188, 89, 60, 71);
		frame.getContentPane().add(Guess2_1);

		Guess2_2 = new JButton("");
		Guess2_2.setEnabled(false);
		Guess2_2.setOpaque(true);
		Guess2_2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess2_2.setBackground(Color.LIGHT_GRAY); 
		Guess2_2.setBounds(258, 89, 60, 71);
		frame.getContentPane().add(Guess2_2);

		Guess2_3 = new JButton("");
		Guess2_3.setEnabled(false);
		Guess2_3.setOpaque(true);
		Guess2_3.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess2_3.setBackground(Color.LIGHT_GRAY); 
		Guess2_3.setBounds(330, 89, 60, 71);
		frame.getContentPane().add(Guess2_3);

		Guess2_4 = new JButton("");
		Guess2_4.setEnabled(false);
		Guess2_4.setOpaque(true);
		Guess2_4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess2_4.setBackground(Color.LIGHT_GRAY);
		Guess2_4.setBounds(404, 89, 60, 71);
		frame.getContentPane().add(Guess2_4);

		Guess2_5 = new JButton("");
		Guess2_5.setEnabled(false);
		Guess2_5.setOpaque(true);
		Guess2_5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess2_5.setBackground(Color.LIGHT_GRAY);
		Guess2_5.setBounds(474, 89, 60, 71);
		frame.getContentPane().add(Guess2_5);

		Guess3_1 = new JButton("");
		Guess3_1.setOpaque(true);
		Guess3_1.setEnabled(false);
		Guess3_1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess3_1.setBackground(Color.LIGHT_GRAY);
		Guess3_1.setBounds(188, 173, 60, 71);
		frame.getContentPane().add(Guess3_1);

		Guess3_2 = new JButton("");
		Guess3_2.setOpaque(true);
		Guess3_2.setEnabled(false);
		Guess3_2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess3_2.setBackground(Color.LIGHT_GRAY);
		Guess3_2.setBounds(258, 173, 60, 71);
		frame.getContentPane().add(Guess3_2);

		Guess3_3 = new JButton("");
		Guess3_3.setOpaque(true);
		Guess3_3.setEnabled(false);
		Guess3_3.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess3_3.setBackground(Color.LIGHT_GRAY);
		Guess3_3.setBounds(330, 173, 60, 71);
		frame.getContentPane().add(Guess3_3);

		Guess3_4 = new JButton("");
		Guess3_4.setOpaque(true);
		Guess3_4.setEnabled(false);
		Guess3_4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess3_4.setBackground(Color.LIGHT_GRAY);
		Guess3_4.setBounds(404, 173, 60, 71);
		frame.getContentPane().add(Guess3_4);

		Guess3_5 = new JButton("");
		Guess3_5.setOpaque(true);
		Guess3_5.setEnabled(false);
		Guess3_5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess3_5.setBackground(Color.LIGHT_GRAY);
		Guess3_5.setBounds(474, 173, 60, 71);
		frame.getContentPane().add(Guess3_5);

		Guess4_1 = new JButton("");
		Guess4_1.setOpaque(true);
		Guess4_1.setEnabled(false);
		Guess4_1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess4_1.setBackground(Color.LIGHT_GRAY);
		Guess4_1.setBounds(188, 257, 60, 71);
		frame.getContentPane().add(Guess4_1);

		Guess4_2 = new JButton("");
		Guess4_2.setOpaque(true);
		Guess4_2.setEnabled(false);
		Guess4_2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess4_2.setBackground(Color.LIGHT_GRAY);
		Guess4_2.setBounds(258, 257, 60, 71);
		frame.getContentPane().add(Guess4_2);

		Guess4_3 = new JButton("");
		Guess4_3.setOpaque(true);
		Guess4_3.setEnabled(false);
		Guess4_3.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess4_3.setBackground(Color.LIGHT_GRAY);
		Guess4_3.setBounds(330, 257, 60, 71);
		frame.getContentPane().add(Guess4_3);

		Guess4_4 = new JButton("");
		Guess4_4.setOpaque(true);
		Guess4_4.setEnabled(false);
		Guess4_4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess4_4.setBackground(Color.LIGHT_GRAY);
		Guess4_4.setBounds(404, 257, 60, 71);
		frame.getContentPane().add(Guess4_4);

		Guess4_5 = new JButton("");
		Guess4_5.setOpaque(true);
		Guess4_5.setEnabled(false);
		Guess4_5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess4_5.setBackground(Color.LIGHT_GRAY);
		Guess4_5.setBounds(474, 257, 60, 71);
		frame.getContentPane().add(Guess4_5);

		Guess5_1 = new JButton("");
		Guess5_1.setOpaque(true);
		Guess5_1.setEnabled(false);
		Guess5_1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess5_1.setBackground(Color.LIGHT_GRAY);
		Guess5_1.setBounds(188, 341, 60, 71);
		frame.getContentPane().add(Guess5_1);

		Guess5_2 = new JButton("");
		Guess5_2.setOpaque(true);
		Guess5_2.setEnabled(false);
		Guess5_2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess5_2.setBackground(Color.LIGHT_GRAY);
		Guess5_2.setBounds(258, 341, 60, 71);
		frame.getContentPane().add(Guess5_2);

		Guess5_3 = new JButton("");
		Guess5_3.setOpaque(true);
		Guess5_3.setEnabled(false);
		Guess5_3.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess5_3.setBackground(Color.LIGHT_GRAY);
		Guess5_3.setBounds(330, 341, 60, 71);
		frame.getContentPane().add(Guess5_3);

		Guess5_4 = new JButton("");
		Guess5_4.setOpaque(true);
		Guess5_4.setEnabled(false);
		Guess5_4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess5_4.setBackground(Color.LIGHT_GRAY);
		Guess5_4.setBounds(404, 341, 60, 71);
		frame.getContentPane().add(Guess5_4);

		Guess5_5 = new JButton("");
		Guess5_5.setOpaque(true);
		Guess5_5.setEnabled(false);
		Guess5_5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess5_5.setBackground(Color.LIGHT_GRAY);
		Guess5_5.setBounds(474, 341, 60, 71);
		frame.getContentPane().add(Guess5_5);

		Guess6_1 = new JButton("");
		Guess6_1.setOpaque(true);
		Guess6_1.setEnabled(false);
		Guess6_1.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess6_1.setBackground(Color.LIGHT_GRAY);
		Guess6_1.setBounds(188, 425, 60, 71);
		frame.getContentPane().add(Guess6_1);

		Guess6_2 = new JButton("");
		Guess6_2.setOpaque(true);
		Guess6_2.setEnabled(false);
		Guess6_2.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess6_2.setBackground(Color.LIGHT_GRAY);
		Guess6_2.setBounds(258, 425, 60, 71);
		frame.getContentPane().add(Guess6_2);

		Guess6_3 = new JButton("");
		Guess6_3.setOpaque(true);
		Guess6_3.setEnabled(false);
		Guess6_3.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess6_3.setBackground(Color.LIGHT_GRAY);
		Guess6_3.setBounds(330, 425, 60, 71);
		frame.getContentPane().add(Guess6_3);

		Guess6_4 = new JButton("");
		Guess6_4.setOpaque(true);
		Guess6_4.setEnabled(false);
		Guess6_4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess6_4.setBackground(Color.LIGHT_GRAY);
		Guess6_4.setBounds(404, 425, 60, 71);
		frame.getContentPane().add(Guess6_4);

		Guess6_5 = new JButton("");
		Guess6_5.setOpaque(true);
		Guess6_5.setEnabled(false);
		Guess6_5.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		Guess6_5.setBackground(Color.LIGHT_GRAY);
		Guess6_5.setBounds(474, 425, 60, 71);
		frame.getContentPane().add(Guess6_5);

		if (imgName.equals(Controller.DIRECTORY)) {
			JLabel Wordler_Design = new RotateLabel("WORDLER");
			Wordler_Design.setForeground(Color.GREEN);
			Wordler_Design.setFont(new Font("Bodoni Ornaments", Font.PLAIN, 80));
			Wordler_Design.setBounds(0, 6, 300, 350);
			frame.getContentPane().add(Wordler_Design);
		}

		Submit_Button = new JButton("Submit");
		Submit_Button.setVisible(false);
		Submit_Button.setOpaque(true);
		Submit_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		Submit_Button.setBackground(Color.PINK);
		Submit_Button.setBounds(303, 424, 117, 29);
		Submit_Button.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				Wordler_Logic currAttempt = new Wordler_Logic(guessMap.get(currGuess).getText(), Progress.getText());
				try {
					Color[] currGuessColors = currAttempt.wordCheck();
					guessMap.get(currGuess).setEditable(false);
					changeBoxColor(currGuessColors);
					changeLetterColor(currGuessColors,guessMap.get(currGuess).getText().replace(" ", "").toUpperCase());
					guessMap.get(currGuess).setText(guessMap.get(currGuess).getText());
					currGuessCount++;
					if (currGuessColors[0] == Color.GREEN) { //Correct! 
						New_Game_Button.setVisible(true);
						New_Game_Button.setEnabled(true);
						currAttempt.displayCorrectWord();
						guessMap.get(currGuess).setText(guessMap.get(currGuess).getText());
						Submit_Button.setEnabled(false);
					} else if (currGuessCount != 7) { //No More Guesses
						currGuess = "Guess_" + currGuessCount;
						guessMap.get(currGuess).setEnabled(true);
						guessMap.get(currGuess).setText("");
						guessMap.get(currGuess).requestFocus();
					} else { //Incorrect!
						New_Game_Button.setVisible(true);
						New_Game_Button.setEnabled(true);
						currAttempt.displayCorrectWord();
						guessMap.get(currGuess).setText(guessMap.get(currGuess).getText());
						Submit_Button.setEnabled(false);
					}
				} catch (IllegalArgumentException e1) {
					Feedback.setText("Not Enough Letters");
					new java.util.Timer().schedule( 
							new java.util.TimerTask() {
								@Override
								public void run() {
									Feedback.setText("");
								}
							}, 
							1000 
							);
				} catch (TypeNotPresentException e2) {
					Feedback.setText("Not in wordList");
					new java.util.Timer().schedule( 
							new java.util.TimerTask() {
								@Override
								public void run() {
									Feedback.setText("");
								}
							}, 
							1000 
							);
				}
			}

			private void changeBoxColor(Color[] newColors) {
				for (int index = 1; index < NUM_BUTTONS; index++) {
					buttonColors[currGuessCount][index].setBackground(newColors[index]);
					if (newColors[0] != Color.GREEN && currGuessCount != 6 ) //On last guess
						buttonColors[currGuessCount+1][index].setBackground(Color.PINK);
				}				
			}

			private void changeLetterColor(Color[] newColors, String currWord) {
				for (int index = 1; index < NUM_BUTTONS; index++) {
					currLetter = String.valueOf(currWord.charAt(index-1));
					Color currentColor = letters.get(currLetter).getBackground();
					if (buttonColors[currGuessCount][index].getBackground().equals(Color.GREEN)) {
						letters.get(currLetter).setBackground(Color.GREEN);
					}
					if (currentColor.equals(Color.LIGHT_GRAY) || currentColor.equals(Color.ORANGE)) {
						//Checks for duplicate letters not in word, so like the L's in "spill"
						if (currentColor.equals(Color.ORANGE) && buttonColors[currGuessCount][index].getBackground().equals(new Color(109,109,109))) {
							//do nothing because letter is still in word
						} else {
							letters.get(currLetter).setBackground(buttonColors[currGuessCount][index].getBackground());
						}
						
					} 
					/*
					//Letters not in word will be blacked out
					if (letters.get(currLetter).getBackground().equals(new Color(109,109,109))) {
						letters.get(currLetter).setBackground(Color.BLACK);
						letters.get(currLetter).setText("");
					}
					*/
				}				
			} 

		});
		frame.getContentPane().add(Submit_Button);

		New_Game_Button = new JButton("New Game");
		New_Game_Button.setVisible(false);
		New_Game_Button.setOpaque(true);
		New_Game_Button.setEnabled(false);
		New_Game_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		New_Game_Button.setBackground(Color.PINK);
		New_Game_Button.setBounds(303, 593, 117, 29);
		New_Game_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Wordler_Logic.setCorrectWord();
				try {
					WithPicture.audioPlayer.stop();
					Controller.main(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} 

		});
		frame.getContentPane().add(New_Game_Button);

		LETTER_Q = new JLabel("Q");
		LETTER_Q.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_Q.setOpaque(true);
		LETTER_Q.setForeground(Color.WHITE);
		LETTER_Q.setBackground(Color.LIGHT_GRAY);
		LETTER_Q.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_Q.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_Q.setBounds(642, 193, 52, 55);
		frame.getContentPane().add(LETTER_Q);

		LETTER_W = new JLabel("W");
		LETTER_W.setOpaque(true);
		LETTER_W.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_W.setForeground(Color.WHITE);
		LETTER_W.setBackground(Color.LIGHT_GRAY);
		LETTER_W.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_W.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_W.setBounds(706, 193, 52, 55);
		frame.getContentPane().add(LETTER_W);

		LETTER_E = new JLabel("E");
		LETTER_E.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_E.setOpaque(true);
		LETTER_E.setForeground(Color.WHITE);
		LETTER_E.setBackground(Color.LIGHT_GRAY);
		LETTER_E.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_E.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_E.setBounds(770, 193, 52, 55);
		frame.getContentPane().add(LETTER_E);

		LETTER_R = new JLabel("R");
		LETTER_R.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_R.setOpaque(true);
		LETTER_R.setForeground(Color.WHITE);
		LETTER_R.setBackground(Color.LIGHT_GRAY);
		LETTER_R.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_R.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_R.setBounds(834, 193, 52, 55);
		frame.getContentPane().add(LETTER_R);

		LETTER_T = new JLabel("T");
		LETTER_T.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_T.setOpaque(true);
		LETTER_T.setForeground(Color.WHITE);
		LETTER_T.setBackground(Color.LIGHT_GRAY);
		LETTER_T.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_T.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_T.setBounds(898, 193, 52, 55);
		frame.getContentPane().add(LETTER_T);

		LETTER_Y = new JLabel("Y");
		LETTER_Y.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_Y.setOpaque(true);
		LETTER_Y.setForeground(Color.WHITE);
		LETTER_Y.setBackground(Color.LIGHT_GRAY);
		LETTER_Y.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_Y.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_Y.setBounds(962, 193, 52, 55);
		frame.getContentPane().add(LETTER_Y);

		LETTER_U = new JLabel("U");
		LETTER_U.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_U.setOpaque(true);
		LETTER_U.setForeground(Color.WHITE);
		LETTER_U.setBackground(Color.LIGHT_GRAY);
		LETTER_U.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_U.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_U.setBounds(1026, 193, 52, 55);
		frame.getContentPane().add(LETTER_U);

		LETTER_I = new JLabel("I");
		LETTER_I.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_I.setOpaque(true);
		LETTER_I.setForeground(Color.WHITE);
		LETTER_I.setBackground(Color.LIGHT_GRAY);
		LETTER_I.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_I.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_I.setBounds(1090, 193, 52, 55);
		frame.getContentPane().add(LETTER_I);

		LETTER_O = new JLabel("O");
		LETTER_O.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_O.setOpaque(true);
		LETTER_O.setForeground(Color.WHITE);
		LETTER_O.setBackground(Color.LIGHT_GRAY);
		LETTER_O.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_O.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_O.setBounds(1154, 193, 52, 55);
		frame.getContentPane().add(LETTER_O);

		LETTER_P = new JLabel("P");
		LETTER_P.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_P.setOpaque(true);
		LETTER_P.setForeground(Color.WHITE);
		LETTER_P.setBackground(Color.LIGHT_GRAY);
		LETTER_P.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_P.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_P.setBounds(1218, 193, 52, 55);
		frame.getContentPane().add(LETTER_P);

		LETTER_A = new JLabel("A");
		LETTER_A.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_A.setOpaque(true);
		LETTER_A.setForeground(Color.WHITE);
		LETTER_A.setBackground(Color.LIGHT_GRAY);
		LETTER_A.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_A.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_A.setBounds(684, 260, 52, 55);
		frame.getContentPane().add(LETTER_A);

		LETTER_S = new JLabel("S");
		LETTER_S.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_S.setOpaque(true);
		LETTER_S.setForeground(Color.WHITE);
		LETTER_S.setBackground(Color.LIGHT_GRAY);
		LETTER_S.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_S.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_S.setBounds(748, 260, 52, 55);
		frame.getContentPane().add(LETTER_S);

		LETTER_D = new JLabel("D");
		LETTER_D.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_D.setOpaque(true);
		LETTER_D.setForeground(Color.WHITE);
		LETTER_D.setBackground(Color.LIGHT_GRAY);
		LETTER_D.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_D.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_D.setBounds(812, 260, 52, 55);
		frame.getContentPane().add(LETTER_D);

		LETTER_F = new JLabel("F");
		LETTER_F.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_F.setOpaque(true);
		LETTER_F.setForeground(Color.WHITE);
		LETTER_F.setBackground(Color.LIGHT_GRAY);
		LETTER_F.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_F.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_F.setBounds(876, 260, 52, 55);
		frame.getContentPane().add(LETTER_F);

		LETTER_G = new JLabel("G");
		LETTER_G.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_G.setOpaque(true);
		LETTER_G.setForeground(Color.WHITE);
		LETTER_G.setBackground(Color.LIGHT_GRAY);
		LETTER_G.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_G.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_G.setBounds(940, 260, 52, 55);
		frame.getContentPane().add(LETTER_G);

		LETTER_H = new JLabel("H");
		LETTER_H.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_H.setOpaque(true);
		LETTER_H.setForeground(Color.WHITE);
		LETTER_H.setBackground(Color.LIGHT_GRAY);
		LETTER_H.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_H.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_H.setBounds(1004, 260, 52, 55);
		frame.getContentPane().add(LETTER_H);

		LETTER_J = new JLabel("J");
		LETTER_J.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_J.setOpaque(true);
		LETTER_J.setForeground(Color.WHITE);
		LETTER_J.setBackground(Color.LIGHT_GRAY);
		LETTER_J.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_J.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_J.setBounds(1068, 260, 52, 55);
		frame.getContentPane().add(LETTER_J);

		LETTER_K = new JLabel("K");
		LETTER_K.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_K.setOpaque(true);
		LETTER_K.setForeground(Color.WHITE);
		LETTER_K.setBackground(Color.LIGHT_GRAY);
		LETTER_K.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_K.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_K.setBounds(1132, 260, 52, 55);
		frame.getContentPane().add(LETTER_K);

		LETTER_L = new JLabel("L");
		LETTER_L.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_L.setOpaque(true);
		LETTER_L.setForeground(Color.WHITE);
		LETTER_L.setBackground(Color.LIGHT_GRAY);
		LETTER_L.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_L.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_L.setBounds(1196, 260, 52, 55);
		frame.getContentPane().add(LETTER_L);

		LETTER_Z = new JLabel("Z");
		LETTER_Z.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_Z.setOpaque(true);
		LETTER_Z.setForeground(Color.WHITE);
		LETTER_Z.setBackground(Color.LIGHT_GRAY);
		LETTER_Z.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_Z.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_Z.setBounds(726, 327, 52, 55);
		frame.getContentPane().add(LETTER_Z);

		LETTER_X = new JLabel("X");
		LETTER_X.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_X.setOpaque(true);
		LETTER_X.setForeground(Color.WHITE);
		LETTER_X.setBackground(Color.LIGHT_GRAY);
		LETTER_X.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_X.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_X.setBounds(790, 327, 52, 55);
		frame.getContentPane().add(LETTER_X);

		LETTER_C = new JLabel("C");
		LETTER_C.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_C.setOpaque(true);
		LETTER_C.setForeground(Color.WHITE);
		LETTER_C.setBackground(Color.LIGHT_GRAY);
		LETTER_C.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_C.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_C.setBounds(854, 327, 52, 55);
		frame.getContentPane().add(LETTER_C);

		LETTER_V = new JLabel("V");
		LETTER_V.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_V.setOpaque(true);
		LETTER_V.setForeground(Color.WHITE);
		LETTER_V.setBackground(Color.LIGHT_GRAY);
		LETTER_V.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_V.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_V.setBounds(918, 327, 52, 55);
		frame.getContentPane().add(LETTER_V);

		LETTER_B = new JLabel("B");
		LETTER_B.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_B.setOpaque(true);
		LETTER_B.setForeground(Color.WHITE);
		LETTER_B.setBackground(Color.LIGHT_GRAY);
		LETTER_B.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_B.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_B.setBounds(982, 327, 52, 55);
		frame.getContentPane().add(LETTER_B);

		LETTER_N = new JLabel("N");
		LETTER_N.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_N.setOpaque(true);
		LETTER_N.setForeground(Color.WHITE);
		LETTER_N.setBackground(Color.LIGHT_GRAY);
		LETTER_N.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_N.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_N.setBounds(1046, 327, 52, 55);
		frame.getContentPane().add(LETTER_N);

		LETTER_M = new JLabel("M");
		LETTER_M.setHorizontalAlignment(SwingConstants.CENTER);
		LETTER_M.setOpaque(true);
		LETTER_M.setForeground(Color.WHITE);
		LETTER_M.setBackground(Color.LIGHT_GRAY);
		LETTER_M.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		LETTER_M.setFont(new Font("Courier", Font.PLAIN, 50));
		LETTER_M.setBounds(1110, 327, 52, 55);
		frame.getContentPane().add(LETTER_M);



	}
}
