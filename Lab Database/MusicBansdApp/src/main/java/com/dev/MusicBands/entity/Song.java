/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "song")
@NamedQueries({
    @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song s"),
    @NamedQuery(name = "Song.findByUuid", query = "SELECT s FROM Song s WHERE s.uuid = :uuid"),
    @NamedQuery(name = "Song.findByName", query = "SELECT s FROM Song s WHERE s.name = :name"),
    @NamedQuery(name = "Song.findBySongYear", query = "SELECT s FROM Song s WHERE s.songYear = :songYear"),
    @NamedQuery(name = "Song.findByFileName", query = "SELECT s FROM Song s WHERE s.fileName = :fileName")})
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uuid")
    private String uuid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "song_year")
    private int songYear;
    @Column(name = "file_name")
    private String fileName;
   
    @JoinColumn(name = "ganre_uuid", referencedColumnName = "uuid")
    @ManyToOne(optional = false)
    private Ganres ganre;
    
    @JoinColumn(name = "album_uuid", referencedColumnName = "uuid")
    @ManyToOne
    public Album album;
    
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "song")
    private Statistics statistics;

    public Song() {
        this.uuid = UUID.randomUUID().toString();
        this.statistics  = new Statistics(this);
    }

    public Song(String uuid) {
        this.uuid = uuid;
    }

    public Song(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSongYear() {
        return songYear;
    }

    public void setSongYear(int songYear) {
        this.songYear = songYear;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Ganres getGanre() {
        return ganre;
    }

    public void setGanre(Ganres ganre) {
        this.ganre = ganre;
    }

   

    

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  this.name;
    }
    
}
