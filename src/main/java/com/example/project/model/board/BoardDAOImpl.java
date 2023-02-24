package com.example.project.model.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;


	@Override
	public List<BoardDTO> list(int start, int end, String search_option, String keyword) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start",start-1);
		map.put("end", end);
		return sqlSession.selectList("board.list", map);
	}

	@Override
	public void insert(BoardDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("dto:"+dto);
		sqlSession.insert("board.insert",dto);
	}

	@Override
	public BoardDTO detail(int idx) {
		// TODO Auto-generated method stub
		//BoardDTO dto=sqlSession.selectOne("board.detail", idx);
		return sqlSession.selectOne("board.detail", idx);
	}

	@Override
	public void increase_hit(int idx) {
		// TODO Auto-generated method stub
		sqlSession.update("board.increase_hit", idx);
	}

	@Override
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("board.update",dto);
		System.out.println(dto);
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		sqlSession.delete("board.delete",idx);
	}

	@Override
	public int count(String search_option, String keyword) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword",keyword);
		return sqlSession.selectOne("board.count", map);
	}

	@Override
	public List<String> list_attach(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.list_attach",idx);
	}

	@Override
	public void insert_attach(String file_name) {
		// TODO Auto-generated method stub
		sqlSession.insert("board.insert_attach", file_name);
	}

	@Override
	public void update_attach(String file_name, int idx) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("file_name", file_name);
		map.put("idx", idx);
		sqlSession.insert("board.update_attach",map);
	}

	@Override
	public void delete_attach(String file_name) {
		// TODO Auto-generated method stub
		sqlSession.delete("board.delete_attach", file_name);
	}

	@Override
	public String setLike(int idx, String userId) {
		Map<String, Object> map = new HashMap<>();
		map.put("idx", idx);
		map.put("userId", userId);
		
		int isLiked = (int)sqlSession.selectOne("board.isLiked", map);
		if(isLiked == 0) {
			sqlSession.selectOne("board.insertLike", map);
			return "I";
		} else { 
			sqlSession.selectOne("board.deleteLike", map);
			return "D";
		}
	}

	@Override
	public boolean isLiked(int idx, String userId) {
		Map<String, Object> map = new HashMap<>();
		map.put("idx", idx);
		map.put("userId", userId);
		
		int isLiked = (int)sqlSession.selectOne("board.isLiked", map);
		return isLiked > 0;
	}
}
