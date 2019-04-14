package com.the23rdTeam.HomeWork.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentPositionDB {

    @Autowired
    private MongoTemplate mongoTemplate;
}
