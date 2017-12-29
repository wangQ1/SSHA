package cn.et.article.service;

import java.util.List;
import cn.et.article.dao.Article;

public interface ArticleService {
	/**
	 * 查询文章
	 * @param seekContent 搜索的内容
	 * @return 文章数组
	 */
	public List<Article> queryArticle(String seekContent);

	public void deleteArticle(Integer id);

	public void updateArticle(Integer id, String title, String content);

	public void saveArticle(String title, String content);
}
