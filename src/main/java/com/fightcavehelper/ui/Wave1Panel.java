package com.fightcavehelper.ui;

import com.fightcavehelper.FightCaveHelperPlugin;
import static com.fightcavehelper.State.wave;
import com.fightcavehelper.Wave;
import com.sun.jna.WString;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.SocketAddress;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Wave1Panel extends JPanel implements ActionListener
{
	String wave1_selection;

	public Wave1Panel(Wave wave)
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel("Wave 1:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(label, c);

		SpawnButton c_btn = new SpawnButton("C", wave);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		add(c_btn, c);

		SpawnButton nw_btn = new SpawnButton("NW", wave);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		add(nw_btn, c);

		SpawnButton s_btn = new SpawnButton("S", wave);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		add(s_btn, c);

		SpawnButton se_btn = new SpawnButton("SE", wave);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		add(se_btn, c);

		SpawnButton sw_btn = new SpawnButton("SW", wave);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		add(sw_btn, c);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}

