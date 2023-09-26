import java.util.Arrays;

class Node {
    double nota;
    Node proximo;

    public Node(double nota) {
        this.nota = nota;
        this.proximo = null;
    }
}

public class ListaEncadeadaNotas {
    private Node cabeca = null;
    private int totalInseridos = 0;

    public void inserirNotas(double nota) {
        Node novoNode = new Node(nota);
        if (cabeca == null) {
            cabeca = novoNode;
        } else {
            Node atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNode;
        }
        totalInseridos++;
    }

    private void imprimirRecursivo(Node node) {
        if (node != null) {
            System.out.println(node.nota);
            imprimirRecursivo(node.proximo);
        }
    }

    public void imprimirNotasOrdenadas() {
        if (cabeca == null) {
            System.out.println("Lista vazia!");
            return;
        }

        double[] notasArray = new double[totalInseridos];
        Node atual = cabeca;
        int index = 0;
        while (atual != null) {
            notasArray[index++] = atual.nota;
            atual = atual.proximo;
        }

        Arrays.sort(notasArray);

        for (double nota : notasArray) {
            System.out.println(nota);
        }
    }

    public void imprimirMaiorNota() {
        double maxNota = Double.MIN_VALUE;
        Node atual = cabeca;
        while (atual != null) {
            if (atual.nota > maxNota) {
                maxNota = atual.nota;
            }
            atual = atual.proximo;
        }
        System.out.println("Maior Nota: " + maxNota);
    }

    public void imprimirMenorNota() {
        if (cabeca == null) {
            System.out.println("Lista vazia!");
            return;
        }
        double minNota = cabeca.nota;
        Node atual = cabeca;
        while (atual != null) {
            if (atual.nota < minNota) {
                minNota = atual.nota;
            }
            atual = atual.proximo;
        }
        System.out.println("Menor Nota: " + minNota);
    }

    public void imprimirQuantidadeDeNotasInseridas() {
        System.out.println("Total de notas inseridas: " + totalInseridos);
    }

    public static void main(String[] args) {
        ListaEncadeadaNotas lista = new ListaEncadeadaNotas();
        lista.inserirNotas(7.5);
        lista.inserirNotas(9.0);
        lista.inserirNotas(6.5);
        lista.imprimirMaiorNota();
        lista.imprimirMenorNota();
        lista.imprimirQuantidadeDeNotasInseridas();
    }
}
