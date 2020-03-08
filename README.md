# 关于“任务”

---

### 异步任务
- @Async--> 异步开启的服务方法上
```
package com.chenzj36.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class AsyncService {

    @Async
    public String hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理完成......");
        return "OK";
    }
}

```
- @EnableAsync --> 主启动类上
```
package com.chenzj36;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
@SpringBootApplication
@EnableAsync
public class SpringbootTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootTaskApplication.class, args);
    }
}

```
### 定时任务
- TaskScheduler 任务调度者
- TaskExecutor 任务执行者
- @EnableScheduling  
*加在主启动类上即可*
- @Scheduled
```
@Service
public class ScheduledService {
    @Scheduled(cron = "0/2 * * * * ?")
    public void hello(){
        System.out.println("定时任务执行~~~");
    }
}
```
- cron   
![enter description here](https://aliyunosschenzj.oss-cn-beijing.aliyuncs.com/aliyunoss/1581313142168.png)
### 邮件发送
- **添加依赖spring-start-mail**
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```
- **开启POP3/SMTP服务，获取授权码**    
qjoykabsqxsybhdj
- **配置properties**
```
spring.mail.username=chenzj36@126.com
spring.mail.password=授权码
spring.mail.host=smtp.126.com
spring.mail.properties.mail.smtp.ssl.enable=true
```
- **测试发送JavaMailSendImpl  
![enter description here](https://aliyunosschenzj.oss-cn-beijing.aliyuncs.com/aliyunoss/1581257111295.png)  
- **测试发送MimeMessage  
```
@Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);

        messageHelper.setTo("chenzj36@live.cn");
        messageHelper.setFrom("chenzj36@126.com");
        messageHelper.setSubject("from springboot");
        messageHelper.setText("<p style='color:red'>一座城市令你念念不忘，大多是因为，那里有你深爱的人和一去不复返的青春~</p>",true);
        messageHelper.addAttachment("1.jpg",new File("E:\\screen\\2020-02-10_10-19-06.jpg"));
        messageHelper.addAttachment("2.jpg",new File("E:\\screen\\2020-02-08_13-27-45.jpg"));

        mailSender.send(mimeMessage);
    }
```
