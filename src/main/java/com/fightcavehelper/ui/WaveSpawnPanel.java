package com.fightcavehelper.ui;

import com.fightcavehelper.State;
import com.fightcavehelper.Wave;
import com.sun.java.swing.action.AlignCenterAction;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.text.StyleConstants.setIcon;
import net.runelite.client.input.MouseListener;
import net.runelite.client.util.ImageUtil;

public class WaveSpawnPanel extends JPanel
{
	//private ImageIcon spawnImg;
	private FightCaveHelperPanel panel;
	private BufferedImage img;
	private ImageIcon image;
	private State state;
	private Wave wave;

	public WaveSpawnPanel(FightCaveHelperPanel panel, Wave wave)
	{
		super();

		//this.panel = panel;
		this.wave = wave;
		//this.img = wave.getImage();
		this.image = wave.getImage(wave.rotation, wave.number);
		//this.state = state;


		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel spawnImg = new JLabel();
		spawnImg.setIcon(image);
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
			wave.number++;
			spawnImg.setIcon(wave.getImage(wave.rotation, wave.number));
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
			wave.number--;
			spawnImg.setIcon(wave.getImage(wave.rotation, wave.number));
		});
		add(back, c);

	}

	public ImageIcon updateSpawnImg(int rotation, int number)
	{
		final String IMG_PATH = "/waves/%s-%s.jpg";

		String waveImgPath = String.format(IMG_PATH, rotation, number);
		BufferedImage image = ImageUtil.loadImageResource(getClass(), waveImgPath);

		return new ImageIcon(image);
	}

}

