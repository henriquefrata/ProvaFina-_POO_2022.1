package br.espm.cambio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
* Esse é o microserviço de cotação
*/
@Component
public class CotacaoService {

    @Autowired
    CotacaoRepository cotacaoRepository;
    
    public List<Cotacao> listaAll() {
         return StreamSupport
            //transforme de iteravel para lista
            .stream(cotacaoRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            //transforma de model para objeto
            .stream().map(CotacaoModel::to)
            .collect(Collectors.toList());
    }

    public Cotacao create(Cotacao vo) {
        vo.setId(UUID.randomUUID());
        return cotacaoRepository.save(new CotacaoModel(vo)).to();
    }

    public Cotacao findCotacaoBySimbolo (String simbolo) {
        return cotacaoRepository.findBySimbolo(simbolo)
            .map(CotacaoModel::to)
            .orElse(null);
    }
    
}