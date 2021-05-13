package com.it.web;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ExportExcelZipUtils {
 
    private static Logger logger = LoggerFactory.getLogger(ExportExcelZipUtils.class);
 
    /**
     * 设置excel压缩文件导出时的请求头
     * @param response
     * @param fileName:多个excel的压缩文件名
     */
    public static void setResponseHeader(final HttpServletResponse response, final String fileName) {
 
        logger.info("begin to set response header");
        try {
            response.reset();
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            logger.info("set response header successfully");
 
        } catch (final Exception e) {
            logger.error("set response header failed", e);
        }
    }
 
    /**
     * 生成excel文件
     * @param dataList：数据
     * @param request
     * @param response
     * @param fileName：生成的excel文件名称
     * @param fileNameList：用于存放生成的文件名称
     */
    public static void toExcel(final String[] labels, final List<String[]> dataList, final HttpServletRequest request,
                               final String fileName, final List<String> fileNameList) {
 
        logger.info("begin to create excel");
        final File dirFile = new File(request.getRealPath(File.separator + "excel") + File.separator);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        final String file = request.getRealPath(File.separator + "excel") + File.separator + fileName + ".xls";
 
        FileOutputStream fos = null;
        Workbook workbook = null;
        try {
            fos = new FileOutputStream(file);
 
            workbook = new HSSFWorkbook();
            final Sheet sheet = workbook.createSheet("数据列表");
            Row row = sheet.createRow(0);
            for (int i = 0; i < labels.length; i++) {
                row.createCell(i).setCellValue(labels[i]);
            }
            for (int i = 0; i < dataList.size(); i++) {
                final String[] vals = dataList.get(i);
                row = sheet.createRow(i + 1);
                for (int j = 0; j < vals.length; j++) {
                    row.createCell(j).setCellValue(vals[j]);
                }
            }
            workbook.write(fos);
            fos.flush();
            fileNameList.add(file);
        } catch (final Exception e) {
            logger.error("create excel failed");
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (final IOException e) {
                    logger.error("workbook关闭失败", e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (final IOException e) {
                    logger.error("输出流关闭失败", e);
                }
            }
        }
    }
    public static String toZipFiles(final HttpServletRequest request, final List<String> fileNameList,
                                    final String zipFileName) {
 
        String zipFilePath = request.getRealPath(File.separator + "excel") + File.separator + zipFileName;
        logger.info("begin to create zip file");
 
        final File[] files = new File[fileNameList.size()];
        for (int i = 0; i < fileNameList.size(); i++) {
            files[i] = new File(fileNameList.get(i));
        }
        // 压缩文件
        final File zipFile = new File(zipFilePath);
        // 将excel文件压缩成zip文件
        final byte[] buf = new byte[1024];
        ZipOutputStream zipOut = null;
        FileInputStream fis = null;
        try {
            zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            for (int i = 0; i < files.length; i++) {
                fis = new FileInputStream(files[i]);
                zipOut.putNextEntry(new ZipEntry(files[i].getName()));
                int len = 0;
                while ((len = fis.read(buf)) > 0) {
                    zipOut.write(buf, 0, len);
                }
                zipOut.closeEntry();
                fis.close();
            }
        } catch (final Exception e) {
            zipFilePath = null;
            logger.error("failed to create zip file");
        } finally {
            if (zipOut != null) {
                try {
                    zipOut.close();
                } catch (final IOException e) {
                    logger.error("failed to close ZipOutputStream");
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (final IOException e) {
                    logger.error("failed to close FileInputStream");
                }
            }
        }
        return zipFilePath;
    }
 
    public static void downloadZip(final OutputStream out, final String zipFilePath) {
 
        logger.info("begin to download zip file from " + zipFilePath);
        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(zipFilePath);
            final byte[] buf = new byte[4096];
            int readLength;
            while (((readLength = inStream.read(buf)) != -1)) {
                out.write(buf, 0, readLength);
            }
            out.flush();
        } catch (final Exception e) {
            logger.error("download zip excel failed");
        } finally {
            try {
                inStream.close();
            } catch (final IOException e) {
                logger.error("failed to close FileInputStream");
            }
            try {
                out.close();
            } catch (final IOException e) {
                logger.error("failed to close OutputStream");
            }
        }
    }
}