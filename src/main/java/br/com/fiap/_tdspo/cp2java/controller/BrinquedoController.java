package br.com.fiap._tdspo.cp2java.controller;

import br.com.fiap._tdspo.cp2java.dao.BrinquedoDao;
import br.com.fiap._tdspo.cp2java.dao.BrinquedoDaoImpl;
import br.com.fiap._tdspo.cp2java.dto.BrinquedoDto;
import br.com.fiap._tdspo.cp2java.entity.Brinquedo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    private EntityManager em;
    private BrinquedoDao dao;

    public BrinquedoController() {
        em = Persistence
                .createEntityManagerFactory("TDSPOPU")
                .createEntityManager();

        dao = new BrinquedoDaoImpl(em);
    }

    @GetMapping
    public List<Brinquedo> getBrinquedos() {
        return dao.listar();
    }

    @GetMapping("/{id}")
    public Brinquedo getBrinquedoById(@PathVariable Integer id) {
        return dao.buscar(id);
    }

    @PostMapping()
    public Brinquedo createBrinquedo(
            @RequestBody BrinquedoDto brinquedoDto){
        return dao.salvar(brinquedoDto.convertToBrinquedo());
    }

    @PutMapping()
    public Brinquedo updateBrinquedo(
            @PathVariable Integer id,
            @RequestBody BrinquedoDto brinquedoDto
    ){
        Brinquedo brinquedoExistente = dao.buscar(id);

        if(brinquedoExistente == null){
            return null;
        }

        brinquedoExistente.setNome(brinquedoDto.getNome());
        brinquedoExistente.setTipo(brinquedoDto.getTipo());
        brinquedoExistente.setClassificacao(brinquedoDto.getClassificacao());
        brinquedoExistente.setTamanho(brinquedoDto.getTamanho());
        brinquedoExistente.setPreco(brinquedoDto.getPreco());

        return dao.salvar(brinquedoExistente);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        dao.remover(id);
    }
}