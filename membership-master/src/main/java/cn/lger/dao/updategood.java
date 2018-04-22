package cn.lger.dao;

import cn.lger.domain.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Repository
//@Service("Quick")
@Component("updategood")
public class updategood implements GoodDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int operation(Commodity ommodity) {
        return jdbcTemplate.update("UPDATE commodity SET commodity_integral = ? , commodity_name = ? ,commodity_number = ?, commodity_price = ? ,commodity_type = ? WHERE id=?",
                ommodity.getCommodityIntegral(),ommodity.getCommodityName(),ommodity.getCommodityNumber(),ommodity.getCommodityPrice(),ommodity.getCommodityType(),ommodity.getId() );

    }}
