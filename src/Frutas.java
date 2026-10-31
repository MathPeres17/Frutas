public abstract class Frutas {
    private String nome;
    private double preco;
    private int quantidade;

    public Frutas(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean vender(int quantidadeCompra) {
        if (quantidadeCompra <= 0 || quantidadeCompra > quantidade) {
            return false;
        }

        quantidade -= quantidadeCompra;
        return true;
    }

    public void exibirInformacoes() {
        System.out.printf(
            "%s | Preço: R$ %.2f por unidade | Disponível: %d%n",
            nome, preco, quantidade
        );
    }
}