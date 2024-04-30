package lshh.circuitbreaker.sample.domain.zipcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipcodeService {
    @Autowired
    private ZipcodeApiProxy api;

    public Zipcode findZipcodeByAddress(String address) {
        return api.findZipcodeByAddress(address);
    }
}
