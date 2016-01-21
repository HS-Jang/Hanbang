package hanbang_TeamA.room.service;

import hanbang_TeamA.room.dao.RoomDAO;
import hanbang_TeamA.room.vo.RoomVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRoomServiceImpl implements AddRoomService{
	
	@Autowired
	RoomDAO roomDAO;

	@Override
	public RoomVO createCustomer(RoomVO roomVo) {
		
		roomVo = roomDAO.insert(roomVo);
		return roomVo;
	}

	@Override
	public RoomVO updateCustomer(RoomVO roomVO) {
		
		roomVO = roomDAO.save(roomVO);
		return roomVO;
	}

	@Override
	public void deleteCustomer(RoomVO roomVO) {
		roomDAO.delete(roomVO);
	}

}
