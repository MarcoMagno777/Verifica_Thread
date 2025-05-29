package com.example;

public class Main {
    public static void main(String[] args) {
        
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

        System.out.println("Parziale: " + threadMoltiA.getRisultato());
        System.out.println("Parziale: " + threadMoltiB.getRisultato());
        System.out.println("Parziale: " + threadMoltiC.getRisultato()); 

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

        ThreadQuadre threadQuadre = new ThreadQuadre(threadTonde2.getRisultatoParziale(), threadTonde3.getRisultatoParziale(), "+");

        threadQuadre.start();

        try {
            threadQuadre.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Risultato finale: " + threadTonde1.getRisultatoParziale()*threadQuadre.getRisultatoParziale());


    }
}