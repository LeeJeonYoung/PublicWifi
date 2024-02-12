package com.example.service;

import com.example.SqlSessionTemplate;
import com.example.dao.BookmarkGroupDAO;
import com.example.dao.HistoryDAO;
import com.example.dto.BookmarkGroupDTO;
import com.example.dto.HistoryDTO;
import com.example.dto.LocationDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class BookmarkGroupService {
    private BookmarkGroupDAO bookmarkGroupDAO = new BookmarkGroupDAO();
    private SqlSession sqlSession = SqlSessionTemplate.getSqlSession();

    public int insert(BookmarkGroupDTO BookmarkGroupDTO){
        return bookmarkGroupDAO.insert(BookmarkGroupDTO, sqlSession);
    }

    public List<BookmarkGroupDTO> select(){
        return bookmarkGroupDAO.select(sqlSession);
    }
    public BookmarkGroupDTO selectById(int id){
        return bookmarkGroupDAO.selectById(id,sqlSession);
    }


    public int delete(BookmarkGroupDTO BookmarkGroupDTO){
        return bookmarkGroupDAO.delete(BookmarkGroupDTO, sqlSession);
    }

    public int update(BookmarkGroupDTO BookmarkGroupDTO){
        return bookmarkGroupDAO.update(BookmarkGroupDTO, sqlSession);
    }



}
