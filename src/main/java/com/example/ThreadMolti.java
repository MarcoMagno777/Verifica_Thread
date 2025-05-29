package com.example;

public class ThreadMolti extends Thread{

    private int risultato;
    private int num1;
    private int num2;

    public ThreadMolti(int num1, int num2){

        this.num1 = num1;
        this.num2 = num2;

    }

    @Override
    public void run() {

        try {
            sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        risultato = num1 * num2;

    }

    public int getRisultato() {
        return risultato;
    }
    
}
