package com.ssonsh.encpilot.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    void generate01() {
        // given
        Member member = Member.of("손성현", "010205741640", "ssh1224@midasin.com");

        // when
        memberRepository.save(member);
        em.flush();
        em.clear();

        // then
        Member findMember = memberRepository.findById(member.getId()).get();
        System.out.println("[Test][findMember] : " + findMember);

        assertNotNull(findMember);
        assertAll(
            () -> assertThat(findMember.getName()).isEqualTo("손성현"),
            () -> assertThat(findMember.getEmailAddress()).isEqualTo("ssh1224@midasin.com"),
            () -> assertThat(findMember.getPhoneNumber()).isEqualTo("010205741640")
        );
    }

}