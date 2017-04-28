/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.upload;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Salem
 */
public class SingleDate {

    private Date date = null;
    private List<Double> data;
    final private DateFormat df;

    public SingleDate(Date date, List<Double> dataa) {
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        this.date = date;
        this.data = dataa;

    }

    public Date getDate() {
        return date;
    }

    public List<Double> getData() {
        return data;
    }

    @Override
    public String toString() {
        String endMessage = " ";

        for (int i = 0; i < data.size(); i++) {
            endMessage += " | " + String.valueOf(this.getData().get(i));
        }
        return "Date : " + df.format(date) + endMessage;

    }

}
