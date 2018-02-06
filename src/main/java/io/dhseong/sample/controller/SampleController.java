package io.dhseong.sample.controller;

import io.dhseong.core.model.AjaxModel;
import io.dhseong.sample.service.SampleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dong hun Seong
 * @since 2018-02-05
 */

@RestController
public class SampleController {

    @Resource(name = "sampleService")
    SampleService sampleService;


    @RequestMapping(value = "/hello")
    public AjaxModel hello(){
        AjaxModel ajaxModel = new AjaxModel();
        ajaxModel.setCode("E00001");
        ajaxModel.setMsg("Hello");
        ajaxModel.setStatus(-9);

        return ajaxModel;
    }

    @RequestMapping(value = "/sampleList")
    public AjaxModel sampleList(){
        AjaxModel ajaxModel = new AjaxModel();
        ajaxModel.setCode("E00001");
        ajaxModel.setMsg("Hello");

        ajaxModel.setDataList(sampleService.sampleList());

        return ajaxModel;
    }

    @RequestMapping(value = "/addSample/{auth_cd}")
    public AjaxModel addSample(@PathVariable(value = "auth_cd") String auth_cd){
        AjaxModel ajaxModel = new AjaxModel();
        ajaxModel.setCode("E00001");
        ajaxModel.setMsg("OK");

        Map<String, String> params = new HashMap<>();
        params.put("AUTH_CD", auth_cd);
        params.put("AUTH_NM", "TEST NAME");

        sampleService.addSample(params);

        return ajaxModel;
    }

    @RequestMapping(value = "/addSampleTransaction/{auth_cd}")
    public AjaxModel addSampleForTransaction(@PathVariable(value = "auth_cd") String auth_cd){
        Map<String, String> params = new HashMap<>();
        params.put("AUTH_CD", auth_cd);
        params.put("AUTH_NM", "TEST NAME");

        sampleService.addSampleForTransactional(params);

        return new AjaxModel();
    }
}
