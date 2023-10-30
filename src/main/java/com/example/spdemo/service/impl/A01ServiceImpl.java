package com.example.spdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spdemo.entity.A01;
import com.example.spdemo.mapper.A01Mapper;
import com.example.spdemo.req.A01Req;
import com.example.spdemo.resp.PageResp;
import com.example.spdemo.service.A01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
public class A01ServiceImpl extends ServiceImpl<A01Mapper, A01> implements A01Service {

    @Autowired
    private A01Mapper a01Mapper;

    @Override
    public PageResp<A01> selectA01List(A01Req a01Req) {
        QueryWrapper<A01> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(a01Req.getA0101())) {
            queryWrapper.lambda().eq(A01::getA0101, a01Req.getA0101());
        }
        if (!ObjectUtils.isEmpty(a01Req.getA0104())) {
            queryWrapper.lambda().eq(A01::getA0104, a01Req.getA0104());
        }
        Page<A01> page = new Page<>(a01Req.getPage(), a01Req.getSize());
        IPage<A01> page1 = a01Mapper.selectPage(page, queryWrapper);
        PageResp<A01> pageResp = new PageResp<>();
        pageResp.setTotal(page1.getTotal());
        pageResp.setList(page1.getRecords());
        return pageResp;
    }

    @Override
    public void delete(String a00) {
        a01Mapper.deleteById(a00);
    }

    @Override
    public boolean save(A01 a01) {
        int i = 0;
        if (!ObjectUtils.isEmpty(a01.getA00())) {
            i = a01Mapper.updateById(a01);
        } else {
            a01.setA00(UUID.randomUUID().toString().toUpperCase());
            i = a01Mapper.insert(a01);
        }
        return i > 0;
    }
}
