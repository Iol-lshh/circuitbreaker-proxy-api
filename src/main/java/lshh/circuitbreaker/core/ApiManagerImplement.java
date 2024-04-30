package lshh.circuitbreaker.core;

import lshh.circuitbreaker.core.exception.ApiConnectException;
import java.util.*;

public class ApiManagerImplement<T> implements ApiManager<T> {

    protected final Map<String, Integer> ID_MAP;
    protected final List<Api<T>> API_LIST;

    public ApiManagerImplement() {
        this.ID_MAP = new HashMap<>();
        this.API_LIST = new ArrayList<>();
    }

    public ApiManagerImplement(List<Api<T>> apiList) {
        this.ID_MAP = new HashMap<>();
        this.API_LIST = new ArrayList<>();
        addApiList(apiList);
    }

    @Override
    public void addApi(String id, Api<T> api) {
        ID_MAP.put(id, API_LIST.size());
        API_LIST.add(api);
    }

    @Override
    public void addApiList(List<Api<T>> list){
        for (Api<T> api : list) {
            addApi(api.getId(), api);
        }
    }

    @Override
    public Optional<Api<T>> findById(String id) {
        Integer index = ID_MAP.get(id);
        if (index == null) {
            return Optional.empty();
        }
        return Optional.of(API_LIST.get(index));
    }

    @Override
    public Optional<Api<T>> findAvailable(){
        for (String id : ID_MAP.keySet()){
            Api<T> api = findById(id).orElseThrow(ApiConnectException::new);
            if (api.isAvailable()) {
                return Optional.of(api);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Api<T>> findAvailableByOrder(){
        for (Api<T> api : API_LIST) {
            if (api.isAvailable()) {
                return Optional.of(api);
            }
        }
        return Optional.empty();
    }
}
