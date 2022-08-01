package com.fightcavehelper.ui;

import com.fightcavehelper.Wave;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jdk.vm.ci.sparc.SPARC;
import jogamp.nativewindow.NullToolkitLock;

public class WaveSpawnPanel extends JPanel
{
	private ImageIcon image;
	private ImageIcon image2;
	public static JLabel wave_number = new JLabel("Wave: " + Wave.getNumber());
	public static JLabel wave_rotation = new JLabel("Rotation: " + Wave.getRotation());
	public static JLabel spawn1 = new JLabel("Wave 1: " + Wave.getSpawn1());
	public static JLabel spawn2 = new JLabel("Wave 2: " + Wave.getSpawn2());




	public WaveSpawnPanel()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setBackground(null);

		JLabel spawnImg = new JLabel();
		spawnImg.setIcon(Wave.getImage());
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.weighty = 1;
		c.insets = new Insets(5, 1, 5, 6);
		add(spawnImg, c);

		wave_number.setForeground(Color.white);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.weighty = 1;
		add(wave_number, c);

		wave_rotation.setForeground(Color.white);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.weighty = 1;
		add(wave_rotation, c);

		spawn1.setForeground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.weighty = 1;
		add(spawn1, c);

		spawn2.setForeground(Color.white);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.weighty = 1;
		add(spawn2, c);

		JButton next = new JButton("Next");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.weighty = 0.2;
		next.setBackground(Color.green);
		next.addActionListener(e -> {
			//wave.rotation = 1; //this is manually setting the rotation for testing
			Wave.increment();
			spawnImg.setIcon(Wave.getImage());
			wave_number.setText("Wave: " + Wave.getNumber());
			wave_rotation.setText("Rotation: " + Wave.getRotation());
		});
		add(next, c);

		JButton back = new JButton("Back");
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.weighty = 0.2;
		back.setBackground(Color.red);
		back.addActionListener(e -> {
			//wave.rotation = 1; //this is manually setting the rotation for testing
			Wave.decrement();
			spawnImg.setIcon(Wave.getImage());
			wave_number.setText("Wave: " + Wave.getNumber());
			wave_rotation.setText("Rotation: " + Wave.getRotation());
		});
		add(back, c);

	}
}

