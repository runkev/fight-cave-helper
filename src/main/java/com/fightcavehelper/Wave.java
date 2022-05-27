package com.fightcavehelper;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.runelite.client.util.ImageUtil;

public class Wave extends JPanel
{
	public int rotation;
	public int number;
	private String waveImgPath;
	private BufferedImage image;
	private ImageIcon img;
	public static final String IMG_PATH = "/waves/%s-%s.jpg";
	public String spawn1;
	public List<String> spawn2 = new ArrayList<>();
	public List<String> spawn4 = new ArrayList<>();
	private String initialSpawns;

	public Wave()
	{
		this.rotation = 0;
		this.number = 1;
		this.waveImgPath = String.format(IMG_PATH, rotation, number);
		this.image = ImageUtil.loadImageResource(getClass(), waveImgPath);
	}

	public void setImage()
	{
		waveImgPath = String.format(IMG_PATH, rotation, number);
		image = ImageUtil.loadImageResource(getClass(), waveImgPath);
		img = new ImageIcon(image);
	}

	public ImageIcon getImage()
	{
		return img;
	}


	public int getRotation()
	{
		return rotation;
	}
	public int getNumber()
	{
		return number;
	}

	public void setRotation(int rotation)
	{
		this.rotation = rotation;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public void reset()
	{
		setRotation(0);
		setNumber(1);
		spawn1 = null;
		spawn2.clear();
		spawn4.clear();
	}

	public void addWaveSpawn(String btn_value)
	{
		if (number == 1)
		{
			spawn1 = btn_value;
			number++;
		}

		if (number == 2)
		{
			spawn2.add(btn_value);
		}

		if (spawn2.size() == 2)
		{
			if (spawn1.equals("C") && spawn2.contains("NW") && spawn2.contains("SW"))
			{
				rotation = 1;
				number++;
			}
		}
	}

	public ImageIcon increment()
	{
		number++;
		setImage();
		return getImage();
	}
	public ImageIcon decrement()
	{
		number--;
		setImage();
		return getImage();
	}


}
