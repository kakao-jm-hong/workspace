package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //  외부에서 사용하지 못하게 막는다.
    private SingletonService() {

    }

}
