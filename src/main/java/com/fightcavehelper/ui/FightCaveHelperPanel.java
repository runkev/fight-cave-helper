package com.fightcavehelper.ui;

import com.fightcavehelper.Wave;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.inject.Singleton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.PluginPanel;

@Slf4j
@Singleton
public class FightCaveHelperPanel extends PluginPanel
{
	Wave wave;
	TopPanel topPanel;
	Wave1Panel wave1Panel;
	Wave2Panel wave2Panel;
	private final JLabel title = new JLabel("Fight Cave Helper");
	private final JButton reset = new JButton("Reset");

	public FightCaveHelperPanel(Wave wave,TopPanel topPanel, Wave1Panel wave1Panel, Wave2Panel wave2Panel)
	{
		this.wave = wave;
		this.topPanel = topPanel;
		this.wave1Panel = wave1Panel;
		this.wave2Panel = wave2Panel;

		this.topPanel.addResetListener(new ResetListener());
		this.wave1Panel.addBtnListener1(new BtnListener1());
		this.wave2Panel.addBtnListener2(new BtnListener2());

		JPanel centerPanel = new JPanel(new BorderLayout());
		setLayout(new BorderLayout(5, 10));

		centerPanel.add(wave1Panel, BorderLayout.NORTH);
		centerPanel.add(wave2Panel, BorderLayout.CENTER);

		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.LINE_START);

//		setLayout(new BorderLayout(5, 10));
//		JPanel northPanel = new JPanel(new BorderLayout());
//		JPanel centerPanel = new JPanel(new BorderLayout());
//		//JPanel southPanel = new JPanel(new BorderLayout());
//
//		Wave1Panel wave1Panel = new Wave1Panel(wave);
//		Wave2Panel wave2Panel = new Wave2Panel(wave);
//		WaveSpawnPanel waveSpawnPanel = new WaveSpawnPanel(wave);
//
//		northPanel.add(title, BorderLayout.WEST);
//		northPanel.add(reset, BorderLayout.EAST);
//
//		centerPanel.add(wave1Panel, BorderLayout.NORTH);
//		centerPanel.add(wave2Panel, BorderLayout.CENTER);
//
//		imgPanel.add(waveSpawnPanel, BorderLayout.NORTH);
//
//		add(northPanel, BorderLayout.NORTH);
//		add(centerPanel, BorderLayout.CENTER);
//		add(imgPanel, BorderLayout.SOUTH);
//
//		reset.setToolTipText("Reset Fight Cave Rotation");
//		reset.addActionListener(e -> {
//			wave.reset();
//			update();
//		});

	}

	class ResetListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			wave.reset();
			wave1Panel.resetBtns();
			wave2Panel.resetBtns();
		}
	}

	class BtnListener1 implements ActionListener
	{
		String spawn1 = wave1Panel.getSpawn1();
		@Override
		public void actionPerformed(ActionEvent e)
		{
			wave.addWaveSpawn(spawn1);
			wave2Panel.enableBtns();
		}
	}

	class BtnListener2 implements ActionListener
	{
		String spawn2 = wave2Panel.getSpawn2();
		@Override
		public void actionPerformed(ActionEvent e)
		{
			wave.addWaveSpawn(spawn2);
		}
	}



}

