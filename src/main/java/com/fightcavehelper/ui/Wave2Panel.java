package com.fightcavehelper.ui;

import com.fightcavehelper.Wave;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Wave2Panel extends JPanel
{
	private String spawn2;
	private int choices = 0;
	ArrayList<JButton> btns = new ArrayList<>();

	public Wave2Panel()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JLabel title = new JLabel("Wave 2: ");
		title.setFont(new Font("Verdana", Font.PLAIN, 12));

		add(title);
		createBtns();
	}

	public void createBtns()
	{
		btns.add(new SpawnButton("C"));
		btns.add(new SpawnButton("NW"));
		btns.add(new SpawnButton("S"));
		btns.add(new SpawnButton("SE"));
		btns.add(new SpawnButton("SW"));

		for (JButton btn : btns)
		{
			setEnabled(false);
			btn.addActionListener(e -> {
				//setEnabled(false);
				choices++;
				disableBtns(btn.getText());
				setSpawn2(btn);
			});
			add(btn);
		}
	}

	public void enableBtns()
	{
		for (JButton btn : btns)
		{
			setEnabled(true);
		}
	}

	public void disableBtns(String text)
	{
		if (choices >= 2)
		{
			for (JButton btn : btns)
			{
				if (!btn.getText().equals(text))
				{
					btn.setEnabled(false);
				}
			}
		}
	}

	public void setSpawn2(JButton btn){spawn2 = btn.getText();}

	public String getSpawn2() {return spawn2;}

	public void resetBtns()
	{
		for (JButton btn : btns)
		{
			btn.setForeground(null);
			btn.setBackground(null);
			btn.setEnabled(true);
		}
		choices = 0;
	}

	public void addBtnListener2 (ActionListener listenForBtn)
	{
		for (JButton btn : btns)
		{
			setSpawn2(btn);
			btn.addActionListener(listenForBtn);
		}
	}


}

