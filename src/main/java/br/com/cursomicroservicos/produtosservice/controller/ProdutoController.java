package br.com.cursomicroservicos.produtosservice.controller;

import br.com.cursomicroservicos.produtosservice.model.Produto;
import br.com.cursomicroservicos.produtosservice.model.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@Slf4j
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

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


    @GetMapping("/teste")
    public ResponseEntity<String> getTest(){
       return ResponseEntity.ok("NOVA FUNCIONALIDADE!!");
    }
}
