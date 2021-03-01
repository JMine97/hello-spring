package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.*;

//회원 객체를 저장하는 저장소
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    //동시성 문제?
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //store.get(id)가 null일 경우 비어있는 Optional 객체를 얻어온다
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //store의 value들은 member
        return store.values().stream() //람다식으로 처리할 수 있게 해주는 반복자 //루프로 돌림
                .filter(member -> member.getName().equals(name)) //조건에 의해 값 선택
                .findAny(); //첫번째 요소 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
        sequence=0;
    }
}
