package br.espm.cambio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CotacaoRepository extends CrudRepository <CotacaoModel , String>{

    @Override
    Iterable<CotacaoModel> findAll();
    
    @Query ("Select m from CotacaoModel m WHERE UPPER(m.idMoeda) = UPPER(:idMoeda)")
    Iterable<CotacaoModel> findAll (@Param ("idMoeda") String idMoeda);
}
