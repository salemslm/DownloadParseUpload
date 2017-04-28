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
