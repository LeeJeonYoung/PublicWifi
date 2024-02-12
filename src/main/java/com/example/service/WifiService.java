package com.example.service;

import com.example.SqlSessionTemplate;
import com.example.dao.WifiDAO;
import com.example.dto.LocationDTO;
import com.example.dto.WifiDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class WifiService {
    private WifiDAO wifiDAO = new WifiDAO();
    private SqlSession sqlSession = SqlSessionTemplate.getSqlSession();

    public List<LocationDTO> search(LocationDTO locationDTO){
        return wifiDAO.search(locationDTO, sqlSession);
    }
    public int insertAll(WifiDTO wifiDTO){
        return wifiDAO.insertAll(wifiDTO, sqlSession);
    }
    public int deleteAll(){
        return wifiDAO.deleteAll(sqlSession);
    }
    public WifiDTO select(String MGR_NO){
        return wifiDAO.select(MGR_NO, sqlSession);
    }

}
