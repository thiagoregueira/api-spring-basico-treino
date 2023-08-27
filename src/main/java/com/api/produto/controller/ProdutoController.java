package com.api.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.model.ProdutoModelo;
import com.api.produto.model.RespostaModelo;
import com.api.produto.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    // Acoes
    @Autowired
    private ProdutoRepositorio acoes;

    // Listar Produtos
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody List<ProdutoModelo> listar() {
        return acoes.findAll();

    }

    // cadastrar produtos
    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
        return acoes.save(produto);

    }

    // filtrar produtos
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public @ResponseBody ProdutoModelo filtrar(@PathVariable int codigo) {
        return acoes.findByCodigo(codigo);

    }

    // alterar produtos
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
        return acoes.save(produto);
    }

    // remover produtos
    @RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
    public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {

        RespostaModelo resposta = new RespostaModelo();

        try {
            ProdutoModelo produto = filtrar(codigo);
            acoes.delete(produto);
            resposta.setMensagem("Produto removido com sucesso!");

        } catch (Exception e) {
            resposta.setMensagem("falha ao remover: " + e.getMessage());
        }

        return resposta;

    }
}
