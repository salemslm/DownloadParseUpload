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
import java.util.stream.Stream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Salem
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<SingleDate> completeFile = new ArrayList<>();

        // Use an InputStream, needs more memory
        try {
            Workbook workbook = WorkbookFactory.create(new FileInputStream("Measured.xlsx"));

            // Get the first sheet.
            Sheet sheet = workbook.getSheetAt(0);

            // Get the first cell.
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);

            // Show what is being read.
            System.out.println(cell.toString());

            Iterator<Row> rowIterator = sheet.iterator();

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

            while (it2.hasNext()) {
                index++;
                Row nextRow = rowIterator.next();
                //System.out.println("Test bizarre : " + it2.next().toString());
                ArrayList<Long> dataForSingleTime = new ArrayList<>();

                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                //NumberFormat.getInstance(Locale.FRANCE);

                ArrayList<Long> tempNumber = new ArrayList<>();
                Number number = 0;

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
                            columnNames.add(nextRow.getCell(indexColumn).toString());

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

                            try {
                                //Be able to read numbers with commas
                                number = format.parse(nextRow.getCell(indexColumn).toString());

                                //Convert the Number type Long and add it to the list
                                tempNumber.add(number.longValue());
                            } catch (ParseException e) {
                                e.getMessage();
                            }

                            indexColumn++;
                        }
                        completeFile.add(new SingleDate(d, tempNumber));

                        break;
                }

            }
            completeFile.stream().forEach((temp) -> {
                System.out.println(temp.toString());
            });

        } catch (InvalidFormatException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    // private ArrayList<String> 

    private Stream<SingleDate> getListOfDatas() {

//        List l = null;
//
//        Iterator it1 = new Iterator<String>() {
//            int i = 0;
//
//            @Override
//            public boolean hasNext() {
//                return i < l.size();
//            }
//
//            @Override
//            public String next() {
//                i++;
//                return l.get(i).toString();
//            }
//        };
        ArrayList<SingleDate> completeFile = new ArrayList<>();

        return completeFile
                .stream();

    }

}
