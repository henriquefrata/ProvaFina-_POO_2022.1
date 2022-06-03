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
    private CotacaoRepository cotacaoRepository;
    
    public List<Cotacao> listaAll() {
         return StreamSupport
            //transforme de iteravel para lista
            .stream(cotacaoRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            //transforma de model para objeto
            .stream().map(CotacaoModel::to)
            .collect(Collectors.toList());
    }

    public Cotacao create(Cotacao cotacao) {
        cotacao.setIdc(UUID.randomUUID());
        return cotacaoRepository.save(new CotacaoModel(cotacao)).to();
    }
}