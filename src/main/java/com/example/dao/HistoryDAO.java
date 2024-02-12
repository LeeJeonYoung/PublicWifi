package com.example.dao;

import com.example.dto.HistoryDTO;
import com.example.dto.LocationDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HistoryDAO {
    public int  save(LocationDTO locationDTO,SqlSession session){
        return session.insert("com.config.HistoryMapper.saveHistory",locationDTO);
    }
    public List<HistoryDTO> search(SqlSession session){
        return session.selectList("com.config.HistoryMapper.selectHistory");
    }
    public int  delete(int id, SqlSession session){
        return session.delete("com.config.HistoryMapper.deleteHistory",id);
    }
}
