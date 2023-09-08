package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

import org.acme.Failing_subModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class SubprocessTests
{
	@Inject
	@Named("failing_sub")
	Process<org.acme.Failing_subModel> process;

	@Test
	public void shouldReturnList()
	{
		// given
		Failing_subModel model = process.createModel();
		model.fromMap(Map.of("myname", "john doe"));

		// when
		ProcessInstance<Failing_subModel> instance = process.createInstance(model);
		instance.start();

		// then
		assertEquals(ProcessInstance.STATE_COMPLETED, instance.status());
		assertThat(instance.variables().getGreeting(), hasItem("Hello john doe"));
	}
}
