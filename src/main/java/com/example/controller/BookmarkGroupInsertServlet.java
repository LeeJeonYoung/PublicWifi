package com.example.controller;

import com.example.dto.BookmarkGroupDTO;
import com.example.service.BookmarkGroupService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookmarkGroupInsertServlet", value = "/bookmarkGroupInsertServlet")
public class BookmarkGroupInsertServlet extends HttpServlet {
    private BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookmarkGroupInsert.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String orderStr = request.getParameter("order");

        BookmarkGroupDTO bookmarkGroupDTO = new BookmarkGroupDTO();
        int order = Integer.parseInt(orderStr);
        bookmarkGroupDTO.setName(name);
        bookmarkGroupDTO.setOrder2(order);

        if (idStr != null && !"".equals(idStr) && !idStr.equals("null")) {
            //update
            int id = Integer.parseInt(idStr);
            bookmarkGroupDTO.setId(id);

            bookmarkGroupService.update(bookmarkGroupDTO);
        } else {
            //insert name,order만
            bookmarkGroupService.insert(bookmarkGroupDTO);
        }
        List<BookmarkGroupDTO> bookmarkGroupList = bookmarkGroupService.select();
        request.setAttribute("bookmarkGroupList", bookmarkGroupList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookmarkGroup.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}