import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.com.poliveira.classes.Pessoa;

/**
 * @author PatrickAOliveira
 *         App
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // ==========================================
        // PARTE 1: Nomes ordenados por ordem alfabética
        // ==========================================
        System.out.println("=== PARTE 1: Ordenação de Nomes ===");
        System.out.println("Digite os nomes separados por vírgula:");
        System.out.print("> ");
        String entradaParte1 = scanner.nextLine();

        List<Pessoa> listaNomesParte1 = processarNomes(entradaParte1);
        Collections.sort(listaNomesParte1);

        exibirParte1(listaNomesParte1);

        // ==========================================
        // PARTE 2: Nomes e Sexos separados por grupo
        // ==========================================
        System.out.println("\n=== PARTE 2: Separação por Grupo de Sexo ===");
        System.out.println("Digite nome e sexo (M/F) no formato 'Nome-Sexo' separados por vírgula");
        System.out.println("(ex: Pedro-M, Ana-F, Carlos-M, Beatriz-F):");
        System.out.print("> ");
        String entradaParte2 = scanner.nextLine();

        List<Pessoa> todasPessoas = processarPessoasComSexo(entradaParte2);

        // Listas para agrupar as pessoas por sexo
        List<Pessoa> grupoMasculino = new ArrayList<>();
        List<Pessoa> grupoFeminino = new ArrayList<>();

        for (Pessoa p : todasPessoas) {
            if (p.getSexo() != null && p.getSexo().equalsIgnoreCase("Masculino")) {
                grupoMasculino.add(p);
            } else if (p.getSexo() != null && p.getSexo().equalsIgnoreCase("Feminino")) {
                grupoFeminino.add(p);
            }
        }

        // Ordena cada grupo em ordem alfabética aproveitando o compareTo da classe
        // Pessoa
        Collections.sort(grupoMasculino);
        Collections.sort(grupoFeminino);

        exibirParte2(grupoMasculino, grupoFeminino);

        scanner.close();
    }

    /**
     * 
     * @param lista
     * @return
     */
    private static List<Pessoa> processarNomes(String lista) {
        List<Pessoa> nomes = new ArrayList<>();

        if (lista != null && !lista.trim().isEmpty()) {
            String[] partes = lista.split(",");
            for (String p : partes) {
                String nomeLimpo = p.trim();

                if (!nomeLimpo.isEmpty()) {
                    // Usa o construtor Pessoa(String nome)
                    nomes.add(new Pessoa(nomeLimpo));
                }
            }
        }

        return nomes;
    }

    /**
     * 
     * @param s
     * @return
     */
    private static List<Pessoa> processarPessoasComSexo(String s) {
        List<Pessoa> pessoas = new ArrayList<>();

        if (s != null && !s.trim().isEmpty()) {
            String[] itens = s.split(",");

            for (String item : itens) {
                String[] dados = item.trim().split("-");

                if (dados.length == 2) {
                    String nome = dados[0].trim();
                    String siglaSexo = dados[1].trim().toUpperCase();
                    String sexo = siglaSexo.equals("M") ? "Masculino" : (siglaSexo.equals("F") ? "Feminino" : "Outro");

                    // Usa o construtor Pessoa(String nome, String sexo)
                    pessoas.add(new Pessoa(nome, sexo));
                }
            }
        }
        return pessoas;
    }

    /**
     * 
     * @param nomes
     */
    private static void exibirParte1(List<Pessoa> nomes) {
        System.out.println("\n--- Nomes Ordenados Alfabeticamente ---");

        if (nomes.isEmpty()) {
            System.out.println("Nenhum nome inserido.");
        } else {
            for (int i = 0; i < nomes.size(); i++) {
                System.out.println((i + 1) + ". " + nomes.get(i));
            }
        }
    }

    /**
     * 
     * @param masculino
     * @param feminino
     */
    private static void exibirParte2(List<Pessoa> masculino, List<Pessoa> feminino) {
        System.out.println("\n--- Grupos Separados por Sexo ---");

        System.out.println("\nGrupo Masculino (" + masculino.size() + "):");
        if (masculino.isEmpty()) {
            System.out.println("  (Nenhum registro)");
        } else {
            for (Pessoa p : masculino) {
                System.out.println("  - " + p.getNome());
            }
        }

        System.out.println("\nGrupo Feminino (" + feminino.size() + "):");
        if (feminino.isEmpty()) {
            System.out.println("  (Nenhum registro)");
        } else {
            for (Pessoa p : feminino) {
                System.out.println("  - " + p.getNome());
            }
        }
    }
}
