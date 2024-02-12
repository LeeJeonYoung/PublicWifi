package com.example.controller;

import com.example.dto.BookmarkDTO;
import com.example.dto.BookmarkGroupDTO;
import com.example.dto.LocationDTO;
import com.example.service.BookmarkGroupService;
import com.example.service.BookmarkService;
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

@WebServlet(name = "BookmarkServlet", value = "/bookmarkServlet")
public class BookmarkServlet extends HttpServlet {
    private BookmarkService bookmarkService = new BookmarkService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println(id);
        if (!("null").equals(id) && !"".equals(id) && id != null) {

            BookmarkDTO bookmarkDTO = new BookmarkDTO();
            bookmarkDTO.setId(Integer.parseInt(id));
            bookmarkService.delete(bookmarkDTO);
        }
        List<BookmarkDTO> bookmarkList = bookmarkService.select();
        request.setAttribute("bookmarkList", bookmarkList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookmark.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("bookmarkGroup");
        System.out.println("name = " + name);
        String wifiNm = request.getParameter("wifiNm");
        System.out.println("wifiNm = " + wifiNm);
        BookmarkDTO bookmarkDTO = new BookmarkDTO();
        bookmarkDTO.setName(name);
        bookmarkDTO.setWifiNm(wifiNm);
        bookmarkService.insert(bookmarkDTO);
        List<BookmarkDTO> bookmarkList = bookmarkService.select();
        request.setAttribute("bookmarkList", bookmarkList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookmark.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}