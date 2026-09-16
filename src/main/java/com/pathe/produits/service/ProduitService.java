package com.pathe.produits.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.pathe.produits.entities.Categorie;
import com.pathe.produits.entities.Produit;

public interface ProduitService {
	Produit saveProduit(Produit p);//Equivaut à C dans le CRUD
	Produit getProduit(Long id);//Equivaut à R dans le CRUD
	Produit updateProduit(Produit p);//Equivaut à U dans le CRUD
	void deleteProduit(Produit p);//Equivaut à D dans le CRUD
	void deleteProduitById(Long id);
	List<Produit> getAllProduits();
	Page<Produit> getAllProduitsParPage(int page, int size); 

	List<Categorie> getAllCategories(); 
	List<Produit> findByNomProduit(String nom); 
	List<Produit> findByNomProduitContains(String nom); 
	List<Produit> findByNomPrix (String nom, Double prix); 
	List<Produit> findByCategorie (Categorie categorie); 
	List<Produit> findByCategorieIdCat(Long idCat); 
	List<Produit> findByOrderByNomProduitAsc(); 
	List<Produit> trierProduitsNomsPrix(); 
}
