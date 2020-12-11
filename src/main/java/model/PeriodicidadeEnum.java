package model;

public enum PeriodicidadeEnum {
    DESPESA_UNICA(0), SEMANAL(7), MENSAL(30);
    private final int valorPeriodicidade;

    public int getValorPeriodicidade() {
        return valorPeriodicidade;
    }


    PeriodicidadeEnum(int valor) {
        valorPeriodicidade = valor;
    }

}
