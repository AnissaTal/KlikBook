package fr.doranco.KlikBook.control;

import java.util.List;

import fr.doranco.KlikBook.entity.ArticlePanier;


public interface IArticlePanierMetier {

	 List<ArticlePanier> getArticlePaniers(Integer userId) throws Exception ;
}
