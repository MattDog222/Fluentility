package com.fluentility.domain.substring;

public class FluentSubstring implements
        FluentSubstringStage,
        FluentSubstringStage.RangeStageStartOrEnd,
        FluentSubstringStage.RangeStageEnd,
        FluentSubstringStage.FinalStage {
    private String originalString;
    private int start;
    private int end;

    private boolean inclusiveLowerBound = true;
    private boolean inclusiveUpperBound = false;

    private FluentSubstring() {}

    public static FluentSubstringStage fluentSubstring() {
        return new FluentSubstring();
    }

    public RangeStageStartOrEnd of(String string) {
        originalString = string;
        start = 0;
        end = string.length();
        return this;
    }

    @Override
    public RangeStageEnd from(int startingPosition) {
        start = startingPosition;
        return this;
    }

    @Override
    public RangeStageEnd fromExclusive(int startingPosition) {
        inclusiveLowerBound = false;
        return from(startingPosition);
    }

    @Override
    public FinalStage to(int endingPosition) {
        end = endingPosition;
        return this;
    }

    @Override
    public FinalStage toInclusive(int endingPosition) {
        inclusiveUpperBound = true;
        return to(endingPosition);
    }

    @Override
    public String get() {
        // Reindex negatives
        if (start < 0) {
            start += originalString.length();
        }
        if (end < 0) {
            end += originalString.length();
        }
        // Shift inclusivity
        if (!inclusiveLowerBound) {
            start += 1;
        }
        if (inclusiveUpperBound) {
            end += 1;
        }

        return originalString.substring(start, end);
    }
}

