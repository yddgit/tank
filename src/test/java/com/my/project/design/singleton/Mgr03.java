package com.my.project.design.singleton;

/**
 * <h1>懒汉式(线程不安全)</h1>
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {}

    public static Mgr03 getInstance() {
        if(INSTANCE == null) {
            // 代码执行到此处，如果被其他线程获得CPU时间片，将会导致线程安全问题
            /*
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr03.getInstance());
            }, "T" + i).start();
        }
    }
}
