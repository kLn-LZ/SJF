package Controller;

public class QuickSort {

    public QuickSort () {
        super();
    }


    public Processo[] quickSortOrder(Processo[] sjfC, int inicio, int fim) {

        if(inicio < fim) {

            int fixedPivot = divide(sjfC, inicio, fim);
            quickSortOrder(sjfC, inicio, fixedPivot - 1);
            quickSortOrder(sjfC, fixedPivot + 1, fim);

        }

        return sjfC;

    }

    private int divide(Processo[] vet, int inicio, int fim) {

        int esq = inicio + 1;
        int dir = fim;
        Processo pivot = vet[inicio];


        while (esq <= dir) {
            while (esq <= dir && vet[esq].tempoExec <= pivot.tempoExec) {
                esq++;
            }
            while(esq <= dir && vet[dir].tempoExec > pivot.tempoExec) {
                dir--;
            }

            if(esq < dir){
                SweapArray(vet, esq, dir);
                esq++;
                dir--;
            }

        }

        SweapArray(vet, inicio, dir);
        return dir;
    }

    private void SweapArray(Processo[] vet, int i, int j ) {

        Processo aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }

}
