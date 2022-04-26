package com.fightcavehelper.ui;

import com.fightcavehelper.FightCaveHelperPlugin;
import com.fightcavehelper.State;
import com.fightcavehelper.Wave;
import javax.inject.Singleton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.PluginPanel;

import java.awt.*;

@Slf4j
@Singleton
public class FightCaveHelperPanel extends PluginPanel
{
	private final FightCaveHelperPlugin plugin;
	private final JPanel imgPanel = new JPanel(new BorderLayout());

	public Wave wave;
	private final JLabel title = new JLabel("Fight Cave Helper");
	private final JButton reset = new JButton("Reset");

	public FightCaveHelperPanel(FightCaveHelperPlugin plugin, Wave wave)
	{
		this.plugin = plugin;
		this.wave = wave;
		//this.state = state;
		setLayout(new BorderLayout(5, 10));
		JPanel northPanel = new JPanel(new BorderLayout());
		JPanel centerPanel = new JPanel(new BorderLayout());
		//JPanel southPanel = new JPanel(new BorderLayout());

		Wave1Panel wave1Panel = new Wave1Panel(wave);
		Wave2Panel wave2Panel = new Wave2Panel(wave);
		WaveSpawnPanel waveSpawnPanel = new WaveSpawnPanel(wave);

		northPanel.add(title, BorderLayout.WEST);
		northPanel.add(reset, BorderLayout.EAST);

		centerPanel.add(wave1Panel, BorderLayout.NORTH);
		centerPanel.add(wave2Panel, BorderLayout.CENTER);

		imgPanel.add(waveSpawnPanel, BorderLayout.NORTH);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(imgPanel, BorderLayout.SOUTH);

		reset.setToolTipText("Reset Fight Cave Rotation");
		reset.addActionListener(e -> {
			wave.reset();
			update();
		});


	}

	public void update()
	{
		SwingUtilities.invokeLater(() -> updatePanel());
	}

	public void updatePanel()
	{

	}



}

