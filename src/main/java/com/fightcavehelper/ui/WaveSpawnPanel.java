package com.fightcavehelper.ui;

import com.fightcavehelper.Wave;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaveSpawnPanel extends JPanel
{
	//private ImageIcon spawnImg;
//	private FightCaveHelperPanel panel;
//	private BufferedImage img;
	private ImageIcon image;
//	private State state;
//	private Wave wave;

	public WaveSpawnPanel(Wave wave)
	{
		//super();

		//this.image = wave.setImage();

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel spawnImg = new JLabel();
		spawnImg.setIcon(wave.getImage());
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		add(spawnImg, c);

		JButton next = new JButton("Next");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.weighty = 0.2;
		//c.insets = new Insets(10, 10, 5, 0);
		next.setBackground(Color.green);
		next.addActionListener(e -> {
			wave.rotation = 1;
			image = wave.increment();
			spawnImg.setIcon(image);
		});
		add(next, c);

		JButton back = new JButton("Back");
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.weighty = 0.2;

		//c.insets = new Insets(10, 5, 5, 0);
		back.setBackground(Color.red);
		back.addActionListener(e -> {
			wave.rotation = 1;
			image = wave.decrement();
			spawnImg.setIcon(image);
		});
		add(back, c);

	}
}

