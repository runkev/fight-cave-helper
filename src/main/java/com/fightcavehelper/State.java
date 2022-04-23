package com.fightcavehelper;

public class State
{
	public static int rotation = 0;
	public static int wave = 1;
	public static String wave1;
	public static String wave2;

	public int getRotation()
	{
		return rotation;
	}

	public void setRotation(int rotation)
	{
		this.rotation = rotation;
	}

	public int getWave()
	{
		return wave;
	}

	public void setWave(int wave)
	{
		this.wave = wave;
	}

	public void reset()
	{
		this.rotation = 0;
		this.wave = 1;
		this.wave1 = null;
		this.wave2 = null;
	}
}
