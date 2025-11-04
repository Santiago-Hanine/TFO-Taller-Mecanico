package servicio;

import repositorio.Repositorio;
import dominio.orden.OrdenDeTrabajo;

import java.util.List;
import java.util.Optional;

public class OrdenService {
    private final Repositorio<OrdenDeTrabajo, Integer> repo;

    public OrdenService(Repositorio<OrdenDeTrabajo, Integer> repo) {
        this.repo = repo;
    }

    public void registrar(OrdenDeTrabajo ot) throws Exception {
        // Validaciones simples si querés
        repo.guardar(ot);
    }

    public List<OrdenDeTrabajo> listar() throws Exception {
        return repo.listar();
    }

    public Optional<OrdenDeTrabajo> buscarPorNumero(int nro) throws Exception {
        return repo.buscarPorId(nro);
    }
}
