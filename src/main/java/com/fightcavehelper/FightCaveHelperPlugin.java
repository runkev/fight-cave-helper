package com.fightcavehelper;

import com.fightcavehelper.ui.FightCaveHelperPanel;
import javax.inject.Inject;
import lombok.Getter;
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

    @Inject
	@Getter
	private NavigationButton navButton;
	private FightCaveHelperPanel panel;
    private State state;

	@Override
    protected void startUp()
	{
		log.info("fight cave helper started.");

		panel = new FightCaveHelperPanel(this);
		state = new State();

        navButton = NavigationButton.builder()
                .tooltip("Fight Cave Helper")
                .icon(ImageUtil.getResourceStreamFromClass(getClass(), "/firecape.png"))
                .priority(50)
                .panel(panel)
                .build();

        clientToolbar.addNavigation(navButton);
        //panel.update(state);
    }

    @Override
    protected void shutDown() throws Exception {
        clientToolbar.removeNavigation(navButton);
        log.info("fight cave helper stopped!");
    }

    public void reset(State state)
	{
		state.reset();
	}

	public void setState(int rotation, int wave)
	{
		state.setRotation(rotation);
		state.setWave(wave);
		panel.update(state);
	}
}
