package com.example.spdemo.req;

import lombok.Data;

import java.util.Date;


public class A01Req extends PageReq {
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String A0101;

    /**
     * 性别
     */
    private String A0104;

    /**
     * 出生日期
     */
    private Date A0107;

    public String getA0101() {
        return A0101;
    }

    public void setA0101(String a0101) {
        A0101 = a0101;
    }

    public String getA0104() {
        return A0104;
    }

    public void setA0104(String a0104) {
        A0104 = a0104;
    }

    public Date getA0107() {
        return A0107;
    }

    public void setA0107(Date a0107) {
        A0107 = a0107;
    }

    @Override
    public String toString() {
        return "A01Req{" +
                "A0101='" + A0101 + '\'' +
                ", A0104='" + A0104 + '\'' +
                ", A0107=" + A0107 +
                '}';
    }
}
