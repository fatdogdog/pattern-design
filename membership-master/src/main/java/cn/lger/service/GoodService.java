package cn.lger.service;


import cn.lger.dao.GoodDao;
import cn.lger.domain.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-19.
 */
@Service
public class GoodService {

    //@Resource
    private final Map<String, GoodDao> strategyMap = new ConcurrentHashMap<>();
    @Autowired
   // private AdminDao adminDao;
    public GoodService(Map<String, GoodDao> strategyMap)
    {   this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
        //this.adminDao = adminDao;
    }

    public GoodDao dooperation(String operationtype){
        return strategyMap.get(operationtype);
    }
}
