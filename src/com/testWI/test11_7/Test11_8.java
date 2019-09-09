package com.testWI.test11_7;

import com.shbtos.biz.smart.cwp.service.SmartWiImportData;
import com.shbtos.biz.smart.cwp.service.SmartWiResults;
import com.testWI.jsonProcess.JsonIO;
import com.testWI.utils.FileUtil;
import com.wids.manager.data.AllData;
import com.wids.manager.method.WIDSMethod;
import com.wids.service.WIDSService;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by csw on 2017/4/13 14:35.
 * Explain: 测试类，将海勃给的一个json数据文件，导入进来，然后调用算法，进行运行测试
 */
public class Test11_8 {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception{

        String filePath = "data/wiData/11.7/11.8/WiBlock集海之盛2出口航次：null进口航次：1108WW-20171108152046475/";

        String wiImportDataJson = FileUtil.readFileToString(new File(filePath + "WiBlockImportDataJson.txt")).toString();

        SmartWiImportData smartWiImportData = new JsonIO().jsonToSmartWiImportData(wiImportDataJson);

        SmartWiResults smartWiResults = new SmartWiResults();
//        AllData allData = new AllData();
//        WIDSMethod.parseData(allData, smartWiImportData, smartWiResults);
//        WIDSService.processWIDS(allData);
//
//        System.out.println(smartWiResults.getSmartReAutoWiInfos().size());

        AllData allData1 = new AllData();
        WIDSMethod.parseAdjustWorkBlockData(allData1, smartWiImportData, smartWiResults);
        WIDSService.adjustWorkBlock(allData1);

        System.out.println(smartWiResults.getSmartReCwpBlockInfoList().size());
    }

}