package com.kh.upload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.model.vo.Board;

@Service
public class BoardService implements BoardMapper{

	@Autowired
	private BoardMapper mapper;

	@Override
	public void addBoard(Board vo) {
		mapper.addBoard(vo);
	}
	
	
}
