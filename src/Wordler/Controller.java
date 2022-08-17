package Wordler;

import java.awt.EventQueue;

public class Controller {
	final static String DIRECTORY = System.getProperty("user.dir")+"/";
	static Wordler_GUI window = new Wordler_GUI("dummy gui");
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.dispose();
					window = new Wordler_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	/*
	GraphicsDevice gd =
            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	if (gd.isFullScreenSupported()) {
        //gd.setFullScreenWindow(window.frame);
        //window.frame.pack();
    } else {
        System.err.println("Full screen not supported");
    }
    */
}
