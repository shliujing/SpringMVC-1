package me.ele.activity.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lj on 2016/12/13.
 */
@Entity
@Table(name = "activity", schema = "", catalog = "test")
public class ActivityEntity {
    private int id;
    private String department;
    private String name;
    private String date;
    private String spend;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "date", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "spend", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSpend() {
        return spend;
    }
    public void setSpend(String spend) {
        this.spend = spend;
    }
    @Column(name = "department", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
