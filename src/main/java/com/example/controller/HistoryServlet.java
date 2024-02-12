package com.example.controller;

import com.example.dto.HistoryDTO;
import com.example.dto.LocationDTO;
import com.example.service.HistoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HistoryServlet", value = "/historyServlet")
public class HistoryServlet extends HttpServlet {
    private String message;
    private HistoryService historyService = new HistoryService();

    public void init() {
        message = "Hello World2!";
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        System.out.println("sss");
        int n = historyService.delete(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/history.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            IOException, HTTPException, ServletException {

        System.out.println(request.getParameter("id") + "");
        String id = request.getParameter("id");
        if (id != null && !"".equals(id)) {
            int n = historyService.delete(id);

        }


        List<HistoryDTO> searchList = historyService.search();


        // jsp에서 사용
        request.setAttribute("searchList", searchList);// 데이터담기

        /**
         * 포워드
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/history.jsp");// 보내야함
        requestDispatcher.forward(request, response);
    }


    public void destroy() {
    }
}