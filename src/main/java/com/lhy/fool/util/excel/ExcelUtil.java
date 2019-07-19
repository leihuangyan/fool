/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExcelUtil
 * Author:   LOOK_ME
 * Date:     2019-01-28 11:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lhy.fool.util.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author LOOK_ME
 * @create 2019-01-28
 * @since 1.0.0
 */
public class ExcelUtil {

    public static void main(String[] args) {

        String sheetName = "用车统计表单";
        String titleName = "用车申请数据统计表";
        String fileName = "用车申请统计表单";
        int columnNumber = 3;
        int[] columnWidth = { 10, 20, 30 };
        String[][] dataList = { { "001", "2015-01-01", "IT" },
                { "002", "2015-01-02", "市场部" }, { "003", "2015-01-03", "测试" } };
        String[] columnName = { "单号", "申请时间", "申请部门" };
        try {
            new ExcelUtil().ExportNoResponse(sheetName, titleName, fileName,
                    columnNumber, columnWidth, columnName, dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void ExportNoResponse(String sheetName, String titleName,
                                 String fileName, int columnNumber, int[] columnWidth,
                                 String[] columnName, String[][] dataList) throws Exception {
        if (columnNumber == columnWidth.length&& columnWidth.length == columnName.length) {
            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet(sheetName);
            // sheet.setDefaultColumnWidth(15); //统一设置列宽
            for (int i = 0; i < columnNumber; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    if (i == j)
                    {
                        sheet.setColumnWidth(i, columnWidth[j] * 256); // 单独设置每列的宽
                    }
                }
            }
            // 创建第0行 也就是标题
            HSSFRow row1 = sheet.createRow((int) 0);
            row1.setHeightInPoints(50);// 设备标题的高度
            // 第三步创建标题的单元格样式style2以及字体样式headerFont1
            HSSFCellStyle style2 = wb.createCellStyle();
            HSSFFont headerFont1 = wb.createFont(); // 创建字体样式
            headerFont1.setFontName("黑体"); // 设置字体类型
            headerFont1.setFontHeightInPoints((short) 15); // 设置字体大小
            style2.setFont(headerFont1); // 为标题样式设置字体样式
            HSSFCell cell1 = row1.createCell(0);// 创建标题第一列
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,
                    columnNumber - 1)); // 合并第0到第17列
            cell1.setCellValue(titleName); // 设置值标题
            cell1.setCellStyle(style2); // 设置标题样式

            // 创建第1行 也就是表头
            HSSFRow row = sheet.createRow((int) 1);
            row.setHeightInPoints(37);// 设置表头高度

            // 第四步，创建表头单元格样式 以及表头的字体样式
            HSSFCellStyle style = wb.createCellStyle();
            style.setWrapText(true);// 设置自动换行
            HSSFFont headerFont = wb.createFont(); // 创建字体样式
            headerFont.setFontName("黑体"); // 设置字体类型
            headerFont.setFontHeightInPoints((short) 10); // 设置字体大小
            style.setFont(headerFont); // 为标题样式设置字体样式

            // 第四.一步，创建表头的列
            for (int i = 0; i < columnNumber; i++)
            {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(columnName[i]);
                cell.setCellStyle(style);
            }

            // 第五步，创建单元格，并设置值
            for (int i = 0; i < dataList.length; i++)
            {
                row = sheet.createRow((int) i + 2);
                // 为数据内容设置特点新单元格样式1 自动换行 上下居中
                HSSFCellStyle zidonghuanhang = wb.createCellStyle();
                zidonghuanhang.setWrapText(true);// 设置自动换行


                // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中
                HSSFCellStyle zidonghuanhang2 = wb.createCellStyle();
                zidonghuanhang2.setWrapText(true);// 设置自动换行
                HSSFCell datacell = null;
                for (int j = 0; j < columnNumber; j++)
                {
                    datacell = row.createCell(j);
                    datacell.setCellValue(dataList[i][j]);
                    datacell.setCellStyle(zidonghuanhang2);
                }
            }

            // 第六步，将文件存到指定位置
            try {
                FileOutputStream fout = new FileOutputStream("D:students.xls");
                wb.write(fout);
                String str = "导出" + fileName + "成功！";
                System.out.println(str);
                fout.close();
            } catch (Exception e) {
                e.printStackTrace();
                String str1 = "导出" + fileName + "失败！";
                System.out.println(str1);
            }
        } else {
            System.out.println("列数目长度名称三个数组长度要一致");
        }

    }


    public void ExportWithResponse(String sheetName, String titleName,
                                   String fileName, int columnNumber, int[] columnWidth,
                                   String[] columnName, String[][] dataList,
                                   HttpServletResponse response) throws Exception {
        if (columnNumber == columnWidth.length&& columnWidth.length == columnName.length) {
            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet(sheetName);
            // sheet.setDefaultColumnWidth(15); //统一设置列宽
            for (int i = 0; i < columnNumber; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    if (i == j)
                    {
                        sheet.setColumnWidth(i, columnWidth[j] * 256); // 单独设置每列的宽
                    }
                }
            }
            // 创建第0行 也就是标题
            HSSFRow row1 = sheet.createRow((int) 0);
            row1.setHeightInPoints(50);// 设备标题的高度
            // 第三步创建标题的单元格样式style2以及字体样式headerFont1
            HSSFCellStyle style2 = wb.createCellStyle();
            style2.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
            HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式

            headerFont1.setFontName("黑体"); // 设置字体类型
            headerFont1.setFontHeightInPoints((short) 15); // 设置字体大小
            style2.setFont(headerFont1); // 为标题样式设置字体样式

            HSSFCell cell1 = row1.createCell(0);// 创建标题第一列
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,
                    columnNumber - 1)); // 合并列标题
            cell1.setCellValue(titleName); // 设置值标题
            cell1.setCellStyle(style2); // 设置标题样式

            // 创建第1行 也就是表头
            HSSFRow row = sheet.createRow((int) 1);
            row.setHeightInPoints(37);// 设置表头高度

            // 第四步，创建表头单元格样式 以及表头的字体样式
            HSSFCellStyle style = wb.createCellStyle();
            style.setWrapText(true);// 设置自动换行
            style.setBottomBorderColor(HSSFColor.BLACK.index);
            HSSFFont headerFont = wb.createFont(); // 创建字体样式
            headerFont.setFontName("黑体"); // 设置字体类型
            headerFont.setFontHeightInPoints((short) 10); // 设置字体大小
            style.setFont(headerFont); // 为标题样式设置字体样式

            // 第四.一步，创建表头的列
            for (int i = 0; i < columnNumber; i++)
            {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(columnName[i]);
                cell.setCellStyle(style);
            }

            // 第五步，创建单元格，并设置值
            for (int i = 0; i < dataList.length; i++)
            {
                row = sheet.createRow((int) i + 2);
                // 为数据内容设置特点新单元格样式1 自动换行 上下居中
                HSSFCellStyle zidonghuanhang = wb.createCellStyle();
                zidonghuanhang.setWrapText(true);// 设置自动换行
                // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中
                HSSFCellStyle zidonghuanhang2 = wb.createCellStyle();
                zidonghuanhang2.setWrapText(true);// 设置自动换行
                // 设置边框
                zidonghuanhang2.setBottomBorderColor(HSSFColor.BLACK.index);
                HSSFCell datacell =null ;
                for (int j = 0; j < columnNumber; j++)
                {
                    datacell = row.createCell(j);
                    datacell.setCellValue(dataList[i][j]);
                    datacell.setCellStyle(zidonghuanhang2);
                }
            }

            // 第六步，将文件存到浏览器设置的下载位置
            String filename = fileName + ".xls";
            response.setContentType("application/ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));
            OutputStream out = response.getOutputStream();
            try {
                wb.write(out);// 将数据写出去
                String str = "导出" + fileName + "成功！";
                System.out.println(str);
            } catch (Exception e) {
                e.printStackTrace();
                String str1 = "导出" + fileName + "失败！";
                System.out.println(str1);
            } finally {
                out.close();
            }

        } else {
            System.out.println("列数目长度名称三个数组长度要一致");
        }

    }


}