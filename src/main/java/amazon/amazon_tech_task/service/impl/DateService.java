package amazon.amazon_tech_task.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class DateService {

    public String convertTimestampToDateString(long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public Date convertTimestampToDate(long timestamp) {
        return new Date(timestamp);
    }
}
