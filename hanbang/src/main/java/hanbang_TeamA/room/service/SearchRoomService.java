package hanbang_TeamA.room.service;

import hanbang_TeamA.room.vo.RoomOptionVO;
import hanbang_TeamA.room.vo.RoomVO;

import java.util.List;

public interface SearchRoomService {
	public List<RoomVO> getRoomList(RoomOptionVO inRoomOptionVO);

	public RoomVO insRoom(RoomVO room);
	
	public List<RoomVO> getRoomListByUserId(RoomVO inRoomVO);
	
	public RoomVO selectRoom(RoomVO roomVo);
	
	public RoomVO getRoomVOById(RoomVO roomVo);

	public List<RoomVO> getAllRoomList(RoomOptionVO inRoomOptionVO);
}