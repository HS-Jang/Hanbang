package hanbang_TeamA.room.service;

import hanbang_TeamA.room.vo.RoomVO;

public interface AddRoomService {

	public RoomVO createCustomer(RoomVO roomVo);

	public RoomVO updateCustomer(RoomVO roomVO);

	public void deleteCustomer(RoomVO roomVO);
	
}
