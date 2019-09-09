package com.testAutoStow.test6_1;

import com.autoStow.caller.manager.AutoStowManager;
import com.shbtos.biz.smart.cwp.service.SmartStowImportData;
import com.shbtos.biz.smart.cwp.service.SmartStowResults;
import com.testAutoStow.jsonProcess.JsonIO;
import com.testAutoStow.utils.FileUtil;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by csw on 2016/12/13 15:03.
 * Explain: 这是个测试类，将海勃给的一个json数据文件，导入进来，然后调用算法，进行运行测试
 */
public class TestStow6_1 {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {

        String filePath = "data/autoStowData/6.1/STOW贝塔出口航次：FJBHDME进口航次：FJBHDMI-20190909153703508/";

        String stowImportDataJson = FileUtil.readFileToString(new File(filePath + "smartStowImportDataJson.txt")).toString();

        //导入json数据文件，存在SmartStowImportData对象里，
        JsonIO jsonIO = new JsonIO();
        SmartStowImportData smartStowImportData = jsonIO.jsonToSmartStowImportData(stowImportDataJson);

        SmartStowResults smartStowResults = new SmartStowResults();

        AutoStowManager autoStowManager = new AutoStowManager();
        autoStowManager.callAutoStow(smartStowImportData, smartStowResults);

    }
}
