/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.upload;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 * @author Salem
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EngieElectrabel engie = new EngieElectrabel("Measured.xlsx");
       
        //engie.getValue(engie.)

    }
    // private ArrayList<String> 

    private Stream<SingleDate> getListOfDatas() {

        ArrayList<SingleDate> completeFile = new ArrayList<>(); 
        return completeFile
                .stream();

    }

}
