package com.example.japanego.mapper;

import com.example.japanego.vo.WordSearchParamVo;
import com.example.japanego.vo.WordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface WordMapper {
    List<WordVo> getRandomWord(int num, int grade);

    List<WordVo> getWordList(WordSearchParamVo wordSearchParamVo);



    @Select("SELECT * FROM WORD WHERE no = #{wordNo}")
    List<WordVo> getWordDetail(int wordNo);

    @Select(" SELECT count(*) FROM WORD")
    int getWordTotalCount();
}
