package io.dhseong.core.model;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 사용자 Model
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
@Alias("userSessionModel")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSessionModel implements Serializable{
    /*사용자ID*/
    @Getter @Setter
    private String userId;
    /*사용자명*/
    @Getter @Setter
    private String userNm;
    /*패스워드*/
    @Getter @Setter
    private String userPw;
    /*사용자구분*/
    @Getter @Setter
    private String userDiv;
    /*권한코드*/
    @Getter @Setter
    private String authCd;
    /*전화번호*/
    @Getter @Setter
    private String telNo;
    /*핸드폰번호*/
    @Getter @Setter
    private String hpNo;
    /*이메일*/
    @Getter @Setter
    private String email;
    /*최초로그인*/
    @Getter @Setter
    private String loginStart;
    /*최종로그인*/
    @Getter @Setter
    private String loginLast;
    /*최종로그인*/
    @Getter @Setter
    private String loginLastStr;
    /*로그인에러*/
    @Getter @Setter
    private int loginError;
    /*이전비밀번호*/
    @Getter @Setter
    private String pwPrior;
    /*비밀번호변경일*/
    @Getter @Setter
    private String pwChange;
    /*비밀번호변경주기*/
    @Getter @Setter
    private String pwUpdate;
    /*비밀번호변경기간*/
    @Getter @Setter
    private String pwPeriod;
    /*사용여부*/
    @Getter @Setter
    private String useChk;
    /*사용자 상태*/
    @Getter @Setter
    private String userStatus;
    /*사업자등록번호*/
    @Getter @Setter
    private String bizNo;
    /*사업자구분*/
    @Getter @Setter
    private String bizDiv;
    /*담당자명*/
    @Getter @Setter
    private String chargeNm;
    /*등록자ID*/
    @Getter @Setter
    private String regId;
    /*등록일자*/
    @Getter @Setter
    private String regDtm;
    /*수정자ID*/
    @Getter @Setter
    private String modId;
    /*수정일자*/
    @Getter @Setter
    private String modDtm;
    /*대표자명*/
    @Getter @Setter
    private String repNm;
    /*우편번호*/
    @Getter @Setter
    private String zipCd;
    /*주소*/
    @Getter @Setter
    private String address;
	/* 사용자 접속 IP */
    @Getter @Setter
    private String userIp;
    @Getter @Setter
    List<MenuModel> menuModelList;
    @Getter @Setter
    Map<String, List<String>> menuBtnAuth;
}
