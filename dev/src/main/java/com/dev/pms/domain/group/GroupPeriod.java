package com.dev.pms.domain.group;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GroupPeriod {

    LocalDate startDate;
    LocalDate endDate;

    public GroupPeriod(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public GroupPeriod() {}

    public boolean isBetween(LocalDate date) {
        return date.isAfter(startDate) && date.isBefore(endDate);
    }
}
