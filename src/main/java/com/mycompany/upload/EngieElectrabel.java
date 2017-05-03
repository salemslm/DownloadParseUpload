/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.upload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Salem
 */
public class EngieElectrabel implements BillReader {

    @Override
    public void read(InputStream _data, Consumer<SingleDate> _callback) {

        List<String> energyLabel = new LinkedList<>();

        Workbook workbook;
        Sheet sheet;
        try {
            workbook = WorkbookFactory.create(_data);

            // Get the first sheet.
            sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            List<Double> listValuesTemp;
            int index = 0;

 
            while (rowIterator.hasNext()) {
                index++;
                Row nextRow = rowIterator.next();

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                listValuesTemp = new LinkedList<>();
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
                            energyLabel.add(nextRow.getCell(indexColumn).getStringCellValue());
                            indexColumn++;
                        }

                        energyLabel.stream().forEach((temp) -> {
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

                        indexColumn = 1;
                        Date d = null;
                        Number number = 0;

                        listValuesTemp = new LinkedList<>();
                        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                        try {
                            d = df.parse(nextRow.getCell(0).toString());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        while (nextRow.getCell(indexColumn) != null) {

                            try {
                                //Be able to read numbers with commas
                                number = format.parse(nextRow.getCell(indexColumn).toString());

                                //Convert the Number type double and add it to the list
                                listValuesTemp.add(number.doubleValue());
                            } catch (ParseException e) {
                                e.getMessage();
                            }

                            indexColumn++;
                        }

                        _callback.accept(new SingleDate(d, listValuesTemp));
                        break;
                }
            }

        } catch (InvalidFormatException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
