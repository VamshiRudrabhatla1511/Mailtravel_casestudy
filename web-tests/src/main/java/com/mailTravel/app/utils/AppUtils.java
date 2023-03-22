package com.mailTravel.app.utils;



import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import com.mailTravel.app.models.EnumConstants;

public class AppUtils {

    /*****************************************
     * Static Map stores API End point
     *****************************************/
    public static Map<String, String> EndPointMap = Collections.unmodifiableMap(Stream.of(
            MapBuilder.entry(EnumConstants.ApiEndPointKey.MOCK.name(),"http://localhost:8080/"))
            .collect(MapBuilder.entriesToMap()));

    public static boolean isApiProfile(String activeProfile) {
        return EnumConstants.Platform.api.name().equalsIgnoreCase(activeProfile);
    }




}
