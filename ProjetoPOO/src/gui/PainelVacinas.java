package gui;

import com.classes.BO.VacinaBO;
import modelos.Vacina;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PainelVacinas extends JPanel {

	private static final long serialVersionUID = 1L;
	private VacinaBO vacinaBO = new VacinaBO();
    private JTable tabela;
    private DefaultTableModel modelo;

    public PainelVacinas() {
        setLayout(new BorderLayout(8,8));
        setBorder(BorderFactory.createEmptyBorder(8,8,8,8));

        JLabel title = new JLabel("Vacinas", SwingConstants.LEFT);
        title.setFont(title.getFont().deriveFont(18f));
        add(title, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new String[]{"ID","Nome","Fabricante","Total Doses","Intervalo (dias)"}, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int r, int c){ return false; }
        };
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

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

        btnRefresh.addActionListener(e -> carregar());
        btnNovo.addActionListener(e -> novo());
        btnEditar.addActionListener(e -> editar());
        btnRemover.addActionListener(e -> remover());

        carregar();
    }

    private void carregar() {
        modelo.setRowCount(0);
        List<Vacina> lista = vacinaBO.listar();
        for (Vacina v : lista) {
            modelo.addRow(new Object[]{ v.getId(), v.getNome(), v.getFabricante(), v.getTotalDoses(), v.getIntervaloDias() });
        }
    }

    private void novo() {
        JTextField id = new JTextField();
        JTextField nome = new JTextField();
        JTextField fab = new JTextField();
        JTextField total = new JTextField();
        JTextField intv = new JTextField();

        Object[] form = {
            "ID:", id,
            "Nome:", nome,
            "Fabricante:", fab,
            "Total de doses:", total,
            "Intervalo (dias):", intv
        };

        int op = JOptionPane.showConfirmDialog(this, form, "Nova Vacina", JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            try {
                Vacina v = new Vacina(id.getText().trim(), nome.getText().trim(), fab.getText().trim(), Integer.parseInt(total.getText().trim()), Integer.parseInt(intv.getText().trim()));
                boolean ok = vacinaBO.adicionar(v);
                JOptionPane.showMessageDialog(this, ok ? "Vacina cadastrada." : "Falha ao cadastrar (verifique duplicidade).");
                if (ok) carregar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dados inválidos: " + ex.getMessage());
            }
        }
    }

    private void editar() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione uma vacina."); return; }
        String id = (String) modelo.getValueAt(sel, 0);
        Vacina v = vacinaBO.buscarPorId(id);
        if (v == null) { JOptionPane.showMessageDialog(this, "Não encontrada."); return; }

        JTextField nome = new JTextField(v.getNome());
        JTextField fab = new JTextField(v.getFabricante());
        JTextField total = new JTextField(String.valueOf(v.getTotalDoses()));
        JTextField intv = new JTextField(String.valueOf(v.getIntervaloDias()));

        Object[] form = {
            "Nome:", nome,
            "Fabricante:", fab,
            "Total de doses:", total,
            "Intervalo (dias):", intv
        };

        int op = JOptionPane.showConfirmDialog(this, form, "Editar Vacina - ID: " + v.getId(), JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            try {
                v.setNome(nome.getText().trim());
                v.setFabricante(fab.getText().trim());
                v.setTotalDoses(Integer.parseInt(total.getText().trim()));
                v.setIntervaloDias(Integer.parseInt(intv.getText().trim()));
                boolean ok = vacinaBO.atualizar(v.getId(), v);
                JOptionPane.showMessageDialog(this, ok ? "Atualizado." : "Falha.");
                if (ok) carregar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        }
    }

    private void remover() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione uma vacina."); return; }
        String id = (String) modelo.getValueAt(sel, 0);
        int conf = JOptionPane.showConfirmDialog(this, "Remover vacina " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            boolean ok = vacinaBO.remover(id);
            JOptionPane.showMessageDialog(this, ok ? "Removida." : "Erro ao remover.");
            if (ok) carregar();
        }
    }
}
