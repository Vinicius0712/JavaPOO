package com.classes.DAO;

import modelos.Paciente;
import com.classes.Conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

	public boolean inserir(Paciente p) {
	    String sql = "INSERT INTO pacientes (cpf, nome, data_nascimento, sexo, idade) VALUES (?, ?, ?, ?, ?)";

	    try (Connection c = Conexao.conectar();
	         PreparedStatement ps = c.prepareStatement(sql)) {

	        ps.setString(1, p.getCpf());
	        ps.setString(2, p.getNome());

	        // data_nascimento é NOT NULL
	        ps.setDate(3, Date.valueOf(p.getDataNascimento()));

	        ps.setString(4, p.getSexo());
	        ps.setString(5, String.valueOf(p.getIdade()));

	        ps.executeUpdate();
	        return true;

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false;
	    }
	}


    public List<Paciente> listar() {
        String sql = "SELECT cpf, nome, data_nascimento, sexo, idade FROM pacientes";
        List<Paciente> res = new ArrayList<>();

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Paciente p = new Paciente(
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getDate("data_nascimento") == null ? null : rs.getDate("data_nascimento").toString()
                );

                p.setSexo(rs.getString("sexo"));
                p.setIdade(rs.getInt("idade"));

                res.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public Paciente buscarPorCpf(String cpf) {
        String sql = "SELECT cpf, nome, data_nascimento, sexo, idade FROM pacientes WHERE cpf = ?";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, cpf);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    Date n = rs.getDate("data_nascimento");

                    Paciente p = new Paciente(
                            rs.getString("cpf"),
                            rs.getString("nome"),
                            n == null ? null : n.toString()
                    );
                    p.setSexo(rs.getString("sexo"));
                    p.setIdade(rs.getInt("idade"));

                    return p;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean atualizar(Paciente p) {
        String sql = "UPDATE pacientes SET nome = ?, data_nascimento = ? WHERE cpf = ?";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            
            if (p.getDataNascimento() != null)
                ps.setDate(2, Date.valueOf(p.getDataNascimento()));
            else
                ps.setNull(2, Types.DATE);

            ps.setString(3, p.getCpf());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean remover(String cpf) {
        String sql = "DELETE FROM pacientes WHERE cpf = ?";

        try (Connection c = Conexao.conectar();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, cpf);
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
