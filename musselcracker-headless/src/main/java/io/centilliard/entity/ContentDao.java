package io.centilliard.entity;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;

@Dao
public interface ContentDao {

    @Update
    void update(ContentEntity contentEntity);
    
    @Select
    PagingIterable<ContentEntity> findAll();
}
