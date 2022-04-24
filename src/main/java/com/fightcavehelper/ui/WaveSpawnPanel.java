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
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaveSpawnPanel extends JPanel
{
	private FightCaveHelperPanel panel;
	private BufferedImage img;
	private ImageIcon image;
	private State state;

	public WaveSpawnPanel(FightCaveHelperPanel panel, State state, Wave wave)
	{
		super();

		this.panel = panel;
		this.img = wave.getImage();
		this.image = new ImageIcon(wave.getImage());
		this.state = state;


		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JButton next = new JButton("Next");
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 5, 0);
		next.setBackground(Color.green);

		next.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
					wave.number++;
					wave.rotation = 1;
					panel.update(state);
			}
		});
		add(next, c);

		JButton back = new JButton("Back");
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10, 5, 5, 0);
		back.setBackground(Color.red);
		add(back, c);

		JLabel spawnImg = new JLabel(image);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.CENTER;
		add(spawnImg, c);
	}

	public ImageIcon imgResize(BufferedImage img)
	{
		Image scaled_img = img.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
		return new ImageIcon(scaled_img);
	}

}

