package com.classes.DAO;

import modelos.UnidadeSaude;
import com.classes.Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnidadeDAO {

    public boolean inserir(UnidadeSaude u) {
        String sql = "INSERT INTO unidades_saude (id, nome, endereco) VALUES (?, ?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getId());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getEndereco());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) { ex.printStackTrace(); return false; }
    }

    public List<UnidadeSaude> listar() {
        String sql = "SELECT id, nome, endereco FROM unidades_saude";
        List<UnidadeSaude> res = new ArrayList<>();
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             while (rs.next()) res.add(new UnidadeSaude(rs.getString("id"), rs.getString("nome"), rs.getString("endereco")));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return res;
    }

    public UnidadeSaude buscarPorId(String id) {
        String sql = "SELECT id, nome, endereco FROM unidades_saude WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
             ps.setString(1, id);
             try (ResultSet rs = ps.executeQuery()) {
                 if (rs.next()) return new UnidadeSaude(rs.getString("id"), rs.getString("nome"), rs.getString("endereco"));
             }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }

    public boolean atualizar(UnidadeSaude u) {
        String sql = "UPDATE unidades_saude SET nome = ?, endereco = ? WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEndereco());
            ps.setString(3, u.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) { ex.printStackTrace(); return false; }
    }

    public boolean remover(String id) {
        String sql = "DELETE FROM unidades_saude WHERE id = ?";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) { ex.printStackTrace(); return false; }
    }
}
