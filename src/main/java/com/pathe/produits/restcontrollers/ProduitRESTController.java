package com.pathe.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pathe.produits.entities.Produit;
import com.pathe.produits.service.ProduitService;


@RestController
@RequestMapping("/api")
//@CrossOrigin
public class ProduitRESTController {
	
	@Autowired
	ProduitService produitService;
	
	@GetMapping("/search")
	public List<Produit> findByNomProduit(@RequestParam("nom") String nom){
		return produitService.findByNomProduit(nom);
	}
	
	@GetMapping("/search2")
	public List<Produit> findByNomProduitContains(@RequestParam("nom") String nom){
		return produitService.findByNomProduitContains(nom);
	}
	
	@GetMapping("/search3")
	public List<Produit> findByOrderByNomProduitAsc(){
		return produitService.findByOrderByNomProduitAsc();
	}
	
	@GetMapping("/search4")
	public List<Produit> findByNomPrix(@RequestParam("nom") String nom, @RequestParam("prix") double prix){
		return produitService.findByNomPrix(nom, prix);
	}
	
	
//	@RequestMapping(method=RequestMethod.GET)
	@GetMapping()
	public List<Produit> getAllProduits()
	{
		return produitService.getAllProduits();
	}
	
//	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@GetMapping("/{id}")
	public Produit getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public Produit createProduit(@RequestBody Produit produit) {
			return produitService.saveProduit(produit);
	}
	
//	@RequestMapping(method = RequestMethod.PUT)
	@PutMapping
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
			produitService.deleteProduitById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
		return produitService.findByCategorieIdCat(idCat);
	}

	
	
	


}