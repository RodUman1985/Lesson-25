package com.company;

public class Test {
    private  int value;
// если synchronized на уровне метода - блокируется доступ к объекту
   //блокируется доступ к классу Test если метод static
    public static synchronized void test(){};
    public synchronized void inc (){
        this.value++;
    }
    public  void dec() {
        //синхронизация отдельного блока кода а не метода целиком
        // (блокировка блока кода вместо блокировки объекта целиком)
        //locked/unlocked
        //synchronized(o)=>o.state=locked
        //после окончания болка synchronized  java автоматически поставит состояние unlocked
        synchronized (this) {
            this.value--;
        }
    }

    public int getValue() {
        return value;
    }
}
