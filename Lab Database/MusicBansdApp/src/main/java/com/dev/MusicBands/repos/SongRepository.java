/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.repos;

import com.dev.MusicBands.entity.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Root
 */
public interface SongRepository extends JpaRepository<Song, String>,
        JpaSpecificationExecutor<Song> {

    @Query(value = "select s.* from public.Song s where  exists "
            + "(select * from public.Album a where a.uuid=s.album_uuid and a.name like :str) "
            + "OR EXISTS (SELECT * FROM Album a1 WHERE a1.uuid=s.album_uuid AND EXISTS (SELECT * FROM PUBLIC.GROUP_MUSIC g WHERE g.UUID = a1.GROUP_UUID AND g.NAME LIKE :str)) "
            + "OR s.name like :str ", nativeQuery = true)
    List<Song> search(String str);
}
