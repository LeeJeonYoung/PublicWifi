package com.example.dao;

import com.example.dto.LocationDTO;
import com.example.dto.WifiDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class WifiDAO {
    public List<LocationDTO> search(LocationDTO locationDTO,SqlSession session){

        return session.selectList("com.config.LocationMapper.selectLocation",locationDTO);
    }

    public int insertAll(WifiDTO wifiDTO,SqlSession session){
        return session.insert("com.config.OpenAPIMapper.insertAll", wifiDTO);
    }
    public int deleteAll(SqlSession session){
        return session.delete("com.config.OpenAPIMapper.deleteAll");
    }
    public WifiDTO select(String MGR_NO,SqlSession session){
        return session.selectOne("com.config.LocationMapper.selectLocationByMgrNo", MGR_NO);
    }
}
