package cz.topPeople.util;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExcelReadAndWrite {

    String dataString = String.valueOf(new SimpleDateFormat("yyyy-MM-dd_").format(new Date()));

    private final String FILE_NAME = "report_" + dataString + ").xlsx";
    private final String PATH = "file:" + System.getProperty("user.home") + File.separator + "upload\\"+ FILE_NAME;


    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    Workbook workbook = null;

//    //initializing the logger
//    static Logger log = Logger.getLogger(ApachePOIExcelReadAndWrite.class.getName());

    /**
     * This method is used for read and write excel file
     *
     * @version 3.14,  becouse version 3.15 methods getCellType is Depricated
     */
//
    private Workbook getWorkbook(FileInputStream stream, String excelPath) {
        if (excelPath.endsWith("xlsx")) {
            try {
                workbook = new XSSFWorkbook(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (excelPath.endsWith("xls")) {
            try {
                workbook = new HSSFWorkbook(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new IllegalAccessException("The specified file is not Excel file");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    private Object getCellValue(Cell cell) {

        if (cell.getCellType() == cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
            return cell.getBooleanCellValue();
        } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
            return cell.getNumericCellValue();
        }
        return null;
    }

    public void readFromExcelFile(FileInputStream stream, String excelPath) {

        try {
            fileInputStream = new FileInputStream(excelPath);
            Workbook workbook = getWorkbook(fileInputStream, excelPath);
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        getCellValue(cell);
                    }
                }
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeToFile( String fileName,String sheetName, Map<String, Object[]> rows) {
        String dataString = String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        String FILE_NAME = sheetName +"_" + dataString + ".xlsx";
        String PATH = System.getProperty("user.home") + File.separator +fileName+File.separator;
        File file = new File(PATH);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(sheetName);
//        //Create row object
        XSSFRow row = null;
        //Iterate over data and write to sheet
        Set<String> keyid = rows.keySet();
        int rowid = 0;
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = rows.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }
        //Write the workbook in file system
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(
                    new File(PATH+FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(
                "Writesheet.xlsx written successfully");

    }

}
