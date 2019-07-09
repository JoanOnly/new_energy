package com.zxkj.energy.pojo.order;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class DispatchInfo implements Serializable {
    private Long id;

    private Long orderId;

    private String orderNo;

    private String dispatchSerialNo;

    private Long companyId;

    private String companyName;

    private Long driverUserId;

    private String driverName;

    private String driverPhone;

    private Long carId;

    private String carNumber;

    private Long dispatchUserId;

    private String dispatchName;

    private String dispatchPhone;

    private Date dispatchGmt;

    private Integer dispatchStatus;

    private Date getGoodsGmt;

    private String transGoosWeight;

    private String receiveNo;

    private String receiveGmt;

    private String receiveName;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}