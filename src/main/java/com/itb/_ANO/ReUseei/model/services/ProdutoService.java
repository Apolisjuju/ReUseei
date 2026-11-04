package com.itb._ANO.ReUseei.model.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itb._ANO.ReUseei.model.entity.Produto;
import com.itb._ANO.ReUseei.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> FindProdutos() {
        return produtoRepository.findAll();
    }

    public Produto SalvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto FindById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Produto não encontrado com o id " + id));
    }

    public Boolean Delete(Long Id) {
        Produto produto = FindById(Id);
        try {
            produtoRepository.delete(produto);
            return true;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }

    public Produto AtualizarProduto(Long Id, Produto prod) {
        Produto produto = FindById(Id);
        try {
            produto.setNome(prod.getNome());
            produto.setDescricao(prod.getDescricao());
            produto.setQuantidadeEstoque(prod.getQuantidadeEstoque());
            produto.setTipo(prod.getTipo());
            produto.setValorCompra(prod.getValorCompra());
            produto.setValorVenda(prod.getValorVenda());
            
         return produtoRepository.save(produto);

           
        } catch (Exception e) {
            return null;
            // TODO: handle exception
        }

    }

}