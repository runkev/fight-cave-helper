package com.fightcavehelper.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel
{
	private final JButton resetBtn = new JButton("Reset");

	public TopPanel()
	{
		setLayout(new BorderLayout());
		setBackground(null);

		JLabel title = new JLabel("Fight Cave Helper");
		title.setForeground(Color.white);
		title.setFont(new Font("Verdana", Font.BOLD, 12));

		resetBtn.setFont(new Font("Verdana", Font.PLAIN, 11));
		resetBtn.setBackground(Color.darkGray);
		resetBtn.setForeground(Color.white);


		add(title, BorderLayout.WEST);
		add(resetBtn, BorderLayout.EAST);
	}

	public void addResetListener(ActionListener listenForReset)
	{
		resetBtn.addActionListener(listenForReset);
	}
}
