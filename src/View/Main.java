package View;


import Controller.Scheduler;
import Controller.Processo;
import Controller.SjfController;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);

        Scheduler scheduler = new Scheduler();

        Processo vet[] = new Processo[20];

        String nomeThread;
        int tempoExec;

        //Criando processos
        for(int i = 0; i < 20; i++) {
            nomeThread = "Thread " + i;
            tempoExec = (int) (Math.random() * 121) + 4;
            Processo processo = new Processo(nomeThread, tempoExec);
            vet[i] = processo;
        }

        //Ordenando processos em ordem crescente de execução
        vet = scheduler.SchedulerSjf(vet);

        //Colocando processos em threads
        for(int i = 0; i < 20; i++) {

            SjfController sjfC = new SjfController(vet[i], semaforo);
            sjfC.start();
        }

    }
}
