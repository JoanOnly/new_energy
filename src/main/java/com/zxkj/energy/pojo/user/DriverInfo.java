package com.zxkj.energy.pojo.user;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class DriverInfo implements Serializable {
    private Long id;

    private Long userId;

    private String driverDocNo;

    private String quasiDrivingType;

    private String driverReceiveGmt;

    private Date validStartGmt;

    private Date validEndGmt;

    private String validTerm;

    private String issueOrgans;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}