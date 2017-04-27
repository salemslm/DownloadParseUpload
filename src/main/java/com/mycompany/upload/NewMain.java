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
        EngieElectrabel engie = new EngieElectrabel("Measured.xlsx");

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
