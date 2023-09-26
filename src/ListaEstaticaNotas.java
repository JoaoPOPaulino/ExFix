import java.util.Arrays;

public class ListaEstaticaNotas {
    private double[] notas;
    private int totalInseridos;

    public ListaEstaticaNotas(int capacidade) {
        notas = new double[capacidade];
        totalInseridos = 0;
    }

    public void inserirNotas(double nota) {
        if (totalInseridos < notas.length) {
            notas[totalInseridos] = nota;
            totalInseridos++;
        } else {
            System.out.println("Lista cheia!");
        }
    }

    public void imprimirNotasOrdenadas() {
        double[] copiaNotas = notas.clone();
        Arrays.sort(copiaNotas, 0, totalInseridos);
        for (int i = 0; i < totalInseridos; i++) {
            System.out.println(copiaNotas[i]);
        }
    }

    public void imprimirMaiorNota() {
        double maiorNota = Double.MIN_VALUE;
        for (int i = 0; i < totalInseridos; i++) {
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }
        System.out.println("Maior nota é: " + maiorNota);
    }

    public void imprimirMenorNota() {
        double menorNota = Double.MAX_VALUE;
        for (int i = 0; i < totalInseridos; i++) {
            if (notas[i] < menorNota) {
                menorNota = notas[i];
            }
        }
        System.out.println("Menor notá é: " + menorNota);
    }

    public static void main(String[] args) {
        ListaEstaticaNotas lista = new ListaEstaticaNotas(5);
        lista.inserirNotas(8.0);
        lista.inserirNotas(5.5);
        lista.inserirNotas(9.5);
        lista.imprimirNotasOrdenadas();
        lista.imprimirMaiorNota();
        lista.imprimirMenorNota();
    }
}
