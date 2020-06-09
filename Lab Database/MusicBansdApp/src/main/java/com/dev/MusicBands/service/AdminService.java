/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.service;

import com.dev.MusicBands.entity.Album;
import com.dev.MusicBands.entity.Ganres;
import com.dev.MusicBands.entity.GroupMusic;
import com.dev.MusicBands.entity.Song;
import com.dev.MusicBands.entity.Statistics;
import com.dev.MusicBands.repos.AlbumRepository;
import com.dev.MusicBands.repos.GanreRepository;
import com.dev.MusicBands.repos.GroupMusicRepository;
import com.dev.MusicBands.repos.SongRepository;
import com.dev.MusicBands.repos.StatisticsRepository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author Root
 */
@Service
@Order(1)
public class AdminService {
    @Autowired 
    GroupMusicRepository grRepos;
    
    @Autowired
    AlbumRepository albumRepository;
    
    @Autowired 
    SongRepository songRepository;
    @Autowired 
    GanreRepository ganreRepository;
    
    @Autowired 
    StatisticsRepository statisticsRepository;
    
    
    public List<Ganres> findGanres(){
        return  ganreRepository.findAll();
    }
    
    
     public List<GroupMusic> findAllGroupMusic(int page, int size) {
        List<GroupMusic> list =grRepos.findAll(PageRequest.of(page, size,Sort.by("name"))).getContent();
        if (list!=null) return  list;
        return new ArrayList<>();
    }
     
      public GroupMusic findGroupMusic(String uuid) {
        GroupMusic group =grRepos.findById(uuid).orElse(null);
        return group; 
    }
     
     public List<Album> findAlbumByGroup(GroupMusic gr) {
        List<Album> list = albumRepository.findByGroupMucis(gr);
        if (list!=null) return  list;
        return new ArrayList<>();
    }
    
    public GroupMusic saveGroup(GroupMusic src) {
        return grRepos.save(src);
    }
    
    public void delGroup(GroupMusic src) {
         grRepos.delete(src);

    }
    
     public void delAlbum(Album src) {
         albumRepository.delete(src);

    }
     
    public Album saveAlbum(Album src) {
        return albumRepository.save(src);
    }
    
      
    public Song saveSong(Song src) {
        return songRepository.save(src);
    }
    
     public Statistics saveStatisics(Statistics src){
        return statisticsRepository.save(src);
    }
    
    public void  delSong(Song src) {
        songRepository.delete(src);
    }
    public String copyFilePoster(File file){
        if(! new File("./poster").exists())
                    {
                        new File("./poster").mkdir();
                    }

        String ext  = FilenameUtils.getExtension(file.getName());
        String name = UUID.randomUUID().toString();
        File dst = new File(String.format("./poster/%s.%s", name,ext));
        try {
            FileUtils.copyFile(file,dst);
        } catch (IOException ex) {
            return null;
        }
        return String.format("./poster/%s.%s", name,ext);
        
    }
    public String copyFileMusic(File file){
        if(! new File("./music").exists())
                    {
                        new File("./music").mkdir();
                    }

        String ext  = FilenameUtils.getExtension(file.getName());
        String name = UUID.randomUUID().toString();
        File dst = new File(String.format("./music/%s.%s", name,ext));
        try {
            FileUtils.copyFile(file,dst);
        } catch (IOException ex) {
            return null;
        }
        return String.format("./music/%s.%s", name,ext);
        
    }
    
     public List<Song> searchSong(String search) {
     
        return songRepository.search(search);
    }

    
   
}
