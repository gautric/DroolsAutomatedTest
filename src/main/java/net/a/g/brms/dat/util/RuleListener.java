package net.a.g.brms.dat.util;

import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleListener extends DefaultAgendaEventListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuleListener.class);

	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		LOGGER.error("=> Rule Fired : '{}'", event.getMatch().getRule().getName());

	}

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		LOGGER.error("=> RuleFlowGroup Activated : '{}'", event.getRuleFlowGroup().getName());
	}
}