package cn.itcast.service;

import cn.itcast.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> findAll();

    void update(Goods goods);

    Goods findById(int id);

}
