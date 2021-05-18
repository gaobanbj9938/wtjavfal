package com.bayside.app.opinion.mobile.war.mynews.model;

import java.util.Date;

public class PersonManage {
    private String id;

    private String code;

    private String name;

    private String gender;

    private String address;

    private String originaddress;

    private String company;

    private String post;

    private Integer age;

    private String industry;

    private String commonaccount;

    private Date starttime;

    private Date endtime;

    private Boolean isenable;

    private String userid;
    
    private String addressprovince;
    
    private String addresscity;
    
    private String originprovince;
    
    private String origincity;
    
    private Date birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOriginaddress() {
        return originaddress;
    }

    public void setOriginaddress(String originaddress) {
        this.originaddress = originaddress == null ? null : originaddress.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getCommonaccount() {
        return commonaccount;
    }

    public void setCommonaccount(String commonaccount) {
        this.commonaccount = commonaccount == null ? null : commonaccount.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

	public String getAddressprovince() {
		return addressprovince;
	}

	public void setAddressprovince(String addressprovince) {
		this.addressprovince = addressprovince;
	}

	public String getAddresscity() {
		return addresscity;
	}

	public void setAddresscity(String addresscity) {
		this.addresscity = addresscity;
	}

	public String getOriginprovince() {
		return originprovince;
	}

	public void setOriginprovince(String originprovince) {
		this.originprovince = originprovince;
	}

	public String getOrigincity() {
		return origincity;
	}

	public void setOrigincity(String origincity) {
		this.origincity = origincity;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
}