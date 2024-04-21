package Controller;

import java.util.concurrent.Semaphore;

public class Processo{


    public int tempoExec;
    public String nomeThread;


    public Processo(String nomeThread, int tempoExec) {

        this.nomeThread = nomeThread;
        this.tempoExec = tempoExec;

    }




}
