package io.centilliard.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.centilliard.entity.ContentDao;
import io.centilliard.entity.ContentEntity;

@ApplicationScoped
public class DataService {

    @Inject ContentDao contentDao;

    public void save(ContentEntity contentEntity) {
        contentDao.update(contentEntity);
    }

    public List<ContentEntity> getAll() {
        return contentDao.findAll().all();
    }
    
}
