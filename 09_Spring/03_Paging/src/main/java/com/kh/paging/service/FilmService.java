package com.kh.paging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.paging.mapper.FilmMapper;
import com.kh.paging.model.dto.PagingDTO;
import com.kh.paging.model.vo.Film;

@Service
public class FilmService { // mapper 파일을 implements하고, override해도 된다.

	@Autowired
	private FilmMapper mapper;

	public List<Film> showFilm(PagingDTO paging) {
		/*
		 * 만약에 limit가 10인 경우
		 * page = 1 -> offset=0
		 * page = 2 -> offset=10
		 * page = 3 -> offset=20
		 * 
		 * offset = limit * (page-1)
		 * */
		paging.setOffset(paging.getLimit() * (paging.getPage()-1));
		return mapper.showFilm(paging);
	}
	
	public int total() {
		return mapper.total();
	}
}
