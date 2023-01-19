package com.example.japanego.controller;

import com.example.japanego.service.WordBankService;
import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordBankVo;
import com.example.japanego.vo.WordWordBankRelationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/relation")
public class RelationRestController {

    @Autowired
    private WordBankService wordBankService;

    // 단어장에 단어 추가
    // http://localhost:8282/japanego/relation/word/{no}/bank/{no}
    @PutMapping("/word/{wordNo}/bank/{bankNo}")
    public String wordAdd(@PathVariable String wordNo, @PathVariable String bankNo) {

        log.info("wordAdd() ..");

        WordWordBankRelationVo wordWordBankRelationVo = new WordWordBankRelationVo(wordNo,bankNo);

        wordBankService.wordAdd(wordWordBankRelationVo);

        return "단어가 해당 단어장에 추가되었습니다.";
    }

    // 단어장에 단어 식제
    // http://localhost:8282/japanego/relation/word/{no}/bank/{no}
    @DeleteMapping("/word/{wordNo}/bank/{bankNo}")
    public String wordDel(@PathVariable String wordNo, @PathVariable String bankNo) {

        log.info("wordDel() ..");

        WordWordBankRelationVo wordWordBankRelationVo = new WordWordBankRelationVo(wordNo,bankNo);

        wordBankService.wordRemove(wordWordBankRelationVo);

        return "단어장에 있는 해당 단어가 삭제되었습니다.";
    }

    @PutMapping("/memorize")
    public String memorizeAdd(@RequestBody MemberWordRelationVo memberWordRelationVo) {

        log.info("wordDel() ..");

        // MemberWordRelationVo memberWordRelationVo = new MemberWordRelationVo(2, 10); // Test Code

        wordBankService.memorizeAdd(memberWordRelationVo);

        return "해당 단어를 암기 단어장에 추가했습니다.";
    }

    @DeleteMapping("/memorize")
    public String memorizeDel(@RequestBody MemberWordRelationVo memberWordRelationVo) {

        log.info("wordDel() ..");

        // MemberWordRelationVo memberWordRelationVo = new MemberWordRelationVo(2, 10); // Test Code

        wordBankService.memorizeRemove(memberWordRelationVo);

        return "해당 단어를 암기 단어장에서 삭제했습니다.";
    }

}
