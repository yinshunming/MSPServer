package cn.edu.nju.software.daoImpl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.nju.software.dao.IContactDAO;
import cn.edu.nju.software.model.Contact;
import cn.edu.nju.software.model.User;

/**
 * A data access object (DAO) providing persistence and search support for
 * Contact entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.nju.software.model.Contact
 * @author MyEclipse Persistence Tools
 */

public class ContactDAOImpl extends HibernateDaoSupport implements IContactDAO{
	private static final Logger log = LoggerFactory.getLogger(ContactDAOImpl.class);
	// property constants
	public static final String NAME = "name";
	public static final String PHONE = "phone";
	public static final String MOBILE = "mobile";
	public static final String EMAIL = "email";
	public static final String NAME_PINYIN = "namePinyin";
	public static final String DEPARTMENT = "department";
	public static final String NICKNAME = "nickname";
	public static final String ADDRESS = "address";
	public static final String NOTE = "note";

	protected void initDao() {
		// do nothing
	}

	public void save(Contact transientInstance) {
		log.debug("saving Contact instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Contact persistentInstance) {
		log.debug("deleting Contact instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Contact findById(java.lang.Integer id) {
		log.debug("getting Contact instance with id: " + id);
		try {
			Contact instance = (Contact) getHibernateTemplate().get(
					"cn.edu.nju.software.model.Contact", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Contact instance) {
		log.debug("finding Contact instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Contact instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Contact as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByNamePinyin(Object namePinyin) {
		return findByProperty(NAME_PINYIN, namePinyin);
	}

	public List findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	public List findByNickname(Object nickname) {
		return findByProperty(NICKNAME, nickname);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all Contact instances");
		try {
			String queryString = "from Contact";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Contact merge(Contact detachedInstance) {
		log.debug("merging Contact instance");
		try {
			Contact result = (Contact) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Contact instance) {
		log.debug("attaching dirty Contact instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contact instance) {
		log.debug("attaching clean Contact instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void update(Contact contact) {
		log.debug("update user instance");
		try {
			getHibernateTemplate().update(contact);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public static ContactDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (ContactDAOImpl) ctx.getBean("ContactDAO");
	}
}