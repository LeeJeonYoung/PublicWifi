package com.example.dao;

import com.example.dto.BookmarkDTO;
import com.example.dto.BookmarkGroupDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookmarkDAO {

    public List<BookmarkDTO> select(SqlSession session){
        return session.selectList("com.config.BookmarkMapper.selectBookmark");
    }

    public int insert(BookmarkDTO bookmarkDTO,SqlSession session){
        System.out.println("Bookmark:insert");
        return session.insert("com.config.BookmarkMapper.insertBookmark",bookmarkDTO);
    }

    public int delete(BookmarkDTO bookmarkDTO,SqlSession session){
        System.out.println("Bookmark:Delete");
        return session.delete("com.config.BookmarkMapper.deleteBookmark",bookmarkDTO);
    }

//    public int update(BookmarkGroupDTO bookmarkGroupDTO,SqlSession session){
//        System.out.println("BookmarkGroup:update");
//        return session.update("com.config.BookmarkGroupMapper.updateBookmarkGroup",bookmarkGroupDTO);
//    }
}
