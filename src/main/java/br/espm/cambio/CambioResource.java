package br.espm.cambio;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CambioResource {

    

    //Moeda

    @Autowired
    private MoedaService moedaService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello ESPM";
    }

    @GetMapping("/moeda")
    public List<Moeda> listMoeda() {
        return moedaService.listaAll();
    }

    @GetMapping("/moeda/{simbolo:[A-Z]{3,}}")
    public Moeda findMoedaBySimbolo(@PathVariable String simbolo) {
        return moedaService.findMoedaBySimbolo(simbolo);
    }

    @GetMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public Moeda findMoedaById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return moedaService.findBy(uuid);
    }
    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda) {
        moedaService.create(moeda);
    }

    @DeleteMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}")
    public void delete(@PathVariable String id) {
        moedaService.delete(id);
    }

    //Cotação

    @Autowired
    private CotacaoService cotacaoService;    

    @RequestMapping(path = "/cotacao/{simbolo}/{ano}/{mes}/{dia}", method = RequestMethod.POST)
    public void save(@RequestBody Cotacao cotacao, @PathVariable String simbolo, @PathVariable String ano, @PathVariable String mes, @PathVariable String dia) {

        LocalDate dt = LocalDate.parse(ano + "-" + mes + "-" + dia);
        cotacao.setData(dt);
        UUID moeda = moedaService.findMoedaBySimbolo(simbolo).getId();
        cotacao.setId(moeda);
        cotacaoService.create(cotacao);

    }

    @GetMapping("/cotacao/{simbolo}")
    public List<Cotacao> findCotacaoBySimbolo(@PathVariable String simbolo) {
        
        UUID id = moedaService.findBySimboloId(simbolo); 
        return cotacaoService.listAll(id);
    }



    
}
