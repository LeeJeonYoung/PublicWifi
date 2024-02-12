package com.example.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.dto.WifiDTO;
import com.example.service.WifiService;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.sql.*;
import java.util.List;
@WebServlet(name = "OpenAPIservlet", value = "/openAPIservlet")
public class OpenAPIServlet extends HttpServlet {
    private WifiService wifiService = new WifiService();

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            StringBuilder sb = new StringBuilder();
            String token ="5146414a67716c6a38357379474176";
            String apiURL = "http://openapi.seoul.go.kr:8088/5146414a67716c6a38357379474176/json/TbPublicWifiInfo/";


            URL url = new URL(apiURL+"1/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            BufferedReader br;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            while(br.ready()){
                sb.append(br.readLine());
            }
            System.out.println("sb = " + sb);
            JsonObject object = (JsonObject) new JsonParser().parse(sb.toString());

            JsonObject data = (JsonObject) object.get("TbPublicWifiInfo");
            JsonElement cnt =  data.get("list_total_count");
            System.out.println("cnt = " + cnt);
            wifiService.deleteAll();
            for (int i = 0; i < Integer.parseInt(String.valueOf(cnt))/1000+1; i++) {
                StringBuilder sb2 = new StringBuilder();
                int start = 1 + i*1000;

                int end = (i+1)*1000;
                String apiURL2 = apiURL + start +"/" +end;

                url = new URL(apiURL2);
                HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
                conn2.setRequestMethod("GET");
                conn2.setRequestProperty("Content-type", "application/json");
                BufferedReader br2;
                if (conn2.getResponseCode() >= 200 && conn2.getResponseCode() <= 300) {
                    br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream(),"UTF-8"));
                } else {
                    br2 = new BufferedReader(new InputStreamReader(conn2.getErrorStream()));
                }
                while(br2.ready()){
                    sb2.append(br2.readLine());
                }
                JsonObject object2 = (JsonObject) new JsonParser().parse(sb2.toString());
                JsonObject data2 = (JsonObject) object2.get("TbPublicWifiInfo");
                JsonArray array = data2.get("row").getAsJsonArray();
                for (int i1 = 0; i1 < array.size(); i1++) {

                    JsonObject result = (JsonObject) array.get(i1).getAsJsonObject();

                    WifiDTO wifiDTO = new WifiDTO();
                    wifiDTO.setX_SWIFI_MGR_NO(result.get("X_SWIFI_MGR_NO").getAsString());
                    wifiDTO.setX_SWIFI_WRDOFC(result.get("X_SWIFI_WRDOFC").getAsString());
                    wifiDTO.setX_SWIFI_MAIN_NM(result.get("X_SWIFI_MAIN_NM").getAsString());
                    wifiDTO.setX_SWIFI_ADRES1(result.get("X_SWIFI_ADRES1").getAsString());
                    wifiDTO.setX_SWIFI_ADRES2(result.get("X_SWIFI_ADRES2").getAsString());
                    wifiDTO.setX_SWIFI_INSTL_FLOOR(result.get("X_SWIFI_INSTL_FLOOR").getAsString());
                    wifiDTO.setX_SWIFI_INSTL_TY(result.get("X_SWIFI_INSTL_TY").getAsString());
                    wifiDTO.setX_SWIFI_INSTL_MBY(result.get("X_SWIFI_INSTL_MBY").getAsString());
                    wifiDTO.setX_SWIFI_SVC_SE(result.get("X_SWIFI_SVC_SE").getAsString());
                    wifiDTO.setX_SWIFI_CMCWR(result.get("X_SWIFI_CMCWR").getAsString());
                    wifiDTO.setX_SWIFI_CNSTC_YEAR(result.get("X_SWIFI_CNSTC_YEAR").getAsString());
                    wifiDTO.setX_SWIFI_INOUT_DOOR(result.get("X_SWIFI_INOUT_DOOR").getAsString());
                    wifiDTO.setX_SWIFI_REMARS3(result.get("X_SWIFI_REMARS3").getAsString());
                    wifiDTO.setLat(result.get("LAT").getAsString());
                    wifiDTO.setLnt(result.get("LNT").getAsString());
                    wifiDTO.setWORK_DTTM(result.get("WORK_DTTM").getAsString());
                    wifiService.insertAll(wifiDTO);
                }
            }


            System.out.println("47");
//            System.out.println(array.toString());
//            Gson gson = new Gson();
//            System.out.println("br: "+ gson.fromJson(br);

            conn.disconnect();

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");// 보내야함
            requestDispatcher.forward(request, response);
        }


}
