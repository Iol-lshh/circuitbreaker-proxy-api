package lshh.circuitbreaker.sample.infrastructure.zipcode;

import lshh.circuitbreaker.core.Api;
import lshh.circuitbreaker.sample.domain.zipcode.Zipcode;

public class ZipcodeApi implements Api<Zipcode> {
    String id;
    String host;

    public ZipcodeApi(String id, String host){
        this.id = id;
        this.host = host;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public Zipcode get(Object param) {
        return null;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
