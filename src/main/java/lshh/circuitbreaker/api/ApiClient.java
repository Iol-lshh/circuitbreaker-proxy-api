package lshh.circuitbreaker.api;

import java.util.Optional;

public interface ApiClient<T> {
    boolean isAvailable();
    String getId();

    Optional<T> find(String address);
}
