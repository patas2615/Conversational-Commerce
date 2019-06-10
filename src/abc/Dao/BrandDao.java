package abc.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.Vo.BrandVo;
@Repository
public class BrandDao {
	@Autowired SessionFactory sessionFactory;

	public void insert(BrandVo vo) {
		// TODO Auto-generated method stub
	
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(vo);
		tr.commit();
		session.close();
	}

	public List search() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from BrandVo");
		List ls=q.list();
		session.close();
		return ls;
	}

	public void delete(BrandVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
	}

	public List edit(BrandVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from BrandVo where brandId= '"+vo.getBrandId()+"'");
		List ls=q.list();
		session.close();
		return ls;
	}

	public void update(BrandVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(vo);
		tr.commit();
		session.close();
	}
	}


