package cn.et.article.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface ArticleDao {
	public List<Article> queryArticle(String seekContent);

	public void deleteArticle(Integer id);

	public void updateArticle(Integer id, String title, String content);

	public void saveArticle(String title, String content);
}
