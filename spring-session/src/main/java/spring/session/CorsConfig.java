/*
 * 文件名：CorsConfig.java
 * 描述：
 * 修改人：ll
 * 修改时间：2017年12月13日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package spring.session;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter
{
   /* @Override  
    public void addCorsMappings(CorsRegistry registry) {  
        
        registry.addMapping("/**")  
                .allowedOrigins("*")    //允许所有前端站点调用
                .allowCredentials(true)  
                .allowedMethods("GET", "POST", "DELETE", "PUT")  
                .maxAge(1728000);  
    }  */
}
