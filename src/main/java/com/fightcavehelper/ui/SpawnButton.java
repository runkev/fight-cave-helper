package com.fightcavehelper.ui;

import com.fightcavehelper.State;
import com.fightcavehelper.Wave;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;

public class SpawnButton extends JButton
{
	private static final Dimension PREFERRED_SIZE = new Dimension(37, 40);
	String text;

	public SpawnButton(String text, Wave wave)
	{
		super(text);
		this.text = text;

		setPreferredSize(PREFERRED_SIZE);
		setFont(new Font("Arial", Font.BOLD, 11));

		addActionListener(e -> {
			setForeground(Color.green);
			setBackground(Color.gray);
			wave.addWaveSpawn(text);
		});
	}
}

