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
public class CategoryDao {
		@Autowired SessionFactory sessionFactory;

		public void insert(CategoryVo vo) {
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
			Query q=session.createQuery("from CategoryVo");
			List ls=q.list();
			session.close();
			return ls;
			
			
		}

		public void delete(CategoryVo catvo) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.delete(catvo);
			tr.commit();
			session.close();
		}

		public List edit(CategoryVo catvo) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			Query q=session.createQuery("from CategoryVo where categoryId= '"+catvo.getCategoryId()+"'");
			List ls=q.list();
			session.close();
			return ls;
		}

		public void update(CategoryVo vo) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(vo);
			tr.commit();
			session.close();
		}
}
