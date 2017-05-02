/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.upload;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Salem
 */
public interface BillReader {
    public Iterator<Row> getEntries();
    public String getSupplier();
    public Date getDocumentDate();
    
    
}
