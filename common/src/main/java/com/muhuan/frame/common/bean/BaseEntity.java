package com.muhuan.frame.common.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName BaseEntity
 * @Description TODO
 * @Author dong <feng.db@uniteddata.com>
 * @Date 2020/2/19
 * @Version 1.0.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
    public class BaseEntity<T> extends CloneEntity<T>{
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 数据创建时间 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long insertTime;

    /** 数据修改时间 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updateTime;
}
