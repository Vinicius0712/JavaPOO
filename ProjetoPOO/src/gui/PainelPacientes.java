package gui;

import com.classes.BO.PacienteBO;
import modelos.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PainelPacientes extends JPanel {
	private static final long serialVersionUID = 1L;
	private PacienteBO pacienteBO = new PacienteBO();
    private JTable tabela;
    private DefaultTableModel modelo;

    public PainelPacientes() {
        setLayout(new BorderLayout(8,8));
        setBorder(BorderFactory.createEmptyBorder(8,8,8,8));

        JLabel titulo = new JLabel("Pacientes", SwingConstants.LEFT);
        titulo.setFont(titulo.getFont().deriveFont(18f));
        add(titulo, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new String[]{"CPF","Nome","Sexo","Idade","Nascimento"}, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int col) { return false; }
        };
        tabela = new JTable(modelo);
        JScrollPane sp = new JScrollPane(tabela);
        add(sp, BorderLayout.CENTER);

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnNovo = new JButton("Novo");
        JButton btnEditar = new JButton("Editar");
        JButton btnRemover = new JButton("Remover");
        JButton btnRefresh = new JButton("Atualizar");

        botoes.add(btnNovo);
        botoes.add(btnEditar);
        botoes.add(btnRemover);
        botoes.add(btnRefresh);

        add(botoes, BorderLayout.SOUTH);

        // ações
        btnRefresh.addActionListener(e -> carregarTabela());
        btnNovo.addActionListener(e -> abrirFormularioNovo());
        btnEditar.addActionListener(e -> editarSelecionado());
        btnRemover.addActionListener(e -> removerSelecionado());

        carregarTabela();
    }

    private void carregarTabela() {
        modelo.setRowCount(0);
        List<Paciente> lista = pacienteBO.listar();
        for (Paciente p : lista) {
            modelo.addRow(new Object[]{ p.getCpf(), p.getNome(), p.getSexo(), p.getIdade(), p.getDataNascimento() });
        }
    }

    private void abrirFormularioNovo() {
        JTextField cpf = new JTextField();
        JTextField nome = new JTextField();
        JTextField sexo = new JTextField();
        JTextField idade = new JTextField();
        JTextField nasc = new JTextField();

        Object[] form = {
                "CPF (apenas números):", cpf,
                "Nome:", nome,
                "Sexo:", sexo,
                "Idade:", idade,
                "Nascimento (YYYY-MM-DD):", nasc
        };

        int opc = JOptionPane.showConfirmDialog(this, form, "Cadastrar Paciente", JOptionPane.OK_CANCEL_OPTION);
        if (opc == JOptionPane.OK_OPTION) {
            try {
                Paciente p = new Paciente(nome.getText().trim(), sexo.getText().trim(), Integer.parseInt(idade.getText().trim()), cpf.getText().trim(), nasc.getText().trim());
                boolean ok = pacienteBO.adicionar(p);
                JOptionPane.showMessageDialog(this, ok ? "Paciente cadastrado." : "Falha ao cadastrar (verifique CPF, duplicidade ou validade).");
                if (ok) carregarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dados inválidos: " + ex.getMessage());
            }
        }
    }

    private void editarSelecionado() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione um paciente."); return; }
        String cpf = (String) modelo.getValueAt(sel, 0);
        Paciente p = pacienteBO.buscarPorCpf(cpf);
        if (p == null) { JOptionPane.showMessageDialog(this, "Paciente não encontrado."); return; }

        JTextField nome = new JTextField(p.getNome());
        JTextField sexo = new JTextField(p.getSexo());
        JTextField idade = new JTextField(String.valueOf(p.getIdade()));
        JTextField nasc = new JTextField(p.getDataNascimento());

        Object[] form = {
                "Nome:", nome,
                "Sexo:", sexo,
                "Idade:", idade,
                "Nascimento (YYYY-MM-DD):", nasc
        };

        int opc = JOptionPane.showConfirmDialog(this, form, "Editar Paciente - CPF: " + p.getCpf(), JOptionPane.OK_CANCEL_OPTION);
        if (opc == JOptionPane.OK_OPTION) {
            try {
                p.setNome(nome.getText().trim());
                p.setSexo(sexo.getText().trim());
                p.setIdade(Integer.parseInt(idade.getText().trim()));
                p.setDataNascimento(nasc.getText().trim());
                boolean ok = pacienteBO.atualizar(p.getCpf(), p);
                JOptionPane.showMessageDialog(this, ok ? "Atualizado." : "Falha ao atualizar.");
                if (ok) carregarTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        }
    }

    private void removerSelecionado() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione um paciente."); return; }
        String cpf = (String) modelo.getValueAt(sel, 0);
        int conf = JOptionPane.showConfirmDialog(this, "Remover paciente " + cpf + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            boolean ok = pacienteBO.remover(cpf);
            JOptionPane.showMessageDialog(this, ok ? "Removido." : "Falha ao remover.");
            if (ok) carregarTabela();
        }
    }
}
