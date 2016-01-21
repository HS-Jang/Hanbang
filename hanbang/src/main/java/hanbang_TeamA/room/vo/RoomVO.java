package hanbang_TeamA.room.vo;

import hanbang_TeamA.com.vo.AbstractVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="room")
public class RoomVO extends AbstractVO {
	
	private String id;	
	private String userId;
	private String title;	//제목
	private String detail;	//상세설명
	private Boolean status;	//상태
	private String registerDate;	//등록일
	private String completeDate;	
	private String dealKind;	//전세. 월세
	private String deposit;		//보증금
	private String monthPay;	//월세
	private String price;		//전세값
	private String address;		//주소
	private String roomkind;	//아파트.원룸.투룸
	private String buildingKind;	//아파트. 빌라. (안씀)
	private String floor;		//층수
	private String roomSize;	//평수(안씀)
	private String urgent;		
	private String latitude;	//위도
	private String longitude;	//경도
	private String telNum;		//전화번호
	private Boolean parkinglot;	//주차장 (Y/N)
	private Boolean elevator;	//엘리베이터(Y/N)
	private Boolean buildingCCTV;	//건물 cctv(Y/N)
	private Boolean outsideCCTV;	//외부근방 CCTV(Y/N)
	private Boolean park;	//공원(Y/N)
	private Boolean pet;		//애완동물 (Y/N)
	private Boolean roomOption;	//룸 풀옵션(Y/N)
	private String MngPay;	//관리비
	private String possibleDate;	//입주가능일
	private List<ImageVO> ImageVO = new ArrayList<>();
	private Boolean firstList; 	//급매물여부(Y/N)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	public String getDealKind() {
		return dealKind;
	}
	public void setDealKind(String dealKind) {
		this.dealKind = dealKind;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getMonthPay() {
		return monthPay;
	}
	public void setMonthPay(String monthPay) {
		this.monthPay = monthPay;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoomkind() {
		return roomkind;
	}
	public void setRoomkind(String roomkind) {
		this.roomkind = roomkind;
	}
	public String getBuildingKind() {
		return buildingKind;
	}
	public void setBuildingKind(String buildingKind) {
		this.buildingKind = buildingKind;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getRoomSize() {
		return roomSize;
	}
	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}
	public String getUrgent() {
		return urgent;
	}
	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
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
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public Boolean getParkinglot() {
		return parkinglot;
	}
	public void setParkinglot(Boolean parkinglot) {
		this.parkinglot = parkinglot;
	}
	public Boolean getElevator() {
		return elevator;
	}
	public void setElevator(Boolean elevator) {
		this.elevator = elevator;
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
	public Boolean getPet() {
		return pet;
	}
	public void setPet(Boolean pet) {
		this.pet = pet;
	}
	public Boolean getRoomOption() {
		return roomOption;
	}
	public void setRoomOption(Boolean roomOption) {
		this.roomOption = roomOption;
	}
	public String getMngPay() {
		return MngPay;
	}
	public void setMngPay(String mngPay) {
		this.MngPay = mngPay;
	}
	public String getPossibleDate() {
		return possibleDate;
	}
	public void setPossibleDate(String possibleDate) {
		this.possibleDate = possibleDate;
	}
	public List<ImageVO> getImageVO() {
		return ImageVO;
	}
	public void setImageVO(List<ImageVO> imageVO) {
		this.ImageVO = imageVO;
	}
	public Boolean getFirstList() {
		return firstList;
	}
	public void setFirstList(Boolean firstList) {
		this.firstList = firstList;
	}
	@Override
	public String toString() {
		return "RoomVO [id=" + id + ", userId=" + userId + ", title=" + title
				+ ", detail=" + detail + ", status=" + status
				+ ", registerDate=" + registerDate + ", completeDate="
				+ completeDate + ", dealKind=" + dealKind + ", deposit="
				+ deposit + ", monthPay=" + monthPay + ", price=" + price
				+ ", address=" + address + ", roomkind=" + roomkind
				+ ", buildingKind=" + buildingKind + ", floor=" + floor
				+ ", roomSize=" + roomSize + ", urgent=" + urgent
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", telNum=" + telNum + ", parkinglot=" + parkinglot
				+ ", elevator=" + elevator + ", buildingCCTV=" + buildingCCTV
				+ ", outsideCCTV=" + outsideCCTV + ", park=" + park + ", pet="
				+ pet + ", roomOption=" + roomOption + ", MngPay=" + MngPay
				+ ", possibleDate=" + possibleDate + ", ImageVO=" + ImageVO
				+ ", firstList=" + firstList + "]";
	}
}
