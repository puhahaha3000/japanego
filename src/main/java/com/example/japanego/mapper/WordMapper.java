package com.example.japanego.mapper;

import com.example.japanego.vo.WordSearchVo;
import com.example.japanego.vo.WordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WordMapper {
    List<WordVo> getRandomWord(int num, int grade);

    List<WordVo> getWordList(WordSearchVo word);

    int getAllWordCount();
}
