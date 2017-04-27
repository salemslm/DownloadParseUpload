/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.upload;

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
    private ArrayList<Long> data = new ArrayList<Long>();

    public SingleDate(Date date, ArrayList<Long> data) {
        this.date = date;
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Long> getData() {
        return data;
    }
    
    @Override
    public String toString() {
        return "Date : " + date.toString() + ", number of columns : " + data.size();
    }

}
