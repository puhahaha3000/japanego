package com.example.japanego.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class WordSearchVo {
    private int startNo;
    private int endNo;

    private Map<String,Object> map;

    public void setWordOption(int startNo,int endNo,String search){
        this.startNo = startNo;
        this.endNo = endNo;
        map = new HashMap<>();
        map.put("hurigana",search);
        map.put("okurigana",search);
        map.put("yomigana",search);
        map.put("word",search);
    }
}
