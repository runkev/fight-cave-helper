package com.fightcavehelper;

import com.fightcavehelper.ui.ButtonPanel;
import com.fightcavehelper.ui.WaveSpawnPanel;
import java.awt.Button;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.runelite.client.util.ImageUtil;

public class Wave extends JPanel
{
	public static int rotation;
	public static int number;
	private static String waveImgPath;
	private static BufferedImage image;
	private static ImageIcon img;
	public static final String IMG_PATH = "/waves/%s-%s.jpg";
	public static String spawn1 = "-";
	public static String spawn2 = "-";
	public static String spawn4 = "-";


	public Wave()
	{
		rotation = 0;
		number = 1;
		waveImgPath = String.format(IMG_PATH, rotation, number);
		image = ImageUtil.loadImageResource(getClass(), waveImgPath);
		img = new ImageIcon(image);
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
		spawn1 = "-";
		spawn2 = "-";
		spawn4 = "-";
		setImage();
		WaveSpawnPanel.updateWave();
	}

	public static void addWaveSpawn()
	{
		if (number == 1)
		{
			spawn1 = ButtonPanel.spawn1;
			//setImage();
			increment();
		}

		else if (number == 2)
		{
			spawn2 = ButtonPanel.spawn2A + ButtonPanel.spawn2B;

			String s = spawn1 + "-" + sortString(spawn2);

			switch (s)
			{
				case "C-NSWW":
					rotation = 1;
					updatePanel();
					break;
				case "C-ESS":
					rotation = 2;
					updatePanel();
					break;
				case "C-ESSW":
					rotation = 3;
					updatePanel();
					break;
				case "NW-CS":
					rotation = 4;
					updatePanel();
					break;
				case "NW-CES":
					rotation = 5;
					updatePanel();
					break;
				case "NW-ESSW":
					rotation = 6;
					updatePanel();
					break;
				case "S-CNW":
					ButtonPanel.enableWave4();
					rotation = 0;
					increment();
					break;
				case "S-ESSW":
					rotation = 9;
					updatePanel();
					break;
				case "S-ENSW":
					rotation = 10;
					updatePanel();
					break;
				case "SE-CSW":
					rotation = 11;
					updatePanel();
					break;
				case "SE-SSW":
					rotation = 12;
					updatePanel();
					break;
				case "SW-CNW":
					rotation = 13;
					updatePanel();
					break;
				case "SW-NSW":
					rotation = 14;
					updatePanel();
					break;
				case "SW-ESS":
					rotation = 15;
					updatePanel();
					break;
				default:
					ButtonPanel.resetBtns();
					Wave.reset();
					System.out.println("Invalid selection, try again");
					//updatePanel();
			}
		}
		else //(number == 3)
		{
			spawn4 = ButtonPanel.spawn4A + ButtonPanel.spawn4B;
			String s = sortString(spawn4);

			switch (s)
			{
				case "ESS":
					rotation = 7;
					updatePanel();
					break;
				case "ESSW":
					rotation = 8;
					updatePanel();
					break;
				default:
					ButtonPanel.resetBtns();
					Wave.reset();
					System.out.println("Invalid selection, try again");
					//updatePanel();
			}
		}
	}

	public static String getSpawn1()
	{
		return spawn1;
	}

	public static String getSpawn2()
	{
		return sortString(spawn2);
	}

	public static void increment()
	{
		number++;
		setImage();
	}
	public static void decrement()
	{
		number--;
		setImage();
	}

	public static String sortString(String input)
	{
		char[] tempArr = input.toCharArray();
		Arrays.sort(tempArr);
		return new String(tempArr);
	}
	public static void updatePanel()
	{
		ButtonPanel.hidePanel();
		increment();
		WaveSpawnPanel.enableButtons();
	}

}
