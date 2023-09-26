class Node {
    int valor;
    Node proximo;

    public Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

public class PilhaDinamica {
    private Node topo = null;
    private int tamanho = 0;

    public void inserirNaPilha(int valor) {
        Node novoNode = new Node(valor);
        if (topo == null) {
            topo = novoNode;
        } else {
            novoNode.proximo = topo;
            topo = novoNode;
        }
        tamanho++;
    }

    public int retirarDaPilha() {
        if (estaVazia()) {
            System.out.println("Pilha vazia! Não é possível retirar.");
            return -1;
        }
        int valorRetirado = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valorRetirado;
    }

    public void imprimirPilha() {
        imprimirRecursivo(topo);
    }

    private void imprimirRecursivo(Node nodeAtual) {
        if (nodeAtual != null) {
            System.out.println(nodeAtual.valor);
            imprimirRecursivo(nodeAtual.proximo);
        }
    }

    public int tamanhoPilha() {
        return tamanho;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public static void main(String[] args) {
        PilhaDinamica pilha = new PilhaDinamica();
        pilha.inserirNaPilha(10);
        pilha.inserirNaPilha(20);
        pilha.inserirNaPilha(30);
        pilha.imprimirPilha();
        pilha.retirarDaPilha();
        pilha.imprimirPilha();
        System.out.println("Tamanho da pilha: " + pilha.tamanhoPilha());
    }
}
