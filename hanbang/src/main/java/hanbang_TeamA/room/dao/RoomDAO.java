package hanbang_TeamA.room.dao;



import hanbang_TeamA.room.vo.RoomVO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomDAO extends MongoRepository<RoomVO, String> {

	public RoomVO findById(String id);
	public List<RoomVO> findByUserId(String userId);
	public RoomVO findByTitle(String title);
	public RoomVO findByDetail(String detail);
	public RoomVO findByStatus(Boolean status);
	public RoomVO findByDealKind(String dealKind);
	public RoomVO findByLatitude(String latitude);
	public RoomVO findByLongitude(String longitude);
	public RoomVO findByDeposit(String deposit);
	public RoomVO findByMonthPay(String monthPay);
	public RoomVO findByPrice(String price);
	public RoomVO findByAddress(String address);
	public RoomVO findByRoomkind(String roomkind);
	public RoomVO findByBuildingKind(String buildingKind);
	public RoomVO findByFloor(String floor);
	public RoomVO findByRoomSize(String roomSize);
	public RoomVO findByUrgent(String urgent);
	public RoomVO findByMngPay(String MngPay);
	public RoomVO findByRegisterDate(String registerDate);
	public RoomVO findByCompleteDate(String completeDate);
	public RoomVO findByTelNum(String telNum);

//	public List<RoomVO> roomOption(String roomOption);
//	public List<RoomVO> envOption(String envOption);

	//옵션부분
	public RoomVO  findByParkinglot (Boolean parkinglot) ;
	public RoomVO  findByElevator (Boolean elevator);
	public RoomVO  findByBuildingCCTV (Boolean buildingCCTV);
	public RoomVO  findByOutsideCCTV (Boolean outsideCCTV);
	public RoomVO  findByPark (Boolean park);
	public RoomVO  findByPet (Boolean pet);
	public RoomVO  findByRoomOption (Boolean roomOption);
	
	public RoomVO findByFirstList(Boolean firstList); 	//급매물여부(Y/N)

//	public List<RoomVO> image(String image);
	
}