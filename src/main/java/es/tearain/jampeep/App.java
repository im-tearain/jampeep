package es.tearain.jampeep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;
import org.apache.kudu.Type;
import org.apache.kudu.client.CreateTableOptions;
import org.apache.kudu.client.KuduClient;
import org.apache.kudu.client.KuduException;
import org.apache.kudu.test.KuduTestHarness;
import org.junit.Rule;

/**
 * Hello world!
 *
 */
public class App {
	@Rule
	public final KuduTestHarness harness = new KuduTestHarness();

	public static void main(String[] args) {

	}

	public void kuduInit() throws KuduException {
		// Get a KuduClient configured to talk to the running mini cluster.
		final KuduClient client = this.harness.getClient();

		// Create a new Kudu table.
		final List<ColumnSchema> columns = new ArrayList<>();
		columns.add(new ColumnSchema.ColumnSchemaBuilder("key", Type.INT32).key(true).build());
		final Schema schema = new Schema(columns);
		final CreateTableOptions opts = new CreateTableOptions()
				.setRangePartitionColumns(Collections.singletonList("key"));
		client.createTable("table-1", schema, opts);
	}
}
