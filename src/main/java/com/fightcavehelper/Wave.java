package com.fightcavehelper;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lombok.Builder;
import net.runelite.client.util.ImageUtil;

public class Wave extends JPanel
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

	public ImageIcon getImage(int rotation, int number)
	{
		waveImgPath = String.format(IMG_PATH, rotation, number);
		image = ImageUtil.loadImageResource(getClass(), waveImgPath);
		return new ImageIcon(image);
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
