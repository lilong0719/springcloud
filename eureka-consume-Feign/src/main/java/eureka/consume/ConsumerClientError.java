/*
 * 文件名：ConsumerClientError.java
 * 描述：
 * 修改人：ll
 * 修改时间：2017年11月28日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package eureka.consume;

import org.springframework.stereotype.Component;

@Component
public class ConsumerClientError implements ConsumerClient
{

    @Override
    public String hello()
    {
        return "error";
    }

}
