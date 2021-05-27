package com.yy.FB.entity;

import com.baomidou.mybatisplus.annotation.IdType;


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
@ApiModel(value="StudioNotRecruited对象", description="")
public class StudioNotRecruited extends Model<StudioNotRecruited> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "需求表id")
    private Integer demandId;

    @ApiModelProperty(value = "工作室id")
    private Integer studioId;

    @ApiModelProperty(value = "投标情况（默认0：正在投标，1：投标成功，2：投标失败）")
    private Integer biddingState;

    @ApiModelProperty(value = "定金状态(0默认:显示，1：不显示）")
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

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
