package com.example.project.model.shop;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO {
@Autowired
SqlSession sqlSession;


	@Override
	public List<CartDTO> cart_money() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.cart_money");
	}

	@Override
	public void insert(CartDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("cart.insert",dto);
	}

	@Override
	public List<CartDTO> list(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.list",userid);
	}

	@Override
	public void delete(int cart_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("cart.delete",cart_id);
	}

	@Override
	public void delete_all(String userid) {
		// TODO Auto-generated method stub
		sqlSession.delete("cart.delete_all",userid);
	}

	@Override
	public int sum_money(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("cart.sum_money",userid);
	}

	@Override
	public void modify(CartDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("cart.modify",dto);
	}

}
