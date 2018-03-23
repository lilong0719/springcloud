/*
 * 文件名：ConsumerClient.java
 * 描述：
 * 修改人：ll
 * 修改时间：2017年11月28日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package eureka.consume;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="EUREKA-PRODUCE",fallback = ConsumerClientError.class)
public interface ConsumerClient
{

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello();
}
