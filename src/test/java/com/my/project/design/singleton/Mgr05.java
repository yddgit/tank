package com.my.project.design.singleton;

/**
 * <h1>错误的写法</h1>
 * 通过缩小同步代码块的方式提高效率，以下方式是不可行的
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {}

    public static Mgr05 getInstance() {
        if(INSTANCE == null) {
            /*
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            synchronized (Mgr05.class) {
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr05.getInstance());
            }, "T" + i).start();
        }
    }
}
