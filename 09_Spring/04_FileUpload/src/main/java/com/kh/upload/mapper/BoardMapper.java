package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.model.vo.Board;

@Mapper
public interface BoardMapper {
	void insert(Board vo);
	List<Board> selectAll();
	Board select(int no);
	void update(Board vo);
	void delete(int no);
	//void write(BoardDTO dto);
	//List<Board> view(int no);
	void update2(BoardDTO dto);
	int total();
	List<Board> showBoard(PagingDTO paging);
}
