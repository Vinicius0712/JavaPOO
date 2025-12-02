package gui;

import com.classes.BO.DoseBO;
import modelos.DoseAplicada;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PainelDoses extends JPanel {

	private static final long serialVersionUID = 1L;
	private DoseBO doseBO = new DoseBO();
    private JTable tabela;
    private DefaultTableModel modelo;

    public PainelDoses() {
        setLayout(new BorderLayout(8,8));
        setBorder(BorderFactory.createEmptyBorder(8,8,8,8));

        JLabel title = new JLabel("Doses Aplicadas", SwingConstants.LEFT);
        title.setFont(title.getFont().deriveFont(18f));
        add(title, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new String[]{"ID","Data","Unidade","Profissional","Lote","Dose","CPF Paciente","Vacina ID"}, 0) {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int r,int c){return false;}
        };
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnRegistrar = new JButton("Registrar Dose");
        JButton btnRefresh = new JButton("Atualizar");
        JButton btnRemover = new JButton("Remover");

        botoes.add(btnRegistrar); botoes.add(btnRefresh); botoes.add(btnRemover);
        add(botoes, BorderLayout.SOUTH);

        btnRefresh.addActionListener(e -> carregar());
        btnRegistrar.addActionListener(e -> registrarDose());
        btnRemover.addActionListener(e -> removerSelecionado());

        carregar();
    }

    private void carregar() {
        modelo.setRowCount(0);
        List<DoseAplicada> lista = doseBO.listar();
        for (DoseAplicada d : lista) {
            modelo.addRow(new Object[]{
                d.getId(), d.getData(), d.getUnidadeId(), d.getProfissionalId(),
                d.getLote(), d.getNumeroDose(), d.getCpfPaciente(), d.getVacinaId()
            });
        }
    }

    private void registrarDose() {
        JTextField cpf = new JTextField();
        JTextField vacinaId = new JTextField();
        JTextField nroDose = new JTextField();
        JTextField data = new JTextField();
        JTextField profId = new JTextField();
        JTextField unidadeId = new JTextField();
        JTextField lote = new JTextField();

        Object[] form = {
            "CPF do paciente:", cpf,
            "ID da vacina:", vacinaId,
            "Número da dose:", nroDose,
            "Data (AAAA-MM-DD):", data,
            "ID do profissional:", profId,
            "ID da unidade:", unidadeId,
            "Lote (opcional):", lote
        };

        int op = JOptionPane.showConfirmDialog(this, form, "Registrar Dose", JOptionPane.OK_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {
            try {
                int nd = Integer.parseInt(nroDose.getText().trim());
                DoseAplicada d = new DoseAplicada(
                        data.getText().trim(),
                        unidadeId.getText().trim(),
                        profId.getText().trim(),
                        lote.getText().trim(),
                        nd,
                        cpf.getText().trim(),
                        vacinaId.getText().trim()
                );

                boolean ok = doseBO.adicionar(d);
                JOptionPane.showMessageDialog(this, ok ? "Dose registrada." : "Falha ao registrar (regras/ constraints).");
                if (ok) carregar();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Número da dose inválido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        }
    }

    private void removerSelecionado() {
        int sel = tabela.getSelectedRow();
        if (sel < 0) { JOptionPane.showMessageDialog(this, "Selecione uma dose."); return; }
        String id = String.valueOf(modelo.getValueAt(sel, 0));
        int conf = JOptionPane.showConfirmDialog(this, "Remover dose id=" + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            boolean ok = doseBO.remover(id);
            JOptionPane.showMessageDialog(this, ok ? "Removida." : "Falha ao remover.");
            if (ok) carregar();
        }
    }
}
