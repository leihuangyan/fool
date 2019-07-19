package com.lhy.fool.util.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 98403
 */
@Component
public class TestExcel {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(TestExcel.class);




    public static void main(String[] args) {

        new TestExcel().readByName("D:\\deppon\\deppon\\固话报销对账单.xls");
    }

    /**
     * @描述：根据文件名读取excel文件
     */
    public List<Map<String, String>> readByName(String filePath) {
        List<Map<String, String>> read = null;
        InputStream is = null;
        /** 验证文件是否合法 */
        if (!validateExcel(filePath)) {
            throw new RuntimeException("文件为空或者不是excel文件");
        }
        try {
            /** 调用本类提供的根据流读取的方法 */
            is = new FileInputStream(new File(filePath));
            Workbook wb = null;
            wb = new HSSFWorkbook(is);
            //2003默认的首页面叫做results页面，看不到，所以应该已第二个界面，下标为1.
            read = read(wb);
            //读取文件
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    /**读取完毕关闭文件流。*/
                    is.close();
                } catch (IOException e) {
                    is = null;
                }
            }
        }
        return read;
    }

    /**
     * @throws ParseException
     * @描述：读取数据 firstRow表示从第几行开始读取，在EXCEL中默认的起始行数是0.
     * 将所有的数据根据存储的方式获取，然后转换为字符类型进行保存。
     */
    private List<Map<String, String>> read(Workbook wb) {
        List<List<String>> dataList = new ArrayList<List<String>>();
        /** 得到总的shell */
        int sheetAccount = wb.getNumberOfSheets();

        logger.info("============得到总的shell:{}", sheetAccount);
        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(0);
        /** 得到Excel的行数 */
        int rowCount = sheet.getPhysicalNumberOfRows();
        // 循环Excel的行  2003和2007都是从第0行开始读取数值，此处选择1，是把模板中标题去掉
        for (int r = 1; r <=rowCount; r++) {
            //获取sheet中的行
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            List<String> rowList = new ArrayList<String>();
            // 循环Excel的列
            for (int c = 0; c < row.getLastCellNum(); c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                    // 以下是判断数据的类型
                    switch (cell.getCellType()) {
                        // XSSFCell可以达到相同的效果
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            // 数字
                            double d = cell.getNumericCellValue();
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                // 日期类型
                                Date date = HSSFDateUtil.getJavaDate(d);
                                cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
                            } else {// 数值类型
                                cellValue = cell.getNumericCellValue() + "";
                            }
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            // 字符串
                            cellValue = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            // 空值
                            cellValue = "";
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            // 故障
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                //将转换之后的字符串进行前后去空格操作。
                cellValue = trim(cellValue);
                if ("未知类型".equals(cellValue)) {
                    System.out.println("row:" + r + "---" + "col:" + c + "数据存在问题");
                }
                logger.info("val:{}",cellValue + "\t");
                rowList.add(cellValue);
            }
            dataList.add(rowList);
            logger.info("==========================【读取1列】===========================================");
        }
        return transformation(dataList);
    }


    /**
     * 将excel元素中的值进行转换为对应的值，并对值进行非空效验。
     * @param dataList
     * @return
     */
    final public static String[] STATEMENT_TITLE = {"单据编号", "子公司", "账期","预算项目","总金额","单据状态", "创建时间", "修改时间"};

    public List<Map<String, String>> transformation(List<List<String>> dataList) {
        List<String> head = dataList.get(0);
        //获取模型中列表界面标题的字段位置
        List<Map<String, String>> models = new ArrayList();

        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 1; i <dataList.size(); i++) {
            //初始化值，将获取的值转换格式到实体中
            //FlrExtension model = new FlrExtension();
            //得到列所有值
            List<String> str = dataList.get(i);
            Map<String, String> map = new HashMap<>();
            //防止过多的空值进行导入。
            for (int j = 0; j < STATEMENT_TITLE.length; j++) {
                final String item = STATEMENT_TITLE[j];
                final String val = str.get(head.indexOf(item));
                map.put(item, val);
            }
            models.add(map);
        }
        logger.info(models.toString());
        return models;
    }


    public String trim(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    /**
     * 验证EXCEL文件是否合法
     */
    public boolean validateExcel(String filePath) {

        /** 判断文件名是否为空或者文件是否存在 */
        if (!CEVUtil.fileExist(filePath)) {
            //	errorInfo = "文件不存在";
            return false;
        }

        /** 检查文件是否是Excel格式的文件 */
        if (!CEVUtil.isExcel(filePath)) {
            //	errorInfo = "文件名不是excel格式";
            return false;
        }
        return true;
    }

}
