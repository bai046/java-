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
@ApiModel(value="TradeRecording对象", description="")
public class TradeRecording extends Model<TradeRecording> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "需求表id")
    private Integer demandId;

    @ApiModelProperty(value = "金额")
    private Double money;

    @ApiModelProperty(value = "交易类型(0:定金；1：定金退回；2：尾款)")
    private Integer type;

    @ApiModelProperty(value = "逻辑删除（0：未删除，1：删除））")
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
