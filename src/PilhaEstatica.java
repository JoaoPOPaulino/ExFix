public class PilhaEstatica {
    private int[] pilha;
    private int topo;
    private static final int CAPACIDADE = 100;

    public PilhaEstatica() {
        this(CAPACIDADE);
    }

    public PilhaEstatica(int capacidade) {
        pilha = new int[capacidade];
        topo = -1;
    }

    public void inserirNaPilha(int valor) {
        if (topo == pilha.length - 1) {
            System.out.println("Pilha cheia! Não é possível inserir.");
            return;
        }
        pilha[++topo] = valor;
    }

    public int retirarDaPilha() {
        if (estaVazia()) {
            System.out.println("Pilha vazia! Não é possível retirar.");
            return -1;
        }
        return pilha[topo--];
    }

    public void imprimirPilha() {
        imprimirRecursivo(topo);
    }

    private void imprimirRecursivo(int index) {
        if (index >= 0) {
            System.out.println(pilha[index]);
            imprimirRecursivo(index - 1);
        }
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public static void main(String[] args) {
        PilhaEstatica pilha = new PilhaEstatica();
        pilha.inserirNaPilha(10);
        pilha.inserirNaPilha(20);
        pilha.inserirNaPilha(30);
        pilha.imprimirPilha();
        pilha.retirarDaPilha();
        pilha.imprimirPilha();
    }
}
