package com.hiruni.bumblebee.loan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class LoanReportBetweenDays {

    private LocalDate fromDate;
    private LocalDate toDate;

    private List<LoanReport> loanReports;
}
