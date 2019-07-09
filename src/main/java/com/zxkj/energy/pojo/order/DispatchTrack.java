package com.zxkj.energy.pojo.order;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class DispatchTrack implements Serializable {
    private Long id;

    private Long companyId;

    private Long orderId;

    private String orderNo;

    private Long dispatchId;

    private String dispatchSerialNo;

    private Integer transStatus;

    private Date recordGmt;

    private Long operatorId;

    private String operatorName;

    private String operatorNote;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}