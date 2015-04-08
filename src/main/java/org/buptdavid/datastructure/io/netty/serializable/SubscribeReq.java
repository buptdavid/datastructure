package org.buptdavid.datastructure.io.netty.serializable;

import java.io.Serializable;

/**
 * Netty Java序列化 订购请求POJO类定义
 * @author weijielu
 *
 */
public class SubscribeReq implements Serializable {

    /**
     * 默认的序列号ID
     */
    private static final long serialVersionUID = 1L;
    
    private int subReqID;
    
    private String userName;
    
    private String productName;
    
    private String phoneNumber;
    
    private String address;
    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SubscribeReq [subReqId=" + subReqID + ", userName=" + userName + ", productName=" + productName + ", phoneNumber=" +phoneNumber + ", address=" + address + "]";
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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    

}
