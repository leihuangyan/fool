package com.lhy.fool.util.excel;

import com.lhy.fool.admin.person.entity.Girl;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：ExportExcelUtil
 * excel 导出工具类
 * @author 98403
 * @param <T>
 */
@Slf4j
public class ExportExcelUtil<T> {

    private HSSFWorkbook workbook;
    private HSSFCellStyle headStyle;
    private HSSFCellStyle commonStyle;
    private HSSFCellStyle topStyle;

    public static final int INT_500 = 350;
    public static final int INT_200 = 200;
    public static final int INT_250 = 240;

    public static final int INT_5000 = 6000;
    public static final int INT_26 = 26;
    public static final int INT_3 = 3;


    /**
     * 方法体说明：设置单元格边框颜色
     * @param cellStyle
     */
    public static void setCellBorderAndColorStyle(HSSFCellStyle cellStyle) {
        // 设置一个单元格边框颜色
        cellStyle.setBorderBottom(BorderStyle.DASH_DOT_DOT);
        cellStyle.setBorderTop(BorderStyle.DASH_DOT_DOT);
        cellStyle.setBorderLeft(BorderStyle.DASH_DOT_DOT);
        cellStyle.setBorderRight(BorderStyle.DASH_DOT_DOT);

        // 设置一个单元格边框颜色
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
    }

    /**
     * 方法体说明：设置单元格对齐方式
     * 日期：
     * @param cellStyle
     */
    public static void setCellStyleAlignment(HSSFCellStyle cellStyle) {
        // 设置上下
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 设置左右
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    }

    /**
     * 方法体说明：设置单元格字体样式
     */
    public static HSSFFont createFonts(HSSFWorkbook wb, short fontSize) {

        // 创建Font对象
        HSSFFont font = wb.createFont();
        // 设置字体
        font.setFontName("微软雅黑");
        // 斜体
        font.setItalic(false);
        // 字体大小
        font.setFontHeight(fontSize);

        return font;
    }

    /**
     * 初始化样式
     */
    public void initStyle() {
        workbook = new HSSFWorkbook();
        headStyle = workbook.createCellStyle();
        commonStyle = workbook.createCellStyle();
        topStyle = workbook.createCellStyle();
        commonStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 设置单元格线粗和颜色
        setCellBorderAndColorStyle(headStyle);
        setCellBorderAndColorStyle(commonStyle);
        setCellBorderAndColorStyle(topStyle);
        // 设置单元格对齐方式
        setCellStyleAlignment(headStyle);
        setCellStyleAlignment(topStyle);
        // 填充背景颜色
        setFillBackgroundColors(headStyle, IndexedColors.BLUE_GREY.getIndex(),
                FillPatternType.SOLID_FOREGROUND);
        setFillBackgroundColors(topStyle, IndexedColors.BLUE_GREY.getIndex(),
                FillPatternType.SOLID_FOREGROUND);
        // 设置字体
        HSSFFont headFont = createFonts(workbook, (short) INT_500);
        HSSFFont commonFont = createFonts(workbook, (short) INT_200);
        HSSFFont topFont = createFonts(workbook, (short) INT_250);
        headFont.setColor(IndexedColors.WHITE.getIndex());

        //headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        //topFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示

        headStyle.setFont(headFont);
        commonStyle.setFont(commonFont);
        topFont.setColor(IndexedColors.WHITE.getIndex());
        topStyle.setFont(topFont);
    }

    /**
     * 方法体说明：设置单元格背景颜色
     * 日期：
     */
    public static void setFillBackgroundColors(HSSFCellStyle cellStyle,
                                               short fg, FillPatternType fp) {
        cellStyle.setFillForegroundColor(fg);
        cellStyle.setFillPattern(fp);
    }

    /**
     * 设置头部样式
     * @param row2Cell0
     * @param title
     */
    public void setHeadStyle(HSSFCell row2Cell0, String title) {
        //row2Cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
        row2Cell0.setCellValue(new HSSFRichTextString("单据编码"));
        row2Cell0.setCellStyle(headStyle);
    }


    /**
     *  赋值
     * @param sheetName excel sheet名
     * @param titleArray 列名
     * @param list 数据list
     * @param methodName 要调用的方法名
     *
     */
    public void setData(String sheetName, String[] titleArray,
                        List<T> list, String methodName) {
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet(sheetName);
        for (int columnNum = 0; columnNum < titleArray.length; columnNum++) {
            sheet.setColumnWidth(columnNum, INT_5000);
        }

        // 第1行
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell row0Cell0 = row0.createCell(0);
        //row0Cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
        row0Cell0.setCellValue(new HSSFRichTextString(sheetName));
        row0Cell0.setCellStyle(headStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, titleArray.length-1));

        // 第二行
        HSSFRow row2 = sheet.createRow(2);
        // 设置行高
        row2.setHeight((short) 320);
        //
        for (int columnNum = 0; columnNum < titleArray.length; columnNum++) {
            HSSFCell row2Cell0 = row2.createCell(columnNum);
            //row2Cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
            row2Cell0.setCellValue(new HSSFRichTextString(titleArray[columnNum]));
            row2Cell0.setCellStyle(topStyle);
        }

        // 加载数据
        for (int rowNum = 0; rowNum < list.size(); rowNum++) {
            // 创建行
            HSSFRow row = sheet.createRow(INT_3 + rowNum);
            // 设置行高
            row.setHeight((short) 300);

            Object temp = null;
            try {
                temp = list.get(rowNum).getClass().getDeclaredMethod(methodName).invoke(list.get(rowNum));
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<String> dataList = (List<String>) temp;

            if(dataList !=null&&!dataList.isEmpty()){
                for (int colunmNum = 0; colunmNum < dataList.size(); colunmNum++) {
                    HSSFCell cell0 = row.createCell(colunmNum);
                    // 设置单元格格式
                    //cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
                    // 设置单元格值
                    cell0.setCellValue(new HSSFRichTextString(dataList.get(colunmNum)));
                    // 设置单元格样式
                    cell0.setCellStyle(commonStyle);
                }
            }
        }
    }

	public static void main(String[] args) {
		ExportExcelUtil<Girl> excelUtil=new ExportExcelUtil<>();
        String [] head = {"ID","NAME","AGE","ADDER"};
        String sheetName = "GIRL";
        String methodName  = "toExportList";
		FileOutputStream out;
        String path ="D:/save/java/util/1.xls";
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        //读取文件流
        //new ByteArrayInputStream(out.toByteArray());
        try {
            //写入文件
        	out = new FileOutputStream(new File(path));
            ArrayList list=new ArrayList();
            //noinspection unchecked
            list.add(new Girl("user1", 1));
            //noinspection unchecked
            list.add(new Girl("user2", 2));
            //noinspection unchecked
            list.add(new Girl("user3", 3));
            //noinspection unchecked
            excelUtil.exportExcel(out, sheetName, head, list, methodName);
            out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * 执行导出
     * @param out 输出流
     * @param sheetName excel sheet名
     * @param titleArray 列名
     * @param list 数据list
     * @param methodName 要调用的方法名
     *
     */
    public void exportExcel(OutputStream out, String sheetName, String[] titleArray, List<T> list, String methodName) {
        initStyle();
        setData(sheetName, titleArray, list, methodName);
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
