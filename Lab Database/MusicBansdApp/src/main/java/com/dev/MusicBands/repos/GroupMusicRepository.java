/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.repos;

import com.dev.MusicBands.entity.GroupMusic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author Root
 */
public interface GroupMusicRepository  extends JpaRepository<GroupMusic, String>, 
         JpaSpecificationExecutor<GroupMusic>
{


}
