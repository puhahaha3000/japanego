package com.example.japanego.controller;

import com.example.japanego.service.WordBankRelationService;
import com.example.japanego.service.WordBankService;
import com.example.japanego.vo.MemberWordRelationVo;
import com.example.japanego.vo.WordWordBankRelationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/relation")
public class RelationRestController {

    @Autowired
    private WordBankRelationService wordBankRelationService;

    // http://localhost:8282/japanego/relation/word/{no}/bank/{no}
    @PutMapping("/word/{wordNo}/bank/{bankNo}")
    public boolean wordAdd(@PathVariable String wordNo, @PathVariable String bankNo) {

        log.info("wordAdd() ..");

        boolean result;   // 작업 성공 & 살패 기록
        int wordNum = Integer.parseInt(wordNo);
        int bankNum = Integer.parseInt(bankNo);
        WordWordBankRelationVo wordWordBankRelationVo = new WordWordBankRelationVo(wordNum,bankNum);

        try {
            wordBankRelationService.addWordToWordBank(wordWordBankRelationVo);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    // http://localhost:8282/japanego/relation/word/{no}/bank/{no}
    @DeleteMapping("/word/{wordNo}/bank/{bankNo}")
    public boolean wordDel(@PathVariable String wordNo, @PathVariable String bankNo) {

        log.info("wordDel() ..");

        boolean result;   // 작업 성공 & 살패 기록
        int wordNum = Integer.parseInt(wordNo);
        int bankNum = Integer.parseInt(bankNo);
        WordWordBankRelationVo wordWordBankRelationVo = new WordWordBankRelationVo(wordNum,bankNum);

        try {
            wordBankRelationService.removeWordFromWordBank(wordWordBankRelationVo);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    // http://localhost:8282/japanego/relation/word/{no}/member/{no}
    @PutMapping("/word/{wordNo}/member/{memberNo}")
    public boolean memorizeAdd(@PathVariable String wordNo, @PathVariable String memberNo) {

        log.info("wordDel() ..");

        boolean result;   // 작업 성공 & 살패 기록
        int wordNum = Integer.parseInt(wordNo);
        int memberNum = Integer.parseInt(memberNo);
        MemberWordRelationVo memberWordRelationVo = new MemberWordRelationVo(wordNum, memberNum);

        try {
            wordBankRelationService.AddMemorizeToMember(memberWordRelationVo);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    // http://localhost:8282/japanego/relation/word/{no}/member/{no}
    @DeleteMapping("/word/{wordNo}/member/{memberNo}")
    public boolean memorizeDel(@PathVariable String wordNo, @PathVariable String memberNo) {

        log.info("wordDel() ..");
        boolean result;   // 작업 성공 & 살패 기록
        int wordNum = Integer.parseInt(wordNo);
        int memberNum = Integer.parseInt(memberNo);
        MemberWordRelationVo memberWordRelationVo = new MemberWordRelationVo(wordNum, memberNum);

        try {
            wordBankRelationService.memorizeRemoveFromMember(memberWordRelationVo);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

}
