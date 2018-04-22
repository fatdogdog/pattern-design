package cn.lger.dao;

import cn.lger.domain.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

//@Repository
//@Service("Quick")
@Component("addgood")
public class addgood implements GoodDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int operation(Commodity ommodity) {
        return jdbcTemplate.update("insert into commodity(commodity_integral, commodity_name, commodity_number,commodity_price,id,commodity_type) values(?, ?, ?,?,?,?)",
                ommodity.getCommodityIntegral(),ommodity.getCommodityName(),ommodity.getCommodityNumber(),ommodity.getCommodityPrice(),ommodity.getId(),ommodity.getCommodityType());

    }}
