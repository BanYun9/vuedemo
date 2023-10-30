package com.example.spdemo.service;

import com.example.spdemo.entity.A01;
import com.example.spdemo.req.A01Req;
import com.example.spdemo.resp.PageResp;

public interface A01Service {
    PageResp<A01> selectA01List(A01Req a01Req);

    void delete(String a00);

    boolean save(A01 a01);
}
