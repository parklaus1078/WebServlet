package Hello.demo.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance(); // cuz it's singleton, I can't initialize an instance of it.

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("kay", 28, "pgw12345@gmail.com", "1234");

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);

    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 20, "member1@naver.com", "1234_1!");
        Member member2 = new Member("member2", 52, "member2@gmail.com", "4324_2!");

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> allMembers = memberRepository.findAll();

        // then
//        assertThat(allMembers.size()).isEqualTo(2); can be substituted with
        assertThat(allMembers).hasSize(2);
        assertThat(allMembers).contains(member1, member2);
    }
}