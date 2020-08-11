package com.muhuan.frame.common.bean;

import java.io.*;

/**
 * @ClassName CloneEntity
 * @Description TODO 深拷贝——序列化实现
 * @Author dong <feng.db@uniteddata.com>
 * @Date 2019/8/24
 * @Version 1.0.0
 **/
public abstract class CloneEntity<T> implements Serializable,Cloneable{
    public T cloneEntity(){
        ByteArrayOutputStream bos  = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        T entity = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            entity = (T)ois.readObject();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (ois!=null)
                    ois.close();
                if (bis!=null)
                    bis.close();
                if (oos!=null)
                    oos.close();
                if (bos!=null)
                    bos.close();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }

}
