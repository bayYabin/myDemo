package com.qkc.mstation.controller;


import com.qkc.mstation.common.model.ApiCode;
import com.qkc.mstation.common.model.ApiResult;
import com.qkc.mstation.pojo.QkcEvalTemplate;
import com.qkc.mstation.service.QkcEvalTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by qukoucai001 on 2018/11/22.
 */

@RestController
@RequestMapping("/evalTemplate")
public class QkcEvalTemplateController {

    private static final Logger logger = LoggerFactory.getLogger(QkcEvalTemplateController.class);


    @Autowired
    private QkcEvalTemplateService qkcEvalTemplateService;


    /**
     *  test
     */
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ApiResult test(@RequestBody QkcEvalTemplate qkcEvalTemplate) {
        if(qkcEvalTemplate.getId()==null){
            return ApiResult.error(ApiCode.NOT_NULL,"所传信息为空");
        }
        logger.info("qkcEvalTemplate:"+qkcEvalTemplate);
        return ApiResult.ok(qkcEvalTemplate);

    }



    /**
     *  hello
     */
    @GetMapping("/hello")
    public ApiResult hello( ) {
        logger.info("hello");
        return ApiResult.ok("hello");
    }


}
