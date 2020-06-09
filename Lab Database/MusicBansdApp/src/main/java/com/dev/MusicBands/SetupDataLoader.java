/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands;

import com.dev.MusicBands.entity.Ganres;
import com.dev.MusicBands.repos.GanreRepository;
import com.dev.MusicBands.repos.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Root
 */
@Component
public class SetupDataLoader implements  ApplicationListener<ContextRefreshedEvent> {
    @Autowired GanreRepository ganres;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
         Ganres[] gs ={
             new Ganres("folk", "Фолк-музыка"), new Ganres("kantry", "Кантри"),
          new Ganres("bluz", "Блюз"),
          new Ganres("djaz", "Джаз"),
          new Ganres("shanson", "Шансон"),
          new Ganres("pop", "Поп-музыка"),
          new Ganres("rock", "Рок"),
          new Ganres("electro", "Электронная музыка"),
          new Ganres("hip", "Хип-хоп"),
          new Ganres("lation", "Латиноамериканская музыка")};
          for(Ganres g:gs){
              if (!ganres.findById(g.getUuid()).isPresent()) ganres.save(g);
          }
         
    }

    
}
