/*
 * 文件名：ConsumerController.java
 * 描述：
 * 修改人：ll
 * 修改时间：2017年11月28日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package eureka.consume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/consumer")
public class ConsumerController
{
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "defaultRest")
    public String sayhello() {
        return restTemplate.getForObject("http://EUREKA-PRODUCE/hello",String.class);
    }
    
    public String defaultRest() {
        return "default HystrixCommand";
    }
    
    @RequestMapping("/login")
    public String login(String code) {
        System.out.println(code);
        return code;
    }
    
}
