package ua.javarush.task.task39.task3913.DTO;

import ua.javarush.task.task39.task3913.DTO.enums.QueryFilter;
import ua.javarush.task.task39.task3913.DTO.enums.QueryType;

import java.util.Objects;

public class QueryEntry {
    private final QueryType queryType;
    private final QueryFilter queryFilter;
    private final QueryFilter queryFilter2;
    private final String startDate;
    private final String endDate;

    public QueryEntry(QueryType queryType, QueryFilter queryFilter, QueryFilter queryFilter2, String startDate, String endDate) {
        this.queryType = queryType;
        this.queryFilter = queryFilter;
        this.startDate = startDate;
        this.endDate = endDate;
        this.queryFilter2 = queryFilter2;
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
        return queryType == that.queryType && queryFilter == that.queryFilter && queryFilter2 == that.queryFilter2  && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryType, queryFilter, queryFilter2, startDate, endDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("QueryEntry{");
        sb.append("queryType=").append(queryType.name().toUpperCase());
        sb.append(" ").append(queryFilter.name());
        sb.append(" ").append(queryFilter2 != null ? "FOR " + queryFilter2.name() : "");
        sb.append(startDate == null || startDate.isEmpty() ? "}" : "AND DATE BETWEEN ");
        sb.append(startDate).append(" AND ").append(endDate).append("}");

        return sb.toString();
    }
}

