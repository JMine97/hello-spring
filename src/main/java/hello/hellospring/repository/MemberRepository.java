package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //저장
    Optional<Member> findById(Long id); //찾아옴
    Optional<Member> findByName(String name); //찾아옴
    List<Member> findAll(); //모든 내용 반환
}
