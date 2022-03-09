package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        final Member member = new Member();
        member.setName("spring");
        repository.save(member);
        final Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        //given
        final Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        final Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        final Member result = repository.findByName("spring1").get();
        //then
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        //given
        final Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        final Member member2 = new Member();
        member1.setName("spring2");
        repository.save(member2);
        //when
        final List<Member> members = repository.findAll();
        //then
        Assertions.assertThat(members.size()).isEqualTo(2);
    }

}
