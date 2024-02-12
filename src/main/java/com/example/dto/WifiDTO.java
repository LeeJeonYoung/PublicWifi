package com.example.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WifiDTO {
    @SerializedName("X_SWIFI_MGR_NO")
    private String X_SWIFI_MGR_NO;
    @SerializedName("X_SWIFI_WRDOFC")
    private String X_SWIFI_WRDOFC;
    @SerializedName("X_SWIFI_MAIN_NM")
    private String X_SWIFI_MAIN_NM;


    @SerializedName("X_SWIFI_ADRES1")
    private String X_SWIFI_ADRES1;
    @SerializedName("X_SWIFI_ADRES2")
    private String X_SWIFI_ADRES2;
    @SerializedName("X_SWIFI_INSTL_FLOOR")
    private String X_SWIFI_INSTL_FLOOR;


    @SerializedName("X_SWIFI_INSTL_TY")
    private String X_SWIFI_INSTL_TY;
    @SerializedName("X_SWIFI_INSTL_MBY")
    private String X_SWIFI_INSTL_MBY;
    @SerializedName("X_SWIFI_SVC_SE")
    private String X_SWIFI_SVC_SE;


    @SerializedName("X_SWIFI_CMCWR")
    private String X_SWIFI_CMCWR;
    @SerializedName("X_SWIFI_CNSTC_YEAR")
    private String X_SWIFI_CNSTC_YEAR;
    @SerializedName("X_SWIFI_INOUT_DOOR")
    private String X_SWIFI_INOUT_DOOR;
    @SerializedName("X_SWIFI_REMARS3")
    private String X_SWIFI_REMARS3;


    @SerializedName("LAT")
    private String lat;
    @SerializedName("LNT")
    private String lnt;
    @SerializedName("WORK_DTTM")
    private String WORK_DTTM;

    @SerializedName("distance")
    private String distance;
}
