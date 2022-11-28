package hellojpa;

import hellojpa.entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Inheritance {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin(); // Transaction 시작

		try {
			Movie movie = new Movie();
			movie.setDirector("감독A");
			movie.setActor("배우A");
			movie.setName("바람과 함께 사라지다");
			movie.setPrice(10000);

			em.persist(movie);

			em.flush();
			em.clear();

			Movie findMovie = em.find(Movie.class, movie.getId());
			System.out.println("findMovie = " + findMovie);

			tx.commit(); // Transaction 저장
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
}
