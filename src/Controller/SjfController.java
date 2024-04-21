package Controller;

import java.util.concurrent.Semaphore;

public class SjfController extends Thread{

    private Processo processo;
    private Semaphore semaforo;

    public SjfController (Processo processo, Semaphore semaforo) {
        this.processo = processo;
        this.semaforo = semaforo;
    }


    @Override
    public void run() {

        try {
            sleep(processo.tempoExec * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            semaforo.acquire();
            execProcess();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaforo.release();
        }


    }

    private void execProcess(){

        try {
            sleep((long) processo.tempoExec * 100);
            System.out.println(processo.nomeThread + " processada em " + processo.tempoExec + " segundos");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
