package com.fightcavehelper;

import com.fightcavehelper.ui.ButtonPanel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.runelite.client.util.ImageUtil;

public class Wave extends JPanel
{
	public static int rotation;
	public static int number;
	public static int number2;
	private static String waveImgPath;
	private static BufferedImage image;
	private static BufferedImage image2;
	private static ImageIcon img;
	private static ImageIcon img2;
	public static final String IMG_PATH = "/waves/%s-%s.jpg";
	public static String spawn1;
	public static String spawn2;
	//public String spawn2B;


	public Wave()
	{
		rotation = 0;
		number = 1;
		number2 = number++;
		waveImgPath = String.format(IMG_PATH, rotation, number);
		image = ImageUtil.loadImageResource(getClass(), waveImgPath);
	}

	public static void setImage()
	{
		waveImgPath = String.format(IMG_PATH, rotation, number);
		image = ImageUtil.loadImageResource(Wave.class, waveImgPath);
		img = new ImageIcon(image);
	}

	public static ImageIcon getImage()
	{
		return img;
	}

	public static void setNextImage()
	{
		String waveImgPath2 = String.format(IMG_PATH, rotation, number2);
		image2 = ImageUtil.loadImageResource(Wave.class, waveImgPath2);
		img2 = new ImageIcon(image2);
	}
	public ImageIcon getNextImage() { return img2; }


	public static int getRotation()
	{
		return rotation;
	}
	public static int getNumber()
	{
		return number;
	}

	public static void setRotation(int rotation)
	{
		Wave.rotation = rotation;
	}

	public static void setNumber(int number)
	{
		Wave.number = number;
	}

	public static void reset()
	{
		setRotation(0);
		setNumber(1);
		spawn1 = null;
		spawn2 = null;
		//spawn2B = null;
		setNextImage();
		setImage();
	}

	public static void addWaveSpawn()
	{
		if (number == 1)
		{
			spawn1 = ButtonPanel.spawn1;
			setImage();
			//increment();
		}

		if (number == 2)
		{
			spawn2 = ButtonPanel.spawn2A + ButtonPanel.spawn2B;

			String s = spawn1 + sortString(spawn2);

			switch (s)
			{
				case "CNSWW":
					rotation = 1;
					increment();
					break;
				case "CESS":
					rotation = 2;
					increment();
					break;
				case "CESSW":
					rotation = 3;
					increment();
					break;
			}
		}
	}

	public static String getSpawn1()
	{
		return spawn1;
	}

	public static String getSpawn2()
	{
		return spawn1;
	}

	public static void increment()
	{
		number++;
		setImage();
		setNextImage();
		//return getImage();
	}
	public static void decrement()
	{
		number--;
		setImage();
		setNextImage();
		//return getImage();
	}

	public static String sortString(String input)
	{
		char tempArr[] = input.toCharArray();
		Arrays.sort(tempArr);
		return new String(tempArr);
	}
}
