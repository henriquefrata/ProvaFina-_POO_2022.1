package br.espm.cambio;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MoedaRepository extends CrudRepository <MoedaModel, String> {
   
    @Override
    Iterable<MoedaModel> findAll();

    @Override
    Optional<MoedaModel> findById(String id);

    @Override
    void deleteById(String id);

    @Query("SELECT m from MoedaModel m WHERE UPPER(m.txSimbolo) = UPPER(:simbolo)")
    Optional<MoedaModel> findBySimbolo(@Param("simbolo") String simbolo);

    @Query ("Select idMoeda from MoedaModel WHERE UPPER(txSimbolo) = UPPER(:simbolo)")
    Optional<UUID> findBySimboloId (@Param ("simbolo") String simbolo);

}
