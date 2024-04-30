package lshh.circuitbreaker.sample.infrastructure.zipcode;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lshh.circuitbreaker.core.exception.ApiConnectException;
import lshh.circuitbreaker.sample.domain.zipcode.Zipcode;
import lshh.circuitbreaker.sample.domain.zipcode.ZipcodeApiProxy;
import org.springframework.stereotype.Component;

@Component
@CircuitBreaker(name = "zipcode", fallbackMethod = "fallback")
public class ZipcodeApiProxyImplement implements ZipcodeApiProxy {

    private final ZipcodeApiManager apiManager;
    private ZipcodeApi api;

    public ZipcodeApiProxyImplement(ZipcodeApiManager apiManager) {
        this.apiManager = apiManager;
        initApi();
    }

    @Override
    public Zipcode findZipcodeByAddress(String address) {
        return api.get(address);
    }

    public void fallback(String address, ApiConnectException exception) {
        initApi();
    }

    public void initApi(){
        this.api = apiManager.getApi();
    }
}
