package com.company;


public class Main2 {
    public static void main(String[] args) {
        Test t=new Test();

        Thread t1=new Thread(()-> {
            for (int i=0; i<10000000;i++) {
                t.inc();// value+1
            }
        });

        Thread t2=new Thread(()-> {
            for (int i=0; i<10000000;i++) {
                t.dec();// value-1
            }
        });
        //приоритеты потоков
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getValue());
    }
}
