package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import gui.Controller;

/**
 * The class MainMenu, a populated BackgroundPanel.
 * 
 * @author James Anderson
 *
 */
@SuppressWarnings("serial")
public class MainMenu extends BackgroundPanel {
	
	/**
	 * Instantiates a MainMenu instance.
	 *
	 * @param controller	the controller
	 */
	public MainMenu(Controller controller) {
		
		//Calls superclass constructor to create the background panel
		super("http://jbaron6.cs2212.ca/img/default_background.png", new GridBagLayout());
		
		//Create a new GridBagConstraints instance to control the layout
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10,150,0,150);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		
		try	{
			//Load and add the main menu title graphic
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/titles/mainmenu.png"));
			add(new JLabel(new ImageIcon(img)), c);
			
		} catch (IOException e) {
			
			//If there is a communication error, add a text placeholder to display
			add(new JLabel("Main Menu"), c);
		}
		
		//Create components
		JButton toDrill = new JButton();
		JButton toLGame = new JButton();
		JButton toFGame = new JButton();
		JButton toStats = new JButton();

		//Add action listeners
		toDrill.addActionListener(new PressDrill(controller));
		toLGame.addActionListener(new PressLGame(controller));
		toFGame.addActionListener(new PressFGame(controller));
		toStats.addActionListener(new PressStats(controller));

		//Set attributes and graphics
		toDrill.setContentAreaFilled(false);
		toDrill.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/drills.png"));
			toDrill.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			toDrill.setText("Drills");
		}
		
		toLGame.setContentAreaFilled(false);
		toLGame.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/lgames_l.png"));
			toLGame.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			toLGame.setText("Level Games");
		}
		
		toFGame.setContentAreaFilled(false);
		toFGame.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/fgame_l.png"));
			toFGame.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			toFGame.setText("Final Game");
		}
		
		toStats.setContentAreaFilled(false);
		toStats.setBorderPainted(false);
		try {
			Image img = ImageIO.read(new URL("http://jbaron6.cs2212.ca/img/main/scores&stats.png"));
			toStats.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			toStats.setText("Scores & Stats");
		}
		
		//Add the components to the view
		c.insets = new Insets(0,150,0,150);
		c.ipady = 20;
		c.weightx = 0.5;
		
		c.gridy = 1;
		add(toDrill, c);
		
		c.gridy = 2;
		add(toLGame, c);

		c.gridy = 3;
		add(toFGame, c);
		
		c.gridy = 4;
		add(toStats, c);
	}	
}

/**
 * The class PressDrill, an action listener.
 * 
 * @author James Anderson
 *
 */
class PressDrill implements ActionListener {
	
	/** The controller. */
	private Controller controller;
	
	/**
	 * Instantiates a PressDrill instance.
	 * 
	 * @param controller	the controller
	 */
	public PressDrill(Controller controller) {
		super();
		this.controller = controller;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Swap screen for the drill menu
		controller.setScreen(new DrillMenu(controller));
	}
}

/**
 * The class PressLGame, an action listener.
 * 
 * @author James Anderson
 *
 */
class PressLGame implements ActionListener {

	/** The controller. */
	private Controller controller;
	
	/**
	 * Instantiates a PressLGame instance.
	 * 
	 * @param controller	the controller
	 */
	public PressLGame(Controller controller) {
		super();
		this.controller = controller;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Swap screen for the level game menu
		controller.setScreen(new LGameMenu(controller));
	}
}

/**
 * The class PressFGame, an action listener.
 * 
 * @author James Anderson
 *
 */
class PressFGame implements ActionListener {

	/** The controller. */
	private Controller controller;
	
	/**
	 * Instantiates a PressFGame instance.
	 * 
	 * @param controller	the controller
	 */
	public PressFGame(Controller controller) {
		super();
		this.controller = controller;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Swap screen for the final game menu
		controller.setScreen(new FGameMenu(controller));
	}
}

/**
 * The class PressStats, an action listener.
 * 
 * @author James Anderson
 *
 */
class PressStats implements ActionListener {

	/** The controller. */
	private Controller controller;
	
	/**
	 * Instantiates a PressStats instance.
	 * 
	 * @param controller	the controller
	 */
	public PressStats(Controller controller) {
		super();
		this.controller = controller;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Swap screen for the stats menu
		controller.setScreen(new StatsMenu(controller));
	}
}