package com.muhuan.frame.common.aop.log;

import com.muhuan.frame.common.bean.ResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

//@Slf4j
//@Order(3)
//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultBean defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (e instanceof RuntimeException) {
//            log.error(e.getLocalizedMessage());
            return ResultBean.defeated(e.getLocalizedMessage());
        }
        return ResultBean.defeated(-1);
    }
}
