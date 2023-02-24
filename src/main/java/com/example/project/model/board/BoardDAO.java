package com.example.project.model.board;

import java.util.List;

public interface BoardDAO {
	List<BoardDTO> list(int start, int end, String search_option, String keyword);
	void insert(BoardDTO dto);
	BoardDTO detail(int idx);
	void increase_hit(int idx);
	void update(BoardDTO dto);
	void delete(int idx);
	int count(String search_option, String keyword);
	List<String> list_attach(int idx);
	void insert_attach(String file_name);
	void update_attach(String file_anme, int idx);
	void delete_attach(String file_name);
	String setLike(int idx, String userId);
	boolean isLiked(int idx, String userId);
	
}
