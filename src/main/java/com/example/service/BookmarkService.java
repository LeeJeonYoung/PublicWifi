package com.example.service;

import com.example.SqlSessionTemplate;
import com.example.dao.BookmarkDAO;
import com.example.dao.BookmarkGroupDAO;
import com.example.dto.BookmarkDTO;
import com.example.dto.BookmarkGroupDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class BookmarkService {
    private BookmarkDAO bookmarkDAO = new BookmarkDAO();
    private SqlSession sqlSession = SqlSessionTemplate.getSqlSession();

    public int insert(BookmarkDTO BookmarkDTO){
        return bookmarkDAO.insert(BookmarkDTO, sqlSession);
    }

    public List<BookmarkDTO> select(){
        return bookmarkDAO.select(sqlSession);
    }



    public int delete(BookmarkDTO BookmarkDTO){
        return bookmarkDAO.delete(BookmarkDTO, sqlSession);
    }

}
