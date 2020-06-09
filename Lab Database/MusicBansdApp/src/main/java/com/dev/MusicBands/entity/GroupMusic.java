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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "group_music")
@NamedQueries({
    @NamedQuery(name = "GroupMusic.findAll", query = "SELECT g FROM GroupMusic g"),
    @NamedQuery(name = "GroupMusic.findByUuid", query = "SELECT g FROM GroupMusic g WHERE g.uuid = :uuid"),
    @NamedQuery(name = "GroupMusic.findByName", query = "SELECT g FROM GroupMusic g WHERE g.name = :name"),
    @NamedQuery(name = "GroupMusic.findByPoster", query = "SELECT g FROM GroupMusic g WHERE g.poster = :poster")})
public class GroupMusic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uuid")
    private String uuid;
    @Basic(optional = false)
    @Column(name = "name")
    public String name = "";
    
    
    @Column(name = "descr")
    private String description = "";
    
    @Column(name = "poster")
    private String poster;
    
    
    @OneToMany(mappedBy = "group",fetch = FetchType.EAGER)
    private Set<Album> albums = new HashSet<>();

    public GroupMusic() {
        this.uuid = UUID.randomUUID().toString();
        
    }

    
    public GroupMusic(String name) {
         this.uuid = UUID.randomUUID().toString();
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
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
        if (!(object instanceof GroupMusic)) {
            return false;
        }
        GroupMusic other = (GroupMusic) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.laba.entity.GroupMusic[ uuid=" + uuid + " ]";
    }
    
}
