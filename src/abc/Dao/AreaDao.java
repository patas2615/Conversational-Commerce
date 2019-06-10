package abc.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.Vo.AreaVo;
@Repository
public class AreaDao {
	@Autowired SessionFactory sessionFactory;
	public void insert(AreaVo vo) {
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
		Query q=session.createQuery("from AreaVo");
		List ls=q.list();
		session.close();
		return ls;	

}
	public void delete(AreaVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
	}
	public List edit(AreaVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from AreaVo where areaId= '"+vo.getAreaId()+"'");
		List ls=q.list();
		session.close();
		return ls;
	}
	public void update(AreaVo vo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(vo);
		tr.commit();
		session.close();
	}
}
