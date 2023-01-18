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

    @PutMapping("/word")
    public String wordAdd(@RequestBody WordWordBankRelationVo wordWordBankRelationVo) {

        log.info("wordAdd() ..");

        // WordWordBankRelationVo wordWordBankRelationVo = new wordWordBankRelationVo(10,2); // Test Code

        wordBankService.wordAdd(wordWordBankRelationVo);

        return "단어가 해당 단어장에 추가되었습니다.";
    }

    @DeleteMapping("/word")
    public String wordDel(@RequestBody WordWordBankRelationVo wordWordBankRelationVo) {

        log.info("wordDel() ..");

        // WordWordBankRelationVo wordWordBankRelationVo = new WordWordBankRelationVo(10,2); // Test Code

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
