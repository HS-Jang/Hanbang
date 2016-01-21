package hanbang_TeamA.room.service;

import hanbang_TeamA.com.controller.LoginController;
import hanbang_TeamA.room.dao.RoomDAO;
import hanbang_TeamA.room.vo.RoomOptionVO;
import hanbang_TeamA.room.vo.RoomVO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchRoomServiceimpl implements SearchRoomService {

	@Autowired
	RoomDAO roomDAO;
	

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Override
	public List<RoomVO> getAllRoomList(RoomOptionVO inRoomOptionVO) {
		System.out
				.println("-------------------------> getRoomList Service Start");

		List<RoomVO> rslt = roomDAO.findAll();

		return rslt;
	}
	@Override
	public List<RoomVO> getRoomList(RoomOptionVO inRoomOptionVO) {
		System.out
		.println("-------------------------> getRoomList Service Start");
		
		List<RoomVO> rslt = roomDAO.findAll();
		getOptionResult(rslt, inRoomOptionVO);
		
		return rslt;
	}
	
	private void getOptionResult(List<RoomVO> rslt, RoomOptionVO inRoomOptionVO){
		logger.debug("" + rslt.size());
		for(int i = 0; i < rslt.size(); i++){
			RoomVO tmpVO = rslt.get(i);
			if(tmpVO == null)
			{
				logger.debug("null");
				continue;
			}
			
			logger.debug(tmpVO.toString());
			
			// 1. 보증금
			if(inRoomOptionVO.getDepositLow() != null
			&& inRoomOptionVO.getDepositHigh() != null	
			&& tmpVO.getDeposit() != null
			)
			{
				if(Integer.parseInt(inRoomOptionVO.getDepositLow()) != 0
				&&	Integer.parseInt(inRoomOptionVO.getDepositHigh()) != 0	
				){
					if(Integer.parseInt(inRoomOptionVO.getDepositLow()) > Integer.parseInt(tmpVO.getDeposit())
					|| Integer.parseInt(inRoomOptionVO.getDepositHigh()) < Integer.parseInt(tmpVO.getDeposit())
					)
					{
						rslt.remove(i--);
						continue;
					}
				}
			}
			
			// 2. 월세 
			if(inRoomOptionVO.getMonthPayLow() != null
			&& inRoomOptionVO.getMonthPayHigh() != null		
			&& tmpVO.getMonthPay() != null
			)
			{
				if(Integer.parseInt(inRoomOptionVO.getMonthPayLow()) != 0
				&&	Integer.parseInt(inRoomOptionVO.getMonthPayHigh()) != 0	
				){
					if(Integer.parseInt(inRoomOptionVO.getMonthPayLow()) > Integer.parseInt(tmpVO.getMonthPay())
					|| Integer.parseInt(inRoomOptionVO.getMonthPayHigh()) < Integer.parseInt(tmpVO.getMonthPay())
					)
					{
						rslt.remove(i--);
						continue;
					}
					
				}
			}
			
			// 3. 방구조
			if(inRoomOptionVO.getRoomkind() != null && !inRoomOptionVO.getRoomkind().equals("0")){
				if(!inRoomOptionVO.getRoomkind().equals(tmpVO.getRoomkind())){
					rslt.remove(i--);
					continue;
				}
			}
			
			// 4. 건물 내 CCTV
			if(tmpVO.getBuildingCCTV() != null && inRoomOptionVO.getBuildingCCTV() != null && inRoomOptionVO.getBuildingCCTV() == true && inRoomOptionVO.getBuildingCCTV() != tmpVO.getBuildingCCTV()){
				rslt.remove(i--);
				continue;
			}
			
			// 5. 외부 CCTV
			if(tmpVO.getOutsideCCTV() != null && inRoomOptionVO.getOutsideCCTV() != null && inRoomOptionVO.getOutsideCCTV() == true && inRoomOptionVO.getOutsideCCTV() != tmpVO.getOutsideCCTV()){
				rslt.remove(i--);
				continue;
			}
			
			// 6. 공원
			if(tmpVO.getPark() != null && inRoomOptionVO.getPark() != null && inRoomOptionVO.getPark() == true && inRoomOptionVO.getPark() != tmpVO.getPark()){
				rslt.remove(i--);
				continue;
			}
			
			// 7. 주차장
			if(tmpVO.getParkinglot() != null && inRoomOptionVO.getParkinglot() != null &&  inRoomOptionVO.getParkinglot() == true && inRoomOptionVO.getParkinglot() != tmpVO.getParkinglot()){
				rslt.remove(i--);
				continue;
			}
			
			// 8. 애완동물
			if(tmpVO.getPet() != null && inRoomOptionVO.getPet() != null && inRoomOptionVO.getPet() == true && inRoomOptionVO.getPet() != tmpVO.getPet()){
				rslt.remove(i--);
				continue;
			}
			
			// 9. 풀옵션
			/* inRoomOptionVO.getRoomOption() == true &&*/
			if(tmpVO.getRoomOption() != null && inRoomOptionVO.getRoomOption() != null && inRoomOptionVO.getRoomOption() == true && inRoomOptionVO.getRoomOption() != tmpVO.getRoomOption()){
				rslt.remove(i--);
				continue;
			}
		}
	}

	@Override
	public RoomVO insRoom(RoomVO roomVO) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------> insRoom Service Start");

		roomVO = roomDAO.save(roomVO);

		System.out.println("id-------------------->" + roomVO.toString());
		return roomVO;
	}

	@Override
	public RoomVO selectRoom(RoomVO roomVO) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------> selectRoom Service Start");

		RoomVO rslt = roomDAO.findById(roomVO.getId());
		//List<RoomVO> rslt = roomDAO.findAll(arg0);
		System.out.println("id-------------------->" + rslt.toString());
		return rslt;
	}

	public List<RoomVO> getRoomListByUserId(RoomVO inRoomVO) {

		List<RoomVO> rslt = roomDAO.findByUserId(inRoomVO.getUserId());

		return rslt;
	}
	
	public RoomVO getRoomVOById(RoomVO inRoomVO) {
		
		RoomVO rVO = roomDAO.findById(inRoomVO.getId());
		
		return rVO;
	}

}