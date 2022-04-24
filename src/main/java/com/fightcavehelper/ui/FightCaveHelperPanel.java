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
	private final State state;
	public Wave wave;
	private final JLabel title = new JLabel("Fight Cave Helper");
	private final JButton reset = new JButton("Reset");

	public FightCaveHelperPanel(FightCaveHelperPlugin plugin, State state, Wave wave)
	{
//		setLayout(new GridBagLayout());
//		GridBagConstraints c = new GridBagConstraints();
//
//		Wave1_Panel wave1_panel = new Wave1_Panel(this);
//		wave1_panel.setBorder(BorderFactory.createLineBorder(Color.white));
//		wave1_panel.setSize(200, 50);
//		c.gridy = 0;
//		c.weighty = 1;
//		c.insets = new Insets(20, 0 ,0 ,0);
//		add(wave1_panel, c);
//
//		Wave2_Panel wave2_panel = new Wave2_Panel(this);
//		wave2_panel.setBorder(BorderFactory.createLineBorder(Color.white));
//		c.gridy = 1;
//		c.insets = new Insets(20, 0 ,0 ,0);
//		add(wave2_panel, c);
		this.plugin = plugin;
		this.wave = wave;
		this.state = state;
		setLayout(new BorderLayout(5, 10));
		JPanel northPanel = new JPanel(new BorderLayout());
		JPanel centerPanel = new JPanel(new BorderLayout());
		JPanel southPanel = new JPanel(new BorderLayout());

		Wave1Panel wave1Panel = new Wave1Panel(plugin, wave);
		Wave2Panel wave2Panel = new Wave2Panel(this);
		WaveSpawnPanel waveSpawnPanel = new WaveSpawnPanel(this, state, wave);

		northPanel.add(title, BorderLayout.WEST);
		northPanel.add(reset, BorderLayout.EAST);

		centerPanel.add(wave1Panel, BorderLayout.NORTH);
		centerPanel.add(wave2Panel, BorderLayout.CENTER);

		southPanel.add(waveSpawnPanel, BorderLayout.NORTH);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		reset.setToolTipText("Reset Fight Cave Rotation");
		reset.addActionListener(e -> plugin.reset(plugin.state));


	}

	public void update(State state)
	{
		SwingUtilities.invokeLater(() -> updatePanel(state));
	}

	public void updatePanel(State state)
	{
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;
	}



}

//@Slf4j
//@Singleton
//public class FightCaveHelperPanel extends PluginPanel {
//    private final FightCaveHelperPlugin plugin;
//    private final JPanel phasesView = new JPanel(new GridBagLayout());
//
//    private static final ImageIcon RESET_ICON;
//    private static final ImageIcon RESET_HOVER_ICON;
//
//    static {
//        final BufferedImage addIcon = ImageUtil.getResourceStreamFromClass(FightCaveHelperPlugin.class, "/ui/reset_icon.png");
//        RESET_ICON = new ImageIcon(addIcon);
//        RESET_HOVER_ICON = new ImageIcon(ImageUtil.alphaOffset(addIcon, 0.53f));
//    }
//
//    private final JLabel title = new JLabel();
//    private final JButton reset = new JButton(RESET_ICON);
//
//	//public FightCaveHelperPanel(FightCaveHelperPlugin plugin) {
//	public FightCaveHelperPanel(FightCaveHelperPlugin plugin) {
//        this.plugin = plugin;
//
//		setLayout(new BorderLayout());
//        setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        JPanel northPanel = new JPanel(new BorderLayout());
//        northPanel.setBorder(new EmptyBorder(1, 0, 10, 0));
//
//        title.setText("Fight Cave Helper");
//        title.setForeground(Color.WHITE);
//
//        northPanel.add(title, BorderLayout.WEST);
//        northPanel.add(reset, BorderLayout.EAST);
//
//        JPanel centerPanel = new JPanel(new BorderLayout());
//        centerPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
//
//        phasesView.setBackground(ColorScheme.DARK_GRAY_COLOR);
//
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.weightx = 1;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//
//
//        reset.setToolTipText("Reset Fight Cave rotation");
//        reset.setRolloverIcon(RESET_HOVER_ICON);
//        reset.addActionListener(l -> plugin.reset());
//
//        centerPanel.add(phasesView, BorderLayout.CENTER);
//
//        add(northPanel, BorderLayout.NORTH);
//        add(centerPanel, BorderLayout.CENTER);
//    }
//
//    public void update(State state) {
//        SwingUtilities.invokeLater(() -> updatePanel(state));
//    }
//
//    private void updatePanel(State state) {
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.weightx = 1;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//
//        phasesView.removeAll();
//
//        JPanel ip = new JPanel(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        c.fill = GridBagConstraints.VERTICAL;
//        c.weighty = 1;
//        c.gridx = 0;
//        c.gridy = 0;
//        for (List<Phase> phases : state.buildTree()) {
//            if (ip.getComponentCount() >= 2 || phases.size() >= 2) {
//                phasesView.add(ip, constraints);
//                constraints.gridy++;
//                ip = new JPanel(new GridBagLayout());
//                c = new GridBagConstraints();
//                c.fill = GridBagConstraints.VERTICAL;
//                c.weighty = 1;
//                c.gridx = 0;
//                c.gridy = 0;
//            }
//
//            if (phases.size() >= 2) {
//                phasesView.add(Box.createRigidArea(new Dimension(0, 12)), constraints);
//                constraints.gridy++;
//                phasesView.add(new JLabel(String.format("Select Phase...")), constraints);
//                constraints.gridy++;
//            }
//
//            for (Phase p : phases) {
//                ip.add(new FightCaveHelperPhasePanel(plugin, p, phases.size()), c);
//                c.gridx++;
//
//                if (p.isCurrent()) {
//                    phasesView.add(Box.createRigidArea(new Dimension(0, 12)), constraints);
//                    constraints.gridy++;
//                    phasesView.add(new JLabel(String.format("Current Phase: %s #%d", p.getRotation(), p.getNumber())), constraints);
//                    constraints.gridy++;
//                }
//            }
//
//            phasesView.add(ip, constraints);
//            constraints.gridy++;
//        }
//
//        repaint();
//        revalidate();
//    }
//}
