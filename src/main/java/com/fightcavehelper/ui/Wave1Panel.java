package com.fightcavehelper.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Wave1Panel extends JPanel
{
	private String spawn1;
	ArrayList<JButton> btns = new ArrayList<>();

	public Wave1Panel()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JLabel title = new JLabel("Wave 1: ");
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
			btn.addActionListener(e -> {
				disableBtns(btn.getText());
				setSpawn1(btn);
			});
			add(btn);
		}
	}

	public void disableBtns(String text)
	{
		for (JButton btn : btns)
		{
			if (!btn.getText().equals(text))
			{
				btn.setEnabled(false);
			}
		}
	}

	public void setSpawn1(JButton btn){spawn1 = btn.getText();}

	public String getSpawn1() {return spawn1;}

	public void resetBtns()
	{
		for (JButton btn : btns)
		{
			btn.setForeground(null);
			btn.setBackground(null);
			btn.setEnabled(true);
		}
	}

	public void addBtnListener1 (ActionListener listenForBtn)
	{
		for (JButton btn : btns)
		{
			setSpawn1(btn);
			btn.addActionListener(listenForBtn);
		}
	}


}

//		setLayout(new GridBagLayout());
//		GridBagConstraints c = new GridBagConstraints();
//
//		JLabel label = new JLabel("Wave 1:");
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 0;
//		c.gridy = 0;
//		add(label, c);
//
//		SpawnButton c_btn = new SpawnButton("C", wave);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 1;
//		c.gridy = 0;
//		add(c_btn, c);
//
//		SpawnButton nw_btn = new SpawnButton("NW", wave);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 2;
//		c.gridy = 0;
//		add(nw_btn, c);
//
//		SpawnButton s_btn = new SpawnButton("S", wave);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 3;
//		c.gridy = 0;
//		add(s_btn, c);
//
//		SpawnButton se_btn = new SpawnButton("SE", wave);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 4;
//		c.gridy = 0;
//		add(se_btn, c);
//
//		SpawnButton sw_btn = new SpawnButton("SW", wave);
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.gridx = 5;
//		c.gridy = 0;
//		add(sw_btn, c);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e)
//	{
//
//	}
//}

