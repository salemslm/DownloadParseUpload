/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.upload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Salem
 */
public class EngieElectrabel {

    ArrayList<SingleDate> completeFile = new ArrayList<>();

    public EngieElectrabel(String xlsxFile) {

        // Use an InputStream, needs more memory
        try {
            Workbook workbook = WorkbookFactory.create(new FileInputStream(xlsxFile));

            // Get the first sheet.
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            ArrayList<Double> tempNumber = new ArrayList<>();
            
            //Get column names :
            ArrayList<String> columnNames = new ArrayList<>();
            int index = 0;

            Iterator it2 = new Iterator() {
                @Override
                public boolean hasNext() {
                    return rowIterator.hasNext();
                }

                @Override
                public Object next() {
                    return "new string: " + rowIterator.next().toString();
                }
            };

            while (rowIterator.hasNext()) {
                index++;
                Row nextRow = rowIterator.next();

                //NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                //NumberFormat.getInstance(Locale.FRANCE);
                tempNumber.clear();

                switch (index) {
                    case 1:
                        //Grey background colors cells : Nothing to do
                        break;
                    case 2:
                        //EAN
                        break;
                    case 3:
                        //Sub EAN
                        break;
                    case 4:
                        //Role description

                        //We don't take 1st column (indexColumn = 0)
                        int indexColumn = 1;
                        while (nextRow.getCell(indexColumn) != null) {
                            columnNames.add(nextRow.getCell(indexColumn).getStringCellValue());
                            indexColumn++;
                        }

                        columnNames.stream().forEach((temp) -> {
                            System.out.println(temp);
                        });
                        break;
                    case 5:
                        //Role

                        break;
                    case 6:
                        //Profile Description
                        break;
                    default:
                        //Read Data

                        //We don't take 1st column (indexColumn = 0)
                        indexColumn = 1;
                        Date d = null;
                        
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        try {

                            d = df.parse(nextRow.getCell(0).toString());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        while (nextRow.getCell(indexColumn) != null) {
                            Cell c = nextRow.getCell(indexColumn);
                            
                            //nextRow.getCell(indexColumn).setCellType(CellType.NUMERIC);
                            tempNumber.add(getCellValue(c));
                            System.out.println("Test " + getCellValue(c).toString());
                            indexColumn++;
                        }
                        System.out.println("***************Temp : ***************");
                        tempNumber.stream().forEach((temp)->{
                        System.out.println(temp);
                    });
                        System.out.println("***************");
                        completeFile.add(new SingleDate(d, tempNumber));
                        break;
                }

            }
             for (SingleDate temp : completeFile) {
                 System.out.println(temp.toString());
             }
//            completeFile.stream().forEach((temp) -> {
//                System.out.println(temp.toString());
//            });

        } catch (InvalidFormatException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    
private Double getCellValue(Cell cell) {
    //String val = "";
    if (cell == null)
        return 0d;
    // new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
    switch (cell.getCellTypeEnum()) {
    case STRING:
        cell.setCellType(CellType.NUMERIC);
        return cell.getNumericCellValue();
    case NUMERIC:
        //val = Double.toString(cell.getNumericCellValue());
        // code derived from SpreadsheetTableRepeating.java
//        double dphi = cell.getNumericCellValue();
//        if ((dphi - (int) dphi) * 1000 == 0) {
//            val = (int) dphi + "";
//        }
        //return val;
        return cell.getNumericCellValue();
//    case BOOLEAN:
//        return Double.parseDouble(cell.getBooleanCellValue()));
//    case FORMULA:
//        return cell.getCellFormula();

    }
    return 0d;
}
}
