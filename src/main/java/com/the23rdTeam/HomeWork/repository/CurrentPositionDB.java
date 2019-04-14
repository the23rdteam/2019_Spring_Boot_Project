package com.the23rdTeam.HomeWork.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentPositionDB {

    @Autowired
    private MongoTemplate mongoTemplate;

    public CurrentPositionDB insertCurrentPositionDB(CurrentPositionDB currentPositionDB){
        return mongoTemplate.insert(currentPositionDB);
    }

    public CurrentPositionDB findPositionBySummonerId(String summonerId){
        Query query = new Query();

        query.addCriteria(Criteria.where("name").is(summonerId));
        query.with(Sort.by(Sort.Order.desc("_id")));

        return mongoTemplate.findOne(query, CurrentPositionDB.class);
    }
}
