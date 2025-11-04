package repositorio;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T, ID> {
    void guardar(T entidad) throws Exception;
    List<T> listar() throws Exception;
    Optional<T> buscarPorId(ID id) throws Exception;
}
