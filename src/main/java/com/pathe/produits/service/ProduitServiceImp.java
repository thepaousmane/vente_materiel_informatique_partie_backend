package com.pathe.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pathe.produits.entities.Categorie;
import com.pathe.produits.entities.Produit;
import com.pathe.produits.repos.CategorieRepository;
import com.pathe.produits.repos.ProduitRepository;

@Service
public class ProduitServiceImp implements ProduitService{
	
	@Autowired
	ProduitRepository produitRepository;
	
	@Override //la méthode, on le nomme comment ? ça fait quoi ? 
	// et ça retourne quoi ?
	public Produit saveProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}
	
	@Override
	public Produit getProduit(Long id) {
//Cette fonction retourne un Produit,
//Cette fonction a besoin d'une "chose" id de type long
		// TODO Auto-generated method stub
		return produitRepository.findById(id).get();
	}
	
	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);		
	}

	@Override
	public List<Produit> getAllProduits() {
//		return null;
		return produitRepository.findAll();
	}

	@Override
	public Page<Produit> getAllProduitsParPage(int page, int size) {
		// TODO Auto-generated method stub
		return produitRepository.findAll(PageRequest.of(page, size)); 
/*		🔧 Détail de PageRequest.of(page, size) :
		C’est une fabrique (factory method) de l’objet PageRequest (qui implémente l’interface Pageable).
		Elle crée un objet qui contient :
		Le numéro de la page demandée,
		Le nombre d’éléments par page.*/
	}

	
	@Override
	public List<Produit> findByNomProduit(String nom) {
		return produitRepository.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		return produitRepository.findByNomProduitContains(nom);
	}

	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long idCat) {
		return produitRepository.findByCategorieIdCat(idCat);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> trierProduitsNomsPrix() {
		return produitRepository.trierProduitsNomsPrix();
	}
	
	
	@Autowired 
	 CategorieRepository categorieRepository; 
	@Override 
	 public List<Categorie> getAllCategories() { 
	  return categorieRepository.findAll(); 
	 }
}
