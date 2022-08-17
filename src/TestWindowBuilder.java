import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;



public class TestWindowBuilder {

	private JFrame frame;
	private JTextField Guess_1;
	private JTextField Guess_2;
	private JTextField Guess_3;
	private JTextField Guess_4;
	private JTextField Guess_5;
	private JButton Submit_Button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindowBuilder window = new TestWindowBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
			if (str == null || !str.toLowerCase().matches("[a-z]+|\\?"))
				return;
			if ((getLength() + str.length()) <= limit) {
				offset = getLength();
				super.insertString(offset, str.toUpperCase() + " ", attr);
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
	public TestWindowBuilder() {
		initialize();
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

		//Frame Stuff
		frame = new JFrame();
		frame.getRootPane().setDefaultButton(Submit_Button);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 740, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addMouseListener(null);
		

		//Guess 1 Button
		Guess_1 = new JTextField();
		Guess_1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_1.setCaretPosition(Guess_1.getDocument().getLength());
			}
		});
		Guess_1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_1.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_1.setDocument(new JTextFieldLimit(10));
		Guess_1.setForeground(Color.WHITE);
		Guess_1.setBackground(new Color(100,100,100,0));
		Guess_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_1.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_1.setBounds(196, 6, 383, 71);
		frame.getContentPane().add(Guess_1);
		Guess_1.addActionListener(pressSubmit);
		Guess_1.setColumns(15);

		//Guess 2 Button
		Guess_2 = new JTextField();
		Guess_2.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_2.setCaretPosition(Guess_2.getDocument().getLength());
			}
		});
		Guess_2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_2.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_2.setDocument(new JTextFieldLimit(10));
		Guess_2.setForeground(Color.WHITE);
		Guess_2.setBackground(new Color(100,100,100,0));
		Guess_2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_2.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_2.setBounds(196, 89, 383, 71);
		frame.getContentPane().add(Guess_2);
		Guess_2.addActionListener(pressSubmit);
		Guess_2.setColumns(15);

		//Guess 3 Button
		Guess_3 = new JTextField();
		Guess_3.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_3.setCaretPosition(Guess_3.getDocument().getLength());
			}
		});
		Guess_3.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_3.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_3.setDocument(new JTextFieldLimit(10));
		Guess_3.setForeground(Color.WHITE);
		Guess_3.setBackground(new Color(100,100,100,0));
		Guess_3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_3.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_3.setBounds(196, 173, 383, 71);
		frame.getContentPane().add(Guess_3);
		Guess_3.addActionListener(pressSubmit);
		Guess_3.setColumns(15);

		//Guess 4 Button
		Guess_4 = new JTextField();
		Guess_4.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_4.setCaretPosition(Guess_4.getDocument().getLength());
			}
		});
		Guess_4.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_4.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_4.setDocument(new JTextFieldLimit(10));
		Guess_4.setForeground(Color.WHITE);
		Guess_4.setBackground(new Color(100,100,100,0));
		Guess_4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_4.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_4.setBounds(196, 257, 383, 71);
		frame.getContentPane().add(Guess_4);
		Guess_4.addActionListener(pressSubmit);
		Guess_4.setColumns(15);

		//Guess 5 Button
		Guess_5 = new JTextField();
		Guess_5.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				Guess_5.setCaretPosition(Guess_5.getDocument().getLength());
			}
		});
		Guess_5.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "noaction");
		Guess_5.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "noaction");
		Guess_5.setDocument(new JTextFieldLimit(10));
		Guess_5.setForeground(Color.WHITE);
		Guess_5.setBackground(new Color(100,100,100,0));
		Guess_5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Guess_5.setFont(new Font("Courier", Font.PLAIN, 60));
		Guess_5.setBounds(196, 341, 383, 71);
		frame.getContentPane().add(Guess_5);
		Guess_5.addActionListener(pressSubmit);
		Guess_5.setColumns(15);

		//Background Colors for all the Guesses
		JButton Guess1_1 = new JButton("");
		Guess1_1.setEnabled(false);
		Guess1_1.setOpaque(true);
		Guess1_1.setBorderPainted(false);
		Guess1_1.setBackground(Color.PINK);
		Guess1_1.setBounds(188, 6, 60, 71);
		frame.getContentPane().add(Guess1_1);

		JButton Guess1_2 = new JButton("");
		Guess1_2.setEnabled(false);
		Guess1_2.setOpaque(true);
		Guess1_2.setBorderPainted(false);
		Guess1_2.setBackground(Color.PINK);
		Guess1_2.setBounds(258, 6, 60, 71);
		frame.getContentPane().add(Guess1_2);

		JButton Guess1_3 = new JButton("");
		Guess1_3.setEnabled(false);
		Guess1_3.setOpaque(true);
		Guess1_3.setBorderPainted(false);
		Guess1_3.setBackground(Color.PINK);
		Guess1_3.setBounds(330, 6, 60, 71);
		frame.getContentPane().add(Guess1_3);

		JButton Guess1_4 = new JButton("");
		Guess1_4.setEnabled(false);
		Guess1_4.setOpaque(true);
		Guess1_4.setBorderPainted(false);
		Guess1_4.setBackground(Color.PINK);
		Guess1_4.setBounds(404, 6, 60, 71);
		frame.getContentPane().add(Guess1_4);

		JButton Guess1_5 = new JButton("");
		Guess1_5.setEnabled(false);
		Guess1_5.setOpaque(true);
		Guess1_5.setBorderPainted(false);
		Guess1_5.setBackground(Color.PINK);
		Guess1_5.setBounds(474, 6, 60, 71);
		frame.getContentPane().add(Guess1_5);

		JButton Guess2_1 = new JButton("");
		Guess2_1.setEnabled(false);
		Guess2_1.setBackground(new Color(109,109,109));; //Incorrect
		Guess2_1.setOpaque(true);
		Guess2_1.setBorderPainted(false);
		Guess2_1.setBounds(188, 89, 60, 71);
		frame.getContentPane().add(Guess2_1);

		JButton Guess2_2 = new JButton("");
		Guess2_2.setEnabled(false);
		Guess2_2.setOpaque(true);
		Guess2_2.setBorderPainted(false);
		Guess2_2.setBackground(Color.ORANGE); //Wrong Spot
		Guess2_2.setBounds(258, 89, 60, 71);
		frame.getContentPane().add(Guess2_2);

		JButton Guess2_3 = new JButton("");
		Guess2_3.setEnabled(false);
		Guess2_3.setOpaque(true);
		Guess2_3.setBorderPainted(false);
		Guess2_3.setBackground(Color.GREEN); //Correct!
		Guess2_3.setBounds(330, 89, 60, 71);
		frame.getContentPane().add(Guess2_3);

		JButton Guess2_4 = new JButton("");
		Guess2_4.setEnabled(false);
		Guess2_4.setOpaque(true);
		Guess2_4.setBorderPainted(false);
		Guess2_4.setBackground(Color.LIGHT_GRAY);
		Guess2_4.setBounds(404, 89, 60, 71);
		frame.getContentPane().add(Guess2_4);

		JButton Guess2_5 = new JButton("");
		Guess2_5.setEnabled(false);
		Guess2_5.setOpaque(true);
		Guess2_5.setBorderPainted(false);
		Guess2_5.setBackground(Color.LIGHT_GRAY);
		Guess2_5.setBounds(474, 89, 60, 71);
		frame.getContentPane().add(Guess2_5);

		JButton Guess3_1 = new JButton("");
		Guess3_1.setOpaque(true);
		Guess3_1.setEnabled(false);
		Guess3_1.setBorderPainted(false);
		Guess3_1.setBackground(Color.LIGHT_GRAY);
		Guess3_1.setBounds(188, 173, 60, 71);
		frame.getContentPane().add(Guess3_1);

		JButton Guess3_2 = new JButton("");
		Guess3_2.setOpaque(true);
		Guess3_2.setEnabled(false);
		Guess3_2.setBorderPainted(false);
		Guess3_2.setBackground(Color.LIGHT_GRAY);
		Guess3_2.setBounds(258, 173, 60, 71);
		frame.getContentPane().add(Guess3_2);

		JButton Guess3_3 = new JButton("");
		Guess3_3.setOpaque(true);
		Guess3_3.setEnabled(false);
		Guess3_3.setBorderPainted(false);
		Guess3_3.setBackground(Color.LIGHT_GRAY);
		Guess3_3.setBounds(330, 173, 60, 71);
		frame.getContentPane().add(Guess3_3);

		JButton Guess3_4 = new JButton("");
		Guess3_4.setOpaque(true);
		Guess3_4.setEnabled(false);
		Guess3_4.setBorderPainted(false);
		Guess3_4.setBackground(Color.LIGHT_GRAY);
		Guess3_4.setBounds(404, 173, 60, 71);
		frame.getContentPane().add(Guess3_4);

		JButton Guess3_5 = new JButton("");
		Guess3_5.setOpaque(true);
		Guess3_5.setEnabled(false);
		Guess3_5.setBorderPainted(false);
		Guess3_5.setBackground(Color.LIGHT_GRAY);
		Guess3_5.setBounds(474, 173, 60, 71);
		frame.getContentPane().add(Guess3_5);

		JButton Guess4_1 = new JButton("");
		Guess4_1.setOpaque(true);
		Guess4_1.setEnabled(false);
		Guess4_1.setBorderPainted(false);
		Guess4_1.setBackground(Color.LIGHT_GRAY);
		Guess4_1.setBounds(188, 257, 60, 71);
		frame.getContentPane().add(Guess4_1);

		JButton Guess4_2 = new JButton("");
		Guess4_2.setOpaque(true);
		Guess4_2.setEnabled(false);
		Guess4_2.setBorderPainted(false);
		Guess4_2.setBackground(Color.LIGHT_GRAY);
		Guess4_2.setBounds(258, 257, 60, 71);
		frame.getContentPane().add(Guess4_2);

		JButton Guess4_3 = new JButton("");
		Guess4_3.setOpaque(true);
		Guess4_3.setEnabled(false);
		Guess4_3.setBorderPainted(false);
		Guess4_3.setBackground(Color.LIGHT_GRAY);
		Guess4_3.setBounds(330, 257, 60, 71);
		frame.getContentPane().add(Guess4_3);

		JButton Guess4_4 = new JButton("");
		Guess4_4.setOpaque(true);
		Guess4_4.setEnabled(false);
		Guess4_4.setBorderPainted(false);
		Guess4_4.setBackground(Color.LIGHT_GRAY);
		Guess4_4.setBounds(404, 257, 60, 71);
		frame.getContentPane().add(Guess4_4);

		JButton Guess4_5 = new JButton("");
		Guess4_5.setOpaque(true);
		Guess4_5.setEnabled(false);
		Guess4_5.setBorderPainted(false);
		Guess4_5.setBackground(Color.LIGHT_GRAY);
		Guess4_5.setBounds(474, 257, 60, 71);
		frame.getContentPane().add(Guess4_5);

		JButton Guess5_1 = new JButton("");
		Guess5_1.setOpaque(true);
		Guess5_1.setEnabled(false);
		Guess5_1.setBorderPainted(false);
		Guess5_1.setBackground(Color.LIGHT_GRAY);
		Guess5_1.setBounds(188, 341, 60, 71);
		frame.getContentPane().add(Guess5_1);

		JButton Guess5_2 = new JButton("");
		Guess5_2.setOpaque(true);
		Guess5_2.setEnabled(false);
		Guess5_2.setBorderPainted(false);
		Guess5_2.setBackground(Color.LIGHT_GRAY);
		Guess5_2.setBounds(258, 341, 60, 71);
		frame.getContentPane().add(Guess5_2);

		JButton Guess5_3 = new JButton("");
		Guess5_3.setOpaque(true);
		Guess5_3.setEnabled(false);
		Guess5_3.setBorderPainted(false);
		Guess5_3.setBackground(Color.LIGHT_GRAY);
		Guess5_3.setBounds(330, 341, 60, 71);
		frame.getContentPane().add(Guess5_3);

		JButton Guess5_4 = new JButton("");
		Guess5_4.setOpaque(true);
		Guess5_4.setEnabled(false);
		Guess5_4.setBorderPainted(false);
		Guess5_4.setBackground(Color.LIGHT_GRAY);
		Guess5_4.setBounds(404, 341, 60, 71);
		frame.getContentPane().add(Guess5_4);

		JButton Guess5_5 = new JButton("");
		Guess5_5.setOpaque(true);
		Guess5_5.setEnabled(false);
		Guess5_5.setBorderPainted(false);
		Guess5_5.setBackground(Color.LIGHT_GRAY);
		Guess5_5.setBounds(474, 341, 60, 71);
		frame.getContentPane().add(Guess5_5);

		JLabel Wordler_Design = new RotateLabel("WORDLER");
		Wordler_Design.setForeground(Color.GREEN);
		Wordler_Design.setFont(new Font("Bodoni Ornaments", Font.PLAIN, 80));
		Wordler_Design.setBounds(0, 6, 300, 350);
		frame.getContentPane().add(Wordler_Design);

		Submit_Button = new JButton("Submit");
		Submit_Button.setOpaque(true);
		Submit_Button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		Submit_Button.setBackground(Color.PINK);
		Submit_Button.setBounds(303, 424, 117, 29);
		Submit_Button.addActionListener(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			} 
			
		});
		frame.getContentPane().add(Submit_Button);




	}
}
