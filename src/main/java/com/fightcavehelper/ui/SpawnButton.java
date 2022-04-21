package com.fightcavehelper.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SpawnButton extends JButton
{
	private static final Dimension PREFERRED_SIZE = new Dimension(37, 40);

	public SpawnButton(String text)
	{
		super(text);

		setPreferredSize(PREFERRED_SIZE);
		setFont(new Font("Arial", Font.BOLD, 11));

	}
}
