package abc.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.Vo.ComplainVo;
@Repository
public class ComplainDao {
	@Autowired SessionFactory sessionFactory;

	public List search() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from ComplainVo");
		List ls=q.list();
		session.close();
		return ls;
	}

	public void insert(ComplainVo vo) {
		
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(vo);
		tr.commit();
		session.close();
	}

}
