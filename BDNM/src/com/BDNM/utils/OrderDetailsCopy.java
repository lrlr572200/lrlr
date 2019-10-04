package com.BDNM.utils;
//订单详情表的副本
public class OrderDetailsCopy {
	    private String orderNum;//订单编号
		private String rmTypeName;
		private double rmTypePrice;
		private int num;
		private double money;
		private double moneyCot;
		
		public double getMoneyCot() {
			return moneyCot;
		}
		public void setMoneyCot(double moneyCot) {
			this.moneyCot = moneyCot;
		}
		public String getOrderNum() {
			return orderNum;
		}
		public void setOrderNum(String orderNum) {
			this.orderNum = orderNum;
		}
		public String getRmTypeName() {
			return rmTypeName;
		}
		public void setRmTypeName(String rmTypeName) {
			this.rmTypeName = rmTypeName;
		}
		public double getRmTypePrice() {
			return rmTypePrice;
		}
		public void setRmTypePrice(double rmTypePrice) {
			this.rmTypePrice = rmTypePrice;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public double getMoney() {
			return money;
		}
		public void setMoney(double money) {
			this.money = money;
		}
		
}
