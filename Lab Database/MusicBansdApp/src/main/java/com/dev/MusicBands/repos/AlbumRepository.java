/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.repos;

import com.dev.MusicBands.entity.Album;
import com.dev.MusicBands.entity.GroupMusic;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Root
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, String>, 
         JpaSpecificationExecutor<Album>{
    @Query("select a from Album a  where a.group=:gr")
    List<Album> findByGroupMucis(GroupMusic gr);
    

}
