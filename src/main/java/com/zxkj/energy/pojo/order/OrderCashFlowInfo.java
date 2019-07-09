package com.zxkj.energy.pojo.order;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class OrderCashFlowInfo implements Serializable {
    private Long id;

    private Long orderId;

    private String orderNo;

    private Long companyId;

    private String cashSerialNo;

    private Date dealGmt;

    private Integer dealType;

    private Long dealCost;

    private String dealMethod;

    private String dealNote;

    private String dealName;

    private String dealBankNo;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}