package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    //jpa를 쓰려면 EntityManager를 주입 받아야한다
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em=em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); //PK 조회 가능
        return Optional.ofNullable(member);
    }

//    PK가 아닌 나머지들은 JPQL을 작성해줘야한다
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where " +
                "m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //객체를 대상으로 sql을 날림
        //sql로 알아서 번역됨
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
