package com.draco18s.hazards.block;

public interface IBreathable {
	public int getAirQuality(int meta);
	
	public boolean causesNausea(int meta);
}
