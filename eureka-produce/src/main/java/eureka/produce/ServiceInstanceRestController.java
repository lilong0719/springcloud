/*
 * 文件名：ServiceInstanceRestController.java
 * 描述：
 * 修改人：ll
 * 修改时间：2017年11月28日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package eureka.produce;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceInstanceRestController
{
    private static final Logger logger = LoggerFactory.getLogger(ServiceInstanceRestController.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/hello")
    public String sayhello() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "hello";
    }
}
