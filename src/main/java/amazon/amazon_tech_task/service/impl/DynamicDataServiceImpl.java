package amazon.amazon_tech_task.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import amazon.amazon_tech_task.model.DynamicData;
import amazon.amazon_tech_task.repository.DynamicDataRepository;
import amazon.amazon_tech_task.service.DynamicDataService;
import org.springframework.stereotype.Service;

@Service
public class DynamicDataServiceImpl implements DynamicDataService {
    private final DynamicDataRepository dynamicDataRepository;
    private final DateService dateService;

    public DynamicDataServiceImpl(DynamicDataRepository dynamicDataRepository, DateService dateService) {
        this.dynamicDataRepository = dynamicDataRepository;
        this.dateService = dateService;
    }

    @Override
    public List<DynamicData> getStatisticsByTimestamp(long timestamp) {
        return dynamicDataRepository.findByDate(dateService.convertTimestampToDateString(timestamp));
    }

    @Override
    public List<DynamicData> getStatisticsByTimestampRange(long startTimestamp, long endTimestamp) {
        return dynamicDataRepository.findByDateBetween(dateService.convertTimestampToDateString(startTimestamp),
                dateService.convertTimestampToDateString(endTimestamp));
    }

    @Override
    public List<Map<String, Object>> getStatisticsByASINs(List<String> asins) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (String asin : asins) {
            List<Map<String, Object>> dataForAsin = dynamicDataRepository.findDataByAsin(asin);
            result.addAll(dataForAsin);
        }

        return result;
    }

}
