package abc.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import abc.Vo.LoginVo;
import abc.Vo.RegisterVo;
@Repository
public class RegisterDao {

	@Autowired SessionFactory sessionFactory;

	public void insert(RegisterVo vo) {
		// TODO Auto-generated method stub
	
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(vo);
		tr.commit();
		session.close();
	}

	public void Logininsert(LoginVo lvo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(lvo);
		tr.commit();
		session.close();
	}

}
