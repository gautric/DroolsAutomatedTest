package net.a.g.brms.dat.util;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleListener extends DefaultAgendaEventListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuleListener.class);
	
	private static AgendaEventListener instance = new RuleListener();

	public static AgendaEventListener getInstance() {
		return instance;
	}
	
	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		LOGGER.info("=> Rule Fired : '{}'", event.getMatch().getRule().getName());
	}

	public void matchCreated(MatchCreatedEvent event) {
		LOGGER.info("=> Rule matchCreated : '{}'", event.getMatch().getRule().getName());
	}

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		LOGGER.info("=> RuleFlowGroup After Activated : '{}'", event.getRuleFlowGroup().getName());
	}

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		LOGGER.info("=> Rule After Fired : '{}'", event.getMatch().getRule().getName());
	}

	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		LOGGER.info("=> AgendaG Popped : '{}'", event.getAgendaGroup().getName());
	}

	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		LOGGER.info("=> AgendaG Pushed : '{}'", event.getAgendaGroup().getName());
	}

	@Override
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		LOGGER.info("=> RuleFlowGroup Before Activated : '{}'", event.getRuleFlowGroup().getName());
	}

	@Override
	public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		LOGGER.info("=> RuleFlowGroup Before DeActivated : '{}'", event.getRuleFlowGroup().getName());
	}

	@Override
	public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
		LOGGER.info("=> RuleFlowGroup After DeActivated : '{}'", event.getRuleFlowGroup().getName());
	}

}