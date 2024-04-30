package lshh.circuitbreaker.core;

import java.util.List;
import java.util.Optional;

public interface ApiManager<T> {

    void addApi(String id, Api<T> api);
    void addApiList(List<Api<T>> list);

    Optional<Api<T>> findById(String id);
    Optional<Api<T>> findAvailable();
    Optional<Api<T>> findAvailableByOrder();
}
