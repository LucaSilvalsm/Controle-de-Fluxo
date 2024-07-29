package candidatura;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.of("pt", "BR"));
        selecaoCandidatos();
    }

    public static void selecaoCandidatos() {
        String[] candidatos = {"Lucas", "Maria", "João", "Pedro", "Rafael", "Ana", "Isabella", "Julia", "Beatriz", "Luisa", "Vitoria", "Gabriela", "Luiz", "Isadora", "Carlos", "Daniela", "Thiago"};
        List<String> candidatosSelecionados = new ArrayList<>();
        int candidatoAtual = 0;
        double salarioBase = 1900.00;

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

        while (candidatosSelecionados.size() < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("Candidato: " + candidato + " Solicitou esse valor de salário: " + currencyFormat.format(salarioPretendido));
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato: " + candidato + " foi selecionado!");
                candidatosSelecionados.add(candidato);
            }
            candidatoAtual++;
        }

        // Exibe a lista dos 5 candidatos selecionados
        System.out.println("\nTotal de candidatos selecionados: " + candidatosSelecionados.size());
        System.out.println("Candidatos Selecionados:");
        for (String candidato : candidatosSelecionados) {
            System.out.println(candidato);
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2100);
    }

    public static void avaliarCandidato(double salarioPretendido) {
        double salarioBase = 1900.00;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o Candidato! Salário pretendido: " + currencyFormat.format(salarioPretendido));
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o Candidato para uma contra proposta! Salário pretendido: " + currencyFormat.format(salarioPretendido));
        } else {
            System.out.println("Aguardando mais candidatos! Salário pretendido: " + currencyFormat.format(salarioPretendido));
        }
    }
}
