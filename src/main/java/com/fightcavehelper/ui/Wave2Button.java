package com.fightcavehelper.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

public class Wave2Button extends JButton
{
	private static final Dimension PREFERRED_SIZE = new Dimension(37, 40);

	public Wave2Button(String text)
	{
		super(text);

		setPreferredSize(PREFERRED_SIZE);
		setFont(new Font("Arial", Font.BOLD, 11));

		addActionListener(e -> {
			setForeground(Color.green);
			setBackground(Color.lightGray);
		});

	}
}
