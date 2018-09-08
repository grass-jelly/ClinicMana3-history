package model;

import java.sql.Date;

public class VisitCountsDTO {
    private Date date;
    private Long count;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
