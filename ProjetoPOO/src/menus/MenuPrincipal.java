package menus;

import java.util.List;
import java.util.Scanner;

import com.classes.BO.*;
import modelos.*;

public class MenuPrincipal {

    private Scanner sc = new Scanner(System.in);
    
    private PacienteBO pacienteBO = new PacienteBO();
    private VacinaBO vacinaBO = new VacinaBO();
    private ProfissionalBO profissionalBO = new ProfissionalBO();
    private UnidadeBO unidadeBO = new UnidadeBO();
    private DoseBO doseBO = new DoseBO();

    public void iniciar() {
        int opc;
        do {
            System.out.println("\n===== SISTEMA DE VACINAS =====");
            System.out.println("1 - Pacientes");
            System.out.println("2 - Vacinas");
            System.out.println("3 - Profissionais");
            System.out.println("4 - Unidades");
            System.out.println("5 - Doses aplicadas");
            System.out.println("6 - Histórico do paciente");
            System.out.println("7 - Verificar pendências");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1 -> menuPacientes();
                case 2 -> menuVacinas();
                case 3 -> menuProfissionais();
                case 4 -> menuUnidades();
                case 5 -> menuDoses();
                case 6 -> historicoPaciente();
                case 7 -> verificarPendencias();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opc != 0);
    }

    // ===========================================================
    //                        PACIENTES
    // ===========================================================
    private void menuPacientes() {
        int op;
        do {
            System.out.println("\n-- PACIENTES --");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por CPF");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> cadastrarPaciente();
                case 2 -> pacienteBO.listar().forEach(System.out::println);
                case 3 -> {
                    System.out.print("CPF: ");
                    System.out.println(pacienteBO.buscarPorCpf(sc.nextLine()));
                }
                case 4 -> atualizarPaciente();
                case 5 -> {
                    System.out.print("CPF: ");
                    System.out.println(pacienteBO.remover(sc.nextLine()) ? "Removido." : "Erro.");
                }
                case 0 -> {}
                default -> System.out.println("Inválido.");
            }

        } while (op != 0);
    }

    private void cadastrarPaciente() {
        System.out.print("CPF: ");    String cpf = sc.nextLine();
        System.out.print("Nome: ");   String nome = sc.nextLine();
        System.out.print("Sexo: ");   String sexo = sc.nextLine();
        System.out.print("Idade: ");  int idade = Integer.parseInt(sc.nextLine());
        System.out.print("Nascimento (YYYY-MM-DD): "); String nasc = sc.nextLine();

        Paciente p = new Paciente(nome, sexo, idade, cpf, nasc);
        System.out.println(pacienteBO.adicionar(p) ? "Cadastrado." : "Falha.");
    }

    private void atualizarPaciente() {
        System.out.print("CPF a atualizar: ");
        String cpf = sc.nextLine();

        Paciente atual = pacienteBO.buscarPorCpf(cpf);
        if (atual == null) { System.out.println("Não encontrado."); return; }

        System.out.print("Novo nome: ");
        String n = sc.nextLine(); if (!n.isBlank()) atual.setNome(n);

        System.out.print("Novo sexo: ");
        String s = sc.nextLine(); if (!s.isBlank()) atual.setSexo(s);

        System.out.print("Nova idade: ");
        String ni = sc.nextLine(); if (!ni.isBlank()) atual.setIdade(Integer.parseInt(ni));

        System.out.print("Nova data nasc: ");
        String dn = sc.nextLine(); if (!dn.isBlank()) atual.setDataNascimento(dn);

        System.out.println(pacienteBO.atualizar(cpf, atual) ? "Atualizado." : "Erro.");
    }

    // ===========================================================
    //                        VACINAS
    // ===========================================================
    private void menuVacinas() {
        int op;
        do {
            System.out.println("\n-- VACINAS --");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("0 - Voltar");

            op = Integer.parseInt(sc.nextLine());
            switch(op) {
                case 1 -> cadastrarVacina();
                case 2 -> vacinaBO.listar().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID da vacina: ");
                    System.out.println(vacinaBO.buscarPorId(sc.nextLine()));
                }
                case 4 -> atualizarVacina();
                case 5 -> {
                    System.out.print("ID: ");
                    System.out.println(vacinaBO.remover(sc.nextLine()) ? "Removida." : "Erro.");
                }
                case 0 -> {}
                default -> System.out.println("Inválido.");
            }

        } while (op != 0);
    }

    private void cadastrarVacina() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Nome da vacina: ");
        String nome = sc.nextLine();

        System.out.print("Fabricante: ");
        String fab = sc.nextLine();

        System.out.print("Doses necessárias: ");
        int total = Integer.parseInt(sc.nextLine());

        System.out.print("Intervalo (dias): ");
        int intv = Integer.parseInt(sc.nextLine());

        Vacina v = new Vacina(id, nome, fab, total, intv);

        System.out.println(vacinaBO.adicionar(v) ? "Cadastrada." : "Erro.");
    }


    private void atualizarVacina() {
        System.out.print("ID da vacina: ");
        String id = sc.nextLine();

        Vacina atual = vacinaBO.buscarPorId(id);
        if (atual == null) { System.out.println("Não encontrada."); return; }

        System.out.print("Novo fabricante: ");
        String n1 = sc.nextLine();
        if (!n1.isBlank()) atual.setFabricante(n1);

        System.out.print("Novo total doses: ");
        String n2 = sc.nextLine();
        if (!n2.isBlank()) atual.setTotalDoses(Integer.parseInt(n2));

        System.out.print("Novo intervalo: ");
        String n3 = sc.nextLine();
        if (!n3.isBlank()) atual.setIntervaloDias(Integer.parseInt(n3));

        System.out.println(vacinaBO.atualizar(id, atual) ? "Atualizada." : "Erro.");
    }

    private void menuDoses() {
        int op;
        do {
            System.out.println("\n-- DOSES APLICADAS --");
            System.out.println("1 - Registrar nova dose");
            System.out.println("2 - Listar todas as doses");
            System.out.println("3 - Listar por CPF do paciente");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> registrarDose();
                case 2 -> doseBO.listar().forEach(System.out::println);
                case 3 -> {
                    System.out.print("CPF: ");
                    doseBO.listarPorPaciente(sc.nextLine()).forEach(System.out::println);
                }
                case 0 -> {}
                default -> System.out.println("Inválido.");
            }

        } while (op != 0);
    }

    private void registrarDose() {
        System.out.print("CPF do paciente: ");
        String cpf = sc.nextLine();

        System.out.print("ID da vacina: ");
        String vacinaId = sc.nextLine();

        System.out.print("Número da dose: ");
        int numDose = Integer.parseInt(sc.nextLine());

        System.out.print("Data (AAAA-MM-DD): ");
        String data = sc.nextLine();

        System.out.print("ID do profissional responsável: ");
        String profissionalId = sc.nextLine();

        System.out.print("ID da unidade: ");
        String unidadeId = sc.nextLine();

        // lote opcional → enviar string vazia
        String lote = "";

        DoseAplicada d = new DoseAplicada(
            data,
            unidadeId,
            profissionalId,
            lote,
            numDose,
            cpf,
            vacinaId
        );

        boolean resultado = doseBO.adicionar(d);
        System.out.println(resultado ? "Dose registrada com sucesso!" : "Falha ao registrar dose.");
    }


    
    private void menuProfissionais() {
        int op;
        do {
            System.out.println("\n-- PROFISSIONAIS --");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> cadastrarProfissional();
                case 2 -> profissionalBO.listar().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID: ");
                    System.out.println(profissionalBO.buscarPorId(sc.nextLine()));
                }
                case 4 -> atualizarProfissional();
                case 5 -> {
                    System.out.print("ID: ");
                    System.out.println(
                        profissionalBO.remover(sc.nextLine())
                            ? "Removido."
                            : "Erro ao remover."
                    );
                }
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    private void cadastrarProfissional() {
        System.out.println("ID: ");
        String id = sc.nextLine();

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Cargo / Registro: ");
        String cargo = sc.nextLine();

        ProfissionalSaude p = new ProfissionalSaude(id, nome, cargo);

        if (profissionalBO.adicionar(p))
            System.out.println("Cadastrado.");
        else
            System.out.println("Falha ao cadastrar.");
    }

    private void atualizarProfissional() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        ProfissionalSaude atual = profissionalBO.buscarPorId(id);
        if (atual == null) {
            System.out.println("Não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        String n1 = sc.nextLine();
        if (!n1.isBlank()) atual.setNome(n1);

        System.out.print("Novo cargo/registro: ");
        String n2 = sc.nextLine();
        if (!n2.isBlank()) atual.setRegistro(n2);

        System.out.println(profissionalBO.atualizar(id, atual)
            ? "Atualizado."
            : "Erro ao atualizar.");
    }

    private void menuUnidades() {
        int op;
        do {
            System.out.println("\n-- UNIDADES DE SAÚDE --");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> cadastrarUnidade();
                case 2 -> unidadeBO.listar().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID: ");
                    System.out.println(unidadeBO.buscarPorId(sc.nextLine()));
                }
                case 4 -> atualizarUnidade();
                case 5 -> {
                    System.out.print("ID: ");
                    System.out.println(
                        unidadeBO.remover(sc.nextLine())
                            ? "Removida."
                            : "Erro ao remover."
                    );
                }
                case 0 -> {}
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    private void cadastrarUnidade() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        UnidadeSaude u = new UnidadeSaude(id, nome, endereco);

        if (unidadeBO.adicionar(u))
            System.out.println("Cadastrada.");
        else
            System.out.println("Falha ao cadastrar.");
    }

    private void atualizarUnidade() {
        System.out.print("ID: ");
        String id = sc.nextLine();

        UnidadeSaude atual = unidadeBO.buscarPorId(id);
        if (atual == null) {
            System.out.println("Não encontrada.");
            return;
        }

        System.out.print("Novo nome: ");
        String n1 = sc.nextLine();
        if (!n1.isBlank()) atual.setNome(n1);

        System.out.print("Novo endereço: ");
        String n2 = sc.nextLine();
        if (!n2.isBlank()) atual.setEndereco(n2);

        System.out.println(
            unidadeBO.atualizar(id, atual)
                ? "Atualizada."
                : "Erro ao atualizar."
        );
    }



    // ===========================================================
    //                    HISTÓRICO / PENDÊNCIAS
    // ===========================================================
    private void historicoPaciente() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        List<DoseAplicada> doses = doseBO.listarPorPaciente(cpf);
        if (doses.isEmpty()) { System.out.println("Nenhuma dose encontrada."); return; }

        doses.forEach(System.out::println);
    }

    private void verificarPendencias() {
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        List<DoseAplicada> aplicadas = doseBO.listarPorPaciente(cpf);

        System.out.println("\n--- SITUAÇÃO VACINAL ---");
        for (Vacina v : vacinaBO.listar()) {
            long qtd = aplicadas.stream()
                    .filter(d -> d.getVacinaId().equalsIgnoreCase(v.getId()))
                    .count();

            if (qtd >= v.getTotalDoses())
                System.out.println(v.getId() + ": COMPLETA");
            else
                System.out.println(v.getId() + ": faltam " + (v.getTotalDoses() - qtd) + " dose(s)");
        }
    }
}
