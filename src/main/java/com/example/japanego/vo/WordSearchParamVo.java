package com.example.japanego.vo;

import lombok.Data;

@Data
public class WordSearchParamVo {
    private int startNo;
    private int endNo;
    private String search;

    public void searchWordSet(int startNo, int endNo, String search) {
        this.startNo = startNo;
        this.endNo = endNo;
        this.search = search;
    }

    public void clear() {
        this.startNo = 0;
        this.endNo = 0;
        this.search = "";
    }
}
