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

    @Getter @Setter
    private int total = 0;

    @Getter @Setter
    private int status = 0;

    @Getter @Setter
    private String code = "";

    @Getter @Setter
    private String msg  = "";

    @Getter @Setter
    private UserSessionModel userSessionModel;
}
