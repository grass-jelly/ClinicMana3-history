package model;

public class VisitCountsDatestringDTO {
    private String date;
    private Long count;

    public VisitCountsDatestringDTO(String text, Long count) {
        this.date = text;
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
