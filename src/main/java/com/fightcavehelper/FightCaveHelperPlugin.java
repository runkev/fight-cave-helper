package com.fightcavehelper;

import com.fightcavehelper.ui.FightCaveHelperPanel;
import com.fightcavehelper.ui.TopPanel;
import com.fightcavehelper.ui.Wave1Panel;
import com.fightcavehelper.ui.Wave2Panel;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@Slf4j
@PluginDescriptor(
        name = "Fight Cave Helper",
        description = "Panel to predict and show Fight Cave waves",
        tags = {"fight", "cave", "jad", "pvm"}
)
public class FightCaveHelperPlugin extends Plugin {

    @Inject
    private ClientToolbar clientToolbar;
	private NavigationButton navButton;
	private final Wave wave = new Wave();
	private final TopPanel topPanel = new TopPanel();
	private final Wave1Panel wave1Panel = new Wave1Panel();
	private final Wave2Panel wave2Panel	= new Wave2Panel();


	@Override
    protected void startUp()
	{
		log.debug("fight cave helper started.");
		FightCaveHelperPanel panel = new FightCaveHelperPanel(wave, topPanel, wave1Panel, wave2Panel);

        navButton = NavigationButton.builder()
                .tooltip("Fight Cave Helper")
                .icon(ImageUtil.loadImageResource(getClass(), "/firecape.png"))
                .priority(50)
                .panel(panel)
                .build();

        clientToolbar.addNavigation(navButton);
    }

    @Override
    protected void shutDown() throws Exception {
        clientToolbar.removeNavigation(navButton);
        log.info("fight cave helper stopped!");
    }

}
