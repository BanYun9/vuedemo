package com.example.spdemo.controller;

import com.example.spdemo.entity.A01;
import com.example.spdemo.req.A01Req;
import com.example.spdemo.resp.PageResp;
import com.example.spdemo.service.A01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.spdemo.resp.CommonResp;

@RestController
@RequestMapping("/A01")
public class A01Controller {

    @Autowired
    private A01Service a01Service;

    @GetMapping("/getA01List")
    public CommonResp<PageResp<A01>> getA01List(A01Req a01Req) {
        CommonResp<PageResp<A01>> resp = new CommonResp<>();
        PageResp<A01> pageResp = a01Service.selectA01List(a01Req);
        resp.setContent(pageResp);
        return resp;
    }

    @DeleteMapping("/delete/{a00}")
    public CommonResp<A01> delete(@PathVariable String a00) {
        CommonResp<A01> resp = new CommonResp<>();
        a01Service.delete(a00);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp<A01> save(@RequestBody A01 a01) {
        CommonResp<A01> resp = new CommonResp<>();
        a01Service.save(a01);
        return resp;
    }
}
