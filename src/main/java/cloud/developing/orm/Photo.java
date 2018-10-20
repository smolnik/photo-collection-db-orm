package cloud.developing.orm;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@DynamoDBTable(tableName = "photos")
@Data
public class Photo {

	@DynamoDBHashKey
	private String userId;

	@DynamoDBRangeKey
	private String photoKey;

	@DynamoDBAttribute
	private String bucket, photoTakenDate, photoTakenTime, principalId, srcPhotoName, thumbnailKey, madeBy, model,
			warning;

}
