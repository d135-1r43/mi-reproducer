package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class SubprocessTests
{
	@Inject
	@Named("failing_sub")
	Process<? extends Model> process;

	@Test
	public void shouldReturnList()
	{
		// given
		Model model = process.createModel();
		model.fromMap(Map.of("myname", "john doe"));

		// when
		ProcessInstance<? extends Model> instance = process.createInstance(model);
		instance.start();

		// then
		assertEquals(ProcessInstance.STATE_COMPLETED, instance.status());
		Collection<String> greeting = (Collection<String>)instance.variables().toMap().get("greeting");
		assertThat(greeting, hasItem("Hello john doe"));
	}
}
