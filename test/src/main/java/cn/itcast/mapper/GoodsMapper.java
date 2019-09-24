package cn.itcast.mapper;

import cn.itcast.domain.Goods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> findAll();

    void update(Goods goods);

    Goods findById(int id);

}
