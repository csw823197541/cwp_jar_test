package com.testWI.test10_25;

import com.shbtos.biz.smart.cwp.pojo.inputs.SmartWiImportData;
import com.shbtos.biz.smart.cwp.pojo.results.SmartWiResults;
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
public class Test10_25 {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception{

        String filePath = "data/wiData/10.24/10.25/WI中远波士顿出口航次：MEA1008进口航次：MEA1007-20171025111124910/";

        String wiImportDataJson = FileUtil.readFileToString(new File(filePath + "WiImportDataJson.txt")).toString();

        SmartWiImportData smartWiImportData = new JsonIO().jsonToSmartWiImportData(wiImportDataJson);

        SmartWiResults smartWiResults = new SmartWiResults();
        AllData allData = new AllData();
        WIDSMethod.parseData(allData, smartWiImportData, smartWiResults);
        WIDSService.processWIDS(allData);

        System.out.println(smartWiResults.getSmartReAutoWiInfos().size());

        AllData allData1 = new AllData();
        WIDSMethod.parseAdjustWorkBlockData(allData1, smartWiImportData, smartWiResults);
        WIDSService.adjustWorkBlock(allData1);

        System.out.println(smartWiResults.getSmartReCwpBlockInfoList().size());
    }

}
