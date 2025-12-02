package com.classes.BO;

import com.classes.DAO.DoseDAO;
import modelos.DoseAplicada;
import java.util.List;

public class DoseBO {

    private DoseDAO dao = new DoseDAO();

    // Regras de negócio:
    // - Impedir dose 2 antes da dose 1
    // - Impedir dose 3 antes da dose 2
    // - Impedir aplicação sem intervalo mínimo (exemplo: 20 dias)
    // - Impedir duas doses da mesma vacina no mesmo dia

    private static final int INTERVALO_MINIMO_DIAS = 20;

    public boolean adicionar(DoseAplicada d) {


        List<DoseAplicada> dosesPaciente = dao.listarPorPaciente(d.getCpfPaciente());

        if (d.getNumeroDose() == 2 && dosesPaciente.stream()
                .noneMatch(x -> x.getNumeroDose() == 1 && x.getVacinaId().equals(d.getVacinaId()))) {
            System.out.println("ERRO: Não é possível aplicar dose 2 sem dose 1.");
            return false;
        }

        // Regra 2 — impedir dose 3 antes da dose 2
        if (d.getNumeroDose() == 3 && dosesPaciente.stream()
                .noneMatch(x -> x.getNumeroDose() == 2 && x.getVacinaId().equals(d.getVacinaId()))) {
            System.out.println("ERRO: Não é possível aplicar dose 3 sem dose 2.");
            return false;
        }

        // Regra 3 — impedir aplicação no mesmo dia da mesma vacina
        if (dosesPaciente.stream().anyMatch(x ->
                x.getVacinaId().equals(d.getVacinaId()) &&
                x.getData().equals(d.getData()))) {
            System.out.println("ERRO: Paciente já tomou essa vacina hoje.");
            return false;
        }

        // Regra 4 — impedir antes do intervalo mínimo
        if (!dosesPaciente.isEmpty()) {
            DoseAplicada ultima = dosesPaciente.get(dosesPaciente.size() - 1);

            int dias = calcularDias(ultima.getData(), d.getData());
            if (dias < INTERVALO_MINIMO_DIAS) {
                System.out.println("ERRO: Intervalo mínimo entre doses não respeitado. Faltam " +
                        (INTERVALO_MINIMO_DIAS - dias) + " dias.");
                return false;
            }
        }

        return dao.inserir(d);
    }

    public List<DoseAplicada> listar() { return dao.listar(); }

    public DoseAplicada buscarPorId(String id) { return dao.buscarPorId(id); }

    public List<DoseAplicada> listarPorPaciente(String cpf) { return dao.listarPorPaciente(cpf); }

    public boolean atualizar(String id, DoseAplicada nova) {
        if (id == null || nova == null) return false;
        return dao.atualizar(nova);
    }

    public boolean remover(String id) { return dao.remover(id); }


    // ------------------------
    // MÉTODO AUXILIAR PARA DIAS
    // ------------------------

    private int calcularDias(String data1, String data2) {
        // formato esperado: dd/MM/yyyy
        try {
            java.time.LocalDate d1 = java.time.LocalDate.parse(data1,
                    java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            java.time.LocalDate d2 = java.time.LocalDate.parse(data2,
                    java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            return (int) java.time.temporal.ChronoUnit.DAYS.between(d1, d2);

        } catch (Exception e) {
            return Integer.MAX_VALUE; // evita travar caso formato esteja incorreto
        }
    }
}
