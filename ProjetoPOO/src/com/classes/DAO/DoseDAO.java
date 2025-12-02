package com.classes.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.classes.Conexao.Conexao;
import modelos.DoseAplicada;

public class DoseDAO {

    // Inserir
    public boolean inserir(DoseAplicada d) {
        String sql = "INSERT INTO doses_aplicadas "
                + "(data, unidade_id, profissional_id, lote, numero_dose, cpf_paciente, vacina_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, d.getData());
            stmt.setString(2, d.getUnidadeId());
            stmt.setString(3, d.getProfissionalId());
            stmt.setString(4, d.getLote());
            stmt.setInt(5, d.getNumeroDose());
            stmt.setString(6, d.getCpfPaciente());
            stmt.setString(7, d.getVacinaId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Listar todos
    public ArrayList<DoseAplicada> listar() {
        ArrayList<DoseAplicada> lista = new ArrayList<>();

        String sql = "SELECT * FROM doses_aplicadas";

        try (Connection con = Conexao.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                DoseAplicada d = new DoseAplicada(
                        rs.getString("id"),
                        rs.getString("data"),
                        rs.getString("unidade_id"),
                        rs.getString("profissional_id"),
                        rs.getString("lote"),
                        rs.getInt("numero_dose"),
                        rs.getString("cpf_paciente"),
                        rs.getString("vacina_id")
                );
                lista.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar por ID
    public DoseAplicada buscarPorId(String id) {
        String sql = "SELECT * FROM doses_aplicadas WHERE id = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new DoseAplicada(
                        rs.getString("id"),
                        rs.getString("data"),
                        rs.getString("unidade_id"),
                        rs.getString("profissional_id"),
                        rs.getString("lote"),
                        rs.getInt("numero_dose"),
                        rs.getString("cpf_paciente"),
                        rs.getString("vacina_id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Listar por paciente
    public ArrayList<DoseAplicada> listarPorPaciente(String cpf) {
        ArrayList<DoseAplicada> lista = new ArrayList<>();

        String sql = "SELECT * FROM doses_aplicadas WHERE cpf_paciente = ? ORDER BY numero_dose";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DoseAplicada d = new DoseAplicada(
                        rs.getString("id"),
                        rs.getString("data"),
                        rs.getString("unidade_id"),
                        rs.getString("profissional_id"),
                        rs.getString("lote"),
                        rs.getInt("numero_dose"),
                        rs.getString("cpf_paciente"),
                        rs.getString("vacina_id")
                );
                lista.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Atualizar
    public boolean atualizar(DoseAplicada d) {
        String sql = "UPDATE doses_aplicadas SET "
                + "data = ?, unidade_id = ?, profissional_id = ?, lote = ?, "
                + "numero_dose = ?, cpf_paciente = ?, vacina_id = ? "
                + "WHERE id = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, d.getData());
            stmt.setString(2, d.getUnidadeId());
            stmt.setString(3, d.getProfissionalId());
            stmt.setString(4, d.getLote());
            stmt.setInt(5, d.getNumeroDose());
            stmt.setString(6, d.getCpfPaciente());
            stmt.setString(7, d.getVacinaId());
            stmt.setString(8, d.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Remover
    public boolean remover(String id) {
        String sql = "DELETE FROM doses_aplicadas WHERE id = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
