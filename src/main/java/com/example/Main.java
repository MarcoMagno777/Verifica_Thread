package com.example;

public class Main {
    public static void main(String[] args) {
        
        //Creazione e esecuzione dei thread per moltiplicare le variabili A B e C
        //Join serve per aspettare che i thread finiscono di eseguire
        //Stampa i parziali per controllare che sia tutto giusto

        ThreadMolti threadMoltiA = new ThreadMolti(2, 6); 
        ThreadMolti threadMoltiB = new ThreadMolti(5, 4);
        ThreadMolti threadMoltiC = new ThreadMolti(3, 3);

        threadMoltiA.start();
        threadMoltiB.start();
        threadMoltiC.start();

        try {

            threadMoltiC.join();
            threadMoltiA.join();
            threadMoltiB.join();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("ParzialeA: " + threadMoltiA.getRisultato());
        System.out.println("ParzialeB: " + threadMoltiB.getRisultato());
        System.out.println("ParzialeC: " + threadMoltiC.getRisultato()); 


        //Crea i thread dedicati alle tonde

        ThreadTonde threadTonde1 = new ThreadTonde(3, threadMoltiA.getRisultato(), "+");
        ThreadTonde threadTonde2 = new ThreadTonde(threadMoltiB.getRisultato(), 7, "-");
        ThreadTonde threadTonde3 = new ThreadTonde(8, threadMoltiC.getRisultato(), "-");

        threadTonde1.start();
        threadTonde2.start();
        threadTonde3.start();
 
        try {

            threadTonde2.join();
            threadTonde3.join();
            threadTonde1.join();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("ParzialeT: " + threadTonde1.getRisultatoParziale());
        System.out.println("ParzialeT: " + threadTonde2.getRisultatoParziale());
        System.out.println("ParzialeT: " + threadTonde3.getRisultatoParziale());

        //Crea i thread dedicati alle quadre dopo aver preso i risultati dalle tonde

        ThreadQuadre threadQuadre = new ThreadQuadre(threadTonde2.getRisultatoParziale(), threadTonde3.getRisultatoParziale(), "+");

        threadQuadre.start();

        try {
            threadQuadre.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Stampa il risultato facendo l'ultima operazione direttamente nel sout

        System.out.println("Risultato finale: " + threadTonde1.getRisultatoParziale()*threadQuadre.getRisultatoParziale());


    }
}