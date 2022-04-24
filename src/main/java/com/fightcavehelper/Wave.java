package com.fightcavehelper;

import com.fightcavehelper.ui.FightCaveHelperPanel;
import java.awt.image.BufferedImage;
import net.runelite.client.util.ImageUtil;

public class Wave
{
	private final int rotation;
	private final int wave;
	private String waveImgPath;
	private BufferedImage image;
	public static final String IMG_PATH = "/waves/%s-%s.jpg";

	public Wave(int rotation, int wave)
	{
		this.rotation = rotation;
		this.wave = wave;
		this.waveImgPath = String.format(IMG_PATH, rotation, wave);
		this.image = ImageUtil.loadImageResource(getClass(), waveImgPath);
	}

	public BufferedImage getImage(){
		return image;
	}
}
