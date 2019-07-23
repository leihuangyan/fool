package com.lhy.fool.util.excel;

import com.lhy.fool.admin.person.entity.Girl;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author 98403
 * @date: 2019-06-24 17:20
 */
public class ExcelDome {
    //导出
    public void saveExcel(List<Girl> users){
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("汇头条");
        ///设置缺省列高
        sheet.setDefaultRowHeightInPoints(30);
        ///设置缺省列宽
        sheet.setDefaultColumnWidth(15);

        //在sheet里创建第一行，
        HSSFRow row1=sheet.createRow(0);
        //创建单元格
        HSSFCell cell=row1.createCell(0);

        //单元格样式
        HSSFCellStyle style=wb.createCellStyle();
        //水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //字体样式
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        font.setFontName("宋体");
        font.setColor(HSSFColor.BLUE.index);
        style.setFont(font);

        cell.setCellStyle(style);
        //设置单元格内容
        cell.setCellValue("小号账号密码");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));

        //创建单元格并设置单元格内容
        HSSFRow row2=sheet.createRow(1);
        row2.createCell(0).setCellValue("ID");
        row2.createCell(1).setCellValue("账号");
        row2.createCell(2).setCellValue("密码");
        for (int i = 0; i < users.size(); i++) {
            int id = i+1;
            String name = users.get(i).getName();
            String address = users.get(i).getAddress();
            HSSFRow row3=sheet.createRow(i+2);
            row3.createCell(0).setCellValue(id);
            row3.createCell(1).setCellValue(name);
            row3.createCell(2).setCellValue(address);
        }

        //输出Excel文件
        try {
            FileOutputStream fos = new FileOutputStream("E:\\Temp\\name.xls");
            wb.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
