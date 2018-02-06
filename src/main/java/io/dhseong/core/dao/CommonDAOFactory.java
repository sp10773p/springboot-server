package io.dhseong.core.dao;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 모든 DAO를 관리하고 반환
 */
@Repository
public class CommonDAOFactory {

    @Resource(name = "commonDAO")
    private CommonDAO commonDAO;

    /**
     * CommonDAO를 반환
     * @return
     */
    public AbstractDAO getDao(){
        return commonDAO;
    }

    /**
     * poolName에 해당하는 DAO를 반환
     * @param poolName
     * @return
     */
    public AbstractDAO getDao(String poolName){
        if(StringUtils.isEmpty(poolName)){
            poolName = "default";
        }

        /*if("zip".equals(poolName.toLowerCase())){
            return commonZipDAO;

        }else if("trade".equals(poolName.toLowerCase())){
            return commonTradeDAO;

        }*/

        return getDao();
    }
}
