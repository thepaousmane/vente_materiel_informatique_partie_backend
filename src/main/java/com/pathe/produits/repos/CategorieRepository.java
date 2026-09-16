package com.pathe.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pathe.produits.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
