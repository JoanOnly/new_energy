package com.zxkj.energy.pojo.order;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class OrderBackCashInfo implements Serializable {
    private Long id;

    private Long companyId;

    private Long orderId;

    private String orderNo;

    private String backSerialNo;

    private Long backUserId;

    private String backName;

    private Long backCost;

    private String backNote;

    private Date backGmt;

    private Long dealUserId;

    private String dealName;

    private Date dealGmt;

    private String dealNote;

    private Byte isBackFinish;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}