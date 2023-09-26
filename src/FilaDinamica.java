class NodeFila {
    int valor;
    NodeFila proximo;

    public NodeFila(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

public class FilaDinamica {
    private NodeFila inicio, fim;
    private int tamanho = 0;

    public void inserirNaFila(int valor) {
        NodeFila novoNode = new NodeFila(valor);
        if (estaVazia()) {
            inicio = fim = novoNode;
        } else {
            fim.proximo = novoNode;
            fim = novoNode;
        }
        tamanho++;
    }

    public int retirarDaFila() {
        if (estaVazia()) {
            System.out.println("Fila vazia! Não é possível retirar.");
            return -1;
        }
        int valorRetirado = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return valorRetirado;
    }

    public void imprimirFila() {
        imprimirRecursivo(inicio);
    }

    private void imprimirRecursivo(NodeFila nodeAtual) {
        if (nodeAtual != null) {
            System.out.println(nodeAtual.valor);
            imprimirRecursivo(nodeAtual.proximo);
        }
    }

    public int tamanhoFila() {
        return tamanho;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public static void main(String[] args) {
        FilaDinamica fila = new FilaDinamica();
        fila.inserirNaFila(10);
        fila.inserirNaFila(20);
        fila.inserirNaFila(30);
        fila.imprimirFila();
        fila.retirarDaFila();
        fila.imprimirFila();
        System.out.println("Tamanho da fila: " + fila.tamanhoFila());
    }
}
