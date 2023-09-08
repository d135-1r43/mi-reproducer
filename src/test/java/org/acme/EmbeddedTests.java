package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsIterableContaining;
import org.junit.jupiter.api.Test;
import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;

import javax.inject.Inject;
import javax.inject.Named;

import org.acme.Working_embeddedModel;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class EmbeddedTests
{
	@Inject
	@Named("working_embedded")
	Process<Working_embeddedModel> process;

	@Test
	public void shouldReturnList()
	{
		// given
		Working_embeddedModel model = process.createModel();
		model.fromMap(Map.of("myname", "john doe"));

		// when
		ProcessInstance<Working_embeddedModel> instance = process.createInstance(model);
		instance.start();

		// then
		assertEquals(ProcessInstance.STATE_COMPLETED, instance.status());
		assertThat(instance.variables().getGreeting(), hasItem("Hello john doe"));
	}
}
