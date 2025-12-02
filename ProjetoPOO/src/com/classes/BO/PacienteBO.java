package com.classes.BO;

import com.classes.DAO.PacienteDAO;
import modelos.Paciente;
import java.util.List;

public class PacienteBO {
    private PacienteDAO dao = new PacienteDAO();

    public boolean adicionar(Paciente p) {

        if (p == null) return false;
        if (!validarCPF(p.getCpf())) return false;
        if (p.getNome() == null || p.getNome().trim().isEmpty()) return false;

        // Impede CPF duplicado
        if (dao.buscarPorCpf(p.getCpf()) != null)
            return false;

        return dao.inserir(p);
    }

    public List<Paciente> listar() { return dao.listar(); }
    public Paciente buscarPorCpf(String cpf) { return dao.buscarPorCpf(cpf); }
    public boolean atualizar(String cpf, Paciente novo) { return dao.atualizar(novo); }
    public boolean remover(String cpf) { return dao.remover(cpf); }

    // ====================================================
    // REGRA DE NEGÓCIO — Validação de CPF
    // ====================================================
    private boolean validarCPF(String cpf) {
        return cpf != null && !cpf.trim().isEmpty();
    }
}
