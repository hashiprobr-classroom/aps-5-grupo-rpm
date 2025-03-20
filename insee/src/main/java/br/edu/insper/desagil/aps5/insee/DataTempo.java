package br.edu.insper.desagil.aps5.insee;

public class DataTempo extends Referencia{
    private Data data;
    private Tempo tempo;

    public DataTempo(Data data, Tempo tempo) {
        this.data = data;
        this.tempo = tempo;
    }

    public Data getData() {
        return data;
    }

    public Tempo getTempo() {
        return tempo;
    }

    @Override
    public int comoInteiro() {
        return (data.comoInteiro()*24*60) + tempo.comoInteiro();
    }

}
