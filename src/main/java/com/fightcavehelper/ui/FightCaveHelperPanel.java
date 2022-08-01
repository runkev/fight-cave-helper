package com.fightcavehelper.ui;

import com.fightcavehelper.Wave;
import java.awt.BorderLayout;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.PluginPanel;

@Slf4j
@Singleton
public class FightCaveHelperPanel extends PluginPanel
{
	Wave wave = new Wave();
	private final JLabel title = new JLabel("Fight Cave Helper");
	private final JButton reset = new JButton("Reset");

	public FightCaveHelperPanel()
	{
		super();

		TopPanel topPanel = new TopPanel();
		ButtonPanel buttonPanel = new ButtonPanel(this);
		WaveSpawnPanel waveSpawnPanel = new WaveSpawnPanel();


		setLayout(new BorderLayout(5, 5));


		add(topPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(waveSpawnPanel, BorderLayout.SOUTH);
	}

}

