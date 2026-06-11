package ua.javarush.task.task39.task3913.DTO;

import ua.javarush.task.task39.task3913.DTO.enums.QueryFilter;
import ua.javarush.task.task39.task3913.DTO.enums.QueryType;

import java.util.Objects;

public class QueryEntry {
    //Type1 -> get user
    //Type2 -> get ip for user = "Eduard Petrovich Morozko"
    //Type3 -> full -> get ip for user = "Eduard Petrovich Morozko" and date between "11.12.2013 0:00:00" and "03.01.2014 23:59:59"
    private int type;
    private QueryType queryType;
    private QueryFilter queryFilter;
    private QueryFilter queryFilter2;
    private String filter2Value;
    private String startDate;
    private String endDate;

    public QueryEntry() {
    }

    public String getFilter2Value() {
        return filter2Value;
    }

    public void setFilter2Value(String filter2Value) {
        this.filter2Value = filter2Value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public QueryFilter getQueryFilter2() {
        return queryFilter2;
    }

    public void setQueryType(QueryType queryType) {
        this.queryType = queryType;
    }

    public void setQueryFilter(QueryFilter queryFilter) {
        this.queryFilter = queryFilter;
    }

    public void setQueryFilter2(QueryFilter queryFilter2) {
        this.queryFilter2 = queryFilter2;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public QueryFilter getQueryFilter() {
        return queryFilter;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QueryEntry that = (QueryEntry) o;
        return type == that.type && queryType == that.queryType && queryFilter == that.queryFilter
                && queryFilter2 == that.queryFilter2 && filter2Value.equals(that.filter2Value) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, queryType, queryFilter, queryFilter2, filter2Value, startDate, endDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("QueryEntry{");
        sb.append(queryType.name().toUpperCase());
        sb.append(" ").append(queryFilter.name());
        sb.append(queryFilter2 != null ? " FOR " + queryFilter2.name() : "");
        sb.append(filter2Value != null ? " " + filter2Value : "");
        sb.append(startDate == null || startDate.isEmpty() ? "}" : "AND DATE BETWEEN ");
        sb.append(endDate == null || endDate.isEmpty() ? "" : startDate + " AND " + endDate + "}");

        return sb.toString();
    }
}
