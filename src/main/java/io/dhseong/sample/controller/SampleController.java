package io.dhseong.sample.controller;

import io.dhseong.core.model.AjaxModel;
import io.dhseong.sample.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author dong hun Seong
 * @since 2018-02-05
 */

@RestController
public class SampleController {

    private Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Resource(name = "sampleService")
    private SampleService sampleService;


    @RequestMapping(value = "/hello")
    public AjaxModel hello(){
        AjaxModel ajaxModel = new AjaxModel();
        ajaxModel.setCode("E00001");
        ajaxModel.setMsg("Hello");
        ajaxModel.setStatus(-9);

        return ajaxModel;
    }

    @RequestMapping(value = "/sample/sampleList")
    @ResponseBody
    public AjaxModel sampleList(){
        AjaxModel ajaxModel = new AjaxModel();
        ajaxModel.setCode("E00001");
        ajaxModel.setMsg("Hello");

        ajaxModel.setDataList(sampleService.sampleList());

        return ajaxModel;
    }

    @RequestMapping(value = "/sample/addSample/{auth_cd}")
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

    @RequestMapping(value = "/sample/addSampleTransaction/{auth_cd}")
    public AjaxModel addSampleForTransaction(@PathVariable(value = "auth_cd") String auth_cd){
        Map<String, String> params = new HashMap<>();
        params.put("AUTH_CD", auth_cd);
        params.put("AUTH_NM", "TEST NAME");

        sampleService.addSampleForTransactional(params);

        return new AjaxModel();
    }


    @RequestMapping(value = "/sample/showUser")
    @ResponseBody
    public AjaxModel showUser(@RequestBody AjaxModel params){
        logger.debug("params : {}", params);
        AjaxModel ajaxModel = new AjaxModel();

        ajaxModel.setStatus(0);

        Map<String, Object> data = new HashMap<>();
        data.put("nickName", "레이서");
        data.put("password", "1234");
        data.put("email", "sp10773p@gmail.com");
        ajaxModel.setData(data);

        return ajaxModel;
    }


    @RequestMapping(value = "/sample/userReg")
    @ResponseBody
    public AjaxModel userReg(@RequestBody AjaxModel params){
        logger.debug("params : {}", params);
        AjaxModel ajaxModel = new AjaxModel();

        ajaxModel.setStatus(0);
        ajaxModel.setMsg("성공");

        return ajaxModel;
    }



    @RequestMapping(value = "/sample/userUpd")
    @ResponseBody
    public AjaxModel userUpd(@RequestBody AjaxModel params){
        logger.debug("params : {}", params);
        AjaxModel ajaxModel = new AjaxModel();

        ajaxModel.setStatus(0);
        ajaxModel.setMsg("변경성공");

        return ajaxModel;
    }


    @RequestMapping(value = "/sample/userShowList")
    public AjaxModel userShowList(HttpServletRequest request){
        AjaxModel ajaxModel = new AjaxModel();

        ajaxModel.setStatus(0);

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> data = new HashMap<>();
        data.put("userId", "sp10773p");
        data.put("password", "1234");
        data.put("nickName", "레이서");
        data.put("email", "sp10773p@gmail.com");

        list.add(data);

        data = new HashMap<>();
        data.put("userId", "tjdehd80");
        data.put("password", "1234");
        data.put("nickName", "성동훈");
        data.put("email", "seongdh@ucssystem.co.kr");

        list.add(data);
        ajaxModel.setDataList(list);

        return ajaxModel;
    }

    @RequestMapping(value = "/sample/deplucateUser")
    public AjaxModel deplucateUser(@RequestBody AjaxModel params){
        logger.debug("params : {}", params);
        AjaxModel ajaxModel = new AjaxModel();

        ajaxModel.setMsg("사용자 아이디를 사용할수 없습니다.");

        return ajaxModel;
    }

    @RequestMapping(value = "/sample/tooManyData")
    @ResponseBody
    public AjaxModel tooManyData(@RequestBody AjaxModel params){
        logger.debug("params : {}", params);
        AjaxModel ajaxModel = new AjaxModel();

        List<Map<String, Object>> list = new ArrayList<>();
        for(int i=0; i < 60000; i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("userId", "user" + i);
            data.put("password", "1234");
            data.put("nickName", "성동훈");
            data.put("email", "seongdh@ucssystem.co.kr");

            list.add(data);
        }

        ajaxModel.setDataList(list);

        return ajaxModel;
    }

    @RequestMapping(value = "/sample/userData")
    public AjaxModel userData(HttpServletRequest request){
        AjaxModel ajaxModel = new AjaxModel();

        ajaxModel.setStatus(0);

        Map<String, Object> data = new HashMap<>();
        data.put("userId", "sp10773p");
        data.put("password", "1234");
        data.put("nickName", "레이서");
        data.put("email", "sp10773p@gmail.com");

        ajaxModel.setData(data);

        return ajaxModel;
    }

    private void printRequestParams(HttpServletRequest request) {
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            System.out.println(key + "::" + request.getParameter(key));
        }
    }
}
