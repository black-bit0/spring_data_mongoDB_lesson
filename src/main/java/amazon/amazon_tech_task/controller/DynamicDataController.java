package amazon.amazon_tech_task.controller;

import amazon.amazon_tech_task.exception.InvalidInputDataException;
import amazon.amazon_tech_task.model.DynamicData;
import amazon.amazon_tech_task.service.DynamicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class DynamicDataController {

    private final DynamicDataService dynamicDataService;

    @Autowired
    public DynamicDataController(DynamicDataService dynamicDataService) {
        this.dynamicDataService = dynamicDataService;
    }

    // TODO remove after test
    @GetMapping("/byTimestamp/{timestamp}")
    public List<DynamicData> getStatisticsByTimestamp(@PathVariable long timestamp) {
        validateTimestamp(timestamp, timestamp);
        return dynamicDataService.getStatisticsByTimestamp(timestamp);
    }

    @GetMapping("/byTimestampRange/{startTimestamp}/{endTimestamp}")
    public List<DynamicData> getStatisticsByTimestampRange(@PathVariable long startTimestamp, @PathVariable long endTimestamp) {
        validateTimestamp(startTimestamp, endTimestamp);
        return dynamicDataService.getStatisticsByTimestampRange(startTimestamp, endTimestamp);
    }

    @GetMapping("/statsByAsin")
    public ResponseEntity<List<Map<String, Object>>> getSalesByDateForAsins(@RequestParam List<String> asins) {
        List<Map<String, Object>> result = dynamicDataService.getStatisticsByASINs(asins);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // TODO fix validation
    private void validateTimestamp(long timestampStart, long timestampEnd) {
        if (timestampStart < 0 || timestampEnd < 0 || timestampEnd < timestampStart) {
            throw new InvalidInputDataException("Invalid timestamp value");
        }
    }
}
