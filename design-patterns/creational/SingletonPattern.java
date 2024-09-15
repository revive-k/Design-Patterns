
public class SingletonPattern {
    public static void main(String[] args) {
        //We are getting same object instance even if when calling multiple times

        System.out.println(EagerInitializedSingleton.getInstance());
        System.out.println(EagerInitializedSingleton.getInstance());

        System.out.println(LazyInitializedSingleton.getInstance());
        System.out.println(LazyInitializedSingleton.getInstance());

        System.out.println(ThreadSafeLazySingleton.getInstance());
        System.out.println(ThreadSafeLazySingleton.getInstance());

        System.out.println(BillPughSingleton.getInstance());
        System.out.println(BillPughSingleton.getInstance());
    }
}

/*
Follow link for more details: https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
*/

class EagerInitializedSingleton {
    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {}

    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }
}

class LazyInitializedSingleton {
    private static LazyInitializedSingleton INSTANCE;

    private LazyInitializedSingleton() {}

    public static LazyInitializedSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new LazyInitializedSingleton();
        }
        return INSTANCE;
    }
}

class ThreadSafeLazySingleton {
    private static ThreadSafeLazySingleton INSTANCE;

    private ThreadSafeLazySingleton() {}

    public static ThreadSafeLazySingleton getInstance() {
        if(INSTANCE == null) {
            synchronized (ThreadSafeLazySingleton.class) {
                if(INSTANCE == null) {
                    INSTANCE = new ThreadSafeLazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}

class BillPughSingleton {
    private BillPughSingleton() {}

    private static class SingletonHelper {
        public static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

