package hanbang_TeamA.room.service;

import hanbang_TeamA.room.dao.RoomDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service
	public class RoomListMapServiceImpl implements RoomListMapService{
		 
		@Autowired
		RoomDAO roomDAO;


	}
