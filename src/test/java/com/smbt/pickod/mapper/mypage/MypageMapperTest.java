package com.smbt.pickod.mapper.mypage;

import com.smbt.pickod.dto.mypage.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Transactional
@SpringBootTest
class MyPageMapperTest {

    @Autowired
    MyPageMapper myPageMapper;

    MpgMyJournalCntDTO mpgMyJournalCntDTO;
    MpgLikeCntDTO mpgLikeCntDTO;
    MpgMyBestDTO mpgMyBestDTO;
    MpgMyCheckListDTO mpgMyMyCheckListDTO;
    MpgMyJournalListDTO mpgMyJournalListDTO;
    MpgMyPlanListDTO mpgMyPlanListDTO;

    @BeforeEach
    void setUp() {
        mpgMyJournalCntDTO = new MpgMyJournalCntDTO();
        mpgLikeCntDTO = new MpgLikeCntDTO();
        mpgMyBestDTO = new MpgMyBestDTO();
        mpgMyMyCheckListDTO = new MpgMyCheckListDTO();
        mpgMyJournalListDTO = new MpgMyJournalListDTO();
        mpgMyPlanListDTO = new MpgMyPlanListDTO();
    }

    @Test
    @DisplayName("내가작성한 저널숫자")
    void journalCnt() {
        //given
        mpgMyJournalCntDTO.setNumberNum(2L);
        //when
        Optional<Long> journalCnt = myPageMapper.journalCnt(mpgMyJournalCntDTO.getNumberNum());
        //that
        assertThat(journalCnt)
                .isNotEmpty()  // 비어 있지 않은지 확인
                .get()         // Optional에서 값을 추출
                .isInstanceOf(Long.class);  // 값이 Long인지 확인

    }

    @Test
    @DisplayName("내가받은 좋아요수")
    void likeCnt() {
        //given
        mpgLikeCntDTO.setMemberNum(2L);

        Optional<Long> likeCnt = myPageMapper.likeCnt(mpgLikeCntDTO.getMemberNum());
        //that
        assertThat(likeCnt)
                .isNotEmpty()
                .get()
                .isInstanceOf(Long.class);
    }

    @Test
    void myBestList() {
        //given
        mpgMyBestDTO.setMemberNum(2L);
        //when
        List<MpgMyBestDTO> myBestList = myPageMapper.myBestList(mpgMyBestDTO.getMemberNum());
        //that
        assertThat(myBestList)
                .isNotEmpty()
                .extracting("jnlTitle")
                .containsExactly("아이들과 대부도에");
    }

    @Test
    void showMyCheckList() {
        //given
        mpgMyMyCheckListDTO.setMemberNum(2L);
        //when
        List<MpgMyCheckListDTO> showMyCheckList = myPageMapper.showMyCheckList(mpgMyMyCheckListDTO.getMemberNum());
        //that
        assertThat(showMyCheckList)
        .isNotEmpty()
                .extracting("title")
                .isInstanceOf(ArrayList.class);
    }

    @Test
    void showMyJournalList() {
        //given
        mpgMyJournalListDTO.setMemberNum(2L);
        //when
        List<MpgMyJournalListDTO> showMyJournalList = myPageMapper.showMyJournalList(mpgMyJournalListDTO.getMemberNum());
        //that
        assertThat(showMyJournalList)
                .isNotEmpty()
                .extracting("jnlTitle")
                .isInstanceOf(ArrayList.class);
    }

    @Test
    void showMyPlanList() {
        //given
        mpgMyPlanListDTO.setMemberNum(2L);
        //when
        List<MpgMyPlanListDTO> showMyPlanList = myPageMapper.showMyPlanList(mpgMyPlanListDTO.getMemberNum());
        //that
        assertThat(showMyPlanList)
                .isNotEmpty()
                .extracting("planTitle")
                .isInstanceOf(ArrayList.class);
    }
}