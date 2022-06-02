package br.espm.cambio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
* Esse é o microserviço de moeda
*/
@Component
public class MoedaService {

    @Autowired
    MoedaRepository moedaRepository;
    
    public List<Moeda> listaAll() {
         return StreamSupport
            //transforme de iteravel para lista
            .stream(moedaRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            //transforma de model para objeto
            .stream().map(MoedaModel::to)
            .collect(Collectors.toList());
    }

    public Moeda create(Moeda vo) {
        vo.setId(UUID.randomUUID());
        return moedaRepository.save(new MoedaModel(vo)).to();
    }

    public Moeda findMoedaBySimbolo (String simbolo) {
        return moedaRepository.findBySimbolo(simbolo)
            .map(MoedaModel::to)
            .orElse(null);
    }

    public Moeda findBy(UUID id) {
        return moedaRepository.findById(id.toString())
                    .map(MoedaModel::to)
                    .orElse(null);
    }
    
}
