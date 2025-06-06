package org.example.trabajo_tp3.DAO;

import java.util.List;

public interface GenericDAOInterface<T> {
    public List<T> listar();
    public T buscarPorId(long id);
    public T agregar(T t);
    public T actualizar(T t);
    public boolean eliminar( long id);
}
