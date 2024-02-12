package com.example.controller;

import com.example.dto.BookmarkGroupDTO;
import com.example.dto.LocationDTO;
import com.example.dto.WifiDTO;
import com.example.service.BookmarkGroupService;
import com.example.service.HistoryService;
import com.example.service.WifiService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LocationDetailServlet", value = "/locationDetail")
public class LocationDetailServlet extends HttpServlet {
    private WifiService wifiService = new WifiService();
    private BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String MGR_NO = request.getParameter("x_SWIFI_MGR_NO");
        System.out.println(MGR_NO);
        WifiDTO wifiDTO = wifiService.select(MGR_NO);
        request.setAttribute("wifiDetail",wifiDTO);
        List<BookmarkGroupDTO> bookmarkGroupList = bookmarkGroupService.select();
        request.setAttribute("bookmarkGroupList",bookmarkGroupList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("wifiDetail.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}