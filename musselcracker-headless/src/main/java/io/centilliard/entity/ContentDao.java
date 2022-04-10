package io.centilliard.entity;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import com.datastax.oss.quarkus.runtime.api.reactive.mapper.MutinyMappedReactiveResultSet;

import io.smallrye.mutiny.Uni;

@Dao
public interface ContentDao {

    @Update
    Uni<Void> update(ContentEntity contentEntity);
    
    MutinyMappedReactiveResultSet<ContentEntity> findAll();
}
