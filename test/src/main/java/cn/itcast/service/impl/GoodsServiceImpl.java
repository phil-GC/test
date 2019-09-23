package cn.itcast.service.impl;

import cn.itcast.domain.Goods;
import cn.itcast.mapper.GoodsMapper;
import cn.itcast.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);
    }

    @Override
    public Goods findById(int id) {
        return goodsMapper.findById(id);
    }
}
