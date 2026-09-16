package com.pathe.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pathe.produits.entities.Categorie;
import com.pathe.produits.entities.Produit;

@RepositoryRestResource(path = "rest") 
//@RepositoryRestResource(collectionResourceRel = "produits", path = "produits/rest")

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Query("select p from Produit p where p.categorie = ?1") 
	List<Produit> findByCategorie (Categorie categorie); 
	//select p : tu sélectionnes un objet p de type Produit.
	//from Produit p : tu parcours tous les objets Produit.
	//where p.categorie = ?1 : tu filtres pour ne garder que ceux dont la catégorie correspond au premier paramètre de la méthode.
	//💡 ?1 signifie le premier paramètre de la méthode. Si tu avais deux paramètres, tu pourrais écrire ?2 pour le deuxième, etc.
	
	
	
	
//	@Query("select p from Produit p where p.categorie = ?1") 
//	List<Produit> findByCategorie (Categorie categorie);
	
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC") 
	List<Produit> trierProduitsNomsPrix (); 
	
//	List<Produit> findByOrderByNomProduitAsc(); 

	List<Produit> findByCategorieIdCat(Long idCat); 


	
	@Query("select p from Produit p where p.nomProduit like %:nom% and p.prixProduit > :prix") 
	List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix); 
	
//	@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2") 
//	List<Produit> findByNomPrix (String nom, Double prix); 
	
	List<Produit> findByNomProduit(String nom); 
	List<Produit> findByNomProduitContains(String nom);   
	List<Produit> findByOrderByNomProduitAsc(); 

	
}
