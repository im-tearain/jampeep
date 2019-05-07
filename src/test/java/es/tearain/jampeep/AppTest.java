package es.tearain.jampeep;

/**
 * Unit test for simple App.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;
import org.apache.kudu.Type;
import org.apache.kudu.client.CreateTableOptions;
import org.apache.kudu.client.KuduClient;
import org.apache.kudu.test.KuduTestHarness;
import org.junit.Rule;
import org.junit.Test;

public class AppTest {
	// The KuduTestHarness automatically starts and stops a real Kudu cluster
	// when each test is run. Kudu persists its on-disk state in a temporary
	// directory under a location defined by the environment variable
	// TEST_TMPDIR
	// if set, or under /tmp otherwise. That cluster data is deleted on
	// successful exit of the test. The cluster output is logged through slf4j.
	@Rule
	public KuduTestHarness harness = new KuduTestHarness();

	@Test
	public void test() throws Exception {
		// Get a KuduClient configured to talk to the running mini cluster.
		final KuduClient client = this.harness.getClient();

		// Create a new Kudu table.
		final List<ColumnSchema> columns = new ArrayList<>();
		columns.add(new ColumnSchema.ColumnSchemaBuilder("key", Type.INT32).key(true).build());
		final Schema schema = new Schema(columns);
		final CreateTableOptions opts = new CreateTableOptions()
				.setRangePartitionColumns(Collections.singletonList("key"));
		client.createTable("table-1", schema, opts);

		// Now we may insert rows into the newly-created Kudu table using
		// 'client',
		// scan the table, etc.
	}
}
