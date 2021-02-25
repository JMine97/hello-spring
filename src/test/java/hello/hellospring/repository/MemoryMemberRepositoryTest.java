package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트는 순서에 의존하지 않고 설계돼야 한다
    //테스트가 끝날때마다 리포지토리를 지워주는 메소드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        //when
        repository.save(member);

        //then
        //optional에서 값 꺼낼 떄는 get()으로 꺼내기 가능
        Member result = repository.findById(member.getId()).get();
        //alt + enter 수정제안 목록
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift + f6 리네임
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift + f6 리네임
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result= repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
