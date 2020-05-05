package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jolan80
 * @date 2020-05-05 16:01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9011 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9011.class, args);
    }

}
