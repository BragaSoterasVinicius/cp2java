package br.com.fiap._tdspo.cp2java.dao;

public interface DaoGenerico <T, K>{
    T salvar(T objeto);

    void remover(K objeto);

    T buscar(K id);

    java.util.List<T> listar();

    void commit();
}
