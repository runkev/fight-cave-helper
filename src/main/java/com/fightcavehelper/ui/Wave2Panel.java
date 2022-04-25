package com.fightcavehelper.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Wave2Panel extends JPanel
{
	private Wave1Panel panel;

	public Wave2Panel()
	{
		super();

		this.panel = panel;

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel("Wave 2:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		add(label, c);

		SpawnButton c_btn = new SpawnButton("C");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		add(c_btn, c);
		c_btn.setEnabled(false);

		SpawnButton nw_btn = new SpawnButton("NW");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		add(nw_btn, c);
		nw_btn.setEnabled(false);

		SpawnButton s_btn = new SpawnButton("S");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		add(s_btn, c);
		s_btn.setEnabled(false);

		SpawnButton se_btn = new SpawnButton("SE");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		add(se_btn, c);
		se_btn.setEnabled(false);

		SpawnButton sw_btn = new SpawnButton("SW");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 1;
		add(sw_btn, c);
		sw_btn.setEnabled(false);
	}
}

