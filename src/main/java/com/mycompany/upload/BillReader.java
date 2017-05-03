/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.upload;

import java.io.InputStream;
import java.util.function.Consumer;

/**
 *
 * @author Salem
 */
public interface BillReader {
    public void read(InputStream _data, Consumer<SingleDate> _callback);   
    
}
