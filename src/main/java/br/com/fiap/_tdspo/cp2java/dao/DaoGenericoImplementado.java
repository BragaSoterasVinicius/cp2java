package br.com.fiap._tdspo.cp2java.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;

public class DaoGenericoImplementado<T,K> implements DaoGenerico<T,K> {
    private EntityManager em;
    private Class<T> clazz;

    public DaoGenericoImplementado(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = (Class<T>) ((ParameterizedType)
                                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    public T salvar(T entidade) {
        return em.merge(entidade);
    }

    public void remover(K id) {
        T entidade = buscar(id);
        em.remove(entidade);
    }

    public T buscar(K id) {
        T entidade = em.find(clazz, id);
        return entidade;
    }
    public void commit() {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

}
