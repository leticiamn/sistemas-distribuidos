import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Projeto4 {
    private static List<String> lista = new ArrayList<>();
    private static List<String> alunos1 = new ArrayList<>(Arrays.asList("Felipe Almeida", "Gabriel de Paula", "Henrique Souza", "Isis Carvalho", "Joana Aparecida"));
    private static List<String> alunos2 = new ArrayList<>(Arrays.asList("Ana Silva", "Bruno Ferreira", "Carlos Machado", "Daniel Santos", "Ester Pereira"));

    public static void main(String[] args) throws InterruptedException {

        lista = Collections.synchronizedList(lista);

        MeuRunnable runnable = new MeuRunnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);

        t0.start();
        t1.start();

        Thread.sleep(500);
        System.out.println(lista);
    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {

            String name = Thread.currentThread().getName();
            if(name.equals("Thread-0"))
                for(int i = 0; i < 5; i++)
                    lista.add(alunos1.get(i)+name);
            else if(name.equals("Thread-1"))
                for(int i = 0; i < 5; i++)
                    lista.add(alunos2.get(i)+name);

        }

    }

}
