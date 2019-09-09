package com.testWI.jsonProcess;

import com.google.gson.Gson;
import com.shbtos.biz.smart.cwp.service.SmartWiImportData;

/**
 * Created by csw on 2017/4/13.
 */
public class JsonIO {

    Gson gson = new Gson();

    public String smartWiImportDataToJson(SmartWiImportData smartWiImportData) {
        return gson.toJson(smartWiImportData);
    }

    public SmartWiImportData jsonToSmartWiImportData(String inJsonStr) {
        return gson.fromJson(inJsonStr, SmartWiImportData.class);
    }

}
