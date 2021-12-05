package uow;

import java.util.Date;

public class AddVisit {


    private int clientId;

    private Date date;

    private String title;

    private Double cost;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setVDate(Date date) {
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void settTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}
