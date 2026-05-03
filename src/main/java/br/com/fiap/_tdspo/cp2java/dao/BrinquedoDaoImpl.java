package br.com.fiap._tdspo.cp2java.dao;
import br.com.fiap._tdspo.cp2java.entity.Brinquedo;
import jakarta.persistence.EntityManager;

public class BrinquedoDaoImpl extends DaoGenericoImplementado<Brinquedo, Integer> implements BrinquedoDao {
    public BrinquedoDaoImpl(EntityManager em) {
        super(em);
    }

}
