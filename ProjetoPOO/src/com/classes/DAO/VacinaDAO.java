package com.classes.DAO;

import modelos.Vacina;
import com.classes.Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO {

    public boolean inserir(Vacina v) {
        String sql = "INSERT INTO vacinas (id, nome, fabricante, total_doses, intervalo_dias) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, v.getId());
            ps.setString(2, v.getNome());
            ps.setString(3, v.getFabricante());
            ps.setInt(4, v.getTotalDoses());
            ps.setInt(5, v.getIntervaloDias());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Vacina> listar() {
        String sql = "SELECT id, nome, fabricante, total_doses, intervalo_dias FROM vacinas";
        List<Vacina> res = new ArrayList<>();

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	Vacina v = new Vacina(
            		    rs.getString("id"),
            		    rs.getString("nome"),
            		    rs.getString("fabricante"),
            		    rs.getInt("total_doses"),
            		    rs.getInt("intervalo_dias")
            		);
            		res.add(v);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return res;
    }

    public Vacina buscarPorId(String id) {
        String sql = "SELECT id, nome, fabricante, total_doses, intervalo_dias FROM vacinas WHERE id = ?";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	Vacina v = new Vacina(
                		    rs.getString("id"),
                		    rs.getString("nome"),
                		    rs.getString("fabricante"),
                		    rs.getInt("total_doses"),
                		    rs.getInt("intervalo_dias")
                		);
                		return v;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean atualizar(Vacina v) {
        String sql = "UPDATE vacinas SET nome = ?, fabricante = ?, total_doses = ?, intervalo_dias = ? WHERE id = ?";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, v.getNome());
            ps.setString(2, v.getFabricante());
            ps.setInt(3, v.getTotalDoses());
            ps.setInt(4, v.getIntervaloDias());
            ps.setString(5, v.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean remover(String id) {
        String sql = "DELETE FROM vacinas WHERE id = ?";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
