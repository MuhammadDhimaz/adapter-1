package com.bpjstk.JSReport.services.utilities;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UtilityService {

    public Map<String, String> createAdditionalData(String shortId, String recipe, String queryId, String p_user, String title, String subtitle, String blth, String periode) {
        Map<String, String> additionalData = new HashMap<>();
        additionalData.put("shortId", shortId);
        additionalData.put("queryId", queryId);
        additionalData.put("p_user", p_user);
        additionalData.put("title", title);
        additionalData.put("subtitle", subtitle);
        additionalData.put("blth", blth);
        additionalData.put("recipe", recipe);
        additionalData.put("periode", periode);
        return additionalData;
    }

    public String getMonthYearFromDate(String dateFormat, String date) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate localDate = LocalDate.parse(date, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM-yyyy");
        return localDate.format(outputFormatter);
    }

    public String getJsreportRecipe(String acceptHeader) {
        return Objects.equals(acceptHeader, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ? "html-to-xlsx" : "chrome-pdf";
    }
}
