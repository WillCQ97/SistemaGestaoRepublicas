package business;

import builder.MoradorDeRepublicaBuilder;
import collection.MoradorDeRepublicaCollection;
import collection.RepublicaCollection;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Classe responsável por criar uma república à partir de um usuário, tornando-o administrador da república criada
 * e removendo-o de outra república caso esteja associado.
 */
public class RepublicaCreator {

    private RepublicaCreator() {

    }

    /**
     *
     * @param criador O Criador da república
     * @param nome O nome da nova república
     * @param vantagens Lista de vantagens da nova república
     * @param vagas O número de vagas disponíveis
     * @param receitaColetiva A receita coletiva inicial
     * @param endereco O Endereço da república
     * @return A república criada
     */
    public static Republica createRepublica(
            Pessoa criador,
            String nome,
            String[] vantagens,
            int vagas,
            double receitaColetiva,
            Endereco endereco
    ) {

        LocalDate dataFundacao = LocalDate.now();
        ArrayList<String> listaVantagens = new ArrayList<>(Arrays.asList(vantagens));
        Republica republica = new Republica()
                .comNome(nome)
                .comDataFundacao(dataFundacao)
                .comVantagens(listaVantagens)
                .comEndereco(endereco)
                .comVagas(vagas)
                .comReceitaColetiva(receitaColetiva);
        return addRepublica(republica, criador);
    }

    /**
     * Cria um MoradorDeRepublica para a republica e pessoa passadas como parâmetro e adiciona ambos às respectivas
     * collections.
     * @param republica A república criada pela pessoa.
     * @param criador A pessoa criadora da repúblcia
     * @return A república criada.
     */
    private static Republica addRepublica(Republica republica, Pessoa criador) {
        addMoradorDeRepublica(republica, criador);
        RepublicaCollection.addRepublica(republica);
        return republica;
    }

    private static void addMoradorDeRepublica(Republica republica, Pessoa criador) {
        removerRepublicaAnterior(criador);

        MoradorDeRepublicaBuilder builder = new MoradorDeRepublicaBuilder();
        builder.addPessoa(criador, true);
        builder.addRepublica(republica);
        MoradorDeRepublica novoMoradorDeRepublica = builder.getResultado();

        MoradorDeRepublicaCollection.addMoradorDeRepublica(novoMoradorDeRepublica);
    }

    /**
     * Remove a associação do criador da nova república com uma república antiga, encerrando seu tempo
     * de administração caso ele seja administrador da antiga república.
     * @param criador A pessoa criadora da nova república
     */
    private static void removerRepublicaAnterior(Pessoa criador) {
        Optional<MoradorDeRepublica> moradorDeRepublica = MoradorDeRepublicaCollection.getMoradorDeRepublica(criador);
        moradorDeRepublica.ifPresent(deRepublica -> {
            deRepublica.setAtual(false);
            if (deRepublica.isRepresentante()) {
                deRepublica.encerrarAdministracao();
            }
        });
    }
}
