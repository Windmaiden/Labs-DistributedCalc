/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.MusicBands.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "album")
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByUuid", query = "SELECT a FROM Album a WHERE a.uuid = :uuid"),
    @NamedQuery(name = "Album.findByName", query = "SELECT a FROM Album a WHERE a.name = :name"),
    @NamedQuery(name = "Album.findByPoster", query = "SELECT a FROM Album a WHERE a.poster = :poster")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uuid")
    private String uuid;
    
    @Column(name = "name")
    public  String name = "";
    
    @Column(name = "decsr")
    private String description ="";
    
    @Column(name = "poster")
    private String poster;
    
    @OneToMany(mappedBy = "album",fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Song> songs = new HashSet<>();
    @JoinColumn(name = "group_uuid", referencedColumnName = "uuid")
    @ManyToOne
    public  GroupMusic group;

    public Album() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Album(String name,String descr) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.description = descr;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public GroupMusic getGroup() {
        return group;
    }

    public void setGroup(GroupMusic group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.laba.entity.Album[ uuid=" + uuid + " ]";
    }
    
}
