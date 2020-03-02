package com.my.project.design.singleton;

/**
 * <h1>懒汉式Synchronized</h1>
 * 可以通过synchronized解决Mgr03的线程安全问题，但也带来效率上的下降
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {}

    private static synchronized Mgr04 getInstance() {
        if(INSTANCE == null) {
            /*
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr04.getInstance());
            }, "T" + i).start();
        }
    }
}
