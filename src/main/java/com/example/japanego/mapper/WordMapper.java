package com.example.japanego.mapper;

import com.example.japanego.vo.WordSearchParamVo;
import com.example.japanego.vo.WordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordMapper {
    List<WordVo> getRandomWord(int num, int grade);

    List<WordVo> getWordList(WordSearchParamVo wordSearchParamVo);

    //WordSearchParamVo => int startNo,int endNo,String search
    //parameterType 이 2가지 int,String 을 통합하기위해 WordSearchParamVo 로 묶어서사용
    List<WordVo> getWordDetail(int wordNo);

    int getWordTotalCount();
}
