package com.zxkj.energy.pojo.user;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CompanyInfo implements Serializable {
    private Long id;

    private Long parentId;

    private String companyName;

    private String companyAbbr;

    private String companyIdCard;

    private String companyPhone;

    private String companyFax;

    private String companyAddr;

    private String docPrefix;

    private Byte isShipper;

    private Byte isTransport;

    private Byte isLogistics;

    private Date gmtCreate;

    private Date gmtModified;

    private String writerName;

    private Byte isDelete;

    private String remark;

    private static final long serialVersionUID = 1L;
}