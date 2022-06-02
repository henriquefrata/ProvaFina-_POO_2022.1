package br.espm.cambio;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CotacaoRepository extends CrudRepository <CotacaoModel, String> {
   
    @Override
    Iterable<CotacaoModel> findAll();

    @Override
    Optional<CotacaoModel> findById(String idc);

    @Query("SELECT c from CotacaoModel c WHERE c.idMoeda = m.idMoeda")
    Optional<CotacaoModel> findBySimbolo(@Param("simbolo") String simbolo);

}
