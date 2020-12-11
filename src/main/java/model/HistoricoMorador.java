package model;

import collection.MoradorDeRepublicaCollection;

import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public class HistoricoMorador {

    private final TreeSet<MoradorDeRepublica> historicoMoradia;

    public SortedSet<MoradorDeRepublica> getHistoricoMoradia() {
        return historicoMoradia;
    }

    public HistoricoMorador(SortedSet<MoradorDeRepublica> historicoMoradia) {
        this.historicoMoradia = (TreeSet<MoradorDeRepublica>) historicoMoradia;
    }

    @Override
    public String toString() {
       String resultadoFinal = "[";

       for (MoradorDeRepublica moradorDeRepublica : historicoMoradia) {
           Optional<MoradorDeRepublica> morador = MoradorDeRepublicaCollection
                   .getRepresentanteRepublica(moradorDeRepublica.getRepublica());

           if (morador.isEmpty()) {
               return "Nenhum histórico do morado";
           }

           Pessoa representante = morador.get().getPessoa();


           resultadoFinal = resultadoFinal.concat(
                   "\n{" +
                           "nomeRepublica: " + moradorDeRepublica.getRepublica().getNome() +
                           "\nrepresentateAtual: " + representante.getNome() +
                           "\ncontatoRepresentante: " + representante.getTelefone() +
                           "\nreputacao: " + moradorDeRepublica.calcularReputacao() +
                   "\n}"

           );
       }

       resultadoFinal = resultadoFinal.concat("\n]");
       return resultadoFinal;
    }

}
