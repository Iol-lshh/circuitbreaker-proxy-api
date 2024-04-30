package lshh.circuitbreaker.core;

public interface Api<T> {
    boolean isAvailable();
    T get(Object param);
    String getId();
}
