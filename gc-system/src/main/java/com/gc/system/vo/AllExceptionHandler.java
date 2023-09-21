package com.gc.system.vo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//对加了@Controller注解的方法进行拦截处理 AOP的实现
@ControllerAdvice
public class AllExceptionHandler {
    //进行异常处理，处理Exception.class的异常
    @ExceptionHandler(SystemException.class)
    @ResponseBody //返回json数据
    public Result doException(SystemException e) {
        return Result.fail(e.getCode(), null, e.getMsg());
    }

    //进行异常处理，处理Exception.class的异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody //返回json数据
    public Result doException(NullPointerException e) {
        e.printStackTrace();
        return Result.fail(400, null, "数据错误");
    }
}
