package com.example.project.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.model.board.BoardDAO;
import com.example.project.model.board.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardDTO> list(int start, int end, String search_option, String keyword) {
		// TODO Auto-generated method stub
		return boardDao.list(start, end, search_option, keyword);
	}

	@Transactional
	@Override
	public void insert(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDao.insert(dto);
	}

	@Override
	public BoardDTO detail(int idx) {
		// TODO Auto-generated method stub
		return boardDao.detail(idx);
	}

	@Override
	public void increase_hit(int idx) {
		// TODO Auto-generated method stub
		boardDao.increase_hit(idx);
	}
	
	@Override
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		boardDao.update(dto);
		String[] files=dto.getFiles();
		if(files==null)return;
		for(String name: files) {
			boardDao.update_attach(name, dto.getIdx());
		}
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		boardDao.delete(idx);
	}

	@Override
	public int count(String search_option, String keyword) {
		// TODO Auto-generated method stub
		return boardDao.count(search_option, keyword);
	}

	@Override
	public List<String> list_attach(int idx) {
		// TODO Auto-generated method stub
		return boardDao.list_attach(idx);
	}

	@Override
	public void delete_attach(String file_name) {
		// TODO Auto-generated method stub
		boardDao.delete_attach(file_name);
	}

	@Override
	public String setLike(int idx, String userId) {
		return boardDao.setLike(idx, userId);
	}

	@Override
	public boolean isLiked(int ide, String userId) {
		return false;
	}
}
