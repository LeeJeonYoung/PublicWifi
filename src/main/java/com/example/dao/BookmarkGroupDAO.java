package com.example.dao;

import com.example.dto.BookmarkGroupDTO;
import com.example.dto.HistoryDTO;
import com.example.dto.LocationDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BookmarkGroupDAO {

    public List<BookmarkGroupDTO> select(SqlSession session){
        return session.selectList("com.config.BookmarkGroupMapper.selectBookmarkGroup");
    }
    public BookmarkGroupDTO selectById(int id, SqlSession session){
        return session.selectOne("com.config.BookmarkGroupMapper.selectBookmarkGroupById",id);
    }

    public int insert(BookmarkGroupDTO bookmarkGroupDTO,SqlSession session){
        System.out.println("BookmarkGroup:insert");
        return session.insert("com.config.BookmarkGroupMapper.insertBookmarkGroup",bookmarkGroupDTO);
    }

    public int delete(BookmarkGroupDTO bookmarkGroupDTO,SqlSession session){
        System.out.println("BookmarkGroup:Delete");
        return session.delete("com.config.BookmarkGroupMapper.deleteBookmarkGroup",bookmarkGroupDTO);
    }

    public int update(BookmarkGroupDTO bookmarkGroupDTO,SqlSession session){
        System.out.println("BookmarkGroup:update");
        return session.update("com.config.BookmarkGroupMapper.updateBookmarkGroup",bookmarkGroupDTO);
    }
}
