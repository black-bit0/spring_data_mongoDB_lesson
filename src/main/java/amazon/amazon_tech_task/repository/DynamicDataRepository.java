package amazon.amazon_tech_task.repository;

import java.util.List;
import java.util.Map;
import amazon.amazon_tech_task.model.DynamicData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicDataRepository extends MongoRepository<DynamicData, String> {
    List<DynamicData> findByDate(String date);

    List<DynamicData> findByDateBetween(String startDate, String endDate);

    //@Query(value = "{ 'asin' : { $regex: ?0, $options: 'i' } }", fields = "{ '?0' : 1 }")
    @Query(value = "{}", fields = "{ 'asin' : 1 }")
    List<Map<String, Object>> findDataByAsin(String asin);

}
