package org.buptdavid.datastructure.io.netty.serializable;

import java.io.Serializable;

/**
 * Netty Java序列化 订购应答POJO类定义
 * @author weijielu
 *
 */
public class SubscribeResp implements Serializable {

    /**
     * 默认序列ID
     */
    private static final long serialVersionUID = 1L;
    
    private int subReqID;
    
    private int respCode;
    
    private String desc;
    
    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SubscribeResp [subReqID=" + subReqID + ", respCode=" + respCode + ", desc=" + desc + "]";
    }

    /**
     * @return the subReqID
     */
    public int getSubReqID() {
        return subReqID;
    }

    /**
     * @param subReqID the subReqID to set
     */
    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    /**
     * @return the respCode
     */
    public int getRespCode() {
        return respCode;
    }

    /**
     * @param respCode the respCode to set
     */
    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
}
