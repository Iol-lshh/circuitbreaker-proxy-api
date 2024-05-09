package lshh.circuitbreaker.sample.controller;

import lombok.RequiredArgsConstructor;
import lshh.circuitbreaker.sample.domain.zipcode.ZipcodeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zipcode")
@RequiredArgsConstructor
public class ZipcodeController {
    private final ZipcodeService zipcodeService;

    @GetMapping("/{address}")
    public String findZipcodeByAddress(@PathVariable String address) {
        return zipcodeService.findZipcodeByAddress(address).orElseThrow().toString();
    }

}
