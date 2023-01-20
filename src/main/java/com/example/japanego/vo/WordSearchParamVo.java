package com.example.japanego.vo;

import lombok.Data;

@Data
public class WordSearchParamVo {
    private int startNo;
    private int endNo;
    private String search;

    public void setSearchParam(int startNo, int endNo, String search) {
        this.startNo = startNo;
        this.endNo = endNo;
        this.search = search;
    }

}
