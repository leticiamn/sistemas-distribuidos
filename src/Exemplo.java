import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exemplo {
    private static List<String> lista = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        //Sobrescreve lista com uma versão sincronizada
        lista = Collections.synchronizedList(lista);

        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(500);
        System.out.println(lista);
    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            lista.add(name);
            System.out.println(name + " inseriu na lista!");
        }

    }

}
