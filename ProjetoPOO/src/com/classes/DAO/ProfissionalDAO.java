package com.classes.DAO;

import modelos.ProfissionalSaude;
import com.classes.Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalDAO {

    public boolean inserir(ProfissionalSaude p) {
        String sql = "INSERT INTO profissionais_saude (id, nome, cargo) VALUES (?, ?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getId());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getRegistro());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) { ex.printStackTrace(); return false; }
    }

    public List<ProfissionalSaude> listar() {
        String sql = "SELECT id, nome, cargo FROM profissionais_saude";
        List<ProfissionalSaude> res = new ArrayList<>();
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             while (rs.next()) {
                 res.add(new ProfissionalSaude(rs.getString("id"), rs.getString("nome"), rs.getString("cargo")));
             }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return res;
    }

    public ProfissionalSaude buscarPorId(String id) {
        String sql = "SELECT id, nome, cargo FROM profissionais_saude WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
             ps.setString(1, id);
             try (ResultSet rs = ps.executeQuery()) {
                 if (rs.next()) return new ProfissionalSaude(rs.getString("id"), rs.getString("nome"), rs.getString("cargo"));
             }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public boolean atualizar(ProfissionalSaude p) {
        String sql = "UPDATE profissionais_saude SET nome = ?, cargo = ? WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getRegistro());
            ps.setString(3, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) { ex.printStackTrace(); return false; }
    }

    public boolean remover(String id) {
        String sql = "DELETE FROM profissionais_saude WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) { ex.printStackTrace(); return false; }
    }
}
