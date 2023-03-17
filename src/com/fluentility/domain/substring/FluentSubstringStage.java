package com.fluentility.domain.substring;

public interface FluentSubstringStage {
    RangeStageStartOrEnd of(String string);

    interface RangeStageStartOrEnd {
        RangeStageEnd from(int startingPosition);
        RangeStageEnd fromExclusive(int startingPosition);
        FinalStage to(int endingPosition);
        FinalStage toInclusive(int endingPosition);
    }

    interface RangeStageEnd {
        FinalStage to(int endingPosition);
        String get();
    }

    interface FinalStage {
        String get();
    }
}
