package io.dhseong.core.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AjaxModel {

    @Getter @Setter
    private Map<String, Object> data;

    @Getter @Setter
    private List<Map<String, Object>> dataList;

    /**
     * 그리드 페이징 관련
     */
    @Getter @Setter
    private int page = 0;

    @Getter @Setter
    private int pageRow = 0;

    @Getter @Setter
    private int total = 0;

    /**
     * 그리드 쿼리
     */
    @Getter @Setter
    private String qKey  = "";

    @Getter @Setter
    private String summQKey  = "";

    @Getter @Setter
    private int status = 0;

    @Getter @Setter
    private String code = "";

    @Getter @Setter
    private String msg  = "";

    @Getter @Setter
    private String success  = "";

    @Getter @Setter
    private UserSessionModel userSessionModel;
}
