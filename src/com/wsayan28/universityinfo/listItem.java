package com.wsayan28.universityinfo;

public class listItem {
	private String shortName;
	private String longName;
	private int image;
	
	public listItem(String shortName, String longName,int image) {
		super();
		this.shortName = shortName;
		this.longName = longName;
		this.image=image;
	}
	
	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}

}
