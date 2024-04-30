package lshh.circuitbreaker.sample.infrastructure.zipcode;

import lshh.circuitbreaker.core.ApiManager;
import lshh.circuitbreaker.core.exception.ApiConnectException;
import lshh.circuitbreaker.sample.domain.zipcode.Zipcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ZipcodeApiManager {
    @Autowired
    private ApiManager<Zipcode> apiManager;

    public ZipcodeApi getApi() {
        return apiManager.findAvailableByOrder()
                .flatMap(api -> Optional.of((ZipcodeApi) api))
                .orElseThrow(ApiConnectException::new);
    }
}
