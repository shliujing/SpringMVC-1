package me.ele.activity.repository;

import me.ele.activity.model.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lj on 2016/12/13 0024.
 */
@Repository // 添加注解
public interface ActivityRepository extends JpaRepository<ActivityEntity, Integer> {
    @Modifying // 说明该方法是修改操作
    @Transactional // 说明该方法是事务性操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update ActivityEntity us set us.name=:qName, us.date=:qDate, us.spend=:qSpend, us.department=:qDepartment where us.id=:qId")
    public void updateActivity(@Param("qName") String name,
                           @Param("qDate") String date,
                           @Param("qSpend") String spend,
                           @Param("qDepartment") String department,
                           @Param("qId") Integer id);
//    @SQLInsert("")
}