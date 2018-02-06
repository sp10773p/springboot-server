package io.dhseong.sample.service;

import io.dhseong.core.dao.CommonDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dong hun Seong
 * @since 2018-02-05
 */
@Service(value = "sampleService")
public class SampleService {

    @Resource(name = "commonDAO")
    CommonDAO commonDAO;

    public List<Map<String, Object>> sampleList(){
        return commonDAO.list("sample.sampleList");
    }

    @Transactional
    public void addSample(Map<String, String> params){
        commonDAO.insert("sample.addSample", params);
    }

    @Transactional
    public void addSampleForTransactional(Map<String, String> params){
        commonDAO.insert("sample.addSample", params);

        params = new HashMap<>();
        params.put("AUTH_CD", null);
        params.put("AUTH_NM", "TEST NAME1");
        commonDAO.insert("sample.addSample", params);
    }
}
