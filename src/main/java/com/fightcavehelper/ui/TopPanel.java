package com.fightcavehelper.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel
{

	public TopPanel()
	{
		super();
		//this.panel = panel;
		JLabel title = new JLabel("Fight Cave Helper");
		JButton reset = new JButton("Reset");

		setLayout(new BorderLayout(2, 2));
		add(title, BorderLayout.WEST);
		add(reset, BorderLayout.EAST);

//		reset.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				Component[] com = panel.getComponents();
//				for (int a = 0; a < com.length; a++){
//					com[a].setEnabled(false);
//				}
//			}
//		}

	}
}
