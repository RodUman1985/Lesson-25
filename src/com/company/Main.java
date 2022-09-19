package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
	// Потоки (Threads)

        long time=System.currentTimeMillis();
       /* for (int i = 0; i< 10000000;i++){
         double t= Math.sin( Objects.hashCode(i)*Math.exp(i*i));
        }
        System.out.println(System.currentTimeMillis()-time);
        //3812*/

        Thread t1=new Thread(() ->{
            System.out.println(" в момент запуска  "+Thread.currentThread().getState());
            for (int i = 0; i< 10000000/2;i++){
                double t= Math.sin( Objects.hashCode(i)*Math.exp(i*i));
            }
        });

        Thread t2=new Thread(() ->{
            for (int i =10000000/2; i< 10000000;i++){
                double t= Math.sin( Objects.hashCode(i)*Math.exp(i*i));
            }
        });
       t1.getState();
        System.out.println("перед запуском        "+t1.getState());
        //создание потоков != их запуску
        //запуск
        t1.start();
        t2.start();
        System.out.println("после запуска  "+t1.getState());
        try {
            //ожидаем завершения дочерних потоков
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("после выполнения  "+t1.getState());
        System.out.println(System.currentTimeMillis()-time);
    }
}
