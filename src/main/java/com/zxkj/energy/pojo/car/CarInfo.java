package com.zxkj.energy.pojo.car;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CarInfo implements Serializable {
    private Long id;

    private Long companyId;

    private Long userId;

    private String carNumber;

    private String carOwnerName;

    private String carOwnerPhone;

    private String carPlateColor;

    private String carBodyColor;

    private Long carTypeId;

    private Integer carOperateStatus;

    private String carIdCard;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}