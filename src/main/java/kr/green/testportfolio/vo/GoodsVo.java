	package kr.green.testportfolio.vo;

public class GoodsVo {
	private int gNum, gPrice, gMax, gReceptionDay;
	private String gName, gKind, tumbImg, gMaker, gPhoneNumber;
	
	
	
	public int getgNum() {
		return gNum;
	}



	public void setgNum(int gNum) {
		this.gNum = gNum;
	}



	public int getgPrice() {
		return gPrice;
	}



	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}



	public int getgMax() {
		return gMax;
	}



	public void setgMax(int gMax) {
		this.gMax = gMax;
	}



	public int getgReceptionDay() {
		return gReceptionDay;
	}



	public void setgReceptionDay(int gReceptionDay) {
		this.gReceptionDay = gReceptionDay;
	}



	public String getgName() {
		return gName;
	}



	public void setgName(String gName) {
		this.gName = gName;
	}



	public String getgKind() {
		return gKind;
	}



	public void setgKind(String gKind) {
		this.gKind = gKind;
	}



	public String getTumbImg() {
		return tumbImg;
	}



	public void setTumbImg(String tumbImg) {
		this.tumbImg = tumbImg;
	}



	public String getgMaker() {
		return gMaker;
	}



	public void setgMaker(String gMaker) {
		this.gMaker = gMaker;
	}



	public String getgPhoneNumber() {
		return gPhoneNumber;
	}



	public void setgPhoneNumber(String gPhoneNumber) {
		this.gPhoneNumber = gPhoneNumber;
	}


	public GoodsVo(int gNum, int gPrice, int gMax, int gReceptionDay, String gName, String gKind, String tumbImg,
			String gMaker, String gPhoneNumber) {
		super();
		this.gNum = gNum;
		this.gPrice = gPrice;
		this.gMax = gMax;
		this.gReceptionDay = gReceptionDay;
		this.gName = gName;
		this.gKind = gKind;
		this.tumbImg = tumbImg;
		this.gMaker = gMaker;
		this.gPhoneNumber = gPhoneNumber;
	}



	@Override
	public String toString() {
		return "GoodsVo [gNum=" + gNum + ", gPrice=" + gPrice + ", gMax=" + gMax + ", gReceptionDay=" + gReceptionDay
				+ ", gName=" + gName + ", gKind=" + gKind + ", tumbImg=" + tumbImg + ", gMaker=" + gMaker
				+ ", gPhoneNumber=" + gPhoneNumber + "]";
	}
	
	
}
