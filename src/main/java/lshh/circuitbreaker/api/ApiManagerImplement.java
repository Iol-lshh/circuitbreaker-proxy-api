package lshh.circuitbreaker.api;

import lshh.circuitbreaker.api.exception.ApiConnectException;
import java.util.*;

public abstract class ApiManagerImplement<T> implements ApiManager<T> {

    protected final Map<String, Integer> ID_MAP;
    protected final List<ApiClient<T>> API_CLIENT_LIST;

    public ApiManagerImplement() {
        this.ID_MAP = new HashMap<>();
        this.API_CLIENT_LIST = new ArrayList<>();
    }

    public ApiManagerImplement(List<ApiClient<T>> apiClientList) {
        this.ID_MAP = new HashMap<>();
        this.API_CLIENT_LIST = new ArrayList<>();
        addApiList(apiClientList);
    }

    @Override
    public void addApi(String id, ApiClient<T> apiClient) {
        ID_MAP.put(id, API_CLIENT_LIST.size());
        API_CLIENT_LIST.add(apiClient);
    }

    @Override
    public void addApiList(List<ApiClient<T>> list){
        for (ApiClient<T> apiClient : list) {
            addApi(apiClient.getId(), apiClient);
        }
    }

    @Override
    public Optional<ApiClient<T>> findById(String id) {
        Integer index = ID_MAP.get(id);
        if (index == null) {
            return Optional.empty();
        }
        return Optional.of(API_CLIENT_LIST.get(index));
    }

    @Override
    public Optional<ApiClient<T>> findAvailable(){
        for (String id : ID_MAP.keySet()){
            ApiClient<T> apiClient = findById(id).orElseThrow(ApiConnectException::new);
            if (apiClient.isAvailable()) {
                return Optional.of(apiClient);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<ApiClient<T>> findAvailableByOrder(){
        for (ApiClient<T> apiClient : API_CLIENT_LIST) {
            if (apiClient.isAvailable()) {
                return Optional.of(apiClient);
            }
        }
        return Optional.empty();
    }
}
