package com.zxkj.energy.pojo.order;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class OrderChargeInfo implements Serializable {
    private Long id;

    private Long orderId;

    private String orderNo;

    private Long companyId;

    private String chargeName;

    private Long chargeCost;

    private Integer chargeType;

    private String chargeNote;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}