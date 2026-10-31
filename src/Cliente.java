public class Cliente {
    private String nome;
    private String email;
    private String cpf;

    public Cliente(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void exibirCadastro() {
        System.out.println("Cliente: " + nome);
        System.out.println("E-mail: " + email);
        System.out.println("CPF: " + cpf);
    }

    public static Cliente[] preCadastrarClientes() {
        return new Cliente[] {
            new Cliente(
                "Ana Souza",
                "ana@email.com",
                "111.111.111-11"
            ),
            new Cliente(
                "Bruno Lima",
                "bruno@email.com",
                "222.222.222-22"
            ),
            new Cliente(
                "Carla Mendes",
                "carla@email.com",
                "333.333.333-33"
            )
        };
    }
}