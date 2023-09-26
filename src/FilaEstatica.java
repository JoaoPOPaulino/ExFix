public class FilaEstatica {
    private int[] fila;
    private int inicio, fim;
    private static final int CAPACIDADE = 100;

    public FilaEstatica() {
        this(CAPACIDADE);
    }

    public FilaEstatica(int capacidade) {
        fila = new int[capacidade];
        inicio = 0;
        fim = -1;
    }

    public void inserirNaFila(int valor) {
        if (fim == fila.length - 1) {
            System.out.println("Fila cheia! Não é possível inserir.");
            return;
        }
        fila[++fim] = valor;
    }

    public int retirarDaFila() {
        if (estaVazia()) {
            System.out.println("Fila vazia! Não é possível retirar.");
            return -1;
        }
        int valorRetirado = fila[inicio++];
        if (inicio > fim) {
            inicio = 0;
            fim = -1;
        }
        return valorRetirado;
    }

    public void imprimirFila() {
        imprimirRecursivo(inicio);
    }

    private void imprimirRecursivo(int index) {
        if (index <= fim) {
            System.out.println(fila[index]);
            imprimirRecursivo(index + 1);
        }
    }

    public int tamanhoFila() {
        return fim - inicio + 1;
    }

    public boolean estaVazia() {
        return fim == -1;
    }

    public static void main(String[] args) {
        FilaEstatica fila = new FilaEstatica();
        fila.inserirNaFila(10);
        fila.inserirNaFila(20);
        fila.inserirNaFila(30);
        fila.imprimirFila();
        fila.retirarDaFila();
        fila.imprimirFila();
        System.out.println("Tamanho da fila: " + fila.tamanhoFila());
    }
}
