package abc.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.Vo.ShopVo;
@Repository

public class ShopDao {
	@Autowired SessionFactory sessionFactory;
	public void insert(ShopVo vo) {
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
		Query q=session.createQuery("from ShopVo");
		List ls=q.list();
		System.out.println("list:"+ls.size());
		session.close();
		return ls;
	}

	public void delete(ShopVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
	}

	public List edit(ShopVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from ShopVo where shopId= '"+vo.getShopId()+"'");
		List ls=q.list();
		session.close();
		return ls;
	}

	public void update(ShopVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(vo);
		tr.commit();
		session.close();
	}

}
