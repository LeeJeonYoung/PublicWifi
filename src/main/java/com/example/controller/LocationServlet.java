package com.example.controller;

import com.example.dto.LocationDTO;
import com.example.service.HistoryService;
import com.example.service.WifiService;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.ws.http.HTTPException;

@WebServlet(name = "LocationServlet", value = "/location")
public class LocationServlet extends HttpServlet {
    private WifiService wifiService = new WifiService();
    private HistoryService historyService = new HistoryService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, HTTPException, ServletException {

        /**
         *  1. 클라이언트로부터 얻기  ( lat x , lnt y ( X,Y좌표) )
         *
         */


        Double latDouble = Double.valueOf(request.getParameter("latitude-input"));
        Double lntDouble = Double.valueOf(request.getParameter("longitude-input"));

        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLat(latDouble);
        locationDTO.setLnt(lntDouble);


        List<LocationDTO> searchList =  wifiService.search(locationDTO); // 20개가져오고

        System.out.println(locationDTO);
        historyService.save(locationDTO); // 위치 히스토리 저장.


        // jsp에서 사용
        request.setAttribute("searchList", searchList);// 데이터담기

        /**
         * 포워드
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");// 보내야함
        requestDispatcher.forward(request, response);


    }

    public void destroy() {
    }
}