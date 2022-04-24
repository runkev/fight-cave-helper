package com.fightcavehelper.ui;

import static com.fightcavehelper.State.rotation;
import static com.fightcavehelper.State.wave;
import com.fightcavehelper.Wave;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaveSpawnPanel extends JPanel
{
	private FightCaveHelperPanel panel;
	private BufferedImage img;
	private ImageIcon image;

	public WaveSpawnPanel(FightCaveHelperPanel panel, Wave wave)
	{
		super();

		this.panel = panel;
		this.img = wave.getImage();
		this.image = new ImageIcon(wave.getImage());

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JButton next = new JButton("Next");
		c.gridx = 0;
		c.gridy = 0;
		next.setBackground(Color.green);
		add(next, c);

		JButton back = new JButton("Back");
		c.gridx = 1;
		c.gridy = 0;
		back.setBackground(Color.red);
		add(back, c);

		JLabel spawnImg = new JLabel(image);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		add(spawnImg, c);
	}

	public ImageIcon imgResize(BufferedImage img)
	{
		Image scaled_img = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
		return new ImageIcon(scaled_img);
	}

}

