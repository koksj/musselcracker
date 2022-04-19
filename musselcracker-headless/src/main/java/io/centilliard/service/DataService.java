/**
 * Authors:
 *     Stefan Kok 
 * 
 * Copyright (C) 2020 Sefan Kok. All Rights Reserved.
 * 
 * This file is part of Musselcracker.
 * 
 * Musselcracker is free software; you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation; version 2.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 * 
 */

package io.centilliard.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.centilliard.entity.ContentDao;
import io.centilliard.entity.Content;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class DataService {

    private static Logger log = LoggerFactory.getLogger(DataService.class);

    @Inject ContentDao contentDao;

    public Uni<Void> save(Content contentEntity) {
        return contentDao.save(contentEntity);
    }

    public Uni<Void> update(Content contentEntity) {
        return contentDao.update(contentEntity);
    }

    public Multi<Content> getAll() {        
        // log.info("msg");
        return contentDao.findAll();
    }

    public Multi<Content> getByID(UUID id) {        
        log.info("id: " + id);
        return contentDao.findById(id);
    }

    public Uni<Void>  delete(Content content) {

        return contentDao.delete(content);
    }
    
}
