package amazon.amazon_tech_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
@Data
@Document(collection = "data")
@AllArgsConstructor
@NoArgsConstructor
public class DynamicData {
    @Id
    private String id;
    private String date;
    private Map<String, Object> salesByDate;
    private Map<String, Object> trafficByDate;
}