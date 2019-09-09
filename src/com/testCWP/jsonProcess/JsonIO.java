package com.testCWP.jsonProcess;

import com.google.gson.Gson;
import com.shbtos.biz.smart.cwp.service.SmartCwpImportData;

/**
 * Created by lekoxnfx on 2017/2/14.
 */
public class JsonIO {
    Gson gson = new Gson();

    public String cwpImportDataToJson(SmartCwpImportData smartCwpImportData){
        return gson.toJson(smartCwpImportData);
    }

    public SmartCwpImportData jsonToCwpImportData(String inJsonStr){
        return gson.fromJson(inJsonStr,SmartCwpImportData.class);
    }

}
