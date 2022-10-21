package com.lostsys.sample.hexagonal.infra.inputport;

import java.util.List;
import java.util.Map;

public interface MessageBrokerInputPort {
    
    public void deleteReg( String table, Map<String, Object> reg );
    public void updateReg( String table, Map<String, Object> reg );
    public void insertReg( String table, Map<String, Object> reg );
    public List<Map<String, Object>> getAll( String table );

}
