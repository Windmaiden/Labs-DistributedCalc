/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.model;


import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Root
 */
public class GanresModel<Ganres>  extends AbstractListModel implements ComboBoxModel {
    
    List<Ganres> list;
    private Ganres selectedItem;

    public GanresModel(List<Ganres> list) {
        this.list = list;
    }
    
    
    
    @Override
    public int getSize() {
         return  list.size();
    }

    @Override
    public Ganres getElementAt(int index) {
        return list.get(index);
    }

   

    @Override
    public Ganres getSelectedItem() {
        return  this.selectedItem;
    }

    @Override
    public void setSelectedItem(Object anItem) {
       this.selectedItem = (Ganres) anItem;
               
    }

    public List<Ganres> getList() {
        return list;
    }

    public void setList(List<Ganres> list) {
        this.list = list;
    }
    
    
}
