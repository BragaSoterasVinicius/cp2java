package br.com.fiap._tdspo.cp2java.dao;

import jakarta.persistence.EntityManager;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DaoGenericoImplementado<T,K> implements DaoGenerico<T,K> {
    private EntityManager em;
    private Class<T> clazz;

    public DaoGenericoImplementado(EntityManager em) {
        this.em = em;
        this.clazz = (Class<T>) ((ParameterizedType)
                                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    public T salvar(T entidade) {
        try {
            em.getTransaction().begin();
            T entidadeSalva = em.merge(entidade);
            em.getTransaction().commit();
            return entidadeSalva;
        } catch(Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    public void remover(K id) {
        try {
            em.getTransaction().begin();
            T entidade = buscar(id);
            if (entidade != null) {
                em.remove(entidade);
            }
            em.getTransaction().commit();
        } catch(Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    public T buscar(K id) {
        T entidade = em.find(clazz, id);
        return entidade;
    }

    public List<T> listar() {
        String jpql = "from " + clazz.getSimpleName();
        return em.createQuery(jpql, clazz).getResultList();
    }

    public void commit() {
        try {
            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
            }
        } catch(Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

}
