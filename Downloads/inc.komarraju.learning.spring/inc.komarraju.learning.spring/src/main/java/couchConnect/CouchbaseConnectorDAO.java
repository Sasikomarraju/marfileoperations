package couchConnect;

import java.util.UUID;

import org.springframework.boot.SpringApplication;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

import springlearning.BasicSpringApplication;

public class CouchbaseConnectorDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//3.1 Prepare a custom environment
		
		CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
				.connectTimeout(20000)
				.kvTimeout(3000)
				.build();
		
//3.2 Connecting to a Cluster with the established environment
		
		Cluster cluster = CouchbaseCluster.create(env,"10.224.223.44");
		System.out.println("Connecting to Couchbase......." + cluster);
		
// Running the Application as a Spring Boot App		
		SpringApplication.run(BasicSpringApplication.class, args);
		 		
// 3.3. Opening a Bucket
		Bucket bucket = cluster.openBucket("POP","marriott");

		
// 3.4 Prepare a JSON Object
		JsonObject content = JsonObject.empty()
				.put("name", "Sasi Komarraju")
				.put("type", "person")
				.put("email","sk123@yahoo.com")
				.put("city","Bethesda");
		
// 3.5 Create a Json document object
		String id = UUID.randomUUID().toString();
		JsonDocument document = JsonDocument.create(id,content);
		
//3.6 Insert the created Json document
		System.out.print("Inserting into couchbase!!!!!");
		JsonDocument inserted = bucket.insert(document);
		
//3.7	retrieve the created document
		System.out.print("Retrieving from couchbase!!!!!");
		JsonDocument retrieved = bucket.get(id);
		System.out.print("id " + id);
		
		
	}

}
