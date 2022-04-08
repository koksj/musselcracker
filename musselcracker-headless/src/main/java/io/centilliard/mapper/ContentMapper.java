package io.centilliard.mapper;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

import io.centilliard.entity.ContentDao;

@Mapper
public interface ContentMapper {
    
    @DaoFactory
    ContentDao contentDao();
}
