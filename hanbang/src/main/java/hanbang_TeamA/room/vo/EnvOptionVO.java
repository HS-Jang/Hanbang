package hanbang_TeamA.room.vo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="envOption")
public class EnvOptionVO{
	private Boolean parkinglog ;
	private Boolean elevator;
	private Boolean buildingCCTV;
	private Boolean outsideCCTV;
	private Boolean park;
	private Boolean pet;
	private Boolean department;
	public Boolean getParkinglog() {
		return parkinglog;
	}
	public void setParkinglog(Boolean parkinglog) {
		this.parkinglog = parkinglog;
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
	public Boolean getDepartment() {
		return department;
	}
	public void setDepartment(Boolean department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EnvOptionVO [parkinglog=" + parkinglog + ", elevator="
				+ elevator + ", buildingCCTV=" + buildingCCTV
				+ ", outsideCCTV=" + outsideCCTV + ", park=" + park + ", pet="
				+ pet + ", department=" + department + "]";
	}

}
