package abc.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.Vo.CategoryVo;
import abc.Vo.SubCategoryVo;

@Repository
public class SubCategoryDao {
	@Autowired SessionFactory sessionFactory;
	
	public void insert(SubCategoryVo vo) {
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
		Query q=session.createQuery("from SubCategoryVo");
		List ls=q.list();
		session.close();
		return ls;
		
	}
	
	public void delete(SubCategoryVo subcatvo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(subcatvo);
		tr.commit();
		session.close();
	}

	public List edit(SubCategoryVo subcatvo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from SubCategoryVo where subcategoryId= '"+subcatvo.getSubcategoryId()+"'");
		List ls=q.list();
		session.close();
		return ls;
	}

	public void update(SubCategoryVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(vo);
		tr.commit();
		session.close();
	}
	
}
