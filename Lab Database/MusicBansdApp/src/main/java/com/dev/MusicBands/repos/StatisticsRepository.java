/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.repos;


import com.dev.MusicBands.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Root
 */
public interface StatisticsRepository extends JpaRepository<Statistics, String>{
    
}
