package com.example.japanego.mapper;

import com.example.japanego.vo.WordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuizMapper {

    List<WordVo> getWordList(int memberNo);
}
