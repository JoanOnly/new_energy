package com.zxkj.energy.pojo.user;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class AddressInfo implements Serializable {
    private Long id;

    private Long companyId;

    private Long userId;

    private String addrProvince;

    private String addrCity;

    private String addrArea;

    private String addrDetail;

    private String userName;

    private String userPhone;

    private Byte isDefault;

    private Byte isDefaultTwo;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}