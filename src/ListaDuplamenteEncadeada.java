class NodeDuplo {
    double nota;
    NodeDuplo anterior;
    NodeDuplo proximo;

    public NodeDuplo(double nota) {
        this.nota = nota;
        this.anterior = null;
        this.proximo = null;
    }
}

public class ListaDuplamenteEncadeada {
    private NodeDuplo cabeca = null;
    private NodeDuplo cauda = null;

    public void inserirNotasInicio(double nota) {
        NodeDuplo novoNode = new NodeDuplo(nota);
        if (cabeca == null) {
            cabeca = novoNode;
            cauda = novoNode;
        } else {
            novoNode.proximo = cabeca;
            cabeca.anterior = novoNode;
            cabeca = novoNode;
        }
    }

    public void inserirNotasMeio(double nota) {
        if (cabeca == null || cabeca.nota > nota) {
            inserirNotasInicio(nota);
            return;
        }

        if (cauda.nota < nota) {
            inserirNotasFim(nota);
            return;
        }

        NodeDuplo atual = cabeca;
        while (atual != null && atual.nota < nota) {
            atual = atual.proximo;
        }

        NodeDuplo novoNode = new NodeDuplo(nota);
        novoNode.proximo = atual;
        novoNode.anterior = atual.anterior;
        atual.anterior.proximo = novoNode;
        atual.anterior = novoNode;
    }

    public void inserirNotasFim(double nota) {
        NodeDuplo novoNode = new NodeDuplo(nota);
        if (cauda == null) {
            cabeca = novoNode;
            cauda = novoNode;
        } else {
            novoNode.anterior = cauda;
            cauda.proximo = novoNode;
            cauda = novoNode;
        }
    }

    public void imprimirNotasOrdemDecrescente() {
        NodeDuplo atual = cauda;
        while (atual != null) {
            System.out.println(atual.nota);
            atual = atual.anterior;
        }
    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.inserirNotasInicio(8.0);
        lista.inserirNotasMeio(7.5);
        lista.inserirNotasMeio(9.0);
        lista.inserirNotasFim(10.0);
        lista.imprimirNotasOrdemDecrescente();
    }
}
