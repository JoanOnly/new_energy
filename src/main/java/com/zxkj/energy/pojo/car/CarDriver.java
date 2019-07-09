package com.zxkj.energy.pojo.car;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CarDriver implements Serializable {
    private Long id;

    private Long carId;

    private Long userId;

    private Long driverId;

    private Byte isDriver;

    private Byte isCopilot;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}