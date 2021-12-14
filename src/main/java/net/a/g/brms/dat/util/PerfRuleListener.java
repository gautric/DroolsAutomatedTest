package net.a.g.brms.dat.util;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

public class PerfRuleListener extends DefaultAgendaEventListener {

	private static PerfRuleListener instance = new PerfRuleListener();

	public static PerfRuleListener getInstance() {
		return instance;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(PerfRuleListener.class);

	public static MetricRegistry metricRegistry = new MetricRegistry();

	private volatile Timer.Context ag_context;
	private volatile Timer.Context rule_then_context;
	private volatile Timer.Context rule_when_context;

	@Override
	public void matchCreated(MatchCreatedEvent event) {
		rule_when_context = metricRegistry.timer("rule-" + event.getMatch().getRule().getName()+"-lhs(when)").time();
	}

	@Override
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		rule_when_context.stop();
		rule_then_context = metricRegistry.timer("rule-" + event.getMatch().getRule().getName()+"-rhs(then)").time();
	}

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		rule_then_context.stop();
	}

	@Override
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
	}

	@Override
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		ag_context.stop();
	}

	@Override
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		ag_context = metricRegistry.timer("agendagroup-" + event.getAgendaGroup().getName()).time();
	}

}