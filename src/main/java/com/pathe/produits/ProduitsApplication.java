package com.pathe.produits;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.pathe.produits.entities.Produit;
import com.pathe.produits.service.ProduitService;

@SpringBootApplication
public class ProduitsApplication 
implements CommandLineRunner 
{

//	@Autowired
//	ProduitService produitService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
	}

//	@Override
//	public void run(String...args) throws Exception {
//		produitService.saveProduit(new Produit("PC Dell QP", 2700.0, new Date())); 
//		produitService.saveProduit(new Produit("PC Asus QP", 2900.0, new Date())); 
//		produitService.saveProduit(new Produit("Imprimante Epson QP", 1000.0, new Date()));
//		}
}
