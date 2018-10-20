package cloud.developing.orm;

import static java.util.stream.Collectors.*;

import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class Db {

	public static void main(String[] args) {
		DynamoDBMapper mapper = new DynamoDBMapper(AmazonDynamoDBAsyncClientBuilder.defaultClient());
		List<Photo> newPhotos = mapper.scan(Photo.class, new DynamoDBScanExpression()).stream().map(p -> {
			p.setBucket("photos.adamsmolnik.com");
			return p;
		}).collect(toList());
		mapper.batchSave(newPhotos);
	}
}