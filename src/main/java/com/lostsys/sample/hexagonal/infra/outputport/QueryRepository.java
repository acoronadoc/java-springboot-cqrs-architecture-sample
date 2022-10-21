package com.lostsys.sample.hexagonal.infra.outputport;

import java.util.List;
import java.util.Map;

public interface QueryRepository {

    public void save( Map<String,Object> reg, Class<?> clazz );

    public void delete( String id, Class<?> clazz );

    public Map<String,Object> getById( String id, Class<?> clazz );

    public List<Map<String,Object>> getAll( Class<?> clazz );    
}
