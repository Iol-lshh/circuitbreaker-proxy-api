package lshh.circuitbreaker.sample.infrastructure.zipcode;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lshh.circuitbreaker.api.ApiManager;
import lshh.circuitbreaker.api.exception.ApiConnectException;
import lshh.circuitbreaker.sample.domain.zipcode.Zipcode;
import lshh.circuitbreaker.sample.domain.zipcode.ZipcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@CircuitBreaker(name = "zipcode", fallbackMethod = "fallback")
public class ZipcodeRepositoryImplement implements ZipcodeRepository {

    private final ApiManager<Zipcode> apiManager;
    private ZipcodeApiClient api;

    public ZipcodeRepositoryImplement(@Autowired ApiManager<Zipcode> apiManager) {
        this.apiManager = apiManager;
        setApi();
    }

    @Override
    public Optional<Zipcode> findZipcodeByAddress(String address) {
        return api.find(address);
    }

    public void fallback(String address, ApiConnectException exception) {
        setApi();
    }

    public void setApi(){
        if(apiManager == null) {
            throw new ApiConnectException("ApiManager is null.");
        }

        this.api = apiManager.findAvailableByOrder()
                .flatMap(api -> Optional.of((ZipcodeApiClient) api))
                .orElseThrow(ApiConnectException::new);
    }
}
