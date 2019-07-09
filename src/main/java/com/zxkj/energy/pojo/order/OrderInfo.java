package com.zxkj.energy.pojo.order;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class OrderInfo implements Serializable {
    private Long id;

    private String orderNo;

    private Long companyId;

    private Date orderGmt;

    private Date arriveGmt;

    private String goodsName;

    private Integer goodsType;

    private String goodsWeight;

    private Integer orderStatus;

    private Long sendUserId;

    private Long sendCompanyId;

    private String sendUserName;

    private String sendUserPhone;

    private String sendProvince;

    private String sendCity;

    private String sendArea;

    private String sendDetail;

    private Long receiveUserId;

    private Long receiveCompanyId;

    private String receiveUserName;

    private String receiveUserPhone;

    private String receiveProvince;

    private String receiveCity;

    private String receiveArea;

    private String receiveDetail;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}