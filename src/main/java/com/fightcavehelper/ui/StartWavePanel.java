package com.fightcavehelper.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartWavePanel extends JPanel
{
	private final FightCaveHelperPanel panel;

	public StartWavePanel(FightCaveHelperPanel panel)
	{
		super();

		this.panel = panel;

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel label1 = new JLabel("Wave 1:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		add(label1, c);

		SpawnButton c_btn1 = new SpawnButton(("C"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		add(c_btn1, c);

		SpawnButton nw_btn1 = new SpawnButton(("NW"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		add(nw_btn1, c);

		SpawnButton s_btn1 = new SpawnButton(("S"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		add(s_btn1, c);

		SpawnButton se_btn1 = new SpawnButton(("SE"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		add(se_btn1, c);

		SpawnButton sw_btn1 = new SpawnButton(("SW"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		add(sw_btn1, c);

		JLabel label2 = new JLabel("Wave 2:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		add(label2, c);

		SpawnButton c_btn2 = new SpawnButton(("C"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		add(c_btn2, c);
		c_btn2.setEnabled(false);

		SpawnButton nw_btn2 = new SpawnButton(("NW"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		add(nw_btn2, c);
		nw_btn2.setEnabled(false);

		SpawnButton s_btn2 = new SpawnButton(("S"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 1;
		add(s_btn2, c);
		s_btn2.setEnabled(false);

		SpawnButton se_btn2 = new SpawnButton(("SE"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		add(se_btn2, c);
		se_btn2.setEnabled(false);

		SpawnButton sw_btn2 = new SpawnButton(("SW"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 1;
		add(sw_btn2, c);
		sw_btn2.setEnabled(false);

		c_btn1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c_btn1.setEnabled(false);
				c_btn1.setForeground(Color.GREEN);
				c_btn1.setBackground(Color.gray);
				nw_btn2.setEnabled(true);
				s_btn2.setEnabled(true);
				se_btn2.setEnabled(true);
				sw_btn2.setEnabled(true);
			};
		});

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

