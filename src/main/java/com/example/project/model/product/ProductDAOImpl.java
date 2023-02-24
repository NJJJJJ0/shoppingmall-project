package com.example.project.model.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
@Autowired
SqlSession sqlSession;

	@Override
	public List<ProductDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.list");
	}

	@Override
	public ProductDTO detail(int product_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.detail", product_code);
	}

	@Override
	public void update(ProductDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("product.update", dto);
	}

	@Override
	public void delete(int product_code) {
		// TODO Auto-generated method stub
		sqlSession.delete("product.delete", product_code);
	}

	@Override
	public void insert(ProductDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("product.insert",dto);
	}

	@Override
	public String file_info(int product_code) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.file_info", product_code);
	}

}
