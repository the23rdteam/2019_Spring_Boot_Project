package com.the23rdTeam.HomeWork.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentPositionDB {

    @Autowired
    private MongoTemplate mongoTemplate;

    public CurrentPositionDB insertCurrentPositionDB(CurrentPositionDB currentPositionDB){
        return mongoTemplate.insert(currentPositionDB);
    }
}
