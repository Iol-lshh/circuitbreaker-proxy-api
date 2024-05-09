package lshh.circuitbreaker.api;

import java.util.List;

public class SimpleApiManager<T> extends ApiManagerImplement<T>{
    public SimpleApiManager() {
        super();
    }

    public SimpleApiManager(List<ApiClient<T>> apiClientList) {
        super(apiClientList);
    }
}
