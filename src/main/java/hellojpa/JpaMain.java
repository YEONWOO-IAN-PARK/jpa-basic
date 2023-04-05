package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // EntityManaberFactory는 DB당 1개의 객체만 생성해서 애플리케이션 전체에서 공유한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // EntityManager는 쓰레드 간에 공유하지 않는다. (사용하고 버려야한다)
        EntityManager em = emf.createEntityManager();
        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행해야한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 영속상태란? : 1차캐시에 해당 엔티티를 올렸을 때 부터
//            em.persist(member); // 영속화.

//            em.detach(member);  // 특정 엔티티를 준영속 상태로 만든다. (영속성 컨텍스트에서 제외)
//            em.clear();         // 영속성 컨텍스트를 완전히 초기화 한다.

            /**
             * flush 시점도 설정을 통해 변경가능하다.
             * FlushModeType.AUTO : 커밋이나 쿼리를 실행할 때 플러시 (기본값)
             * FlushModeType.COMMIT : 커밋할 때만 플러시
             */
//            em.flush(); // 강제로 DB에 반영한다.

            Member member = new Member();
            member.setUsername("C");

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
