package amazon.amazon_tech_task.service;

import java.util.List;
import java.util.Map;
import amazon.amazon_tech_task.model.DynamicData;

public interface DynamicDataService {
    List<DynamicData> getStatisticsByTimestamp(long timestamp);

    List<DynamicData> getStatisticsByTimestampRange(long startTimestamp, long endTimestamp);

    List<Map<String, Object>> getStatisticsByASINs(List<String> asins);
}
