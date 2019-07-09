package com.zxkj.energy.pojo.car;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CarType implements Serializable {
    private Long id;

    private Long companyId;

    private String carTypeName;

    private String containerLength;

    private String containerWidth;

    private String containerHeight;

    private String containerLoadWeight;

    private String containerVolume;

    private String carUserReference;

    private Integer carType;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}