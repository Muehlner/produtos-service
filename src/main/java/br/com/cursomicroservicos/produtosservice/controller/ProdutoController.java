package br.com.cursomicroservicos.produtosservice.controller;

import br.com.cursomicroservicos.produtosservice.model.Produto;
import br.com.cursomicroservicos.produtosservice.model.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> post(@RequestBody Produto produto) {
        Produto retornoDb = produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(retornoDb);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> get() {
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok().body(produtos);
    }

}
