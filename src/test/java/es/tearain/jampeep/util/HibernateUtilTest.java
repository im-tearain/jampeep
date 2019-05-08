package es.tearain.jampeep.util;

import org.hibernate.Session;
import org.junit.Test;

import es.tearain.jampeep.model.User;

public class HibernateUtilTest {

	final private static Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Test
	public void shouldCreateAndCloseAConnection() {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			final User user = session.get(User.class, 1);
			System.out.println(user.toString());
		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
	}
}
