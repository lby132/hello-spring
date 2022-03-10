package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        final Member member = new Member();
        member.setName("hello");

        //when
        final Long saveId = memberService.join(member);

        //then
        final Member findMember = memberRepository.findById(saveId).get();
        System.out.println("findMember = " + findMember);
        org.junit.jupiter.api.Assertions.assertEquals(member.getName(), findMember.getName());
    }
}
