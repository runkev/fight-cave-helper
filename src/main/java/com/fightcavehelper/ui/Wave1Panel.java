package com.fightcavehelper.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketAddress;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Wave1Panel extends JPanel
{
	private FightCaveHelperPanel panel;

	public Wave1Panel(FightCaveHelperPanel panel)
	{
		super();

		this.panel = panel;

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel("Wave 1:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(label, c);

		SpawnButton c_btn = new SpawnButton("C");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		add(c_btn, c);

		SpawnButton nw_btn = new SpawnButton("NW");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		add(nw_btn, c);

		SpawnButton s_btn = new SpawnButton("S");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		add(s_btn, c);

		SpawnButton se_btn = new SpawnButton("SE");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		add(se_btn, c);

		SpawnButton sw_btn = new SpawnButton("SW");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		add(sw_btn, c);


//		JLabel label = new JLabel("Wave 2: ");
//		label.setFont(new Font("Arial", Font.PLAIN ,10));
//
//		SpawnButton c_btn = new SpawnButton(("C"));
//		SpawnButton nw_btn = new SpawnButton(("NW"));
//		SpawnButton s_btn = new SpawnButton(("S"));
//		SpawnButton se_btn = new SpawnButton(("SE"));
//		SpawnButton sw_btn = new SpawnButton(("SW"));
//
//
//		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
//		add(label);
//		add(c_btn);
//		add(nw_btn);
//		add(s_btn);
//		add(se_btn);
//		add(sw_btn);


	}
}

