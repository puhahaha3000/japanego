package com.example.japanego.mapper;

import com.example.japanego.vo.WordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WordMapper {
    List<WordVo> getRandomWord(int num, int grade);

    List<WordVo> getWordList(Map<String,Object> wordMap);

    List<WordVo> getWordDetail(int wordNo);

    int getAllWordCount();
}
