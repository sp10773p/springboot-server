package io.dhseong.core.model;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 메뉴 Model
 * @author 성동훈
 * @since 2017-01-05
 * @version 1.0
 * @see
 *
 * <pre>
 * == 개정이력(Modification Information) ==
 *
 * 수정일      수정자  수정내용
 * ----------- ------- ---------------------------
 * 2017.01.05  성동훈  최초 생성
 *
 * </pre>
 */
@Alias("menuModel")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuModel implements Serializable{

    /** 메뉴코드 **/
    @Getter @Setter
    private String menuId;
    /** 상위메뉴코드 **/
    @Getter @Setter
    private String pmenuId;
    /** 메뉴명 **/
    @Getter @Setter
    private String menuNm;
    /** 메뉴설명 **/
    @Getter @Setter
    private String menuDc;
    /** 경로 **/
    @Getter @Setter
    private String menuPath;
    /** 주소 **/
    @Getter @Setter
    private String menuUrl;
    /** 레벨 **/
    @Getter @Setter
    private String menuLevel;
    /** 구분 **/
    @Getter @Setter
    private String menuDiv;
    /** 링크여부 **/
    @Getter @Setter
    private String linkYn;
    /** 순서 **/
    @Getter @Setter
    private int menuOrdr;
    /** 권한코드 **/
    @Getter @Setter
    private String authCd;
    /** 메뉴코드01 **/
    @Getter @Setter
    private String menuCod1;
    /** 메뉴코드02 **/
    @Getter @Setter
    private String menuCod2;
    /** 메뉴코드03 **/
    @Getter @Setter
    private String menuCod3;
    /** 메뉴코드04 **/
    @Getter @Setter
    private String menuCod4;
    /** 등록자ID **/
    @Getter @Setter
    private String regId;
    /** 등록일시 **/
    @Getter @Setter
    private String regDtm;
    /** 수정자ID **/
    @Getter @Setter
    private String modId;
    /** 수정일시 **/
    @Getter @Setter
    private String modDtm;
    /** DASH 경로 **/
    @Getter @Setter
    private String dashPath;
    /** DASH 주소 **/
    @Getter @Setter
    private String dashUrl;
    /** 메뉴ICON **/
    @Getter @Setter
    private String icon;
}
