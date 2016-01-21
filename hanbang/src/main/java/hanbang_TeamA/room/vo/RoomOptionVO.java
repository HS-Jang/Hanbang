package hanbang_TeamA.room.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="roomOptionVO")
public class RoomOptionVO{

	private String latitude;	//목적지위도
	private String longitude;	//목적지경도
	private String dealKind;	//전세. 월세
	private String transportation; //교통수단
	private String time;
	private String depositLow;		//보증금
	private String depositHigh;		//보증금
	private String monthPayLow;		//월세
	private String monthPayHigh;	//월세
	private String price;		//전세값
	private String roomkind;	//아파트.원룸.투룸
	private Boolean buildingCCTV;	//건물 cctv(Y/N)
	private Boolean outsideCCTV;	//외부근방 CCTV(Y/N)
	private Boolean park;	//공원(Y/N)
	private Boolean parkinglot;	//주차장 (Y/N)
	
	private String address;

	private Boolean pet;		//애완동물 (Y/N)
	private Boolean roomOption; //풀옵션여부
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getDealKind() {
		return dealKind;
	}
	public void setDealKind(String dealKind) {
		this.dealKind = dealKind;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDepositLow() {
		return depositLow;
	}
	public void setDepositLow(String depositLow) {
		this.depositLow = depositLow;
	}
	public String getDepositHigh() {
		return depositHigh;
	}
	public void setDepositHigh(String depositHigh) {
		this.depositHigh = depositHigh;
	}
	public String getMonthPayLow() {
		return monthPayLow;
	}
	public void setMonthPayLow(String monthPayLow) {
		this.monthPayLow = monthPayLow;
	}
	public String getMonthPayHigh() {
		return monthPayHigh;
	}
	public void setMonthPayHigh(String monthPayHigh) {
		this.monthPayHigh = monthPayHigh;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRoomkind() {
		return roomkind;
	}
	public void setRoomkind(String roomkind) {
		this.roomkind = roomkind;
	}
	public Boolean getBuildingCCTV() {
		return buildingCCTV;
	}
	public void setBuildingCCTV(Boolean buildingCCTV) {
		this.buildingCCTV = buildingCCTV;
	}
	public Boolean getOutsideCCTV() {
		return outsideCCTV;
	}
	public void setOutsideCCTV(Boolean outsideCCTV) {
		this.outsideCCTV = outsideCCTV;
	}
	public Boolean getPark() {
		return park;
	}
	public void setPark(Boolean park) {
		this.park = park;
	}
	public Boolean getParkinglot() {
		return parkinglot;
	}
	public void setParkinglot(Boolean parkinglot) {
		this.parkinglot = parkinglot;
	}
	public Boolean getPet() {
		return pet;
	}
	public void setPet(Boolean pet) {
		this.pet = pet;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getRoomOption() {
		return roomOption;
	}
	public void setRoomOption(Boolean roomOption) {
		this.roomOption = roomOption;
	}
	@Override
	public String toString() {
		return "RoomOptionVO [latitude=" + latitude + ", longitude="
				+ longitude + ", dealKind=" + dealKind + ", transportation="
				+ transportation + ", time=" + time + ", depositLow="
				+ depositLow + ", depositHigh=" + depositHigh
				+ ", monthPayLow=" + monthPayLow + ", monthPayHigh="
				+ monthPayHigh + ", price=" + price + ", roomkind=" + roomkind
				+ ", buildingCCTV=" + buildingCCTV + ", outsideCCTV="
				+ outsideCCTV + ", park=" + park + ", parkinglot=" + parkinglot
				+ ", address=" + address + ", pet=" + pet + ", roomOption="
				+ roomOption + "]";
	}

}
