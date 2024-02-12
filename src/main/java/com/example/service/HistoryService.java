package com.example.service;

import com.example.SqlSessionTemplate;
import com.example.dao.HistoryDAO;
import com.example.dao.WifiDAO;
import com.example.dto.HistoryDTO;
import com.example.dto.LocationDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class HistoryService {
    private HistoryDAO historyDAO = new HistoryDAO();
    private SqlSession sqlSession = SqlSessionTemplate.getSqlSession();

    public int save(LocationDTO locationDTO){
        return historyDAO.save(locationDTO, sqlSession);
    }

    public List<HistoryDTO> search(){
        return historyDAO.search(sqlSession);
    }

    public int delete(String idStr){
        int id = Integer.parseInt(idStr);
        return historyDAO.delete(id, sqlSession);
    }

}
