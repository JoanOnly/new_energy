package com.zxkj.energy.pojo.user;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class AccountInfo implements Serializable {
    private Long id;

    private Long companyId;

    private String userPhone;

    private String userAccount;

    private String userPass;

    private String accountDoc;

    private Integer accountType;

    private Integer accountStatus;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}