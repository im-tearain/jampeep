package es.tearain.jampeep.repository.mysql;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.tearain.jampeep.model.HibernateUtilSessionException;
import es.tearain.jampeep.model.User;
import es.tearain.jampeep.repository.UserRepository;
import es.tearain.jampeep.util.HibernateUtil;

public class UserRepositorymMySQL implements UserRepository {

	final static Logger logger = LoggerFactory.getLogger(UserRepositorymMySQL.class);
	final private Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public void createUser(User user) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			this.session.save(user);

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error creating an User on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
	}

	@Override
	public User getUser(int id) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();
		User retornedUser;

		try {
			HibernateUtil.openSessionAndBindToThread();

			retornedUser = this.session.get(User.class, id);

			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			throw new HibernateUtilSessionException("Error getting an User by 'id' on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
		return retornedUser;
	}

	@Override
	public User getUser(String name) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();
		final User retornedUser;

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			retornedUser = (User) this.session.createQuery("from USU where USU_NAM = :name").setParameter("name", name)
					.uniqueResult();

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error getting an User by 'name' on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
		return retornedUser;
	}

	@Override
	public void updateUser(User updatedUser) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			this.session.update(updatedUser);

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error updating an User on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();

	}

	@Override
	public void removeUser(int id) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			final User userToRemove = this.session.get(User.class, id);
			this.session.delete(userToRemove);

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error deleting an User by 'id' on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void removeUser(String name) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			final User userToRemove = (User) this.session.createQuery("from USU where USU_NAM = :name")
					.setParameter("name", name).uniqueResult();

			this.session.delete(userToRemove);

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error deleting an User by 'name' on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void autoManagePasswordOnTrustedDevice() {
		// TODO Auto-generated method stub

	}

}
