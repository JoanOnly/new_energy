package com.zxkj.energy.pojo.user;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserInfo implements Serializable {
    private Long id;

    private Long companyId;

    private String accountDoc;

    private String userName;

    private String userPhone;

    private String userSex;

    private String userIdCard;

    private Date userBirthGmt;

    private Integer userStatus;

    private Integer userType;

    private Byte isDriver;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}