package gui;

import com.classes.BO.ProfissionalBO;
import modelos.ProfissionalSaude;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PainelProfissionais extends JPanel {

	private static final long serialVersionUID = 1L;
	private ProfissionalBO profissionalBO = new ProfissionalBO();
    private JTable tabela;
    private DefaultTableModel modelo;

    public PainelProfissionais() {
        setLayout(new BorderLayout(8,8));
        setBorder(BorderFactory.createEmptyBorder(8,8,8,8));

        JLabel title = new JLabel("Profissionais de Saúde", SwingConstants.LEFT);
        title.setFont(title.getFont().deriveFont(18f));
        add(title, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new String[]{"ID","Nome","Registro/Cargo"}, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int r,int c){ return false; }
        };
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnNovo = new JButton("Novo");
        JButton btnEditar = new JButton("Editar");
        JButton btnRemover = new JButton("Remover");
        JButton btnRefresh = new JButton("Atualizar");

        botoes.add(btnNovo); botoes.add(btnEditar); botoes.add(btnRemover); botoes.add(btnRefresh);
        add(botoes, BorderLayout.SOUTH);

        btnRefresh.addActionListener(e -> carregar());
        btnNovo.addActionListener(e -> novo());
        btnEditar.addActionListener(e -> editar());
        btnRemover.addActionListener(e -> remover());

        carregar();
    }

    private void carregar() {
        modelo.setRowCount(0);
        List<ProfissionalSaude> lista = profissionalBO.listar();
        for (ProfissionalSaude p : lista) {
            modelo.addRow(new Object[]{ p.getId(), p.getNome(), p.getRegistro() });
        }
    }

    private void novo() {
        JTextField id = new JTextField();
        JTextField nome = new JTextField();
        JTextField reg = new JTextField();

        Object[] form = { "ID:", id, "Nome:", nome, "Registro/Cargo:", reg };
        int op = JOptionPane.showConfirmDialog(this, form, "Novo Profissional", JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            ProfissionalSaude p = new ProfissionalSaude(id.getText().trim(), nome.getText().trim(), reg.getText().trim());
            boolean ok = profissionalBO.adicionar(p);
            JOptionPane.showMessageDialog(this, ok ? "Cadastrado." : "Falha ao cadastrar.");
            if (ok) carregar();
        }
    }

    private void editar() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione um profissional."); return; }
        String id = (String) modelo.getValueAt(sel, 0);
        ProfissionalSaude p = profissionalBO.buscarPorId(id);
        if (p == null) { JOptionPane.showMessageDialog(this, "Não encontrado."); return; }

        JTextField nome = new JTextField(p.getNome());
        JTextField reg = new JTextField(p.getRegistro());
        Object[] form = { "Nome:", nome, "Registro/Cargo:", reg };
        int op = JOptionPane.showConfirmDialog(this, form, "Editar Profissional - ID: " + id, JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            p.setNome(nome.getText().trim());
            p.setRegistro(reg.getText().trim());
            boolean ok = profissionalBO.atualizar(id, p);
            JOptionPane.showMessageDialog(this, ok ? "Atualizado." : "Falha.");
            if (ok) carregar();
        }
    }

    private void remover() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione um profissional."); return; }
        String id = (String) modelo.getValueAt(sel, 0);
        int conf = JOptionPane.showConfirmDialog(this, "Remover profissional " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            boolean ok = profissionalBO.remover(id);
            JOptionPane.showMessageDialog(this, ok ? "Removido." : "Erro.");
            if (ok) carregar();
        }
    }
}
