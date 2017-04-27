/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.upload;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Salem
 */
public class SingleDate {

    final private Date date;
    final private ArrayList<Double> data;
    final private DateFormat df;

    public SingleDate(Date date, ArrayList<Double> data) {
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("***************Instanciation de SingleDate : ***************");
        data.stream().forEach((temp) -> {
            System.out.print(" " + temp + " | ");
        });
        System.out.println("");
        this.date = date;
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Double> getData() {
        return data;
    }

    @Override
    public String toString() {
        String endMessage = " ";

        for (int i = 0; i < data.size(); i++) {
            endMessage += " | " + data.get(i).toString();
            //System.out.println("" + data.get(i).toString());
        }
        return "Date : " + df.format(date) + endMessage;

    }

}
