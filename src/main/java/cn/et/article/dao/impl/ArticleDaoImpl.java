package cn.et.article.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.et.article.dao.Article;
import cn.et.article.dao.ArticleDao;
import cn.et.article.dao.HibernateSessionFactory;

public class ArticleDaoImpl implements ArticleDao {

	@SuppressWarnings("unchecked")
	public List<Article> queryArticle(String seekContent) {
		Session session = HibernateSessionFactory.getSession();
		Article art = new Article();
		art.setAContent(seekContent);
		Query query = session.createQuery("select * from where a_content like ?");
		query.setString(0, "%" + seekContent + "%");
		return query.list();
	}

	public void deleteArticle(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Article art = new Article();
		art.setAId(id);
		Transaction tran = session.getTransaction();
		tran.begin();
		session.delete(art);
		tran.commit();
	}

	public void updateArticle(Integer id, String title, String content) {
		Session session = HibernateSessionFactory.getSession();
		Article art = new Article();
		art.setAId(id);
		art.setATitle(title);
		art.setAContent(content);
		Transaction tran = session.getTransaction();
		tran.begin();
		session.update(art);
		tran.commit();
	}

	public void saveArticle(String title, String content) {
		Session session = HibernateSessionFactory.getSession();
		Article art = new Article();
		art.setATitle(title);
		art.setAContent(content);
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(art);
		tran.commit();
	}
}
