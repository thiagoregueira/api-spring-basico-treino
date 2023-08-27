package com.api.produto.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.model.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer> {

    // listar todos os produtos
    List<ProdutoModelo> findAll();

    // pesquisar por codigo
    ProdutoModelo findByCodigo(int codigo);

    // remover produto
    void delete(ProdutoModelo produtoModelo);

    // cadastrar/alterar produto
    // ProdutoModelo save(ProdutoModelo produtoModelo);
    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);

}
