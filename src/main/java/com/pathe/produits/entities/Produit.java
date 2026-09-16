package com.pathe.produits.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Produit {
	
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private Long idProduit; 
	@NotNull
	@Size (min = 4,max = 15)
	private String nomProduit;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixProduit;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
 
	 
	 @ManyToOne
//	 @JoinColumn(name = "categorie_id_cat")
	 private Categorie categorie;
	 	 
	 public Produit() { 
	  super(); 
	 } 
	 
	 public Produit(String nomProduit, Double prixProduit, Date dateCreation) { 
	  super(); 
	  this.nomProduit = nomProduit; 
	  this.prixProduit = prixProduit; 
	  this.dateCreation = dateCreation; 
	 } 
	 
//	public Produit(Long idProduit, String nomProduit, Double prixProduit, Date dateCreation, Categorie categorie) {
//		super();
//		this.idProduit = idProduit;
//		this.nomProduit = nomProduit;
//		this.prixProduit = prixProduit;
//		this.dateCreation = dateCreation;
//		this.categorie = categorie;
//		}

	 
	 public Long getIdProduit() { 
		  return idProduit; 
		 } 
		 
		 public void setIdProduit(Long idProduit) { 
			  this.idProduit = idProduit; 
		 } 
		 
		 public String getNomProduit() { 
//			  return this.nomProduit; ça fonctionne aussi correctement, je dois essayer de savoir quel est la différence entre les deux
			  return nomProduit; 
	 } 
		 
		 public void setNomProduit(String nomProduit) { 
		  this.nomProduit = nomProduit; 
		 } 
		 
		 public Double getPrixProduit() { 
		  return prixProduit; 
		 } 
		 
		 public void setPrixProduit(Double prixProduit) { 
		  this.prixProduit = prixProduit; 
		 } 
		 
		 public Date getDateCreation() { 
		  return dateCreation; 
		 } 
		 
		 public void setDateCreation(Date dateCreation) { 
		  this.dateCreation = dateCreation; 
		 } 
		 
		 @Override 
		 public String toString() { 
		  return "Produit [idProduit=" + idProduit + ", nomProduit=" + 
		nomProduit + ", prixProduit=" + prixProduit 
		    + ", dateCreation=" + dateCreation + "]"; 
		 }

		public Categorie getCategorie() {
			return categorie;
		}

	
		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		} 
		
//		@Override
//		public String toString() {
//			return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
//					+ ", dateCreation=" + dateCreation + ", categorie=" + categorie + "]";
//		}

	
} 
	 