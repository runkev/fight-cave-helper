package com.fightcavehelper.ui;

import com.fightcavehelper.State;
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

	public SpawnButton(String text)
	{
		super(text);
		this.text = text;

		setPreferredSize(PREFERRED_SIZE);
		setFont(new Font("Arial", Font.BOLD, 11));

		addActionListener(e -> {
			setForeground(Color.green);
			setBackground(Color.gray);

		});
	}

//	@Override
//	public void actionPerformed(ActionEvent e)
//	{
//		setEnabled(false);
//		setForeground(Color.GREEN);
//		setBackground(Color.gray);
//
//		if (State.wave == 1 && text.equals("C"))
//		{
//			State.wave++;
//			State.wave1 = text;
//		}
//		if (State.wave == 1 && text.equals("NW"))
//		{
//			State.wave++;
//			State.wave1 = text;
//		}
//		if (State.wave == 1 && text.equals("S"))
//		{
//			State.wave++;
//			State.wave1 = text;
//		}
//		if (State.wave == 1 && text.equals("SE"))
//		{
//			State.wave++;
//			State.wave1 = text;
//		}
//		if (State.wave == 1 && text.equals("SW"))
//		{
//			State.wave++;
//			State.wave1 = text;
//		}
	}

