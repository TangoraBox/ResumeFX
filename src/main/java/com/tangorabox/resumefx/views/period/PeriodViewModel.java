package com.tangorabox.resumefx.views.period;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class PeriodViewModel implements Comparable<PeriodViewModel> {

    private final ObjectProperty<LocalDate> startDate = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> endDate = new SimpleObjectProperty<>();
    private final LongProperty durationMonths = new SimpleLongProperty();
    private final StringProperty durationLabel = new SimpleStringProperty();

    public PeriodViewModel() {
        initDurationMonthsProperty();
        durationLabel.bind(Bindings.createStringBinding(this::calculateDurationLabel, durationMonths));
    }

    private void initDurationMonthsProperty() {
        durationMonths.bind(Bindings.createObjectBinding(
                () -> {
                    if (startDate.get() == null) {
                        return 0;
                    }
                    return ChronoUnit.MONTHS.between(startDate.get(), getEndDate());
                }, startDate, endDate));
    }

    private String calculateDurationLabel() {
        StringBuilder result = new StringBuilder();
        Period period = Period.ofMonths((int) getDurationMonths()).normalized();
        result.append(calculateDurationAux(period.getYears(), "year"));
        result.append(calculateDurationAux(period.getMonths(), "month"));
        return result.toString();
    }

    private String calculateDurationAux(int amount, String label) {
        StringBuilder result = new StringBuilder();
        if (amount > 0) {
            result.append(String.format("%s %s", amount, label));
            if (amount > 1) {
                result.append("s");
            }
        }
        if (result.length() > 0) {
            result.append("\n");
        }
        return result.toString();
    }

    public LocalDate getStartDate() {
        return startDate.get();
    }

    public ObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public LocalDate getEndDate() {
        return endDate.get() != null ? endDate.get() : LocalDate.now();
    }

    public ObjectProperty<LocalDate> endDateProperty() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate.set(endDate);
    }

    public long getDurationMonths() {
        return durationMonths.get();
    }

    public LongProperty durationMonthsProperty() {
        return durationMonths;
    }

    public String getDurationLabel() {
        return durationLabel.get();
    }

    public StringProperty durationLabelProperty() {
        return durationLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeriodViewModel that = (PeriodViewModel) o;
        return Objects.equals(getEndDate(), that.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEndDate());
    }

    @Override
    public int compareTo(PeriodViewModel that) {
        return that.getEndDate().compareTo(this.getEndDate());
    }
}
