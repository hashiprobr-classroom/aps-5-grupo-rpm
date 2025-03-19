package br.edu.insper.desagil.aps5.insee;

public class Tempo extends Referencia{
    private int hora;
    private int minutos;

    public Tempo() {
        this.hora = 0;
        this.minutos = 0;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void atualiza(int hora, int minuto) {
        if (hora<0){
            this.hora = 0;
        }
        else if(hora>23){
            this.hora = 23;
        }
        else{
            this.hora = hora;
        }

        if (minuto<0){
            this.minutos = 0;
        }
        else if(minuto>59){
            this.minutos = 59;
        }
        else{
            this.minutos = minuto;
        }
    }

    @Override
    public int obterValor() {
        return this.hora*60 + this.minutos;
    }
}
