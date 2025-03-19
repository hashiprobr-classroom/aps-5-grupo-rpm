package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AgendaTest {
    private Agenda agenda;

    @BeforeEach
    void setUp(){
        agenda = new Agenda();
    }

    private Evento eventoFalso(boolean x){
        Evento evento = mock(Evento.class);{
            when(evento.ehAntes()).thenReturn(x);
            return evento;
        }

    }

    @Test
    public void constroi(){
        boolean x = agenda.getEventos().equals(new ArrayList<>());
        assertTrue(x);
    }

    @Test
    public void adicionaValido(){
        Evento e = eventoFalso(false);
        agenda.adiciona(e);
        List<Evento> lista = new ArrayList<>();
        lista.add(e);
        boolean x = agenda.getEventos().equals(lista);
        assertTrue(x);
    }

    @Test
    public void adicionaInvalido(){
        Evento e = eventoFalso(true); // Evento inválido

        // Usa assertThrows para verificar se IllegalArgumentException é lançada
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adiciona(e); // Tenta adicionar evento inválido
        });

        // Verifica se a mensagem da exceção é a esperada
        assertEquals("Evento invalido!", exception.getMessage());
    }




}
