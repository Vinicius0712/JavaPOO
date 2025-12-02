package com.classes.BO;

import com.classes.DAO.VacinaDAO;
import modelos.Vacina;
import java.util.List;

public class VacinaBO {
    private VacinaDAO dao = new VacinaDAO();

    public boolean adicionar(Vacina v) {

        if (v == null) return false;
        if (v.getNome() == null || v.getNome().trim().isEmpty()) return false;
        if (v.getTotalDoses() < 1) return false;
        if (v.getTotalDoses() > 1 && v.getIntervaloDias() <= 0) return false;

        // Verifica duplicidade
        if (dao.buscarPorId(v.getId()) != null)
            return false;

        return dao.inserir(v);
    }

    public List<Vacina> listar() { return dao.listar(); }

    public Vacina buscarPorId(String id) { return dao.buscarPorId(id); }

    public boolean atualizar(String id, Vacina novo) {
        if (id == null || novo == null) return false;
        return dao.atualizar(novo);
    }

    public boolean remover(String id) {
        return dao.remover(id);
    }
}
