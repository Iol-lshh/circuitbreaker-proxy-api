package lshh.circuitbreaker.sample.infrastructure.zipcode;

import lshh.circuitbreaker.api.ApiClient;
import lshh.circuitbreaker.sample.domain.zipcode.Zipcode;

import java.util.Optional;

public class ZipcodeApiClient implements ApiClient<Zipcode> {
    String id;
    String host;

    public ZipcodeApiClient(String id, String host){
        this.id = id;
        this.host = host;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Optional<Zipcode> find(String address) {
        return Optional.empty();
    }
}
