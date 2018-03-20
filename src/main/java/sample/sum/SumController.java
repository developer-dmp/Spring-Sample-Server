package sample.sum;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SumController {

    private static final String template = "The sum of %s and %s is: %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/sum2")
    public Sum sum(
            @RequestParam(value="n1", defaultValue="0") int n1,
            @RequestParam(value="n2", defaultValue="0") int n2) {

        return new Sum(counter.incrementAndGet(), n1, n2);
    }

    @RequestMapping("/sum3")
    public Sum sum(
            @RequestParam(value="n1", defaultValue="0") int n1,
            @RequestParam(value="n2", defaultValue="0") int n2,
            @RequestParam(value="n3", defaultValue="0") int n3
            ) {
        return new Sum(counter.incrementAndGet(), n1, n2, n3);
    }
}
