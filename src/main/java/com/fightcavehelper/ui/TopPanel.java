package com.fightcavehelper.ui;

import com.fightcavehelper.State;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel
{
	private final FightCaveHelperPanel panel;
	State state;

	public TopPanel(FightCaveHelperPanel panel, State state)
	{
		super();
		this.panel = panel;
		//this.state = state;
		JLabel title = new JLabel("Fight Cave Helper");
		JButton reset = new JButton("Reset");

		setLayout(new BorderLayout(2, 2));
		add(title, BorderLayout.WEST);
		add(reset, BorderLayout.EAST);

		reset.addActionListener(e -> state.reset());

	}
}
