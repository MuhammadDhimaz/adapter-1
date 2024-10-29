package com.bpjstk.JSReport.models;

import java.util.List;
import java.util.Map;

public record PostData(String code,
                       String user,
                       String title,
                       String subtitle,
                       String blth,
                       String periode,
                       List<Map<String, Object>> data
) {
}


