package Controller;

public class Scheduler {

    public Scheduler() {

    }


    public Processo[] SchedulerSjf(Processo[] processo) {
        QuickSort qs = new QuickSort();

        return qs.quickSortOrder(processo, 0, processo.length - 1);
    }

}
