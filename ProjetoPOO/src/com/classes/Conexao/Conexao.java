package com.classes.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String NOME_DO_BANCO = "sistema_vacinas";
    private static final String URL = "jdbc:mysql://localhost:3306/" + NOME_DO_BANCO + "?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "banco123";

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
