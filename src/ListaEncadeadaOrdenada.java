class Node {
    double nota;
    Node proximo;

    public Node(double nota) {
        this.nota = nota;
        this.proximo = null;
    }
}

public class ListaEncadeadaOrdenada {
    private Node cabeca = null;

    public void inserirNotasInicio(double nota) {
        Node novoNode = new Node(nota);
        novoNode.proximo = cabeca;
        cabeca = novoNode;
    }

    public void inserirNotasMeio(double nota) {
        if (cabeca == null || cabeca.nota > nota) {
            inserirNotasInicio(nota);
            return;
        }

        Node atual = cabeca;
        while (atual.proximo != null && atual.proximo.nota < nota) {
            atual = atual.proximo;
        }

        Node novoNode = new Node(nota);
        novoNode.proximo = atual.proximo;
        atual.proximo = novoNode;
    }

    public void inserirNotasFim(double nota) {
        Node novoNode = new Node(nota);
        if (cabeca == null) {
            cabeca = novoNode;
            return;
        }

        Node atual = cabeca;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        atual.proximo = novoNode;
    }

    public void imprimirNotas() {
        imprimirRecursivo(cabeca);
    }

    private void imprimirRecursivo(Node node) {
        if (node != null) {
            System.out.println(node.nota);
            imprimirRecursivo(node.proximo);
        }
    }

    public void imprimirMediaNotas() {
        if (cabeca == null) {
            System.out.println("Lista vazia!");
            return;
        }

        double soma = 0;
        int contador = 0;
        Node atual = cabeca;
        while (atual != null) {
            soma += atual.nota;
            contador++;
            atual = atual.proximo;
        }

        System.out.println("Média das notas: " + (soma / contador));
    }

    public static void main(String[] args) {
        ListaEncadeadaOrdenada lista = new ListaEncadeadaOrdenada();
        lista.inserirNotasInicio(8.0);
        lista.inserirNotasMeio(7.5);
        lista.inserirNotasMeio(9.0);
        lista.inserirNotasFim(10.0);
        lista.imprimirNotas();
        lista.imprimirMediaNotas();
    }
}
