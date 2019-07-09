package com.zxkj.energy.pojo.car;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CarArchives implements Serializable {
    private Long id;

    private Long companyId;

    private Long carId;

    private String carDocNo;

    private String carDrivingDoc;

    private String carInsideNo;

    private String carNumber;

    private Integer carType;

    private String carOwner;

    private String carOwnerAddr;

    private String carUseNature;

    private String carBrand;

    private String carIdCard;

    private String carEngineNo;

    private Date carRegisterGmt;

    private String carIssueGmt;

    private String carApproveGmt;

    private String carPlateColor;

    private Integer carStatus;

    private Byte isLevelDoc;

    private Byte isPurchaseTax;

    private Byte isLoanCar;

    private Byte isInstallGps;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}