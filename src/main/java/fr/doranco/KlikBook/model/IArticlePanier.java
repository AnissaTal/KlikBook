package fr.doranco.KlikBook.model;

import java.util.List;

import fr.doranco.KlikBook.entity.ArticlePanier;


public interface IArticlePanier extends IEntityDao<ArticlePanier> {

	 List<ArticlePanier> getArticlePaniers(Integer userId) throws Exception ;
}
