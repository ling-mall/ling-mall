//package com.ling.lingcloud.common.web.controller;
//
//import com.ling.lingcloud.common.web.domain.R;
//import com.ling.lingcloud.common.exception.CommonCodeEnum;
//import com.ling.lingcloud.common.web.exception.CommonWebErrorCodeEnum;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 自定义错误处理.
// * Class created on 2023/11/22 by 钟舒艺
// *
// * @author 钟舒艺
// */
//@Slf4j
//@RestController
//@AutoConfigureBefore(ErrorMvcAutoConfiguration.class)
//public class CustomErrorController implements ErrorController {
//
//
//    /**
//     * 自定义 error 处理.
//     *
//     * @param request 请求信息
//     * @return 通用返回
//     */
//    @RequestMapping("/error")
//    public R<Void> doHandleError(HttpServletRequest request) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        if (status != null) {
//            Integer statusCode = Integer.valueOf(status.toString());
//            log.error(String.valueOf(statusCode));
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                return R.error(CommonWebErrorCodeEnum.NOT_FOUND);
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
////                return R.failed(statusCode, "服务器错误");
//                return R.error(CommonWebErrorCodeEnum.UNKNOWN_ERROR);
//            } else {
////                return R.failed(statusCode, HttpStatus.valueOf(statusCode).getReasonPhrase());
//            }
//        }
////        return R.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器错误");
//        return R.success();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(CommonCodeEnum.SUCCESS.builderCode());
//    }
//}
