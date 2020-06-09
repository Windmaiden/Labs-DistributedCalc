/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.model;

import com.dev.MusicBands.entity.Album;
import com.dev.MusicBands.entity.Song;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Root
 */
public class SongModel extends  DefaultTableModel {
    private List<Song> list;
   
   // заголовки таблицы
    private final String[] columnNames = new String[] {
            "Назва","Жанр","Рік","Група","Альбом","Прослуховувань"};

    private final Class[] columnClass = new Class[] {
            String.class, String.class,Integer.class,String.class,String.class,String.class,Integer.class
    };

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    public SongModel(List<Song> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        if (list==null) return  0;
        else return list.size();
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Song row = list.get(rowIndex);
        switch (columnIndex){
            case 0: return row.getName();
            case 1: return row.getGanre().getName();        
            case 2: return row.getSongYear();
            case 3: return row.getAlbum().getName();
            case 4: return row.getAlbum().getGroup().getName();
            case 5: return row.getStatistics().getCounter();
            case 100:return row;
        }
        return null;
    }
    
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }


    @Override
    public void removeRow(int row) {
        if (list.size()>0)
            list.remove(row);
    }
    
    
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public void update(List<Song> list){
       this.list=list;
    }
    
    

}
