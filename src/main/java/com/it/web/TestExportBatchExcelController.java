package com.it.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class TestExportBatchExcelController {
 
    private final Logger logger = LoggerFactory.getLogger(TestExportBatchExcelController.class);
 
//    @Autowired
//    DataInfoMapper dataInfoMapper;
 
    @RequestMapping("/exportBatchExcel")
    public void exportApplyBatchExcel(final HttpServletRequest request, final HttpServletResponse response) {
 
        // 生成的excel表格路径
        final List<String> fileNameList = new ArrayList<>();
 
        // excel表头
        final String[] labels1 = { "软件", "数量" };
        // 获取并整理数据
        final List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        Map<String, String> map=new LinkedHashMap<>();
        map.put("SOFTWARE_NAME","IDEA");
        map.put("NUM","18");
        dataList.add(map);
        final List<String[]> datas = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            final String[] data = { dataList.get(i).get("SOFTWARE_NAME"), String.valueOf(dataList.get(i).get("NUM")) };
            datas.add(data);
        }
        // 将数据导入到excel表格中，并将生成的表格路径添加到fileNameList中
        ExportExcelZipUtils.toExcel(labels1, datas, request, "软件数量关系1", fileNameList);
        final String[] labels2 = { "软件", "数量" };
        final List<Map<String, String>> dataList2 = new ArrayList<Map<String, String>>();
        Map<String, String> map2=new LinkedHashMap<>();
        map2.put("SOFTWARE_NAME","POST");
        map2.put("NUM","19");
        dataList2.add(map2);
        final List<String[]> datas2 = new ArrayList<>();
        for (int i = 0; i < dataList2.size(); i++) {
            final String[] data2 = { dataList2.get(i).get("SOFTWARE_NAME"),
                    String.valueOf(dataList2.get(i).get("NUM")) };
            datas2.add(data2);
        }
        ExportExcelZipUtils.toExcel(labels2, datas2, request, "软件数量关系2", fileNameList);
        // 将生成的多个excel表格路径压缩成zip格式文件，并返回生成的临时zip文件路径
        final String zipFilePath = ExportExcelZipUtils.toZipFiles(request, fileNameList, "批量导出excel文件.zip");
        // zip文件创建成功
        if (!StringUtils.isEmpty(zipFilePath)) {
            try {
                // 设置response头
                ExportExcelZipUtils.setResponseHeader(response, "批量导出excel文件.zip");
                // 下载
                ExportExcelZipUtils.downloadZip(response.getOutputStream(), zipFilePath);
            } catch (final IOException e) {
                logger.info("get outputStream from response failed");
            }
        }
    }
}