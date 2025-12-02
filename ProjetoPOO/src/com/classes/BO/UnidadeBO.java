package com.classes.BO;

import com.classes.DAO.UnidadeDAO;
import modelos.UnidadeSaude;
import java.util.List;

public class UnidadeBO {
    private UnidadeDAO dao = new UnidadeDAO();

    public boolean adicionar(UnidadeSaude u) {

        if (u == null) return false;
        if (u.getNome() == null || u.getNome().trim().isEmpty()) return false;

        // evita ID duplicado
        if (dao.buscarPorId(u.getId()) != null)
            return false;

        return dao.inserir(u);
    }

    public List<UnidadeSaude> listar() { return dao.listar(); }
    public UnidadeSaude buscarPorId(String id) { return dao.buscarPorId(id); }
    public boolean atualizar(String id, UnidadeSaude novo) { return dao.atualizar(novo); }
    public boolean remover(String id) { return dao.remover(id); }
}
