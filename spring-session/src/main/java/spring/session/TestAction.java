/*
 * 文件名：TestAction.java
 * 描述：
 * 修改人：ll
 * 修改时间：2017年12月5日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package spring.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@RequestMapping(value = "/admin/v1")  
public class TestAction
{
    @RequestMapping(value = "/first", method = RequestMethod.GET)  
    public Map<String, Object> firstResp (HttpServletRequest request){  
        Map<String, Object> map = new HashMap<>();  
        request.getSession().setAttribute("request Url", request.getRequestURL());  
        map.put("request Url", request.getRequestURL());  
        return map;  
    }  
  
    @RequestMapping(value = "/sessions", method = RequestMethod.GET)  
    public Object sessions (HttpServletRequest request){  
        Map<String, Object> map = new HashMap<>();  
        map.put("sessionId", request.getSession().getId());  
        map.put("message", request.getSession().getAttribute("map"));  
        return map;  
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.POST)  
    public Map<String, Object> test (@RequestParam(value="username",required=false) String username,@RequestParam(value="password",required=false) String password){ 
        Map<String, Object> map = new HashMap<>();  
        System.out.println(username);
        if("1".equals(username)) {
            map.put("data", "-1");  
        }
        if("2".equals(username)) {
            map.put("data", "0");  
        }
        if("admin".equals(username)) {
            map.put("data", "admin");  
        }
        if("3".equals(username)) {
            map.put("data", "3");  
        }
        if("ok".equals(username)) {
            map.put("data", "ok");  
        }
        return map;
    } 
    @RequestMapping(value = "/list", method = RequestMethod.GET)  
    public List<String> list(){ 
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        list.add("fff");
        list.add("ddd");
        return list;
    } 
}
