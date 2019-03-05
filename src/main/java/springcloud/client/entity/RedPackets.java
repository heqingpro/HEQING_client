package springcloud.client.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "red_packets", schema = "test")
public class RedPackets {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private Integer count;

    @Column(name = "number")
    private Integer number;

    @Column(name = "total")
    private Integer total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "total")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedPackets that = (RedPackets) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(count, that.count) &&
                Objects.equals(number, that.number) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, count, number, total);
    }
}
