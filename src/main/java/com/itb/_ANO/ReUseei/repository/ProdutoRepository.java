package com.itb._ANO.ReUseei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itb._ANO.ReUseei.model.entity.Produto;



@Repository 
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
