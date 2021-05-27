package com.yy.FB.entity;

import com.baomidou.mybatisplus.annotation.*;


import java.util.Date;
import java.io.Serializable;


import com.baomidou.mybatisplus.extension.activerecord.Model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * <p>
 * 
 * </p>
 *
 * @author abc
 * @since 2021-05-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
@TableName(value = "user")
public class User extends Model<User>{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "角色(0,1,2)")
    private Integer role;

    @ApiModelProperty(value = "企业或工作室描述")
    private String description;

    @ApiModelProperty(value = "头像")
    private String image;

    @ApiModelProperty(value = "审核状态(0,1,2)")
    private Integer auditStatus;

    @ApiModelProperty(value = "成立时间")
    private Date establishedTime;

    @ApiModelProperty(value = "需求指标评分")
    private Float evaluateDemand;

    @ApiModelProperty(value = "能力指标评分")
    private Float evaluateAbility;

    @ApiModelProperty(value = "计划指标评分")
    private Float evaluatePlan;

    @ApiModelProperty(value = "擅长类型")
    private Integer typeId;

    @ApiModelProperty(value = "服务总数")
    private Integer nums;

    @ApiModelProperty(value = "余额")
    private Double balance;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }




}
