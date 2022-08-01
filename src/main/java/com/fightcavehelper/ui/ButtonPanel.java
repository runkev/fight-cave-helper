package com.fightcavehelper.ui;

import com.fightcavehelper.Wave;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.Kernel;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel
{
	private static final Insets INSETS_LEFT_BORDER = new Insets(1, 0, 1, 1);
	private static final Insets INSETS_RIGHT_BORDER = new Insets(1, 1, 1, 0);
	private static final Insets INSETS = new Insets(1, 1, 1, 1);
	public static String spawn1;
	public static String spawn2A;
	public static String spawn2B;
	private String spawn4;
	private static int choices = 0;
	static ArrayList<JButton> btns1 = new ArrayList<>();
	static ArrayList<JButton> btns2 = new ArrayList<>();
	ArrayList<JButton> btns4 = new ArrayList<>();

	private final FightCaveHelperPanel panel;
	private final GridBagConstraints c;

	public ButtonPanel(FightCaveHelperPanel panel)
	{
		super();

		this.panel = panel;

		setLayout(new GridBagLayout());

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy	= 0;

		//setBackground(null);

//		JLabel title = new JLabel("Wave 1: ");
//		title.setFont(new Font("Verdana", Font.PLAIN, 12));
//		title.setForeground(Color.white);
//		add(title);

//		JLabel wave1 = new JLabel("Wave 1:");
//		add(wave1);
		createBtns1();

//		JLabel wave2 = new JLabel("Wave 2:");
//		add(wave2);
		createBtns2();
	}

	public void createBtns1()
	{


		btns1.add(new SpawnButton("C"));
		btns1.add(new SpawnButton("NW"));
		btns1.add(new SpawnButton("S"));
		btns1.add(new SpawnButton("SE"));
		btns1.add(new SpawnButton("SW"));

		for (JButton btn : btns1)
		{
			btn.addActionListener(e -> {
				disableBtns1();
				setSpawn1(btn);
				enableBtns2();
				Wave.increment();
				Wave.addWaveSpawn();
			});
			add(btn);
			addComp(btn);
		}
	}

	public void disableBtns1()
	{
		for (JButton btn : btns1)
		{
			btn.setEnabled(false);
		}
	}

	public void setSpawn1(JButton btn)
	{
		spawn1 = btn.getText();
		btn.setBackground(Color.green);
	}

	public void createBtns2()
	{

		btns2.add(new SpawnButton("C"));
		btns2.add(new SpawnButton("NW"));
		btns2.add(new SpawnButton("S"));
		btns2.add(new SpawnButton("SE"));
		btns2.add(new SpawnButton("SW"));

		for (JButton btn : btns2)
		{
			btn.setEnabled(false);
			btn.addActionListener(e -> {
				btn.setEnabled(false);
				choices++;
				disableBtns2(btn.getText());
				setSpawn2(btn);
				Wave.increment();
				Wave.addWaveSpawn();
				WaveSpawnPanel.wave_number.setText("Wave: "+ Wave.getNumber());

			});
			add(btn);
			addComp(btn);
		}
	}

	public void enableBtns2()
	{
		for (JButton btn : btns2)
		{
			btn.setEnabled(true);
		}
	}

	public void disableBtns2(String text)
	{
		if (choices >= 2)
		{
			for (JButton btn : btns2)
			{
				if (!btn.getText().equals(text))
				{
					btn.setEnabled(false);
				}
			}
		}
	}

	public void setSpawn2(JButton btn)
	{
		if (choices == 0)
		{
			spawn2A = btn.getText();
			btn.setBackground(Color.green);
			choices++;
		}
		else
		{
			spawn2B = btn.getText();
			btn.setBackground(Color.green);
			Wave.increment();
		}
	}

	public static void resetBtns()
	{
		choices = 0;
		spawn1 = null;
		spawn2A = null;
		spawn2B = null;
		for (JButton btn : btns1)
		{
			btn.setForeground(Color.white);
			btn.setBackground(null);
			btn.setEnabled(true);
		}
		for (JButton btn : btns2)
		{
			btn.setForeground(Color.white);
			btn.setBackground(null);
			btn.setEnabled(false);
		}
	}

	private void addComp(Component component)
	{
		switch (c.gridx)
		{
			case 0:
				c.insets = INSETS_LEFT_BORDER;
				break;
			case 5:
				c.insets = INSETS_RIGHT_BORDER;
				break;
			default:
				c.insets = INSETS;
		}
		if (c.gridwidth == 5)
		{
			c.insets = INSETS_RIGHT_BORDER;
		}
		add(component, c);
		c.gridx = ++c.gridx % 5;
		c.gridy = c.gridx == 0 ? ++c.gridy : c.gridy;
	}
}
