public class Main {
    public static void main(String[] args) {

        Foo foo = new Foo();

        Thread threadA = new Thread(() -> {
            try {
                foo.first();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                foo.second();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                foo.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadD = new Thread(() -> {
            try {
                foo.fourth();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadC.start();
        threadB.start();
        threadA.start();
        threadD.start();
    }
}

