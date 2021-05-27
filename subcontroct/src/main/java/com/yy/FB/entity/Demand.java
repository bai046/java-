package com.yy.FB.entity;

import com.baomidou.mybatisplus.annotation.IdType;


import java.sql.Blob;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="Demand对象", description="")
public class Demand extends Model<Demand> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需求id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "项目标题")
    private String projectTitle;

    @ApiModelProperty(value = "项目描述")
    private String projectDescrition;

    @ApiModelProperty(value = "项目类型")
    private Integer typeId;

    @ApiModelProperty(value = "项目周期")
    private Integer projectCycle;

    @ApiModelProperty(value = "预算金额")
    private Double budget;

    @ApiModelProperty(value = "最终定价")
    private Double finalBudget;

    @ApiModelProperty(value = "技术栈要求")
    private String technologyRequire;

    @ApiModelProperty(value = "文件上传")
    private Blob fileDownload;

    @ApiModelProperty(value = "状态(0:招募中；1:招募成功;2:已废弃)")
    private Integer status;

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
