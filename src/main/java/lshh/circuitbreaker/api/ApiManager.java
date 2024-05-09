package lshh.circuitbreaker.api;

import java.util.List;
import java.util.Optional;

public interface ApiManager<T> {

    void addApi(String id, ApiClient<T> apiClient);
    void addApiList(List<ApiClient<T>> list);

    Optional<ApiClient<T>> findById(String id);
    Optional<ApiClient<T>> findAvailable();
    Optional<ApiClient<T>> findAvailableByOrder();
}
