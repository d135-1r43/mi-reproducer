package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class JbpmTests
{
	@Inject
	@Named("MultiInstanceLoopCharacteristicsSubProcessWithOutput")
	Process<? extends Model> process;

	@Test
	public void shouldRunJbpmnReferenceModel()
	{
		// given
		Map<String, Object> params = new HashMap<>();

		List<String> myList = new ArrayList<>();
		List<String> myListOut = new ArrayList<>();

		myList.add("First Item");
		myList.add("Second Item");

		params.put("list", myList);
		params.put("listOut", myListOut);
		assertThat(myListOut).isEmpty();

		// when
		Model model = process.createModel();
		model.fromMap(params);

		ProcessInstance<? extends Model> instance = process.createInstance(model);
		instance.start();

		// then
		assertThat(myListOut).hasSize(2);
		assertThat(myListOut.get(1)).isEqualTo("Second Item changed by subprocess");
	}
}
