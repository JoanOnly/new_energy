package com.zxkj.energy.pojo.user;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class DriverCar implements Serializable {
    private Long id;

    private Long userId;

    private Long driverId;

    private Long carId;

    private Byte isDefault;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}