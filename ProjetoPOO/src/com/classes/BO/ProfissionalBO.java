package com.classes.BO;

import com.classes.DAO.ProfissionalDAO;
import modelos.ProfissionalSaude;
import java.util.List;

public class ProfissionalBO {
    private ProfissionalDAO dao = new ProfissionalDAO();

    public boolean adicionar(ProfissionalSaude p) {

        if (p == null) return false;
        if (p.getNome() == null || p.getNome().trim().isEmpty()) return false;

        // Verifica duplicidade
        if (dao.buscarPorId(p.getId()) != null)
            return false;

        return dao.inserir(p);
    }

    public List<ProfissionalSaude> listar() { return dao.listar(); }
    public ProfissionalSaude buscarPorId(String id) { return dao.buscarPorId(id); }
    public boolean atualizar(String id, ProfissionalSaude novo) { return dao.atualizar(novo); }
    public boolean remover(String id) { return dao.remover(id); }
}
