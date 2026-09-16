package com.pathe.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.pathe.produits.entities.Categorie;
import com.pathe.produits.entities.Produit;
import com.pathe.produits.repos.ProduitRepository;
import com.pathe.produits.service.ProduitService;

@SpringBootTest
class ProduitsApplicationTests {
	@Autowired //l'injection de dépendance
	private ProduitRepository produitRepository;
	
	@Autowired
	ProduitService produitService;
	@Test
	public void testCreateProduit() {
//	Produit prod = new Produit("Samsung X air",2050.000,new Date());
//	produitRepository.save(prod);
		Produit prod = new Produit();
		prod.setNomProduit("computer FLop");
		prod.setPrixProduit(3000.000);
		prod.setDateCreation(new Date());
		produitService.saveProduit(prod);
	}
	
	@Test
	public void testFindProduit()
	{
//	Produit p = produitRepository.findById(1L).get(); 
	Produit p =produitService.getProduit(3L);
	System.out.println(p);
//	System.out.println(p.getNomProduit());
	}
	
	@Test
	public void testUpdateProduit(){
	Produit p = produitRepository.findById(2L).get();
	p.setPrixProduit(2000.0);
	p.setNomProduit("Lenovo");
	produitRepository.save(p);
	}
	@Test
	public void testDeleteProduit()
	{
	produitRepository.deleteById(2L);;
	}
	
	@Test
	public void testListerTousProduits()
	{
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods)
		{
		System.out.println(p);
		}
	}
	
	
	@Test 
	public void testFindByNomProduitContains() 
	{ 
		Page<Produit>  prods = produitService.getAllProduitsParPage(0,2); 
		System.out.println(prods.getSize()); 
		System.out.println(prods.getTotalElements()); 
		System.out.println(prods.getTotalPages()); 
		prods.getContent().forEach(p -> {System.out.println(p.toString());
		}); 
	} 
 
	@Test 
	public void testfindByCategorie() 
	{ 
	Categorie cat = new Categorie(); 
	cat.setIdCat(1L);    
	List<Produit>  prods = produitRepository.findByCategorie(cat); 
	for (Produit p : prods) 
	{ 
	System.out.println(p); 
	} 
	} 


//	@Test
//	void contextLoads() {
//	}

}
