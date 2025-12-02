package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
    private JPanel panelContainer;

    public MainWindow() {
        setTitle("Sistema de Vacinação - Interface Gráfica");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // MENU LATERAL
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(8, 1, 6, 6));
        menu.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        menu.setPreferredSize(new Dimension(220, 0));

        JButton btnHome = new JButton("Home");
        JButton btnPacientes = new JButton("Pacientes");
        JButton btnVacinas = new JButton("Vacinas");
        JButton btnDoses = new JButton("Doses");
        JButton btnProfissionais = new JButton("Profissionais");
        JButton btnUnidades = new JButton("Unidades");
        JButton btnSair = new JButton("Sair");

        menu.add(btnHome);
        menu.add(btnPacientes);
        menu.add(btnVacinas);
        menu.add(btnDoses);
        menu.add(btnProfissionais);
        menu.add(btnUnidades);
        menu.add(btnSair);

        add(menu, BorderLayout.WEST);

        // ÁREA PRINCIPAL
        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);

        panelContainer.add(new JLabel("<html><h1 style='text-align:center'>Bem-vindo ao Sistema de Vacinação</h1><p style='text-align:center'>Use o menu à esquerda para navegar</p></html>", SwingConstants.CENTER), "home");
        panelContainer.add(new PainelPacientes(), "pacientes");
        panelContainer.add(new PainelVacinas(), "vacinas");
        panelContainer.add(new PainelDoses(), "doses");
        panelContainer.add(new PainelProfissionais(), "profissionais");
        panelContainer.add(new PainelUnidades(), "unidades");

        add(panelContainer, BorderLayout.CENTER);

        // EVENTOS BOTÕES
        btnHome.addActionListener(e -> cardLayout.show(panelContainer, "home"));
        btnPacientes.addActionListener(e -> cardLayout.show(panelContainer, "pacientes"));
        btnVacinas.addActionListener(e -> cardLayout.show(panelContainer, "vacinas"));
        btnDoses.addActionListener(e -> cardLayout.show(panelContainer, "doses"));
        btnProfissionais.addActionListener(e -> cardLayout.show(panelContainer, "profissionais"));
        btnUnidades.addActionListener(e -> cardLayout.show(panelContainer, "unidades"));
        btnSair.addActionListener(e -> {
            int conf = JOptionPane.showConfirmDialog(this, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) System.exit(0);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
