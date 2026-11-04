package com.itb._ANO.ReUseei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itb._ANO.ReUseei.model.entity.Produto;
import com.itb._ANO.ReUseei.model.services.ProdutoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodosProdutos() {

        return ResponseEntity.ok().body(produtoService.FindProdutos());
    }

    @GetMapping("FindById")
    public String getMethodName(@RequestParam Long Id) {
        return ResponseEntity.ok().body(produtoService.FindById(Id));
    }

    // Salvar Produto

    @PostMapping("/salvarProduto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.SalvarProduto(produto);

        // 2. Retorna o produto envelopado em um ResponseEntity com status 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {

        System.out.println("DELETE chamado para o ID: " + id);

        try {
            if (produtoService.Delete(id)) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.notFound().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

   @PutMapping("/editar/{id}")
public ResponseEntity<Produto> putMethodName(@PathVariable Long id, @RequestBody Produto produto) {
    // 1. Atualiza o produto usando o seu Service
    Produto produtoAtualizado = produtoService.AtualizarProduto(id, produto);
    
    // 2. Retorna a resposta HTTP correta (200 OK) com o objeto atualizado
    return ResponseEntity.ok(produtoAtualizado);
}

}
