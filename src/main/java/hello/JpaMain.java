package hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            /*Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);*/


           /*Member findMember = em.find(Member.class,1L);
           System.out.println("findMember.id = "+findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            tx.commit();*/

          /* Member findMember = em.find(Member.class,1L);
           em.remove(findMember);

            tx.commit();*/

         /* Member findMember = em.find(Member.class,1L);
          findMember.setName("HelloJPA");

          tx.commit();*/

         List<Member> result = em.createQuery("select m from Member as m",Member.class).getResultList();

         for(Member member : result){
             System.out.println("member.name = " + member.getName());
         }

         tx.commit();
         }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
