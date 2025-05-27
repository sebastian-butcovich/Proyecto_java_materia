package org.example.trabajo_tp3.DAO;

import java.util.List;

public interface GenericDAO <T> {
    public List<T> listar();
    public T buscarPorId(long id);
    public boolean agregar(T t);
    public boolean actualizar(T t);
    public boolean eliminar( long id);
}
