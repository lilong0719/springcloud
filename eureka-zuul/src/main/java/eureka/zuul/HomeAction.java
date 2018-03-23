/*
 * 文件名：HomeAction.java
 * 描述：
 * 修改人：ll
 * 修改时间：2017年12月1日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package eureka.zuul;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAction
{

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }
}
