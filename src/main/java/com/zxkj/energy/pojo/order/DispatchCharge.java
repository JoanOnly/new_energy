package com.zxkj.energy.pojo.order;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class DispatchCharge implements Serializable {
    private Long id;

    private Long orderId;

    private String orderNo;

    private Long dispatchId;

    private String dispatchSerialNo;

    private Long companyId;

    private String chargeName;

    private Long chargeCost;

    private Integer chargeType;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}