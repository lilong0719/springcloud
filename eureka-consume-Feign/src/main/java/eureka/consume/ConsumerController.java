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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController
{
    @Autowired
    private ConsumerClient consumerClient;
    /*@Autowired
    private RestTemplate restTemplate;*/

    /*@RequestMapping("/hello")
    public String sayhello() {
        return restTemplate.getForObject("http://EUREKA-PRODUCE/hello",String.class);
    }*/
    
    @RequestMapping("/hello")
    public String sayhello() {
        return consumerClient.hello();
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String getDemo(){
        return "good";
    }

    @RequestMapping(value = "/demo1", method = RequestMethod.GET)
    public String getDemo1(){
        return "good1";
    }
}
