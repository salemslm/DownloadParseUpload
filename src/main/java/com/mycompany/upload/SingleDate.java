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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Salem
 */
public class SingleDate {

    private Date date;
    private ArrayList<Double> data = new ArrayList<>();
    private DateFormat df;

    public SingleDate(Date date, ArrayList<Double> data) {
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

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

        }
        try {
            return "Date : " + df.format(date) + endMessage;

        } catch (NullPointerException e) {
            System.out.println("Error : " + e.getMessage());

        }
        return endMessage;
    }

}
