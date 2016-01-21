package hanbang_TeamA.com.service;

import hanbang_TeamA.com.dao.HanbangDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HanbangServiceImpl implements HanbangService {
	
	@Autowired
	HanbangDAO hanbangRepo;
	
	public String getString()
	{
		return hanbangRepo.getString();
	}
}
