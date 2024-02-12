package com.example.controller;

import com.example.dto.BookmarkGroupDTO;
import com.example.dto.LocationDTO;
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

@WebServlet(name = "BookmarkGroupServlet", value = "/bookmarkGroupServlet")
public class BookmarkGroupServlet extends HttpServlet {
    private BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<BookmarkGroupDTO> bookmarkGroupList = bookmarkGroupService.select();
        System.out.println("bookmarkGroupList"+bookmarkGroupList);
        request.setAttribute("bookmarkGroupList", bookmarkGroupList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookmarkGroup.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        int id =0;
        System.out.println("idStr"+idStr);
        if (idStr!=null && !"".equals(idStr)) {
            id = Integer.parseInt(idStr);
            BookmarkGroupDTO bookmarkGroupDTO = bookmarkGroupService.selectById(id);

            String flag = request.getParameter("flag");

             if(flag.equals("delete")) {
                bookmarkGroupService.delete(bookmarkGroupDTO);
            }
        }else{
            System.out.println("error");
        }
        List<BookmarkGroupDTO> bookmarkGroupList = bookmarkGroupService.select();
        request.setAttribute("bookmarkGroupList", bookmarkGroupList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookmarkGroup.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}