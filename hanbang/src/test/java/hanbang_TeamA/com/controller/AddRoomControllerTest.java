package hanbang_TeamA.com.controller;

import hanbang_TeamA.room.service.SearchRoomServiceimpl;
import hanbang_TeamA.room.vo.RoomVO;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddRoomControllerTest extends TestCase {
	
	SearchRoomServiceimpl a;
	
	@Before
	public void setUp(){
		a = new SearchRoomServiceimpl();
	}
	
	@After
	public void tearDown(){
		a = null;
	}

	@Test
	public void testCreatRoom(){
		RoomVO vo = new RoomVO();
		vo.setId("aa");
		assertEquals(a.getRoomVOById(vo).getId(), "aa");
	}
}
