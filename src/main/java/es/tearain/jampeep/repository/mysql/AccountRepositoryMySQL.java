package es.tearain.jampeep.repository.mysql;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.tearain.jampeep.model.Account;
import es.tearain.jampeep.model.HibernateUtilSessionException;
import es.tearain.jampeep.repository.AccountRepository;
import es.tearain.jampeep.util.HibernateUtil;

public class AccountRepositoryMySQL implements AccountRepository {

	final static Logger logger = LoggerFactory.getLogger(AccountRepositoryMySQL.class);
	final private Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Override
	public void createAccount(Account account) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			this.session.save(account);

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error creating an Account on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
	}

	@Override
	public Account getAccount(int id) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();
		Account retornedAccount;

		try {
			HibernateUtil.openSessionAndBindToThread();

			retornedAccount = this.session.get(Account.class, id);

			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			throw new HibernateUtilSessionException("Error getting an Account by 'id' on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
		return retornedAccount;
	}

	@Override
	public Account getAccount(String name) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();
		final Account retornedAccount;

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			retornedAccount = (Account) this.session.createQuery("from ACC where ACC_NAM = :name")
					.setParameter("name", name).uniqueResult();

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error getting an Account by 'name' on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
		return retornedAccount;
	}

	@Override
	public void updateAccount(Account updatedAccount) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			this.session.update(updatedAccount);

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error updating an Account on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();

	}

	@Override
	public void removeAccount(int id) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			final Account accountToRemove = this.session.get(Account.class, id);
			this.session.delete(accountToRemove);

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error deleting an Account by 'id' on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void removeAccount(String name) throws HibernateUtilSessionException {
		HibernateUtil.buildSessionFactory();

		try {
			HibernateUtil.openSessionAndBindToThread();

			this.session.beginTransaction();

			final Account accountToRemove = (Account) this.session.createQuery("from ACC where ACC_NAM = :name")
					.setParameter("name", name).uniqueResult();

			this.session.delete(accountToRemove);

			this.session.getTransaction().commit();
			this.session.close();

		} catch (final Exception e) {
			e.printStackTrace();
			logger.error(e.toString());

			this.session.getTransaction().rollback();

			throw new HibernateUtilSessionException("Error deleting an Account by 'name' on MySQL Database");

		} finally {
			HibernateUtil.closeSessionAndUnbindFromThread();
		}

		HibernateUtil.closeSessionFactory();
	}

	@Override
	public String generatePassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
