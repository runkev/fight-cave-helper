package com.fightcavehelper;

import java.awt.image.BufferedImage;
import net.runelite.client.util.ImageUtil;

public class Wave
{
	public int rotation;
	public int number;
	private String waveImgPath;
	private BufferedImage image;
	public static final String IMG_PATH = "/waves/%s-%s.jpg";

	public Wave(int rotation, int number)
	{
		this.rotation = rotation;
		this.number = number;
		this.waveImgPath = String.format(IMG_PATH, rotation, number);
		this.image = ImageUtil.loadImageResource(getClass(), waveImgPath);
	}

	public BufferedImage getImage(){
		return image;
	}

	public int getRotation()
	{
		return rotation;
	}
	public int getNumber()
	{
		return number;
	}
}
