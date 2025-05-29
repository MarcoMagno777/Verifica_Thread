package com.example;

public class ThreadTonde extends Thread{
    
    private int risultatoParziale;
    private int num1;
    private int num2;
    private String operazione;

    public ThreadTonde(int num1, int num2, String operazione){

        this.num1 = num1;
        this.num2 = num2;
        this.operazione = operazione;

    }

    //Controlla il segno per crearne un thread dedicato 

    @Override
    public void run() {
  
        switch (operazione) {
            case "+":
                
                ThreadSomma threadSomma = new ThreadSomma(num1, num2);

                threadSomma.start();

                try {
                    threadSomma.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                risultatoParziale = threadSomma.getRisultato();

                break;
            case "-":

                ThreadSott threadSott = new ThreadSott(num1, num2);

                threadSott.start();

                try {
                    threadSott.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                risultatoParziale = threadSott.getRisultato();

                break;
            default:
                break;
        }

    }

    public int getRisultatoParziale() {
        return risultatoParziale;
    }


}
