package io.centilliard.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.centilliard.entity.ContentDao;
import io.centilliard.entity.ContentEntity;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class DataService {

    @Inject ContentDao contentDao;

    public Uni<Void> save(ContentEntity contentEntity) {
        return contentDao.update(contentEntity);
    }

    public Multi<ContentEntity> getAll() {
        return contentDao.findAll();
    }
    
}
