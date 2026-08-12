package br.com.fiap._tdspo.cp2java.controller;

import br.com.fiap._tdspo.cp2java.dao.BrinquedoDao;
import br.com.fiap._tdspo.cp2java.dao.BrinquedoDaoImpl;
import br.com.fiap._tdspo.cp2java.entity.Brinquedo;
import br.com.fiap._tdspo.cp2java.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @GetMapping
    public List<Brinquedo> listar() {
        EntityManager em = criarEntityManager();
        try {
            BrinquedoDao dao = new BrinquedoDaoImpl(em);
            return dao.listar();
        } finally {
            em.close();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscar(@PathVariable Integer id) {
        EntityManager em = criarEntityManager();
        try {
            BrinquedoDao dao = new BrinquedoDaoImpl(em);
            Brinquedo brinquedo = dao.buscar(id);
            if (brinquedo == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(brinquedo);
        } finally {
            em.close();
        }
    }

    @PostMapping
    public ResponseEntity<Brinquedo> cadastrar(@RequestBody Brinquedo brinquedo) {
        EntityManager em = criarEntityManager();
        try {
            BrinquedoDao dao = new BrinquedoDaoImpl(em);
            Brinquedo salvo = dao.salvar(brinquedo);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } finally {
            em.close();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> atualizar(@PathVariable Integer id, @RequestBody Brinquedo brinquedo) {
        EntityManager em = criarEntityManager();
        try {
            BrinquedoDao dao = new BrinquedoDaoImpl(em);
            if (dao.buscar(id) == null) {
                return ResponseEntity.notFound().build();
            }
            brinquedo.setId(id);
            Brinquedo atualizado = dao.salvar(brinquedo);
            return ResponseEntity.ok(atualizado);
        } finally {
            em.close();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        EntityManager em = criarEntityManager();
        try {
            BrinquedoDao dao = new BrinquedoDaoImpl(em);
            if (dao.buscar(id) == null) {
                return ResponseEntity.notFound().build();
            }
            dao.remover(id);
            return ResponseEntity.noContent().build();
        } finally {
            em.close();
        }
    }

    private EntityManager criarEntityManager() {
        return EntityManagerFactorySingleton.getInstance().createEntityManager();
    }
}
