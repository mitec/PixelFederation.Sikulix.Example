package com.pixelfederation.qa.automation.core.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.sikuli.basics.Settings;

public class SikuliXDriverConfig extends Settings {
    public final double WaitTimeBeforeAction;
    public final boolean CanHighlight;
    public final double HighlightTime;
    public final double ClickDelay;

    public SikuliXDriverConfig(
            @JsonProperty("WaitTimeBeforeAction") double waitTimeBeforeAction,
            @JsonProperty("CanHighlight") boolean canHighlight,
            @JsonProperty("HighlightTime") float highlightTime,
            @JsonProperty("ClickDelay") float clickDelay,
            @JsonProperty("AutoWaitTimeout") float autoWaitTimeout,
            @JsonProperty("MinSimilarity") double minSimilarity,
            @JsonProperty("MoveMouseDelay") float moveMouseDelay
    ) {
        WaitTimeBeforeAction = waitTimeBeforeAction;
        CanHighlight = canHighlight;
        HighlightTime = highlightTime;
        ClickDelay = clickDelay;
        MoveMouseDelay = moveMouseDelay;

        // DO NOT USE SikuliX settings DIRECTLY, if required, add another one below
        AutoWaitTimeout = autoWaitTimeout;
        MinSimilarity = minSimilarity;
        OcrTextRead = true;

        // ignore sikulix highlighting feature, because it highlights found item 2x and that makes development much slower (or at least more annoying :)
        //Highlight = canHighlight;
        //DefaultHighlightTime = highlightTime;
    }
}